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
     * and for throwing a NullPointerException if the path string is null
     */
    @Test
    void import_projectData_fileFromPathDoesNotExists() {
        System.out.println("/**\n" +
                " * tests M_IMPORT for throwing an InvalidPathException while importing the project data of a project if the XML file given by path does not exist\n" +
                " * and for throwing a NullPointerException if the path string is null\n" +
                " */");
        M_IMPORT import_test = new M_IMPORT();
        String path1 = "testFiles/non_existing_file.xml";
        assertThrows(InvalidPathException.class, () -> import_test.importProject(path1));

        String path2 = null;
        assertThrows(NullPointerException.class, () -> import_test.importProject(path2));
    }

    /**
     * test M_IMPORT for throwing an JAXBException while importing the project data of a project if the XML file given by path is empty
     */
    @Test
    void import_projectData_JAXBException() {
        System.out.println("/**\n" +
                " * test M_IMPORT for throwing an JAXBException while importing the project data of a project if the XML file given by path is empty\n" +
                " */");
        M_IMPORT import_test = new M_IMPORT();
        String path = "testFiles/test_JAXBException.xml";
        assertThrows(IllegalStateException.class, () -> import_test.importProject(path));
    }

    /**
     * tests M_IMPORT for running without any problems while importing the project data of a project
     */
    @Test
    void import_projectData_cleanRun() {
        System.out.println("/**\n" +
                " * tests M_IMPORT for running without any problems while importing the project data of a project\n" +
                " */");
        try {
            M_IMPORT import_test = new M_IMPORT();
            String path = "testFiles/test.xml";
            import_test.importProject(path);
        } catch (Exception e) {
            e.getStackTrace();
            fail();
        }

    }

    /**
     * tests M_IMPORT for throwing an InvalidPathException while importing the config data of a project if the XML file given by path does not exist
     */
    @Test
    void import_configData_fileFromPathDoesNotExists() {
        System.out.println("/**\n" +
                " * tests M_IMPORT for throwing an InvalidPathException while importing the config data of a project if the XML file given by path does not exist\n" +
                " */");
        M_IMPORT import_test = new M_IMPORT();
        M_PROJECTDATA projData_test = M_PROJECTDATA.getInstance();
        String path1 = "testFiles/non_existing_file.xml";
        assertThrows(InvalidPathException.class, () -> import_test.importProject(projData_test, path1));

        String path2 = null;
        assertThrows(NullPointerException.class, () -> import_test.importProject(projData_test, path2));
    }

    /**
     * tests M_IMPORT for throwing a NullPointerException while importing the config data of a project if the project that imports the config data is null
     * and for throwing a NullPointerException if the path string is null
     */
    @Test
    void import_configData_nullProjectDataTest() {
        System.out.println("/**\n" +
                " * tests M_IMPORT for throwing a NullPointerException while importing the config data of a project if the project that imports the config data is null\n" +
                " * and for throwing a NullPointerException if the path string is null\n" +
                " */");
        M_IMPORT import_test = new M_IMPORT();
        M_PROJECTDATA projData_test = null;
        String path = "testFiles/test_config.xml";
        assertThrows(NullPointerException.class, () -> import_test.importProject(projData_test, path));
    }

    /**
     * test M_IMPORT for throwing an JAXBException while importing the config data of a project if the XML file given by path is empty
     */
    @Test
    void import_configData_JAXBException() {
        System.out.println("/**\n" +
                " * test M_IMPORT for throwing an JAXBException while importing the config data of a project if the XML file given by path is empty\n" +
                " */");
        M_IMPORT import_test = new M_IMPORT();
        String path = "testFiles/test_config_JAXBException.xml";
        assertThrows(IllegalStateException.class, () -> import_test.importProject(path));
    }

    /**
     * tests M_IMPORT for running without any problems while importing the config data of a project
     */
    @Test
    void import_configData_cleanRun() {
        System.out.println("/**\n" +
                " * test M_IMPORT for throwing an JAXBException while importing the config data of a project if the XML file given by path is empty\n" +
                " */");
        try {
            M_IMPORT import_test = new M_IMPORT();
            M_PROJECTDATA projData_test = M_PROJECTDATA.getInstance();
            String path = "testFiles/test_config.xml";
            import_test.importProject(projData_test, path);
        } catch (Exception e) {
            e.getStackTrace();
            fail();
        }

    }


}