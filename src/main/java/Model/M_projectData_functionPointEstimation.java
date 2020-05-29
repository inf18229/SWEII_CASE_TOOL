/**
 * Main: This file is part of CASE-Tool
 *
 * With the CASE-Tool it is possible to create feasibility studies
 * and save them. The software is based on a student project.
 *
 * Description:  Model for Function Point Estimation
 */

package Model;

public class M_projectData_functionPointEstimation extends M_project_Data_Estimation {
    public M_projectData_functionPointEstimation(double actualValue, double setpoint) {
        super(actualValue, setpoint);
    }

    public int countInputSimple = 0;
    public int countInputMedium = 0;
    public int countInputComplex = 0;

    public int countQuerySimple = 1;
    public int countQueryMedium = 2;
    public int countQueryComplex = 3;

    public int countOutputSimple = 0;
    public int countOutputMedium = 0;
    public int countOutputComplex = 0;

    public int countDatasetSimple = 0;
    public int countDatasetMedium = 0;
    public int countDatasetComplex = 0;

    public int countReferenceSimple = 0;
    public int countReferenceMedium = 0;
    public int countReferenceComplex = 0;

    public int factor1 = 0;
    public int factor2 = 0;
    public int factor3 = 0;
    public int factor4a = 0;
    public int factor4b = 0;
    public int factor4c = 0;
    public int factor4d = 0;
    public int factor5 = 0;
    public int factor6 = 0;
    public int factor7 = 0;

    public int e1Sum = 0;
    public int e2Sum = 0;
    public double e3Sum = 0;

    public double jonesDuration = 0;
    public int jonesPersons = 0;
    public double jonesPersonMoths = 0;

    public double correctionFactor = 0;


    @Override
    public void estimate() {

    }

    public void calcE2Sum() {
        //Calculation for E2
        e2Sum = factor1 + factor2 + factor3 + factor4a + factor4b + factor4c + factor4d + factor5 + factor6 + factor7;
    }

    public void calcE3() {
        //Calculation for E3
        e3Sum = (float) e2Sum / 100 + 0.7;
    }

    public void calcFunctionPointResult() {
        //Calculation for Function Point Result
        setpoint = e1Sum * e3Sum;
    }

    public void updateValues() {
        //Update Calculation functions
        calcE2Sum();
        calcE3();
        calcFunctionPointResult();
        calcJonesEstimation();
    }

    private void calcJonesEstimation() {
        //Calculation for Jones Estimation
        jonesDuration = Math.pow(setpoint, 0.4);

        jonesPersons = (int) Math.round(setpoint/150);
        if (jonesPersons < 1 & setpoint != 0) jonesPersons = 1;

        jonesPersonMoths = jonesDuration * jonesPersons;
    }
}
