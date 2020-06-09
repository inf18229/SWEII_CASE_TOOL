package CONTROLLER.TAB;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTCONTENTFACTORY;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTFUNCTION;
import VIEW.I_V_FRAME;

import javax.swing.*;

public class C_PRODUCTFUNCTION implements I_C_PRODUCTFUNCTION {
    private I_V_FRAME viewFrame;
    private JTextField prodFuncID;
    private JTextField prodFuncFunction;
    private JTextField prodFuncProtagonist;
    private JTextArea prodFuncDescription;
    private JComboBox prodFuncFPCategory;
    private JComboBox prodFuncFPWeight;
    private JSpinner prodFuncFPFTR;
    private JSpinner prodFuncFPDET;
    private JList prodFuncIDList;
    private M_PROJECTDATA projectData;

    public C_PRODUCTFUNCTION(I_V_FRAME mainFrame, M_PROJECTDATA projData) {
        viewFrame = mainFrame;
        prodFuncIDList = mainFrame.getProdFuncIDList();
        prodFuncID = mainFrame.getTextFieldProdFuncID();
        prodFuncFunction = mainFrame.getTextFieldProdFunc();
        prodFuncProtagonist = mainFrame.getTextFieldProdFuncProtagonist();
        prodFuncDescription = mainFrame.getTextAreaprodFuncDescription();
        prodFuncFPCategory = mainFrame.getComboBoxProdFuncCategory();
        prodFuncFPFTR = mainFrame.getSpinnerProdFuncFTR();
        prodFuncFPDET = mainFrame.getSpinnerProdFuncDET();
        projectData = projData;

    }

    @Override
    public void updateProjectData() {
        for (M_PROJECTDATA_PRODUCTFUNCTION projectDataFunction : projectData.getProductFunctionList()) {
            if (projectDataFunction.id.equals(prodFuncIDList.getSelectedValue())) {
                projectDataFunction.id = prodFuncID.getText();
                projectDataFunction.actor = prodFuncProtagonist.getText();
                projectDataFunction.function = prodFuncFunction.getText();
                projectDataFunction.description = prodFuncDescription.getText();
                projectDataFunction.functionPointCategory = prodFuncFPCategory.getSelectedItem().toString();
                projectDataFunction.functionPointFTR = (int) prodFuncFPFTR.getValue();
                projectDataFunction.functionPointDET = (int) prodFuncFPDET.getValue();
                projectDataFunction.calculateWeight();
                viewFrame.changeprodFuncIDListElement(projectDataFunction.id);
                viewFrame.setWeightDescription(projectDataFunction.functionPointWeighting);
            }
        }
    }

    @Override
    public void newProductFunction() {
        System.out.println("Notified Tab Product Function that a new Element is requested");
        boolean alreadyexists = false;
        for (M_PROJECTDATA_PRODUCTFUNCTION projectDataFunction : projectData.getProductFunctionList()) {
            if (projectDataFunction.id.equals(prodFuncID.getText())) {
                alreadyexists = true;
                break;
            }
        }
        if (!alreadyexists) {
            //Using ProductContentFactory to create object
            M_PROJECTDATA_PRODUCTFUNCTION newProductFunction = new M_PROJECTDATA_PRODUCTCONTENTFACTORY().createProductFunction(prodFuncID.getText());
            newProductFunction.actor = prodFuncProtagonist.getText();
            newProductFunction.function = prodFuncFunction.getText();
            newProductFunction.description = prodFuncDescription.getText();
            newProductFunction.functionPointCategory = prodFuncFPCategory.getSelectedItem().toString();
            newProductFunction.functionPointFTR = (int) prodFuncFPFTR.getValue();
            newProductFunction.functionPointDET = (int) prodFuncFPDET.getValue();
            newProductFunction.calculateWeight();
            viewFrame.setWeightDescription(newProductFunction.functionPointWeighting);

            System.out.println(newProductFunction.toString());
            projectData.getProductFunctionList().add(newProductFunction);
            viewFrame.addProdFuncIDListElement(prodFuncID.getText());
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
            System.out.println("Selected ID does not exist no update of Info can occur");
        } else {
            viewFrame.updateProdFuncInfo(selectedProjectData);
        }
        viewFrame.setWeightDescription(selectedProjectData.functionPointWeighting);
    }

    @Override
    public void deleteProductFunction() {
        int index = 0;
        int removedElement = -1;
        for (M_PROJECTDATA_PRODUCTFUNCTION projectDataFunction : projectData.getProductFunctionList()) {
            if (projectDataFunction.id.equals(prodFuncIDList.getSelectedValue())) {
                removedElement = index;
            }
            index++;
        }
        if (removedElement >= 0) {
            projectData.getProductFunctionList().remove(removedElement);
            viewFrame.reinitializeProdFuncIDList(projectData);
        }

    }
}
