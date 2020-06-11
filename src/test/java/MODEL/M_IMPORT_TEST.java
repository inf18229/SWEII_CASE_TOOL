/**
 * @autor: David
 * Responsible: David
 * Last edit date: 10.06.2020
 */
package MODEL;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import org.junit.jupiter.api.Test;

import java.nio.file.InvalidPathException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class M_IMPORT_TEST {
    // Testcases:
    // 1. test if file from path exists

    // 1. Testcase:
    @Test
    void import_projectData_fileFromPathDoesNotExists() {
        M_IMPORT import_test = new M_IMPORT();
        String path = "non_existing_file.xml";

        //Tests whether the file at location path exists
        assertThrows(InvalidPathException.class, () -> import_test.importProject(path));
    }

    // 2. Testcase:
    @Test
    void import_projectData_cleanRun() {
       try{
           M_IMPORT import_test = new M_IMPORT();
           String path = "test.xml";
           import_test.importProject(path);
       }
       catch(Exception e){
            e.getStackTrace();
            fail();
       }

    }

    // 3. Testcase:
    @Test
    void import_configData_fileFromPathDoesNotExists() {
        M_IMPORT import_test = new M_IMPORT();
        M_PROJECTDATA projData_test = M_PROJECTDATA.getInstance();
        String path = "non_existing_file.xml";

        //Tests whether the file at location path exists
        assertThrows(InvalidPathException.class, () -> import_test.importProject(projData_test, path));
    }

    // 4. Testcase:
    @Test
    void import_configData_nullProjectDataTest() {
        M_IMPORT import_test = new M_IMPORT();
        M_PROJECTDATA projData_test = null;
        String path = "test_config.xml";

        //Tests whether the file at location path exists
        assertThrows(NullPointerException.class, () -> import_test.importProject(projData_test, path));
    }

    // 5. Testcase:
    @Test
    void import_configData_cleanRun() {
        try{
            M_IMPORT import_test = new M_IMPORT();
            M_PROJECTDATA projData_test = M_PROJECTDATA.getInstance();
            String path = "test_config.xml";
            import_test.importProject(projData_test, path);
        }
        catch(Exception e){
            e.getStackTrace();
            fail();
        }

    }


}