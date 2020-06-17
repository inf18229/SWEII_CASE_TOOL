package MODEL;

import MODEL.FUNCTIONPOINTESTIMATION.M_FUNCTIONPOINTESTIMATION_CONFIGDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA;
import org.junit.jupiter.api.Test;

import java.nio.file.InvalidPathException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * this class tests the M_EXPORT class
 */
class M_EXPORT_TEST {

    /**
     * tests M_EXPORT for throwing a NullPointerException while exporting the project data of a project if the project data is null
     */
    @Test
    void export_projectData_nullProjectDataTest() {
        System.out.println("/**\n" +
                " * tests M_EXPORT for throwing a NullPointerException while exporting the project data of a project if the project data is null\n" +
                " */");
        M_EXPORT export_test = new M_EXPORT();
        M_PROJECTDATA projData_test = null;
        String path = "testFiles/test_export.xml";
        assertThrows(NullPointerException.class, () -> export_test.export(projData_test, path));
    }

    /**
     * tests M_EXPORT for throwing a InvalidPathException while exporting the project data of  a project if the path is empty, only contains blanks or is null
     */
    @Test
    void export_projectData_emptyFilenameTest() {
        System.out.println("/**\n" +
                "     * tests M_EXPORT for throwing a InvalidPathException while exporting the project data of  a project if the path is empty, only contains blanks or is null\n" +
                "     */");
        M_EXPORT export_test = new M_EXPORT();
        M_PROJECTDATA projData_test = M_PROJECTDATA.getInstance();
        projData_test.getProductUse().content = "TestProductUse";

        String path1 = " ";
        assertThrows(InvalidPathException.class, () -> export_test.export(projData_test, path1));

        String path2 = "";
        assertThrows(InvalidPathException.class, () -> export_test.export(projData_test, path2));

        String path3 = null;
        assertThrows(NullPointerException.class, () -> export_test.export(projData_test, path3));
    }

    /**
     * tests M_EXPORT for running without an problems while exporting the project data of a project
     */
    @Test
    void export_projectData_cleanRun() {
        System.out.println("/**\n" +
                " * tests M_EXPORT for running without an problems while exporting the project data of a project\n" +
                " */");
        try {
            M_EXPORT export_test = new M_EXPORT();
            M_PROJECTDATA projData_test = M_PROJECTDATA.getInstance();
            projData_test.getProductUse().content = "TestProductUse";
            String path = "testFiles/test_projectData_cleanRun.xml";
            export_test.export(projData_test, path);
        } catch (Exception e) {
            e.getStackTrace();
            fail();
        }

    }

    /**
     * tests M_EXPORT for throwing a NullPointerException while exporting the config data of a project if the project data is null
     */
    @Test
    void export_configData_nullConfigDataTest() {
        System.out.println("/**\n" +
                " * tests M_EXPORT for throwing a NullPointerException while exporting the config data of a project if the project data is null\n" +
                " */");
        M_EXPORT export_test = new M_EXPORT();
        M_FUNCTIONPOINTESTIMATION_CONFIGDATA confData_test = null;
        String path = "testFiles/test_export.xml";
        assertThrows(NullPointerException.class, () -> export_test.export(confData_test, path));
    }

    /**
     * tests M_EXPORT for throwing a InvalidPathException while exporting the config data of a project if the path is empty, only contains blanks or is null
     */
    @Test
    void export_configData_emptyFilenameTest() {
        System.out.println("/**\n" +
                " * tests M_EXPORT for throwing a InvalidPathException while exporting the config data of a project if the path is empty, only contains blanks or is null\n" +
                " */");
        M_EXPORT export_test = new M_EXPORT();
        M_FUNCTIONPOINTESTIMATION_CONFIGDATA confData_test = M_FUNCTIONPOINTESTIMATION_CONFIGDATA.getInstance();

        String path1 = " ";
        assertThrows(InvalidPathException.class, () -> export_test.export(confData_test, path1));

        String path2 = "";
        assertThrows(InvalidPathException.class, () -> export_test.export(confData_test, path2));

        String path3 = null;
        assertThrows(NullPointerException.class, () -> export_test.export(confData_test, path3));
    }


    /**
     * tests M_EXPORT for running without any problems while exporting the config data of a project
     */
    @Test
    void export_configData_cleanRun() {
        System.out.println("/**\n" +
                " * tests M_EXPORT for running without any problems while exporting the config data of a project\n" +
                " */");
        try {
            M_EXPORT export_test = new M_EXPORT();
            M_FUNCTIONPOINTESTIMATION_CONFIGDATA confData_test = M_FUNCTIONPOINTESTIMATION_CONFIGDATA.getInstance();
            String path = "testFiles/test_configData_cleanRun.xml";
            export_test.export(confData_test, path);
        } catch (Exception e) {
            e.getStackTrace();
            fail();
        }
    }
}