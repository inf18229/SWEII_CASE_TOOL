package CONTROLLER.TAB;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTCONTENTFACTORY;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTFUNCTION;
import VIEW.I_V_FRAME;

import javax.swing.*;

public class C_PRODUCTFUNCTION implements I_C_PRODUCTFUNCTION {
    private I_V_FRAME viewFrame;
    private JTextField funcReqID;
    private JTextField funcReqFunction;
    private JTextField funcReqProtagonist;
    private JTextArea funcReqDescription;
    private JComboBox funcReqFPCategory;
    private JComboBox funcReqFPWeight;
    private JSpinner funcReqFPFTR;
    private JSpinner funcReqFPDET;
    private JList funcReqIDList;
    private M_PROJECTDATA projectData;

    public C_PRODUCTFUNCTION(I_V_FRAME mainFrame, M_PROJECTDATA projData) {
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
        for (M_PROJECTDATA_PRODUCTFUNCTION projectDataFunction : projectData.getProductFunctionList()) {
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
        for (M_PROJECTDATA_PRODUCTFUNCTION projectDataFunction : projectData.getProductFunctionList()) {
            if (projectDataFunction.id.equals(funcReqID.getText())) {
                alreadyexists = true;
                break;
            }
        }
        if (!alreadyexists) {
            //Using ProductContentFactory to create object
            M_PROJECTDATA_PRODUCTFUNCTION newProductFunction = new M_PROJECTDATA_PRODUCTCONTENTFACTORY().createProductFunction(funcReqID.getText());
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
        M_PROJECTDATA_PRODUCTFUNCTION selectedProjectData = null;
        for (M_PROJECTDATA_PRODUCTFUNCTION projectDataFunction : projectData.getProductFunctionList()) {
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
        for (M_PROJECTDATA_PRODUCTFUNCTION projectDataFunction : projectData.getProductFunctionList()) {
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
