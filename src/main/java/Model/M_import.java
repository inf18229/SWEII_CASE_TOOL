package Model;


import Model.projectData.M_projectData;
import Model.projectData.M_projectData_functionPointEstimation_configData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

//TODO: KONTROLLFLUSSGRAPH
// This class imports an Object/Project from an XML file
public class M_import {
    /**
     * this class imports a Project from an XML file
     */
    private M_projectData projData;
    private M_projectData_functionPointEstimation_configData confData;

    public M_import() {
        projData = new M_projectData();
        confData = new M_projectData_functionPointEstimation_configData();
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
        else {
            JAXBContext jaxbContext;
            try {
                jaxbContext = JAXBContext.newInstance(M_projectData.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                JAXBElement<M_projectData> jaxbElement = (JAXBElement<M_projectData>) jaxbUnmarshaller
                        .unmarshal(new StreamSource(xmlFile), M_projectData.class);

                M_projectData projectData_temp = jaxbElement.getValue();
                projData = projectData_temp;
                System.out.println(projectData_temp);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return projData;
    }

    public void importProject(M_projectData projData, String path) {
        /**
         * This function imports a project by converting an XML file to the projectData Java Object
         * @param path the path for the project that has to be imported
         * @return projectData returns the loaded project in a M_projectData object
         */

        File xmlFile = new File(path);
        if (!xmlFile.exists() && projData != null) {
            throw new RuntimeException("Parameter failure");
        }
        else {
            JAXBContext jaxbContext;
            try {
                jaxbContext = JAXBContext.newInstance(M_projectData_functionPointEstimation_configData.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                JAXBElement<M_projectData_functionPointEstimation_configData> jaxbElement = (JAXBElement<M_projectData_functionPointEstimation_configData>) jaxbUnmarshaller
                        .unmarshal(new StreamSource(xmlFile), M_projectData_functionPointEstimation_configData.class);

                M_projectData_functionPointEstimation_configData confData_temp = jaxbElement.getValue();
                confData = confData_temp;
                System.out.println(confData);
                projData.setM_projectData_functionPointEstimation_configData(confData); //TODO: check if relevant für Tests? (in fPEstimation muss eine Referenz auf die configData gehalten werden, sonst werden die Berechnungen zu kompliziert) sh. ProjectData Funktion
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }
}
