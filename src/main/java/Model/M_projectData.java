/**
 * Main: This file is part of CASE-Tool
 *
 * With the CASE-Tool it is possible to create feasibility studies
 * and save them. The software is based on a student project.
 *
 * Description:  Main Model of software
 */

package Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;

@XmlRootElement(name = "M_projectData")
@XmlAccessorType(XmlAccessType.FIELD)

public class M_projectData {
    @XmlTransient
    ArrayList<M_projectData_productData> productDataList = new ArrayList<>();
    ArrayList<M_projectData_productFunction> productFunctionList = new ArrayList<>();

    M_projectData_productUse m_projectData_productUse = new M_projectData_productUse();
    M_projectData_targetDefinition m_projectData_targetDefinition = new M_projectData_targetDefinition();
    M_projectData_productEnvironment m_projectData_productEnvironment = new M_projectData_productEnvironment();

    M_projectData_functionPointEstimation m_projectData_functionPointEstimation = new M_projectData_functionPointEstimation(/*0,0*/);

    public M_projectData_productUse getM_projectData_productUse() {
        return m_projectData_productUse;
    }

    public M_projectData_targetDefinition getM_projectData_targetDefinition() {
        return m_projectData_targetDefinition;
    }

    public M_projectData_productEnvironment getM_projectData_productEnvironment() {
        return m_projectData_productEnvironment;
    }

    public ArrayList<M_projectData_productData> getProductDataList() {
        return productDataList;
    }

    public ArrayList<M_projectData_productFunction> getProductFunctionList() {
        return productFunctionList;
    }

    public M_projectData_functionPointEstimation getM_projectData_functionPointEstimation() {
        return m_projectData_functionPointEstimation;
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
                '}';
    }
}