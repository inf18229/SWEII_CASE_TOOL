package Controller;

import Model.M_import;
import Model.projectData.M_projectData;
import View.I_V_basic;
import View.I_V_start;
import View.V_start;

import javax.swing.*;
import java.io.File;

/**
 * C_start is the basic controller, that is always created first.
 * Its only purpose is to handle USER-IO during the start sequence
 */
public class C_start implements I_C_start {
    //TODO: create Model and store in local Variable
    //TODO: create VIEW and store in local Variable
    I_V_start viewStart;
    M_import m__import;
    //I_C_frame controllerFrame;

    /**
     * creates Object of Class C_start
     * creates the startwindow of the programm viewStart and makes it visible
     * it passes itself as C_start controllerStart into the main
     * and therefore creates a reference to itself in the viewStart
     */
    public C_start() {
        viewStart = new V_start(this);
        I_V_basic.show(viewStart.getJFrame());  // makes viewStart visible and enables user input
        m__import = new M_import();
    }

    /**
     * this message gets called by Views to notify the start Controller that a new project should be created
     * the Controller therefore asks the viewStart for a path where the new project should get created
     * after getting the path the Controller has to close viewStart (hide) and pass the job of handeling the project
     * to the newly created controllerFrame
     */
    public void notifyCreate() {
        System.out.println("Neues Projekt wurde gedrückt.");
        String path = viewStart.getPath();
        if (path == "" | path == null) {
            //go to start view
        } else {
            //TODO: Model den Pfad (in createData(path)) übergeben --> Beachten: im path muss pfad und name des files ein
            //TODO: Idee: Pfad auswählen lassen und Namen separat angeben + erweitern mit .xml --> überprüfen auf leeren Namen
            I_V_basic.hide(viewStart.getJFrame());  // makes viewStart invisible and disables user input
            I_C_frame controllerFrame = C_frame.getInstance();
            controllerFrame.setLinks(new M_projectData(), this, path);
        }

        //String path = "test.xml";

    }

    /**
     * notifyOpen()
     * <p>
     * this message gets called by Views to notify the start Controller that a existing project should be opened
     * the Controller therefore asks the viewStart for a path to the file that should be opened
     */
    public void notifyOpen() {
        System.out.println("Öffne Projekt wurde gedrückt.");
        String path = "test.xml"; // fixed path relative
        //String path  = viewStart.getPath(); //TODO: abfangen wenn man name von nicht existierender Datei eingegeben und auf open gedrückt wird
        File xmlFile = new File(path);
        if (xmlFile.exists()) {
            M_projectData projectData = new M_projectData();
            if (path instanceof String) {
            /*if (!xmlFile.exists())
            {
                throw new RuntimeException("File does not exist");
            }*/
                projectData = m__import.importProject(path);
                projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData()); //TODO: check if relevant for testing
            } else {
                //TODO: return an error that a path has to be chosen for import
            }
            I_V_basic.hide(viewStart.getJFrame());  // makes viewStart invisible and disables user input
            //TODO: initialize C_Frame with Project Data from XML file (und pfad übergeben)
            I_C_frame controllerFrame = C_frame.getInstance();
            controllerFrame.setLinks(projectData, this, path);//new C_frame(new M_projectData(), this, path);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Sie müssen einen korrekten Dateipfad angeben",
                    "Achtung",
                    JOptionPane.WARNING_MESSAGE);
        }

    }

    /**
     * this method shows the viewStart and tells the Start Controller, that he is in charge now
     */
    @Override
    public void notifyShow() {
        I_V_basic.show(viewStart.getJFrame());
    }
}
