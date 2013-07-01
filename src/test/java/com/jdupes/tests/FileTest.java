package com.jdupes.tests;

import com.jdupes.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: humberto
 * Date: 30/06/13
 * Time: 14:29
 */
@RunWith(JUnit4.class)
public class FileTest {

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
    public void testEquals() throws Exception {
        String folder = System.getProperty("java.io.tmpdir");
        com.jdupes.File file1 = new File(folder + java.io.File.separator + "A");
        com.jdupes.File file2 = new File(folder + java.io.File.separator + "B");
        com.jdupes.File file3 = new File(folder + java.io.File.separator + "C");

        assertEquals(file1, file2);
        assertFalse(file1.equals(file3));
    }

    @After
    public void deleteFiles() throws IOException{
        String folder = System.getProperty("java.io.tmpdir");
        new java.io.File(folder, "A").delete();
        new java.io.File(folder, "B").delete();
        new java.io.File(folder, "C").delete();
    }
}
