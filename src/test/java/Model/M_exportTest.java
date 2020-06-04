/**
 * @autor: David
 * Responsible: David
 * Last edit date: 04.06.2020
 */
package Model;
// helpful links: https://junit.org/junit5/docs/current/user-guide/

import Model.projectData.M_projectData;
import org.junit.jupiter.api.Test;
import java.nio.file.InvalidPathException;
import static org.junit.jupiter.api.Assertions.*;

class M_exportTest {
    // Testcases:
    // 1. tests whether marshalling works with M_projectdata pointing to null
    // 2. empty filename or with blanks or null
    // 3. filename with special signs (&,|, ³,\, ...)
    
    // 1. Testcase:
    @Test
    void export_nullProjectTest()
    {
        M_export export_test = null;
        M_projectData projData_test = new M_projectData();
        String path = "test_export.xml";
        //Tests whether an error has occured by transforming from java into xml
        assertThrows(RuntimeException.class, () ->export_test.export(projData_test, path));
    }

    // 2. Testcase:
    @Test
    void export_emptyFilenameTest()
    {
        M_export export_test = new M_export();
        M_projectData projData_test = new M_projectData();
        projData_test.getM_projectData_productUse().setContent("TestProductUse");

        //Class 1 --> string with blanks
        String path1 = " ";
        //Tests whether the file at location path can be found
        assertThrows(RuntimeException.class, () -> export_test.export(projData_test, path1));

        //Class 2 --> Empty String
        String path2 = "";
        //Tests whether the file at location path can be found
        assertThrows(RuntimeException.class, () -> export_test.export(projData_test, path2));

        //Class 3 --> null
        String path3 = null;
        //Tests whether the file at location path can be found
        assertThrows(RuntimeException.class, () -> export_test.export(projData_test, path3));
    }

    // 3. Testcase:
    @Test
    void export_weirdFilenameTest()
    {
        M_export export_test = new M_export();
        M_projectData projData_test = new M_projectData();
        projData_test.getM_projectData_productUse().setContent("TestProductUse");
        String path1 = "$test/test=test(&%|?|).xml";
        //Tests whether the weird path from path1 is valid
        assertThrows(InvalidPathException.class, () ->export_test.export(projData_test, path1));

        //Tests whether the more realistic path from path2 is valid
        String path2 = "test_export?.xml";
        assertThrows(InvalidPathException.class, () ->export_test.export(projData_test, path2));
    }
}