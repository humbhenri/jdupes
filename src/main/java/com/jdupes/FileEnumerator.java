package com.jdupes;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: humberto
 * Date: 30/06/13
 * Time: 14:44
 */
public class FileEnumerator {
    private final String path;

    public FileEnumerator(String path) {
        this.path = path;
    }

    public File[] enumerateFilesRecursively() {
        List<File> files = enumerateFilesRecursively(this.path);
        File[] fileArray = files.toArray(new File[files.size()]);
        Arrays.sort(fileArray);
        return fileArray;
    }

    private List<File> enumerateFilesRecursively(String path) {
        List<File> result = new ArrayList<File>();
        java.io.File[] files = new java.io.File(path).listFiles();
        if (files == null) {
            return result;
        }
        for (java.io.File file : files) {
            if (file.isFile()) {
                File f = new File(file.getAbsolutePath());
                result.add(f);
            } else if (file.isDirectory()) {
                result.addAll(enumerateFilesRecursively(file.getAbsolutePath()));
            }
        }
        return result;
    }

    public String getPath() {
        return path;
    }
}
