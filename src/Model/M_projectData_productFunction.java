/**
 * Main: This file is part of CASE-Tool
 *
 * With the CASE-Tool it is possible to create feasibility studies
 * and save them. The software is based on a student project.
 *
 * Description:  Model for Product Functions
 */

package Model;

public class M_projectData_productFunction extends M_projectData_productContent {
    public String id = "";
    public String function = "";
    public String source = "";
    public String protagonist = "";
    public String reference = "";
    public String description = "";
    public int functionPointWeighting;
    public String functionPointCategory = "";
    public int functionPointDET;
    public int functionPointFTR;

    public String getId() {
        return id;
    }

    public String getFunction() {
        return function;
    }

    public String getSource() {
        return source;
    }

    public String getProtagonist() {
        return protagonist;
    }

    public String getReference() {
        return reference;
    }

    public String getDescription() {
        return description;
    }

    public int getFunctionPointWeighting() {
        return functionPointWeighting;
    }

    public String getFunctionPointCategory() {
        return functionPointCategory;
    }

    public int getFunctionPointDET() {
        return functionPointDET;
    }

    public int getFunctionPointFTR() {
        return functionPointFTR;
    }
}
