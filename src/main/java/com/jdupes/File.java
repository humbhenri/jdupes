package com.jdupes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: humberto
 * Date: 30/06/13
 * Time: 14:27
 */
public class File implements Comparable<File>{

    private final java.io.File file;

    public File(String source) {
        this.file = new java.io.File(source);
    }

    public String getName() {
        return file.getName();
    }

    public String getPath() {
        return file.getPath();
    }

    public long getSize() {
        return file.length();
    }

    /**
     *
     * @param o
     * @return true if the object denoted by o is a file that is a duplicate of this
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (getSize() != file.getSize()) return false;

        // compare by chunks
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(file.file));
        } catch (FileNotFoundException e) {
            return false;
        }
        BufferedReader thisReader = null;
        try {
            thisReader = new BufferedReader(new FileReader(this.file));
        } catch (FileNotFoundException e) {
            return false;
        }
        int len = 512;
        int fileread = 0;
        int thisread = 0;
        char[] filecbuf = new char[len];
        char[] thiscbuf = new char[len];
        while (fileread != -1 && thisread != -1) {
            try {
                fileread = fileReader.read(filecbuf);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            try {
                thisread = thisReader.read(thiscbuf);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            if (!Arrays.equals(filecbuf, thiscbuf)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return "File{" +
                "file=" + file + "; " +
                "size=" + getSize() +
                '}';
    }

    @Override
    public int compareTo(File o) {
        return Long.compare(o.getSize(), this.getSize());
    }
}
