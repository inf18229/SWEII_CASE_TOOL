package Controller.tab;

import Model.projectData.M_projectData;
import Model.projectData.M_projectData_productContentFactory;
import Model.projectData.M_projectData_productFunction;
import View.I_V_frame;

import javax.swing.*;

public class C_functionalReqirement implements I_C_functionalReqirement {
    private I_V_frame viewFrame;
    private JTextField funcReqID;
    private JTextField funcReqFunction;
    private JTextField funcReqProtagonist;
    private JTextArea funcReqDescription;
    private JComboBox funcReqFPCategory;
    private JComboBox funcReqFPWeight;
    private JSpinner funcReqFPFTR;
    private JSpinner funcReqFPDET;
    private JList funcReqIDList;
    private M_projectData projectData;

    public C_functionalReqirement(I_V_frame mainFrame, M_projectData projData) {
        viewFrame = mainFrame;
        funcReqIDList = mainFrame.getfunctionalReqIDList();
        funcReqID = mainFrame.getTextFieldReqID();
        funcReqFunction = mainFrame.getTextFieldReqFunction();
        funcReqProtagonist = mainFrame.getTextFieldReqProtagonist();
        funcReqDescription = mainFrame.getTextAreaReqDescription();
        funcReqFPCategory = mainFrame.getComboBoxReqCategory();
        funcReqFPFTR = mainFrame.getSpinnerReqFTR();
        funcReqFPDET = mainFrame.getSpinnerReqDET();
        projectData = projData;

    }

    @Override
    public void updateProjectData() {
        for (M_projectData_productFunction projectDataFunction : projectData.getProductFunctionList()) {
            if (projectDataFunction.id.equals(funcReqIDList.getSelectedValue())) {
                projectDataFunction.id = funcReqID.getText();
                projectDataFunction.actor = funcReqProtagonist.getText();
                projectDataFunction.function = funcReqFunction.getText();
                projectDataFunction.description = funcReqDescription.getText();
                projectDataFunction.functionPointCategory = funcReqFPCategory.getSelectedItem().toString();
                projectDataFunction.functionPointFTR = (int) funcReqFPFTR.getValue();
                projectDataFunction.functionPointDET = (int) funcReqFPDET.getValue();
                projectDataFunction.calculateWeight();
                viewFrame.changeReqIDListElement(projectDataFunction.id);
                viewFrame.setWeightDescription(projectDataFunction.functionPointWeighting);
            }
        }
    }

    @Override
    public void newFuncReqElement() {
        System.out.println("Notified Tab Func Req that a new Element is requested");
        boolean alreadyexists = false;
        for (M_projectData_productFunction projectDataFunction : projectData.getProductFunctionList()) {
            if (projectDataFunction.id.equals(funcReqID.getText())) {
                alreadyexists = true;
                break;
            }
        }
        if (!alreadyexists) {
            //Using ProductContentFactory to create object
            M_projectData_productFunction newProductFunction = new M_projectData_productContentFactory().createProductFunction(funcReqID.getText());
            newProductFunction.actor = funcReqProtagonist.getText();
            newProductFunction.function = funcReqFunction.getText();
            newProductFunction.description = funcReqDescription.getText();
            newProductFunction.functionPointCategory = funcReqFPCategory.getSelectedItem().toString();
            newProductFunction.functionPointFTR = (int) funcReqFPFTR.getValue();
            newProductFunction.functionPointDET = (int) funcReqFPDET.getValue();
            newProductFunction.calculateWeight();
            viewFrame.setWeightDescription(newProductFunction.functionPointWeighting);

            System.out.println(newProductFunction.toString());
            projectData.getProductFunctionList().add(newProductFunction);
            viewFrame.addFuncReqIDListElement(funcReqID.getText());
        } else {
            System.out.println("ID already exists in project Function");
        }


    }

    @Override
    public void notifyChangeSelectedListItem(String selectedID) {
        M_projectData_productFunction selectedProjectData = null;
        for (M_projectData_productFunction projectDataFunction : projectData.getProductFunctionList()) {
            if (projectDataFunction.id.equals(selectedID)) {
                selectedProjectData = projectDataFunction;

            }
        }
        if (selectedProjectData == null) {
            System.out.println("Selected ID does not exist no update of Info can occure");
        } else {
            viewFrame.updateFuncReqInfo(selectedProjectData);
        }
        viewFrame.setWeightDescription(selectedProjectData.functionPointWeighting);
    }

    @Override
    public void deleteFuncReqElement() {
        int index = 0;
        int removedelement = -1;
        for (M_projectData_productFunction projectDataFunction : projectData.getProductFunctionList()) {
            if (projectDataFunction.id.equals(funcReqIDList.getSelectedValue())) {
                removedelement = index;
                System.out.println("Bis hier");
            }
            index++;
        }
        if (removedelement >= 0) {
            projectData.getProductFunctionList().remove(removedelement);
            viewFrame.reinitializeReqIDList(projectData);
        }

    }
}
