package Controller;

import Model.M_projectData;
import View.I_V_frame;

import javax.swing.*;

/**
 * C_general is the implementation of I_C_general
 * it is responsible for all actions regarding the general tab in I_C_frame
 */
public class C_general implements  I_C_general {
    private JTextArea targetUse;    // stores text Area "Zielbestimmungen" for which the controller is responsible for
    private JTextArea productUse;   // stores text Area "Produkteinsatz" for which the controller is responsible for
    private JTextArea productEnvironment; // stores text Area "Umgebung" for which the controller is responsible for
    private M_projectData projectData;  // stores a reference to the complete data modell

    public C_general(I_V_frame mainFrame, M_projectData projectData){
        this.targetUse = mainFrame.getTargetUse();
        this.productUse = mainFrame.getProductUse();
        this.productEnvironment=mainFrame.getProductEnvironment();
        this.projectData = projectData;
    }

    /**
     * TODO: add description
     */
    @Override
    public void updateProjectData(){
            System.out.println("Update Project Data from general Tab triggered.");
            projectData.getM_projectData_targetDefinition().setContent(targetUse.getText());
            projectData.getM_projectData_productUse().setContent(productUse.getText());
            projectData.getM_projectData_productEnvironment().setContent(productEnvironment.getText());
            System.out.println(projectData.getM_projectData_targetDefinition().toString());
            System.out.println(projectData.getM_projectData_productUse().toString());
            System.out.println(projectData.getM_projectData_productEnvironment().toString());

    }
}

