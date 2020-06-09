/**
 * @autor: David
 * Responsible: David
 * Last edit date: 04.06.2020
 */
package MODEL;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class M_IMPORTTest {
    // Testcases:
    // 1. test if file from path exists

    // 1. Testcase:
    @Test
    void import_projectData_fileFromPathDoesNotExists() {
        M_IMPORT import_test = new M_IMPORT();
        String path = "non_existing_file.xml";

        //Tests whether the file at location path exists
        assertThrows(RuntimeException.class, () -> import_test.importProject(path));
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
       }

    }

    // 3. Testcase:
    @Test
    void import_configData_fileFromPathDoesNotExists() {
        M_IMPORT import_test = new M_IMPORT();
        M_PROJECTDATA projData_test = new M_PROJECTDATA();
        String path = "non_existing_file.xml";

        //Tests whether the file at location path exists
        assertThrows(RuntimeException.class, () -> import_test.importProject(projData_test, path));
    }

    // 4. Testcase:
    @Test
    void import_configData_nullProjectDataTest() {
        M_IMPORT import_test = new M_IMPORT();
        M_PROJECTDATA projData_test = null;
        String path = "test_config.xml";

        //Tests whether the file at location path exists
        assertThrows(RuntimeException.class, () -> import_test.importProject(projData_test, path));
    }

    // 5. Testcase:
    @Test
    void import_configData_cleanRun() {
        try{
            M_IMPORT import_test = new M_IMPORT();
            M_PROJECTDATA projData_test = new M_PROJECTDATA();
            String path = "test_config.xml";
            import_test.importProject(projData_test, path);
        }
        catch(Exception e){
            e.getStackTrace();
        }

    }


}