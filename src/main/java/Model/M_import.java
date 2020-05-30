package Model;
/**
 * @autor: David
 *
 */

import Model.projectData.M_projectData;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

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
         * This function returns the loaded projectData
         */
        jaxbXmlFileToObject(path);
        return projectData;
    }

    // code from: https://howtodoinjava.com/jaxb/unmarshal-without-xmlrootelement/
    private void jaxbXmlFileToObject(String fileName)
    {
        /**
         * This function converts the XML file to the projectData Java Object
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
