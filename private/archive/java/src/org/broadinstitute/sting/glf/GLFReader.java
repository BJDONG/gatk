package org.broadinstitute.sting.utils.genotype.glf;

import net.sf.samtools.util.BinaryCodec;
import net.sf.samtools.util.BlockCompressedInputStream;
import net.sf.samtools.util.RuntimeEOFException;
import org.broadinstitute.sting.utils.exceptions.ReviewedStingException;
import org.broadinstitute.sting.utils.exceptions.UserException;
import org.broadinstitute.sting.utils.genotype.LikelihoodObject;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

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

/** an object for reading in GLF files */
// TODO -- DELETE ME GLF
public class GLFReader implements Iterator<GLFRecord> {

    // our next record
    private GLFRecord nextRecord = null;

    // the glf magic number, which identifies a properly formatted GLF file
    public static final short[] glfMagic = {'G', 'L', 'F', '\3'};

    // our input codec
    private final BinaryCodec inputBinaryCodec;

    // our header string
    private String headerStr;

    // our reference name
    private String referenceName;

    // reference length
    private int referenceLength;

    // the current location, keeping track of the offsets
    private long currentLocation = 1;

    // we have this variable becuase there is no eof for glf's
    private int lastRecordType = -1;

    private File myFile;

    /**
     * create a glf reader
     *
     * @param readFrom the file to read from
     */
    public GLFReader(File readFrom) {
        myFile = readFrom;

        try {
            inputBinaryCodec = new BinaryCodec(new DataInputStream(new BlockCompressedInputStream(readFrom)));
        } catch (IOException e) {
            throw new UserException.CouldNotReadInputFile(myFile, e);
        }

        inputBinaryCodec.setInputFileName(readFrom.getName());

        // first verify that it's a valid GLF
        for (short s : glfMagic) {
            if (inputBinaryCodec.readUByte() != s)
                throw new UserException.MalformedFile(myFile, "Verification of GLF format failed: magic string doesn't match)");
        }

        // get the header string
        headerStr = inputBinaryCodec.readLengthAndString(false);

        if (advanceContig()) {
            // setup the next record
            next();
        }

    }

    /**
     * read in a single point call
     *
     * @param refBase          the reference base
     * @param inputBinaryCodec the binary codec
     *
     * @return a single point call object
     */
    private GLFSingleCall generateSPC(char refBase, BinaryCodec inputBinaryCodec) {
        int offset = (int) inputBinaryCodec.readUInt();
        long depth = inputBinaryCodec.readUInt();
        short min_lk = (short) ((depth & 0x00000000ff000000) >> 24);
        int readDepth = (int) (depth & 0x0000000000ffffff);
        short rmsMapping = inputBinaryCodec.readUByte();
        double[] lkValues = new double[LikelihoodObject.GENOTYPE.values().length];
        for (int x = 0; x < LikelihoodObject.GENOTYPE.values().length; x++) {
            lkValues[x] = ((double)inputBinaryCodec.readUByte() / GLFRecord.LIKELIHOOD_SCALE_FACTOR + (double)min_lk);
        }
        return new GLFSingleCall(referenceName, refBase, (int)(offset+currentLocation), readDepth, rmsMapping, lkValues);
    }

    /**
     * read in a variable length call, and generate a VLC object from the data
     *
     * @param refBase          the reference base
     * @param inputBinaryCodec the input codex
     *
     * @return a GLFVariableLengthCall object
     */
    private GLFVariableLengthCall generateVLC(char refBase, BinaryCodec inputBinaryCodec) {
        int offset = (int) inputBinaryCodec.readUInt();
        int depth = (int) inputBinaryCodec.readUInt();
        short min_lk = (short) ((depth & 0x00000000ff000000) >> 24);
        int readDepth = (depth & 0x0000000000ffffff);
        short rmsMapping = inputBinaryCodec.readUByte();
        short lkHom1 = inputBinaryCodec.readUByte();
        short lkHom2 = inputBinaryCodec.readUByte();
        short lkHet = inputBinaryCodec.readUByte();
        int indelLen1 = (int) inputBinaryCodec.readShort();
        int indelLen2 = (int) inputBinaryCodec.readShort();

        int readCnt = Math.abs(indelLen1);
        short indelSeq1[] = new short[readCnt];
        for (int x = 0; x < readCnt; x++) {
            indelSeq1[x] = inputBinaryCodec.readUByte();
        }
        readCnt = Math.abs(indelLen2);
        short indelSeq2[] = new short[readCnt];
        for (int x = 0; x < readCnt; x++) {
            indelSeq2[x] = inputBinaryCodec.readUByte();
        }
        return new GLFVariableLengthCall(referenceName, refBase, offset+currentLocation, readDepth, rmsMapping, lkHom1, lkHom2, lkHet, indelLen1, indelSeq1, indelLen2, indelSeq2);
    }

    public boolean hasNext() {
        return (nextRecord != null);
    }

    public GLFRecord next() {
        GLFRecord ret = nextRecord;
        short firstBase = protectedByteReadForFile();
        if (firstBase == -1) return ret;

        // parse out the record type and reference base
        byte recordType = (byte) ((firstBase & 0x0f0) >> 4);
        char refBase = (char) (firstBase & 0x000f);
        lastRecordType = recordType;

        if (recordType == 1) {
            nextRecord = generateSPC(refBase, inputBinaryCodec);
        } else if (recordType == 2) {
            nextRecord = generateVLC(refBase, inputBinaryCodec);
        } else if (recordType == 0) {
            if (advanceContig()) {
                return next();
            }
            //nextRecord = null;
        } else {
            throw new UserException.MalformedFile(myFile, "Unknown GLF record type (type = " + recordType + ")");
        }
        if (nextRecord != null) currentLocation = nextRecord.getPosition();
        return ret;
    }

    /**
     * read a short, and if we see an exception only throw it if it's unexpected (not after a zero)
     * @return a short
     */
    private short protectedByteReadForFile() {
        short st = -1;
        try {
            st = inputBinaryCodec.readUByte();
        } catch (RuntimeEOFException exp) {
            nextRecord = null;
            if (lastRecordType != 0) {
                throw exp; // if the last record was a zero, this is an ok condition.  Otherwise throw an exception
            }
        }
        return st;
    }

    /**
     * advance to the next contig
     *
     * @return true if we could advance
     */
    private boolean advanceContig() {
        // try to read the next sequence record
        try {
            // get the reference name
            referenceName = inputBinaryCodec.readLengthAndString(true);

            // get the reference length - this may be a problem storing an unsigned int into a signed int.  but screw it.
            referenceLength = (int) inputBinaryCodec.readUInt();
            //System.err.println(referenceName.length());
            currentLocation = 1;
            return true;
        } catch (RuntimeException e) {
            if (lastRecordType != 0) {
                throw e; // if the last record was a zero, this is an ok condition.  Otherwise throw an exception
            }
            nextRecord = null;
        }
        return false;
    }

    public void remove() {
        throw new ReviewedStingException("GLFReader doesn't support remove()");
    }

    public void close() {
        inputBinaryCodec.close();
    }
    
    public String getHeaderStr() {
        return headerStr;
    }

}
