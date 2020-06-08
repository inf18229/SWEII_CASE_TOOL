package Model;
// helpful links: https://junit.org/junit5/docs/current/user-guide/

import Model.projectData.M_projectData;
import Model.projectData.M_projectData_functionPointEstimation_configData;
import org.junit.jupiter.api.Test;

import java.nio.file.InvalidPathException;

import static org.junit.jupiter.api.Assertions.*;

//TODO: JAXBException --> Kein Test weil wir davon ausgehen dass JAXB korrekt durchläuft
class M_exportTest {
    // Equivilence classes:
    // 1. tests whether marshalling works with M_projectdata pointing to null
    // 2. empty filename or with blanks or null
    // 3. filename with special signs (&,|, ³,\, ...)

    // 1. Testcase:
    @Test
    void export_projectData_nullProjectTest() {
        M_export export_test = new M_export();
        M_projectData projData_test = null;
        String path = "test_export.xml";
        //Tests whether an error has occured by transforming from java into xml
        assertThrows(RuntimeException.class, () -> export_test.export(projData_test, path));
    }

    // 2. Testcase:
    @Test
    void export_projectData_emptyFilenameTest() {
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
    void export_projectData_weirdFilenameTest() {
        M_export export_test = new M_export();
        M_projectData projData_test = new M_projectData();
        projData_test.getM_projectData_productUse().setContent("TestProductUse");
        String path1 = "$test/test=test(&%|?|).xml";
        //Tests whether the weird path from path1 is valid
        assertThrows(InvalidPathException.class, () -> export_test.export(projData_test, path1));

        //Tests whether the more realistic path from path2 is valid
        String path2 = "test_export?.xml";
        assertThrows(InvalidPathException.class, () -> export_test.export(projData_test, path2));
    }

    //4. Testcase
    @Test
    void export_projectData_cleanRun() {
        try {
            M_export export_test = new M_export();
            M_projectData projData_test = new M_projectData();
            projData_test.getM_projectData_productUse().setContent("TestProductUse");
            String path = "test.xml";
            export_test.export(projData_test, path);
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    // 5. Testcase:
    @Test
    void export_configData_nullProjectDataTest() {
        M_export export_test = new M_export();
        M_projectData_functionPointEstimation_configData confData_test = null;
        String path = "test_export.xml";
        //Tests whether an error has occured by transforming from java into xml
        assertThrows(RuntimeException.class, () -> export_test.export(confData_test, path));
    }

    // 6. Testcase:
    @Test
    void export_configData_emptyFilenameTest() {
        M_export export_test = new M_export();
        M_projectData_functionPointEstimation_configData confData_test = new M_projectData_functionPointEstimation_configData();

        //Class 1 --> string with blanks
        String path1 = " ";
        //Tests whether the file at location path can be found
        assertThrows(RuntimeException.class, () -> export_test.export(confData_test, path1));

        //Class 2 --> Empty String
        String path2 = "";
        //Tests whether the file at location path can be found
        assertThrows(RuntimeException.class, () -> export_test.export(confData_test, path2));

        //Class 3 --> null
        String path3 = null;
        //Tests whether the file at location path can be found
        assertThrows(RuntimeException.class, () -> export_test.export(confData_test, path3));
    }

    // 7. Testcase:
    @Test
    void export_configData_weirdFilenameTest() {
        M_export export_test = new M_export();
        M_projectData_functionPointEstimation_configData confData_test = new M_projectData_functionPointEstimation_configData();
        String path1 = "$test/test=test(&%|?|).xml";
        //Tests whether the weird path from path1 is valid
        assertThrows(InvalidPathException.class, () -> export_test.export(confData_test, path1));

        //Tests whether the more realistic path from path2 is valid
        String path2 = "test_export?.xml";
        assertThrows(InvalidPathException.class, () -> export_test.export(confData_test, path2));
    }

    // 8. Testcase
    @Test
    void export_configData_cleanRun() {
        try {
            M_export export_test = new M_export();
            M_projectData_functionPointEstimation_configData confData_test = new M_projectData_functionPointEstimation_configData();
            String path = "test_config.xml";
            export_test.export(confData_test, path);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}