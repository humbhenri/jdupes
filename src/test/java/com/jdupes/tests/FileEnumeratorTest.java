package com.jdupes.tests;

import com.jdupes.File;
import com.jdupes.FileEnumerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: humberto
 * Date: 30/06/13
 * Time: 14:44
 */
@RunWith(JUnit4.class)
public class FileEnumeratorTest {

    @Test
    public void testEnumerate() throws Exception {
        String path = ".";
        FileEnumerator fileEnumerator = new FileEnumerator(path);
        File[] result = fileEnumerator.enumerateFilesRecursively();
        for (File file : result) {
            System.out.println(file);
        }
        assertTrue(result.length > 0);
    }
}
