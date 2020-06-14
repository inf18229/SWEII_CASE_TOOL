package MODEL;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import MODEL.FUNCTIONPOINTESTIMATION.M_FUNCTIONPOINTESTIMATION_CONFIGDATA;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.nio.file.InvalidPathException;

/**
 * this class imports a project or a projects config Data from an XML file
 */
public class M_IMPORT {
    private M_PROJECTDATA projectData;
    private M_FUNCTIONPOINTESTIMATION_CONFIGDATA configData;

    /**
     * constructor of M_IMPORT class
     */
    public M_IMPORT() {
        projectData = M_PROJECTDATA.getInstance();
        configData = M_FUNCTIONPOINTESTIMATION_CONFIGDATA.getInstance();
    }

    /**
     * This function imports a project by converting an XML file to the M_PROJECTDATA Java Object
     * @param path the path for the project that has to be imported
     * @return projectData returns the loaded project in a M_PROJECTDATA object
     * @throws InvalidPathException
     * @source code idea from: https://howtodoinjava.com/jaxb/unmarshal-without-xmlrootelement/
     */
    public M_PROJECTDATA importProject(String path) throws InvalidPathException {
        File xmlFile = new File(path);
        if (!xmlFile.exists()) {
            projectData = null;
            throw new InvalidPathException(path, "Invalid path");
        } else {
            JAXBContext jaxbContext;
            try {
                jaxbContext = JAXBContext.newInstance(M_PROJECTDATA.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                JAXBElement<M_PROJECTDATA> jaxbElement = (JAXBElement<M_PROJECTDATA>) jaxbUnmarshaller
                        .unmarshal(new StreamSource(xmlFile), M_PROJECTDATA.class);

                M_PROJECTDATA projectData_temp = jaxbElement.getValue();
                projectData = projectData_temp;
                System.out.println(projectData_temp);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return projectData;
    }

    /**
     * This function imports a projects config data by converting a XML file to the M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA Java Object
     * @param projData the project where the imported configData should be inserted
     * @param path the path for the project that has to be imported
     * @throws InvalidPathException
     * @throws NullPointerException
     * @source code idea from: https://howtodoinjava.com/jaxb/unmarshal-without-xmlrootelement/
     */
    public void importProject(M_PROJECTDATA projData, String path) throws InvalidPathException, NullPointerException {
        File xmlFile = new File(path);
        if (!xmlFile.exists()) {
            throw new InvalidPathException(path, "Invalid path");
        } else if (projData == null) {
            throw new NullPointerException();
        } else {
            JAXBContext jaxbContext;
            try {
                jaxbContext = JAXBContext.newInstance(M_FUNCTIONPOINTESTIMATION_CONFIGDATA.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                JAXBElement<M_FUNCTIONPOINTESTIMATION_CONFIGDATA> jaxbElement = (JAXBElement<M_FUNCTIONPOINTESTIMATION_CONFIGDATA>) jaxbUnmarshaller
                        .unmarshal(new StreamSource(xmlFile), M_FUNCTIONPOINTESTIMATION_CONFIGDATA.class);

                M_FUNCTIONPOINTESTIMATION_CONFIGDATA confData_temp = jaxbElement.getValue();
                configData = confData_temp;
                System.out.println(configData);
                projData.setFunctionPointEstimation_configData(configData); //TODO: Kontrollflussgraph
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }
}
