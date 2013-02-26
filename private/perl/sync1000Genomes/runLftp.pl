#!/usr/bin/perl -w

# Runs lftp to pull down a file

use strict;
use Getopt::Long;

my $file = undef;
GetOptions( "file=s" => \$file);

if ( !$file ) {
    print "Usage: runLftp.pl\n\t-file \t<file>\n";
    exit(1);
}

chomp($file);

$file =~ m/data\/(.*)\/(.*)\/.*/;

my $dir = "/humgen/1kg/DCC/ftp/data/$1/";
mkdir($dir) unless(-d $dir);
$dir = "/humgen/1kg/DCC/ftp/data/$1/$2/";
mkdir($dir) unless(-d $dir);
chdir $dir;

open (TMP, '>lftp.txt');
print TMP "get ftp://ftp-trace.ncbi.nih.gov/1000genomes/ftp/$file\n";
close (TMP);

my $cmd = "lftp -f lftp.txt";
system($cmd);

unlink "lftp.txt";
