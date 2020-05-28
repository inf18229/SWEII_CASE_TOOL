/**
 * Main: This file is part of CASE-Tool
 *
 * With the CASE-Tool it is possible to create feasibility studies
 * and save them. The software is based on a student project.
 *
 * Description:  Model for Product Content Factory
 */

package Model;

public class M_projectData_productContentFactory {
    public static M_projectData_productData createProductData(String id) {
        M_projectData_productData productData = new M_projectData_productData();
        productData.id = id;


        return productData;
    }

    public static M_projectData_productFunction createProductFunction(String id) {
        M_projectData_productFunction productFunction = new M_projectData_productFunction();
        productFunction.id = id;


        return productFunction;
    }

    public static M_projectData_productDataAttribute createProductDataAttribute(String productDataAttributeName) {
        M_projectData_productDataAttribute m_projectData_productDataAttribute = new M_projectData_productDataAttribute();
        m_projectData_productDataAttribute.name = productDataAttributeName;


        return m_projectData_productDataAttribute;
    }
}
