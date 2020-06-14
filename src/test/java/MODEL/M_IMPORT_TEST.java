package MODEL;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import org.junit.jupiter.api.Test;
import java.nio.file.InvalidPathException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * this class tests the M_IMPORT class
 */
class M_IMPORT_TEST {

    /**
     * tests M_IMPORT for throwing an InvalidPathException while importing the project data of a project if the XML file given by path does not exist
     */
    @Test
    void import_projectData_fileFromPathDoesNotExists() {
        M_IMPORT import_test = new M_IMPORT();
        String path = "testFiles/non_existing_file.xml";
        assertThrows(InvalidPathException.class, () -> import_test.importProject(path));
    }

    /**
     * test M_IMPORT for throwing an JAXBException while importing the project data of a project if the XML file given by path is empty
     */
    @Test
    void import_projectData_JAXBException(){
        M_IMPORT import_test = new M_IMPORT();
        String path = "testFiles/test_JAXBException.xml";
        assertThrows(IllegalStateException.class, () -> import_test.importProject(path));
    }

    /**
     * tests M_IMPORT for running without any problems while importing the project data of a project
     */
    @Test
    void import_projectData_cleanRun() {
       try{
           M_IMPORT import_test = new M_IMPORT();
           String path = "testFiles/test.xml";
           import_test.importProject(path);
       }
       catch(Exception e){
            e.getStackTrace();
            fail();
       }

    }

    /**
     * tests M_IMPORT for throwing an InvalidPathException while importing the config data of a project if the XML file given by path does not exist
     */
    @Test
    void import_configData_fileFromPathDoesNotExists() {
        M_IMPORT import_test = new M_IMPORT();
        M_PROJECTDATA projData_test = M_PROJECTDATA.getInstance();
        String path = "testFiles/non_existing_file.xml";
        assertThrows(InvalidPathException.class, () -> import_test.importProject(projData_test, path));
    }

    /**
     * tests M_IMPORT for throwing a NullPointerException while importing the config data of a project if the project that imports the config data is null
     */
    @Test
    void import_configData_nullProjectDataTest() {
        M_IMPORT import_test = new M_IMPORT();
        M_PROJECTDATA projData_test = null;
        String path = "testFiles/test_config.xml";

        //Tests whether the file at location path exists
        assertThrows(NullPointerException.class, () -> import_test.importProject(projData_test, path));
    }

    /**
     * test M_IMPORT for throwing an JAXBException while importing the config data of a project if the XML file given by path is empty
     */
    @Test
    void import_configData_JAXBException(){
        M_IMPORT import_test = new M_IMPORT();
        String path = "testFiles/test_config_JAXBException.xml";
        assertThrows(IllegalStateException.class, () -> import_test.importProject(path));
    }

    /**
     * tests M_IMPORT for running without any problems while importing the config data of a project
     */
    @Test
    void import_configData_cleanRun() {
        try{
            M_IMPORT import_test = new M_IMPORT();
            M_PROJECTDATA projData_test = M_PROJECTDATA.getInstance();
            String path = "testFiles/test_config.xml";
            import_test.importProject(projData_test, path);
        }
        catch(Exception e){
            e.getStackTrace();
            fail();
        }

    }


}