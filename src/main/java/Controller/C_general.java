package Controller;

import Model.M_projectData;
import View.I_V_frame;

import javax.swing.*;

public class C_general implements  I_C_general {
    private JTextArea targetUse;
    private JTextArea productUse;
    private M_projectData projectData;

    public C_general(I_V_frame mainFrame, M_projectData projectData){
        this.targetUse=mainFrame.getTargetUse();    //Controller know the text Area he is responsible for
        this.productUse=mainFrame.getProductUse();  //Controller know the text Area he is responsible for
        this.projectData=projectData;               //Controller know the data modell
    }

    @Override
    public void updateProjectData(){
            System.out.println("update Project Data from general Tab triggered");
            projectData.getM_projectData_targetDefinition().setContent(targetUse.getText());
            projectData.getM_projectData_productUse().setContent(productUse.getText());
            System.out.println(projectData.getM_projectData_targetDefinition().toString());
            System.out.println(projectData.getM_projectData_productUse().toString());

    }
}

