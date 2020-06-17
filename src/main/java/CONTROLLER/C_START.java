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
public class C_START implements I_C_START {
    private static C_START controllerStart;

    private I_V_START viewStart;
    private M_IMPORT importObj;

    /**
     * creates Object of Class C_START
     * creates the startwindow of the programm viewStart and makes it visible
     * it passes itself as C_START controllerStart into the main
     * and therefore creates a reference to itself in the viewStart
     */
    private C_START() {
        viewStart = new V_START(this);
        I_V_BASIC.show(viewStart.getJFrame());  // makes viewStart visible and enables user input
        importObj = new M_IMPORT();
    }

    /**
     * checks if controller was already created
     * if it wasn't it creates a new controller
     * it always returns a reference to the controller
     *
     * @return reference to controller
     */
    public static C_START getInstance() {
        if (C_START.controllerStart == null) {
            C_START.controllerStart = new C_START();
        }
        return C_START.controllerStart;
    }

    /**
     * gets called by Views to notify the start Controller that a new project should be created
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
            I_V_BASIC.hide(viewStart.getJFrame());  // makes viewStart invisible and disables user input
            I_C_FRAME controllerFrame = C_FRAME.getInstance();
            controllerFrame.setLinks(M_PROJECTDATA.getInstance(), this, path);
        }
    }

    /**
     * gets called by Views to notify the start Controller that a existing project should be opened
     * the Controller therefore asks the viewStart for a path to the file that should be opened
     */
    public void notifyOpen() {
        System.out.println("Öffne Projekt wurde gedrückt.");
        String path = viewStart.getPath(true);
        File xmlFile = new File(path);
        if (xmlFile.exists()) {
            M_PROJECTDATA projectData = M_PROJECTDATA.getInstance();
            if (path instanceof String) {
                try {
                    projectData = importObj.importProject(path);
                    projectData.setFunctionPointEstimation_configData(projectData.getFunctionPointEstimation_configData());
                    projectData.getFunctionPointEstimation().setE2Correction(-1); //clean Correction Factor from last Calculation
                } catch (InvalidPathException e) {
                    e.getStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Sie müssen einen korrekten Dateipfad angeben",
                            "Achtung",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Sie müssen einen korrekten Dateipfad angeben",
                        "Achtung",
                        JOptionPane.WARNING_MESSAGE);
            }
            I_V_BASIC.hide(viewStart.getJFrame());  // makes viewStart invisible and disables user input
            I_C_FRAME controllerFrame = C_FRAME.getInstance();
            controllerFrame.setLinks(projectData, this, path);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Sie müssen einen korrekten Dateipfad angeben",
                    "Achtung",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * shows the viewStart and tells the Start Controller, that he is in charge now
     */
    @Override
    public void notifyShow() {
        I_V_BASIC.show(viewStart.getJFrame());
    }
}
