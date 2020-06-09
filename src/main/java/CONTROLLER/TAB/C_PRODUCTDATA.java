package CONTROLLER.TAB;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import VIEW.I_V_FRAME;

import javax.swing.*;

public class C_PRODUCTDATA implements I_C_PRODUCTCONTENT {
    private I_V_FRAME viewFrame;

    private M_PROJECTDATA projectData;

    public C_PRODUCTDATA(I_V_FRAME mainFrame, M_PROJECTDATA projData){
            viewFrame = mainFrame;
    }

    @Override
    public void newProductContent() {

    }

    @Override
    public void saveProductContent(String selectedID) {

    }

    @Override
    public void deleteProductContent() {

    }

    @Override
    public void updateProjectData() {

    }
}
