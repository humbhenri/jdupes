package com.jdupes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: humberto
 * Date: 30/06/13
 * Time: 17:59
 */
public class FileComparator {

    private final File[] files;

    public FileComparator(File[] files) {
        this.files = files;
    }

    public List<FileDuplicate> getDuplicates() {
        // we assume that files is sorted by size
        List<FileDuplicate> result = new ArrayList<FileDuplicate>();
        int i = 0;
        FileDuplicate duplicates = new FileDuplicate();
        while (i < files.length) {
            if (duplicates.isEmpty() || duplicates.get(0).equals(files[i])) {
                duplicates.add(files[i]);
                i++;
            } else {
                if (duplicates.size() > 1) {
                    result.add(duplicates);
                }
                duplicates = new FileDuplicate();
            }
        }
        return result;
    }
}
