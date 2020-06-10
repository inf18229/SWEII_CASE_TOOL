package MODEL;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

//TODO: KONTROLLFLUSSGRAPH
//TODO: Reicht es einmal im Try Block zu sein für Zweigabdeckung

//TODO: check why factorEntanglement doesn't get exported!

public class M_EXPORT {
    /**
     * this class saves the current Project to XML
     */
    public M_EXPORT() {

    }


    //code idea from: https://howtodoinjava.com/jaxb/write-object-to-xml/
    public void export(M_PROJECTDATA projData, String projPath) throws InvalidPathException, NullPointerException {
        /**
         * this function converts the current project to XML and saves the new XML file
         * @param projData the projectData of the current project
         * @param projPath the Path that defines where to save the data into a XML file
         */
        if (projPath != null && projData != null) {
            if(!projPath.isEmpty() && !projPath.isBlank()) {
                try {
                    //Create JAXB Context
                    JAXBContext jaxbContext = JAXBContext.newInstance(M_PROJECTDATA.class);

                    //Create Marshaller
                    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                    //Required formatting??
                    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                    //Store XML to File
                    projPath = projPath.trim(); //delete whitespaces at beginning and ending
                    File file = new File(projPath); //ToDo: Pathname aktualisieren

                    //Writes XML file to file-system
                    jaxbMarshaller.marshal(projData, file);
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
            else{
                throw new InvalidPathException(projPath, "Invalid Filename");
            }
        } else {
            throw new NullPointerException();
        }
    }

    public void export(M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA confData, String confPath) {
        /**
         * this function converts the current project to XML and saves the new XML file
         * @param projData the projectData of the current project
         * @param projPath the Path that defines where to save the data into a XML file
         */
        if (confPath != null && !confPath.isEmpty() && !confPath.isBlank() && confData != null) {
            //check for a valid path
            try {
                Paths.get(confPath);
            }
            // finally used because using the try block without catch or finally not possible
            finally {

            }
            try {
                //Create JAXB Context
                JAXBContext jaxbContext = JAXBContext.newInstance(M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA.class);

                //Create Marshaller
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                //Required formatting??
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                //Store XML to File
                confPath = confPath.trim(); //delete whitespaces at beginning and ending
                File file = new File(confPath); //ToDo: Pathname aktualisieren

                //Writes XML file to file-system
                jaxbMarshaller.marshal(confData, file);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("Invalid filename");
        }
    }
}



