package CONTROLLER.TAB;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTCONTENTFACTORY;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTFUNCTION;
import VIEW.I_V_FRAME;

import javax.swing.*;

public class C_PRODUCTFUNCTION implements I_C_PRODUCTFUNCTION {
    private static C_PRODUCTFUNCTION controllerProductFunction;
    private I_V_FRAME viewFrame;
    private M_PROJECTDATA projectData;

    /**
     * initialize Productfunction Object
     */
    private C_PRODUCTFUNCTION() {
    }

    public static C_PRODUCTFUNCTION getInstance() {
        if (controllerProductFunction == null) {
            controllerProductFunction = new C_PRODUCTFUNCTION();
        } else {
            System.out.println("C_PRODUCTFUNCTION Instance already created");
        }
        return controllerProductFunction;
    }

    @Override
    public void setLinks(I_V_FRAME view, M_PROJECTDATA projData) {
        viewFrame = view;
        projectData = projData;
    }

    /**
     * updates the Project Data mainly called by SAVE action
     */
    @Override
    public void updateProjectData() {
        for (M_PROJECTDATA_PRODUCTFUNCTION projectDataFunction : projectData.getProductFunctionList()) {
            if (projectDataFunction.id.equals(viewFrame.getProdFuncIDList().getSelectedValue())) {
                projectDataFunction.id = viewFrame.getTextFieldProdFuncID().getText();
                setProductFunctionElements(projectDataFunction);
                viewFrame.changeprodFuncIDListElement(projectDataFunction.id);
                viewFrame.setWeightDescription(projectDataFunction.functionPointWeighting);
            }
        }
    }

    /**
     * set the Project Data Function object that is given as an argument
     *
     * @param projectDataFunction contains a project data element that wants to be configured by the function
     */
    private void setProductFunctionElements(M_PROJECTDATA_PRODUCTFUNCTION projectDataFunction) {
        projectDataFunction.actor = viewFrame.getTextFieldProdFuncProtagonist().getText();
        projectDataFunction.function = viewFrame.getTextFieldProdFunc().getText();
        projectDataFunction.description = viewFrame.getTextAreaprodFuncDescription().getText();
        projectDataFunction.functionPointCategory = viewFrame.getComboBoxProdFuncCategory().getSelectedItem().toString();
        projectDataFunction.functionPointFTR = (int) viewFrame.getSpinnerProdFuncFTR().getValue();
        projectDataFunction.functionPointDET = (int) viewFrame.getSpinnerProdFuncDET().getValue();
        projectDataFunction.calculateWeight();
    }

    /**
     * creates a new Product Function Item in the Project. Implments the abstract Function of a Product Content Item
     */
    @Override
    public void newProductContent() {
        System.out.println("Notified Tab Product Function that a new Element is requested");
        boolean alreadyexists = false;
        for (M_PROJECTDATA_PRODUCTFUNCTION projectDataFunction : projectData.getProductFunctionList()) {
            if (projectDataFunction.id.equals(viewFrame.getTextFieldProdFuncID().getText())) {
                alreadyexists = true;
                break;
            }
        }
        if (!alreadyexists) {
            //Using ProductContentFactory to create object
            if (!viewFrame.getTextFieldProdFuncID().getText().isEmpty()) {
                M_PROJECTDATA_PRODUCTFUNCTION newProductFunction = M_PROJECTDATA_PRODUCTCONTENTFACTORY.createProductContent(viewFrame.getTextFieldProdFuncID().getText(),"PRODUCTFUNCTION");
                setProductFunctionElements(newProductFunction);
                viewFrame.setWeightDescription(newProductFunction.functionPointWeighting);
                projectData.getProductFunctionList().add(newProductFunction);
                viewFrame.addProdFuncIDListElement(viewFrame.getTextFieldProdFuncID().getText());
            } else {
                JOptionPane.showMessageDialog(null,
                        "Bitte ID eingeben um eine neue Produktfunktion anzulegen",
                        "Achtung",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Produktfunktions ID existiert bereits",
                    "Achtung",
                    JOptionPane.WARNING_MESSAGE);
        }


    }

    /**
     * Saves the elements of the selected Product Function ID
     *
     * @param selectedID is the current selected ID from JList Panel
     */
    @Override
    public void notifySelectionChange(String selectedID) {
        M_PROJECTDATA_PRODUCTFUNCTION selectedProjectData = null;
        for (M_PROJECTDATA_PRODUCTFUNCTION projectDataFunction : projectData.getProductFunctionList()) {
            if (projectDataFunction.id.equals(selectedID)) {
                selectedProjectData = projectDataFunction;

            }
        }
        if (selectedProjectData == null) {
            JOptionPane.showMessageDialog(null,
                    "Keine ID selektiert um Aktualisierung durchzuführen",
                    "Achtung",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            viewFrame.updateProdFuncInfo(selectedProjectData);
        }
        viewFrame.setWeightDescription(selectedProjectData.functionPointWeighting);
    }

    /**
     * Deletes the Product Function
     */
    @Override
    public void deleteProductContent() {
        int index = 0;
        int removedElement = -1;
        for (M_PROJECTDATA_PRODUCTFUNCTION projectDataFunction : projectData.getProductFunctionList()) {
            if (projectDataFunction.id.equals(viewFrame.getProdFuncIDList().getSelectedValue())) {
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
