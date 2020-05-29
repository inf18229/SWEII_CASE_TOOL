package Model;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

// This class imports an Object/Project from an XML file
public class M_projectData_import {
    M_projectData projectData;
    public M_projectData_import()
    {
        projectData = new M_projectData();
    }

    public M_projectData importProject(String path)
    {
        jaxbXmlFileToObject(path);
        return projectData;
    }

    // code from: https://howtodoinjava.com/jaxb/unmarshal-without-xmlrootelement/
    private void jaxbXmlFileToObject(String fileName)
    {
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
