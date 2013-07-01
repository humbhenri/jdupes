package com.jdupes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: humberto
 * Date: 30/06/13
 * Time: 18:15
 */
public class FileDuplicate {

    private List<File> files;

    public FileDuplicate() {
        this.files = new ArrayList<File>();
    }

    public boolean isEmpty() {
        return this.files.isEmpty();
    }

    public File get(int i) {
        return this.files.get(i);
    }

    public void add(File file) {
        this.files.add(file);
    }

    public int size() {
        return this.files.size();
    }

    @Override
    public String toString() {
        return "FileDuplicate{" +
                "size=" + this.files.size() + "; " +
                "files=" + files +
                "}\n";
    }
}
