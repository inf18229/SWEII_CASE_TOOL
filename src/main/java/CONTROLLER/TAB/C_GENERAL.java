package CONTROLLER.TAB;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import VIEW.I_V_FRAME;

import javax.swing.*;

/**
 * C_GENERAL is the implementation of I_C_GENERAL
 * it is responsible for all actions regarding the general tab in I_C_FRAME
 */
public class C_GENERAL implements I_C_GENERAL {
    private static C_GENERAL controllerGeneral;
    private I_V_FRAME view;
    private JTextArea targetUse;    // stores text Area "Zielbestimmungen" for which the controller is responsible for
    private JTextArea productUse;   // stores text Area "Produkteinsatz" for which the controller is responsible for
    private JTextArea productEnvironment; // stores text Area "Umgebung" for which the controller is responsible for
    private M_PROJECTDATA projectData;  // stores a reference to the complete data modell

    private C_GENERAL() {
    }

    public static C_GENERAL getInstance() {
        if (controllerGeneral == null) {
            controllerGeneral = new C_GENERAL();
        }
        else{
            System.out.println("C_GENERAL Instance already created");
        }
        return controllerGeneral;
    }

    @Override
    public void setLinks(I_V_FRAME view, M_PROJECTDATA projData) {
        if (projectData == null || view == null){
            targetUse = view.getTargetUse();
            productUse = view.getProductUse();
            productEnvironment = view.getProductEnvironment();
            projectData = projData;
        }
        else {
            System.out.println("C_GENERAL Links already set");
        }
    }

    /**
     * updates the ProjectData Modell if somthing is changed in the View
     * View will call Controllers updateProjectData function if somthing is changed.
     * No Input validation for controller needed because only text areas are controlled.
     */
    @Override
    public void updateProjectData() {
        System.out.println("Update Project Data from general Tab triggered.");
        projectData.getTargetDefinition().setContent(targetUse.getText());
        projectData.getProductUse().setContent(productUse.getText());
        projectData.getProductEnvironment().setContent(productEnvironment.getText());
        System.out.println(projectData.getTargetDefinition().toString());
        System.out.println(projectData.getProductUse().toString());
        System.out.println(projectData.getProductEnvironment().toString());

    }
}

