/**
 * @autor: David
 * Responsible: David
 * Last edit date: 10.06.2020
 */

package MODEL;
// helpful links: https://junit.org/junit5/docs/current/user-guide/

import MODEL.FUNCTIONPOINTESTIMATION.M_FUNCTIONPOINTESTIMATION_CONFIGDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA;
import org.junit.jupiter.api.Test;

import java.nio.file.InvalidPathException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

//TODO: JAXBException --> Kein Test weil wir davon ausgehen dass JAXB korrekt durchläuft

// TODO: TOP PRIORITY!!! change path to testFiles

class M_EXPORT_TEST {
    // Equivalence classes:
    // 1. tests whether marshalling works with M_projectdata pointing to null
    // 2. empty filename or with blanks or null
    // 3. filename with special signs (&,|, ³,\, ...)

    // 1. Testcase:
    @Test
    void export_projectData_nullProjectDataTest() {
        M_EXPORT export_test = new M_EXPORT();
        M_PROJECTDATA projData_test = null;
        String path = "test_export.xml";
        //Tests whether an error has occured by transforming from java into xml
        assertThrows(NullPointerException.class, () -> export_test.export(projData_test, path));
    }

    // 2. Testcase:
    @Test
    void export_projectData_emptyFilenameTest() {
        M_EXPORT export_test = new M_EXPORT();
        M_PROJECTDATA projData_test = M_PROJECTDATA.getInstance();
        projData_test.getProductUse().content = "TestProductUse";

        //Class 1 --> string with blanks
        String path1 = " ";
        //Tests whether the file at location path can be found
        assertThrows(InvalidPathException.class, () -> export_test.export(projData_test, path1));

        //Class 2 --> Empty String
        String path2 = "";
        //Tests whether the file at location path can be found
        assertThrows(InvalidPathException.class, () -> export_test.export(projData_test, path2));

        //Class 3 --> null
        String path3 = null;
        //Tests whether the file at location path can be found
        assertThrows(NullPointerException.class, () -> export_test.export(projData_test, path3));
    }


    //3. Testcase
    @Test
    void export_projectData_cleanRun() {
        try {
            M_EXPORT export_test = new M_EXPORT();
            M_PROJECTDATA projData_test = M_PROJECTDATA.getInstance();
            projData_test.getProductUse().content = "TestProductUse";
            String path = "test.xml";
            export_test.export(projData_test, path);
        } catch (Exception e) {
            e.getStackTrace();
            fail();
        }

    }

    // 4. Testcase:
    @Test
    void export_configData_nullProjectDataTest() {
        M_EXPORT export_test = new M_EXPORT();
        M_FUNCTIONPOINTESTIMATION_CONFIGDATA confData_test = null;
        String path = "test_export.xml";
        //Tests whether an error has occured by transforming from java into xml
        assertThrows(NullPointerException.class, () -> export_test.export(confData_test, path));
    }

    // 5. Testcase:
    @Test
    void export_configData_emptyFilenameTest() {
        M_EXPORT export_test = new M_EXPORT();
        M_FUNCTIONPOINTESTIMATION_CONFIGDATA confData_test = M_FUNCTIONPOINTESTIMATION_CONFIGDATA.getInstance();

        //Class 1 --> string with blanks
        String path1 = " ";
        //Tests whether the file at location path can be found
        assertThrows(InvalidPathException.class, () -> export_test.export(confData_test, path1));

        //Class 2 --> Empty String
        String path2 = "";
        //Tests whether the file at location path can be found
        assertThrows(InvalidPathException.class, () -> export_test.export(confData_test, path2));

        //Class 3 --> null
        String path3 = null;
        //Tests whether the file at location path can be found
        assertThrows(NullPointerException.class, () -> export_test.export(confData_test, path3));
    }


    // 6. Testcase
    @Test
    void export_configData_cleanRun() {
        try {
            M_EXPORT export_test = new M_EXPORT();
            M_FUNCTIONPOINTESTIMATION_CONFIGDATA confData_test = M_FUNCTIONPOINTESTIMATION_CONFIGDATA.getInstance();
            String path = "test_config.xml";
            export_test.export(confData_test, path);
        } catch (Exception e) {
            e.getStackTrace();
            fail();
        }
    }
}