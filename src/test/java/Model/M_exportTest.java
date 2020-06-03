package Model;
// helpful links: https://junit.org/junit5/docs/current/user-guide/
import Model.projectData.M_projectData;

import java.io.FileNotFoundException;
import java.rmi.MarshalException;

import static org.junit.jupiter.api.Assertions.*;

class M_exportTest {
    // Testcases:
    // 1. test whether marshalling works with empty projectdata object
    // 2. empty filename
    // 3. filename with special signs (&,|, ³,\, ...)
    // --> alle 3 liefern Fehler --> d.h. keine Exception ist aufgetreten

    
    // 1. Testcase:
    @org.junit.jupiter.api.Test
    void jaxbObjectToXML_emptyProjectTest()
    {
        M_export export_test = new M_export();
        M_projectData projData_test = new M_projectData();
        String path = "test.xml";
        //Tests whether an error has occured by transforming from java into xml
        assertThrows(MarshalException.class, () ->export_test.export(projData_test, path));
    }

    // 2. Testcase:
    @org.junit.jupiter.api.Test
    void jaxbObjectToXML_emptyFilenameTest()
    {
        M_export export_test = new M_export();
        M_projectData projData_test = new M_projectData();
        projData_test.getM_projectData_productUse().setContent("TestProductUse");
        String path = "";
        //Tests whether the file at location path can be found
        assertThrows(FileNotFoundException.class, () ->export_test.export(projData_test, path));
    }

    // 3. Testcase:
    @org.junit.jupiter.api.Test
    void jaxbObjectToXML_FilenameTest()
    {
        M_export export_test = new M_export();
        M_projectData projData_test = new M_projectData();
        projData_test.getM_projectData_productUse().setContent("TestProductUse");
        String path = "$test/test=test(&%||)";
        //Tests whether the file at location path can be found
        assertThrows(FileNotFoundException.class, () ->export_test.export(projData_test, path));
    }
}