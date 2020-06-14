package MODEL;

import MODEL.FUNCTIONPOINTESTIMATION.M_FUNCTIONPOINTESTIMATION_CONFIGDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.InvalidPathException;

//TODO: KONTROLLFLUSSGRAPH
//TODO: Reicht es einmal im Try Block zu sein für Zweigabdeckung

/**
 * this class saves the current Project to XML
 */
public class M_EXPORT {

    /**
     * constructor of M_EXPORT class
     */
    public M_EXPORT() {

    }

    /**
     * this function converts the current project to XML and saves the new XML file
     * @param projData the projectData of the current project
     * @param projPath the path that defines where to save the data into a XML file
     * @throws InvalidPathException
     * @throws NullPointerException
     * @source code idea from: https://howtodoinjava.com/jaxb/write-object-to-xml/
     */
    public void export(M_PROJECTDATA projData, String projPath) throws InvalidPathException, NullPointerException {
        if (projPath != null && projData != null) {
            if(!projPath.isEmpty() && !projPath.isBlank()) {
                try {
                    JAXBContext jaxbContext = JAXBContext.newInstance(M_PROJECTDATA.class);
                    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                    projPath = projPath.trim(); //delete whitespaces at beginning and ending of confPath
                    File file = new File(projPath);
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

    /**
     * this function converts the current confData of a project to XML and saves the new XML file
     * @param confData the confData of the current project
     * @param confPath the Path that defines where to save the data into a XML file
     * @throws InvalidPathException
     * @throws NullPointerException
     * @source code idea from: https://howtodoinjava.com/jaxb/write-object-to-xml/
     */
    public void export(M_FUNCTIONPOINTESTIMATION_CONFIGDATA confData, String confPath) throws  InvalidPathException, NullPointerException {
        if (confPath != null && confData != null) {
            if(!confPath.isEmpty() && !confPath.isBlank()) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(M_FUNCTIONPOINTESTIMATION_CONFIGDATA.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                confPath = confPath.trim(); //delete whitespaces at beginning and ending of confPath
                File file = new File(confPath);
                jaxbMarshaller.marshal(confData, file);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        } else{
                throw new InvalidPathException(confPath, "Invalid Filename");
            }
        } else {
            throw new NullPointerException();
        }
    }
}



