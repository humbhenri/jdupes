package com.jdupes.tests;

import com.jdupes.FileComparator;
import com.jdupes.FileDuplicate;
import com.jdupes.FileEnumerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: humberto
 * Date: 30/06/13
 * Time: 18:12
 */
@RunWith(JUnit4.class)
public class FileComparatorTest {

    @Before
    public void createFiles() throws IOException {
        String tempFolder = System.getProperty("java.io.tmpdir");
        BufferedWriter writer = new BufferedWriter(new FileWriter(new java.io.File(tempFolder, "A")));
        writer.write("A B C D");
        writer.close();

        writer = new BufferedWriter(new FileWriter(new java.io.File(tempFolder, "B")));
        writer.write("A B C D");
        writer.close();

        writer = new BufferedWriter(new FileWriter(new java.io.File(tempFolder, "C")));
        writer.write("A B C");
        writer.close();
    }

    @Test
    public void testGetDuplicates() throws Exception {
        String folder = System.getProperty("java.io.tmpdir");
        FileComparator fileComparator = new FileComparator(new FileEnumerator(folder).enumerateFilesRecursively());
        List<FileDuplicate> duplicates = fileComparator.getDuplicates();
        System.out.println(duplicates);
        assertTrue(duplicates.size() > 0);
    }

    @After
    public void deleteFiles() throws IOException{
        String folder = System.getProperty("java.io.tmpdir");
        new java.io.File(folder, "A").delete();
        new java.io.File(folder, "B").delete();
        new java.io.File(folder, "C").delete();
    }
}
