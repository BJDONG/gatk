package org.broadinstitute.sting.gatk.walkers.reducereads;

import net.sf.samtools.CigarElement;
import net.sf.samtools.SAMRecord;
import org.broadinstitute.sting.utils.BaseUtils;
import org.broadinstitute.sting.utils.exceptions.ReviewedStingException;
import org.broadinstitute.sting.utils.pileup.PileupElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Copyright (c) 2009 The Broad Institute
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

/**
 * Created by IntelliJ IDEA.
 * User: depristo
 * Date: Apr 14, 2009
 * Time: 8:54:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class RefPileupElement extends PileupElement {
    final int refOffset;

    public RefPileupElement(SAMRecord read, int offset, int refOffset) {
        super(read, offset);
        this.refOffset = refOffset;
        if ( refOffset < 0 )
            throw new ReviewedStingException("Bad RefPileupElement: ref offset < 0: " + refOffset + " for read " + read);
    }

    public int getRefOffset() {
        return refOffset;
    }

    public static Iterable<RefPileupElement> walkRead(SAMRecord read) {
        return walkRead(read, 0);
    }

    public static Iterable<RefPileupElement> walkRead(final SAMRecord read, final int refIStart) {
        return new Iterable<RefPileupElement>() {
            public Iterator<RefPileupElement> iterator() {
                List<RefPileupElement> elts = new ArrayList<RefPileupElement>();

                // todo -- need to be ++X not X++ operators.  The refI should go from -1, for reads like 2I2M,
                // todo -- so that we can represent insertions to the left of the read
                int readI = 0, refI = read.getAlignmentStart() - refIStart;
                for ( CigarElement elt : read.getCigar().getCigarElements() ) {
                    int l = elt.getLength();
                    switch (elt.getOperator()) {
                        case N: // cannot handle these
                            break;
                        case H : case P : // ignore pads and hard clips
                            break;
                        case S :
                            //refI += l; // move the reference too, in addition to I
                            readI += l;
                            break;
                        case I :
                            for ( int i = 0; i < l; i++)
                                if ( refI >= 0 )
                                    readI++;
                            // todo -- replace when insertions handled correctly
//                                    elts.add(new RefPileupElement(read, readI++, refI));
                            break;
                        case D :
                            for ( int i = 0; i < l; i++)
                                if ( refI >= 0 )
                                    elts.add(new RefPileupElement(read, -1, refI++));
                            break;
                        case M :
                            for ( int i = 0; i < l; i++)
                                if ( refI >= 0 )
                                    elts.add(new RefPileupElement(read, readI++, refI++));
                            break;
                        default:
                            throw new ReviewedStingException("BUG: Unexpected CIGAR element " + elt + " in read " + read.getReadName());
                    }
                }

                return elts.iterator();
            }
        };
    }
}