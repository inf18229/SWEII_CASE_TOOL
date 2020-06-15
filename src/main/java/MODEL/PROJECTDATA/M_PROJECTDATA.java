package MODEL.PROJECTDATA;

import MODEL.FUNCTIONPOINTESTIMATION.M_FUNCTIONPOINTESTIMATION;
import MODEL.FUNCTIONPOINTESTIMATION.M_FUNCTIONPOINTESTIMATION_CONFIGDATA;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "PROJECTDATA")
@XmlAccessorType(XmlAccessType.FIELD)

/**
 * Class holds all information of a project file.
 */
public class M_PROJECTDATA {
    private static M_PROJECTDATA projectData; //holds Singleton reference to Project Data
    private ArrayList<M_PROJECTDATA_PRODUCTDATA> productDataList; //TODO: evtl. list entfernen, sonst sind in XML-Datei alle Daten einzelne Listen
    private ArrayList<M_PROJECTDATA_PRODUCTFUNCTION> productFunctionList;   //TODO: evtl. list entfernen, sonst sind in XML-Datei alle Daten einzelne Listen
    private M_PROJECTDATA_PRODUCTUSE productUse;
    private M_PROJECTDATA_TARGETDEFINITION targetDefinition;
    private M_PROJECTDATA_PRODUCTENVIRONMENT productEnvironment;
    private M_FUNCTIONPOINTESTIMATION functionPointEstimation;
    private M_FUNCTIONPOINTESTIMATION_CONFIGDATA functionPointEstimation_configData;

    /**
     * Singleton Constructor of M_PROJECTDATA Class
     */
    private M_PROJECTDATA() {
        productDataList = new ArrayList<>();
        productFunctionList = new ArrayList<>();
        productUse = new M_PROJECTDATA_PRODUCTUSE();
        targetDefinition = new M_PROJECTDATA_TARGETDEFINITION();
        productEnvironment = new M_PROJECTDATA_PRODUCTENVIRONMENT();
        functionPointEstimation = M_FUNCTIONPOINTESTIMATION.getInstance();
        functionPointEstimation_configData = M_FUNCTIONPOINTESTIMATION_CONFIGDATA.getInstance();
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
     * @return return M_PROJECTDATA_PRODUCTUSE Object
     */
    public M_PROJECTDATA_PRODUCTUSE getProductUse() {
        return productUse;
    }

    /**
     * get Target Defention of Project
     * @return return M_PROJECTDATA_TARGETDEFINITION Object
     */
    public M_PROJECTDATA_TARGETDEFINITION getTargetDefinition() {
        return targetDefinition;
    }

    /**
     * get Product Environment Description
     * @return M_PROJECTDATA_PRODUCTENVIRONMENT Object
     */
    public M_PROJECTDATA_PRODUCTENVIRONMENT getProductEnvironment() {
        return productEnvironment;
    }

    /**
     * get List of Product Data's
     * @return ArrayList of M_PROJECTDATA_PRODUCTDATA Objects
     */
    public ArrayList<M_PROJECTDATA_PRODUCTDATA> getProductDataList() {
        return productDataList;
    }

    /**
     * get List of Product Function's
     * @return ArrayList of M_PROJECTDATA_PRODUCTFUNCTION Objects
     */
    public ArrayList<M_PROJECTDATA_PRODUCTFUNCTION> getProductFunctionList() {
        return productFunctionList;
    }

    /**
     * get Function Point Estimation
     * @return M_PROJECTDATA_FUNCTIONPOINTESTIMATION Object
     */
    public M_FUNCTIONPOINTESTIMATION getFunctionPointEstimation() {
        return functionPointEstimation;
    }

    /**
     * get Function Point Estimation Configuration Data
     * @return M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA Object
     */
    public M_FUNCTIONPOINTESTIMATION_CONFIGDATA getFunctionPointEstimation_configData() {
        return functionPointEstimation_configData;
    }

    /**
     * sets Function Point Estimation Configuration Data
     * @param confData M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA Object contains all config Data Elements
     */
    public void setFunctionPointEstimation_configData(M_FUNCTIONPOINTESTIMATION_CONFIGDATA confData) {
        functionPointEstimation_configData = confData;
        functionPointEstimation.setConfigData(confData);
    }
}