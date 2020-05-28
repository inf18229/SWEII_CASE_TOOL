package Model;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

public class M_projectData_export {

    M_projectData projectData;
    public M_projectData_export(M_projectData projectData)
    {
        this.projectData=projectData;
    }
    public void export(M_projectData temp_projectData)
    {
        jaxbObjectToXML(temp_projectData);
    }

    //code from: https://howtodoinjava.com/jaxb/write-object-to-xml/
    private static void jaxbObjectToXML(M_projectData temp_projectData)
    {
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(M_projectData.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Store XML to File
            File file = new File("test.xml");

            //Manually workaround for JAXB with class without annotations
            JAXBElement<M_projectData> jaxbElement = new JAXBElement<M_projectData>
                    ( new QName("root_projectData"), M_projectData.class, temp_projectData);

            //Writes XML file to file-system
            jaxbMarshaller.marshal(jaxbElement, System.out);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}


