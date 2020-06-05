/**
 * @autor: David
 * Responsible: David
 * Last edit date: 04.06.2020
 */
package Model;

import Model.projectData.M_projectData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Paths;

public class M_export {
    /**
     * this class saves the current Project to XML
     */
    public M_export() {

    }


    //code idea from: https://howtodoinjava.com/jaxb/write-object-to-xml/
    public void export(M_projectData projData, String projPath) {
        /**
         * this function converts the current project to XML and saves the new XML file
         * @param projData the projectData of the current project
         * @param projPath the Path that defines where to save the data into a XML file
         */
        if (projPath != null && !projPath.isEmpty() && !projPath.isBlank() && projData != null) {
            //check for a valid path
            try {
                Paths.get(projPath);
            }
            // finally used because using the try block without catch or finally not possible
            finally {

            }
            try {
                //Create JAXB Context
                JAXBContext jaxbContext = JAXBContext.newInstance(M_projectData.class);

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
        } else {
            throw new RuntimeException("Invalid filename");
        }
    }
}



