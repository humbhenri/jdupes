Find duplicate files
---------------------

Given a path the program enumerate all the duplicates. The set of duplicates is separated of
each other by an empty line.

Build
-----
mvn clean package

Usage
-----
java -jar jdupes [path]

Benchmark
---------
System: Macbook Pro, Core 2 Duo 2.4 GHz, 4 GB 1067 MHz DDR3
Folder size: 54 MB

time java -jar jdupes [path]
real	0m13.089s
user	0m2.293s
sys	0m0.809s
