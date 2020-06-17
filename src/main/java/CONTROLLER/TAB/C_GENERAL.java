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
    private I_V_FRAME viewFrame;
    private M_PROJECTDATA projectData;  // stores a reference to the complete data modell

    /**
     * private Singleton constructor
     */
    private C_GENERAL() {
    }

    /**
     * constructs one Element of C_GENERAL
     * @return C_GENERAL Object
     */
    public static C_GENERAL getInstance() {
        if (controllerGeneral == null) {
            controllerGeneral = new C_GENERAL();
        } else {
            System.out.println("C_GENERAL Instance already created");
        }
        return controllerGeneral;
    }

    /**
     * set References to view and projData
     * @param view     reference to the view that should be referenced in this object
     * @param projData reference to the project data that should be referenced in this object
     */
    @Override
    public void setLinks(I_V_FRAME view, M_PROJECTDATA projData) {
        viewFrame =view;
        projectData = projData;
    }

    /**
     * updates the ProjectData Modell if somthing is changed in the View
     * View will call Controllers updateProjectData function if somthing is changed.
     * No Input validation for controller needed because only text areas are controlled.
     */
    @Override
    public void updateProjectData() {
        projectData.getTargetDefinition().content = viewFrame.getTargetUse().getText();
        projectData.getProductUse().content = viewFrame.getProductUse().getText();
        projectData.getProductEnvironment().content = viewFrame.getProductEnvironment().getText();
    }
}

