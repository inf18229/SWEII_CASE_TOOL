/**
 * @autor: David
 * Responsible: David
 * Last edit date: 04.06.2020
 */
package Model;

import Model.projectData.M_projectData;
import org.junit.jupiter.api.Test;

import java.nio.file.InvalidPathException;

import static org.junit.jupiter.api.Assertions.*;

class M_importTest {
    // Testcases:
    // 1. test if file from path exists

    // 1. Testcase:
    @Test
    void import_fileFromPathExists()
    {
        M_import import_test = new M_import();
        String path = "test.xml";

        //Tests whether the file at location path exists
        assertThrows(RuntimeException.class, () -> import_test.importProject(path));
    }


}