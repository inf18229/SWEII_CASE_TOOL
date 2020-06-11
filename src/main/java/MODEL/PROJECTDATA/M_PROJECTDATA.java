package MODEL.PROJECTDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name="M_PROJECTDATA")
@XmlAccessorType(XmlAccessType.FIELD)

//TODO: Make to Singleton
public class M_PROJECTDATA {
    private static M_PROJECTDATA projectData;

    //@XmlTransient // jumps over first element - TODO: why do we use this here?
    //int stuffElement = 0; // this element is ignored and the export starts with the second element

    ArrayList<M_PROJECTDATA_PRODUCTDATA> productDataList = new ArrayList<>();
    ArrayList<M_PROJECTDATA_PRODUCTFUNCTION> productFunctionList = new ArrayList<>();

    M_PROJECTDATA_PRODUCTUSE m_projectData_productUse = new M_PROJECTDATA_PRODUCTUSE();
    M_PROJECTDATA_TARGETDEFINITION m_projectData_targetDefinition = new M_PROJECTDATA_TARGETDEFINITION();
    M_PROJECTDATA_PRODUCTENVIRONMENT m_projectData_productEnvironment = new M_PROJECTDATA_PRODUCTENVIRONMENT();

    M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA m_projectData_functionPointEstimation_configData = M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA.getInstance();
    M_PROJECTDATA_FUNCTIONPOINTESTIMATION m_projectData_functionPointEstimation = M_PROJECTDATA_FUNCTIONPOINTESTIMATION.getInstance(m_projectData_functionPointEstimation_configData);

    public M_PROJECTDATA_PRODUCTUSE getM_projectData_productUse() {
        return m_projectData_productUse;
    }

    public M_PROJECTDATA_TARGETDEFINITION getM_projectData_targetDefinition() {
        return m_projectData_targetDefinition;
    }

    public M_PROJECTDATA_PRODUCTENVIRONMENT getM_projectData_productEnvironment() {
        return m_projectData_productEnvironment;
    }

    public ArrayList<M_PROJECTDATA_PRODUCTDATA> getProductDataList() {
        return productDataList;
    }

    public ArrayList<M_PROJECTDATA_PRODUCTFUNCTION> getProductFunctionList() {
        return productFunctionList;
    }

    public M_PROJECTDATA_FUNCTIONPOINTESTIMATION getM_projectData_functionPointEstimation() {
        return m_projectData_functionPointEstimation;
    }

    public M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA getM_projectData_functionPointEstimation_configData() {
        return m_projectData_functionPointEstimation_configData;
    }

    private M_PROJECTDATA() {}

    public static M_PROJECTDATA getInstance() {
        if (M_PROJECTDATA.projectData == null) {
            M_PROJECTDATA.projectData = new M_PROJECTDATA();
        }
        return M_PROJECTDATA.projectData;
    }

    public void setM_projectData_functionPointEstimation_configData(M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA confData) {
        m_projectData_functionPointEstimation_configData = confData;
        m_projectData_functionPointEstimation.setConfigData(confData);
    }

    @Override
    public String toString() {
        return "Model{" +
                "productDataList=" + productDataList +
                ", productFunctionList=" + productFunctionList +
                ", productUse=" + m_projectData_productUse +
                ", targetDefinition=" + m_projectData_targetDefinition +
                ", productEnvironment=" + m_projectData_productEnvironment +
                ", functionPointEstimation=" + m_projectData_functionPointEstimation +
                ", functionPointEstimation=" + m_projectData_functionPointEstimation_configData +
                '}';
    }
}