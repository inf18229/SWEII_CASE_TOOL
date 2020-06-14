package MODEL.PROJECTDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "M_PROJECTDATA")
@XmlAccessorType(XmlAccessType.FIELD)

/**
 * Class holds all information of a project file.
 */
public class M_PROJECTDATA {
    private static M_PROJECTDATA projectData; //holds Singleton reference to Project Data
    private ArrayList<M_PROJECTDATA_PRODUCTDATA> productDataList;
    private ArrayList<M_PROJECTDATA_PRODUCTFUNCTION> productFunctionList;
    private M_PROJECTDATA_PRODUCTUSE productUse;
    private M_PROJECTDATA_TARGETDEFINITION targetDefinition;
    private M_PROJECTDATA_PRODUCTENVIRONMENT productEnvironment;
    private M_PROJECTDATA_FUNCTIONPOINTESTIMATION functionPointEstimation;
    private M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA functionPointEstimation_configData;

    /**
     * Singlton Constructor of M_PROJECTDATA Class
     */
    private M_PROJECTDATA() {
        productDataList = new ArrayList<>();
        productFunctionList = new ArrayList<>();
        productUse = new M_PROJECTDATA_PRODUCTUSE();
        targetDefinition = new M_PROJECTDATA_TARGETDEFINITION();
        productEnvironment = new M_PROJECTDATA_PRODUCTENVIRONMENT();
        functionPointEstimation = M_PROJECTDATA_FUNCTIONPOINTESTIMATION.getInstance();
        functionPointEstimation_configData = M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA.getInstance();
        functionPointEstimation.setConfigData(functionPointEstimation_configData);
    }

    /**
     * create or receive Object of M_PROJECTDATA
     * @return M_PROJECTDATA Object
     */
    public static M_PROJECTDATA getInstance() {
        if (M_PROJECTDATA.projectData == null) {
            M_PROJECTDATA.projectData = new M_PROJECTDATA();
        } else {
            System.out.println("ProjectData Instance already created");
        }
        return M_PROJECTDATA.projectData;
    }

    /**
     * get the Product Use of a Project
     * @return return project
     */
    public M_PROJECTDATA_PRODUCTUSE getProductUse() {
        return productUse;
    }

    public M_PROJECTDATA_TARGETDEFINITION getTargetDefinition() {
        return targetDefinition;
    }

    public M_PROJECTDATA_PRODUCTENVIRONMENT getProductEnvironment() {
        return productEnvironment;
    }

    public ArrayList<M_PROJECTDATA_PRODUCTDATA> getProductDataList() {
        return productDataList;
    }

    public ArrayList<M_PROJECTDATA_PRODUCTFUNCTION> getProductFunctionList() {
        return productFunctionList;
    }

    public M_PROJECTDATA_FUNCTIONPOINTESTIMATION getFunctionPointEstimation() {
        return functionPointEstimation;
    }

    public M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA getFunctionPointEstimation_configData() {
        return functionPointEstimation_configData;
    }

    public void setFunctionPointEstimation_configData(M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA confData) {
        functionPointEstimation_configData = confData;
        functionPointEstimation.setConfigData(confData);
    }

    @Override
    public String toString() {
        return "Model{" +
                "productDataList=" + productDataList +
                ", productFunctionList=" + productFunctionList +
                ", productUse=" + productUse +
                ", targetDefinition=" + targetDefinition +
                ", productEnvironment=" + productEnvironment +
                ", functionPointEstimation=" + functionPointEstimation +
                ", functionPointEstimation=" + functionPointEstimation_configData +
                '}';
    }
}