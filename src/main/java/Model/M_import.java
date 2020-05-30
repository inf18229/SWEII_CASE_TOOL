package Model;
/**
 * @autor: David
 * Resposible: David
 * Last edit date: 30.05.2020
 */

import Model.projectData.M_projectData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

// This class imports an Object/Project from an XML file
public class M_import {
    M_projectData projectData;
    public M_import()
    {
        projectData = new M_projectData();
    }

    public M_projectData importProject(String path)
    {
        /**
         * this function calls the jaxXmlFileToObject function to import a project
         * @param path the path for the project that has to be imported
         * @return projectData returns the loaded project
         */
        jaxbXmlFileToObject(path);
        return projectData;
    }

    // code from: https://howtodoinjava.com/jaxb/unmarshal-without-xmlrootelement/
    private void jaxbXmlFileToObject(String fileName)
    {
        /**
         * This function imports a project by converting an XML file to the projectData Java Object
         * @param fileName the path for the project that has to be imported
         */
        File xmlFile = new File(fileName);
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(M_projectData.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            JAXBElement<M_projectData> jaxbElement = (JAXBElement<M_projectData>) jaxbUnmarshaller
                    .unmarshal(new StreamSource(xmlFile), M_projectData.class);

            M_projectData projectData_temp = jaxbElement.getValue();
            projectData = projectData_temp;
            System.out.println(projectData_temp);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
