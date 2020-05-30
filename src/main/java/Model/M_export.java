/**
 * @autor: David
 * Responsible: David
 * Last edit date: 30.05.2020
 */
package Model;

import Model.projectData.M_projectData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class M_export {
    /**
     *this class saves the current Project to XML
     */
    public M_export()
    {

    }
    public void export(M_projectData temp_projectData)
    {
        jaxbObjectToXML(temp_projectData);
    }

    //code from: https://howtodoinjava.com/jaxb/write-object-to-xml/
    private static void jaxbObjectToXML(M_projectData projData)
    {
        /**
         * this function converts the current project to XML and saves the new XML file
         * @param projData the projectData of the current project
         */
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(M_projectData.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Store XML to File
            File file = new File("test.xml"); //ToDo: Pathname aktualisieren

            //Writes XML file to file-system
            jaxbMarshaller.marshal(projData, file);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}


