/**
 * Main: This file is part of CASE-Tool
 *
 * With the CASE-Tool it is possible to create feasibility studies
 * and save them. The software is based on a student project.
 *
 * Description:  Model for Estimation
 */

package Model;

public abstract class M_project_Data_Estimation {
    //actual value
    public double actualValue = 0;
    //nominal value
    public double setpoint = 0;

    public M_project_Data_Estimation(double actualValue, double setpoint) {
        this.actualValue = actualValue;
        this.setpoint = setpoint;
    }
    public abstract void estimate();
}
