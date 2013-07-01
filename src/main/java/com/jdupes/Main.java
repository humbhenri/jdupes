package com.jdupes;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    if (args.length != 1) {
            System.out.println("NAME\n\tjdupes - find duplicate files in a given path" +
                    "\nSYNOPSYS\n\tjdupes [path]");
        } else {
            List<FileDuplicate> duplicates = new FileComparator(
                    new FileEnumerator(args[0]).enumerateFilesRecursively()).getDuplicates();
            for (FileDuplicate duplicate : duplicates) {
                for (int i=0; i<duplicate.size(); i++) {
                    System.out.println(duplicate.get(i).getPath());
                }
                System.out.println();
            }
        }
    }
}
