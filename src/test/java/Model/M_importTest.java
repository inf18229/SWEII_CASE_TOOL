/**
 * @autor: David
 * Responsible: David
 * Last edit date: 04.06.2020
 */
package Model;

import Model.projectData.M_projectData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class M_importTest {
    // Testcases:
    // 1. test if file from path exists

    // 1. Testcase:
    @Test
    void import_projectData_fileFromPathDoesNotExists() {
        M_import import_test = new M_import();
        String path = "non_existing_file.xml";

        //Tests whether the file at location path exists
        assertThrows(RuntimeException.class, () -> import_test.importProject(path));
    }

    // 2. Testcase:
    @Test
    void import_projectData_cleanRun() {
       try{
           M_import import_test = new M_import();
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
        M_import import_test = new M_import();
        M_projectData projData_test = new M_projectData();
        String path = "non_existing_file.xml";

        //Tests whether the file at location path exists
        assertThrows(RuntimeException.class, () -> import_test.importProject(projData_test, path));
    }

    // 4. Testcase:
    @Test
    void import_configData_nullProjectDataTest() {
        M_import import_test = new M_import();
        M_projectData projData_test = null;
        String path = "test_config.xml";

        //Tests whether the file at location path exists
        assertThrows(RuntimeException.class, () -> import_test.importProject(projData_test, path));
    }

    // 5. Testcase:
    @Test
    void import_configData_cleanRun() {
        try{
            M_import import_test = new M_import();
            M_projectData projData_test = new M_projectData();
            String path = "test_config.xml";
            import_test.importProject(projData_test, path);
        }
        catch(Exception e){
            e.getStackTrace();
        }

    }


}