/**
 * @autor: David
 * Responsible: David
 * Last edit date: 10.06.2020
 */

package MODEL;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.nio.file.InvalidPathException;

//TODO: KONTROLLFLUSSGRAPH
// This class imports an Object/Project from an XML file
public class M_IMPORT {
    /**
     * this class imports a project or a projects config Data from an XML file
     */
    private M_PROJECTDATA projData;
    private M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA confData;

    public M_IMPORT() {
        projData = M_PROJECTDATA.getInstance();
        confData = M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA.getInstance();
    }

    // code idea from: https://howtodoinjava.com/jaxb/unmarshal-without-xmlrootelement/
    public M_PROJECTDATA importProject(String path) throws InvalidPathException {
        /**
         * This function imports a project by converting an XML file to the M_PROJECTDATA Java Object
         * @param path the path for the project that has to be imported
         * @return projectData returns the loaded project in a M_PROJECTDATA object
         */
        File xmlFile = new File(path);
        if (!xmlFile.exists()) {
            projData = null;
            throw new InvalidPathException(path, "Invalid path");
        } else {
            JAXBContext jaxbContext;
            try {
                jaxbContext = JAXBContext.newInstance(M_PROJECTDATA.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                JAXBElement<M_PROJECTDATA> jaxbElement = (JAXBElement<M_PROJECTDATA>) jaxbUnmarshaller
                        .unmarshal(new StreamSource(xmlFile), M_PROJECTDATA.class);

                M_PROJECTDATA projectData_temp = jaxbElement.getValue();
                projData = projectData_temp;
                System.out.println(projectData_temp);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return projData;
    }

    public void importProject(M_PROJECTDATA projData, String path) throws InvalidPathException, NullPointerException {
        /**
         * This function imports a projects config data by converting a XML file to the M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA Java Object
         * @param path the path for the project that has to be imported
         * @param projData the project where the imported configData should be inserted
         */

        File xmlFile = new File(path);
        if (!xmlFile.exists()) {
            throw new InvalidPathException(path, "Invalid path");
        } else if (projData == null) {
            throw new NullPointerException();
        } else {
            JAXBContext jaxbContext;
            try {
                jaxbContext = JAXBContext.newInstance(M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                JAXBElement<M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA> jaxbElement = (JAXBElement<M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA>) jaxbUnmarshaller
                        .unmarshal(new StreamSource(xmlFile), M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA.class);

                M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA confData_temp = jaxbElement.getValue();
                confData = confData_temp;
                System.out.println(confData);
                projData.setM_projectData_functionPointEstimation_configData(confData); //TODO: check if relevant für Tests? (in fPEstimation muss eine Referenz auf die configData gehalten werden, sonst werden die Berechnungen zu kompliziert) sh. ProjectData Funktion
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }
}
