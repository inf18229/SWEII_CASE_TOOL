/**
 * @autor: David
 * Responsible: David
 * Last edit date: 04.06.2020
 */
package Model;


import Model.projectData.M_projectData;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

//TODO: INFORMATION HIDING
//TODO: KONTROLLFLUSSGRAPH
// This class imports an Object/Project from an XML file
public class M_import {
    M_projectData projectData;

    public M_import() {
        projectData = new M_projectData();
    }

    // code idea from: https://howtodoinjava.com/jaxb/unmarshal-without-xmlrootelement/
    public M_projectData importProject(String path) {
        /**
         * This function imports a project by converting an XML file to the projectData Java Object
         * @param path the path for the project that has to be imported
         * @return projectData returns the loaded project in a M_projectData object
         */

        File xmlFile = new File(path);
        if (!xmlFile.exists()) {
            throw new RuntimeException("File does not exist");
        }

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(M_projectData.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            JAXBElement<M_projectData> jaxbElement = (JAXBElement<M_projectData>) jaxbUnmarshaller
                    .unmarshal(new StreamSource(xmlFile), M_projectData.class);

            M_projectData projectData_temp = jaxbElement.getValue();
            projectData = projectData_temp;
            System.out.println(projectData_temp);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return projectData;
    }
}
