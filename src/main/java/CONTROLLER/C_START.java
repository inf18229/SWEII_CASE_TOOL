package CONTROLLER;

import MODEL.M_IMPORT;
import MODEL.PROJECTDATA.M_PROJECTDATA;
import VIEW.I_V_BASIC;
import VIEW.I_V_START;
import VIEW.V_START;

import javax.swing.*;
import java.io.File;
import java.nio.file.InvalidPathException;

/**
 * C_START is the basic controller, that is always created first.
 * Its only purpose is to handle USER-IO during the start sequence
 */
public class C_START implements I_C_start {
    private static C_START controllerStart;

    //TODO: create Model and store in local Variable
    //TODO: create VIEW and store in local Variable
    I_V_START viewStart;
    M_IMPORT m__import;
    //I_C_FRAME controllerFrame;

    /**
     * creates Object of Class C_START
     * creates the startwindow of the programm viewStart and makes it visible
     * it passes itself as C_START controllerStart into the main
     * and therefore creates a reference to itself in the viewStart
     */
    private C_START(){
        viewStart = new V_START(this);
        I_V_BASIC.show(viewStart.getJFrame());  // makes viewStart visible and enables user input
        m__import = new M_IMPORT();
    }

    /**
     * this method checks if controller was already created
     * if it wasn't it creates a new controller
     * it always returns a reference to the controller
     * @return reference to controller
     */
    public static C_START getInstance () {
        if (C_START.controllerStart == null) {
            C_START.controllerStart = new C_START();
        }
        return C_START.controllerStart;
    }

    /**
     * this message gets called by Views to notify the start Controller that a new project should be created
     * the Controller therefore asks the viewStart for a path where the new project should get created
     * after getting the path the Controller has to close viewStart (hide) and pass the job of handeling the project
     * to the newly created controllerFrame
     */
    public void notifyCreate() {
        System.out.println("Neues Projekt wurde gedrückt.");
        String path = viewStart.getPath(false);
        if (path == "" | path == null) {
            //go to start view
        } else {
            //TODO: Model den Pfad (in createData(path)) übergeben --> Beachten: im path muss pfad und name des files ein
            //TODO: Idee: Pfad auswählen lassen und Namen separat angeben + erweitern mit .xml --> überprüfen auf leeren Namen
            I_V_BASIC.hide(viewStart.getJFrame());  // makes viewStart invisible and disables user input
            I_C_FRAME controllerFrame = C_FRAME.getInstance();
            controllerFrame.setLinks(new M_PROJECTDATA(), this, path);
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
        //String path  = viewStart.getPath(true); //TODO: abfangen wenn man name von nicht existierender Datei eingegeben und auf open gedrückt wird
        File xmlFile = new File(path);
        if (xmlFile.exists()) {
            M_PROJECTDATA projectData = new M_PROJECTDATA();
            if (path instanceof String) {
                try{
                    projectData = m__import.importProject(path);
                    projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData()); //TODO: check if relevant for testing
                    projectData.getM_projectData_functionPointEstimation().e2Correction = -1; //clean Correction Factor from last Calculation
                }
                catch(InvalidPathException e)
                {
                    e.getStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Sie müssen einen korrekten Dateipfad angeben",
                            "Achtung",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "Sie müssen einen korrekten Dateipfad angeben",
                        "Achtung",
                        JOptionPane.WARNING_MESSAGE);
            }
            I_V_BASIC.hide(viewStart.getJFrame());  // makes viewStart invisible and disables user input
            //TODO: initialize C_Frame with Project Data from XML file (und pfad übergeben)
            I_C_FRAME controllerFrame = C_FRAME.getInstance();
            controllerFrame.setLinks(projectData, this, path);//new C_FRAME(new M_PROJECTDATA(), this, path);
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
        I_V_BASIC.show(viewStart.getJFrame());
    }
}
