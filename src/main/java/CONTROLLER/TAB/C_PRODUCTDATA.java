package CONTROLLER.TAB;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTCONTENTFACTORY;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTFUNCTION;
import VIEW.I_V_FRAME;

public class C_PRODUCTDATA implements I_C_PRODUCTDATA {
    private I_V_FRAME viewFrame;

    private M_PROJECTDATA projectData;

    public C_PRODUCTDATA(I_V_FRAME mainFrame, M_PROJECTDATA projData) {
        viewFrame = mainFrame;
        projectData = projData;
    }

    private void setProductDataElements(M_PROJECTDATA_PRODUCTDATA projectDataProductData) {
        projectDataProductData.reference = viewFrame.getTextFieldproductDataReference().getText();
        projectDataProductData.memoryContent = viewFrame.getTextAreaproductDataDescription().getText();
        projectDataProductData.functionPointRET = (int) viewFrame.getSpinnerproductDataRET().getValue();
        projectDataProductData.functionPointDET = (int) viewFrame.getSpinnerproductDataDET().getValue();
        projectDataProductData.functionPointCategory = viewFrame.getComboBoxProdDataCategory().getSelectedItem().toString();
        projectDataProductData.calculateWeight();
    }

    @Override
    public void newProductContent() {
        System.out.println("Notified Tab Product Data that a new Element is requested");
        boolean alreadyexists = false;
        for (M_PROJECTDATA_PRODUCTDATA projectDataProductData : projectData.getProductDataList()) {
            if (projectDataProductData.id.equals(viewFrame.getTextFieldproductDataID().getText())) {
                alreadyexists = true;
                break;
            }
        }
        if (!alreadyexists) {
            //Using ProductContentFactory to create object
            M_PROJECTDATA_PRODUCTDATA newProductData = new M_PROJECTDATA_PRODUCTCONTENTFACTORY().createProductData(viewFrame.getTextFieldproductDataID().getText());
            setProductDataElements(newProductData);
            //TODO: XML wird nicht an der richtigen stelle Befüllt
            //viewFrame.setWeightDescription(newProductData.functionPointWeighting);
            projectData.getProductDataList().add(newProductData);
            for (M_PROJECTDATA_PRODUCTDATA dataelement : projectData.getProductDataList()) {
                System.out.println(dataelement.memoryContent);
            }
            viewFrame.addProdDataIDListElement(viewFrame.getTextFieldproductDataID().getText());
        } else {
            System.out.println("ID already exists in project Function");
        }
    }

    @Override
    public void notifySelectionChange(String selectedID) {

    }

    @Override
    public void deleteProductContent() {

    }

    @Override
    public void updateProjectData() {

    }

}
