/**
 * Main: This file is part of CASE-Tool
 *
 * With the CASE-Tool it is possible to create feasibility studies
 * and save them. The software is based on a student project.
 *
 * Description:  Model for Function Point Estimation
 */

package Model.projectData;

public class M_projectData_functionPointEstimation/* extends M_project_Data_Estimation */{
    /*public M_projectData_functionPointEstimation(double actualValue, double setpoint) {
        super(actualValue, setpoint);
    }*/
    public M_projectData_functionPointEstimation(){

    }

    //variables for all counts
    public int countInputSimple = 0;
    public int countInputMedium = 0;
    public int countInputComplex = 0;

    public int countQuerySimple = 0;
    public int countQueryMedium = 0;
    public int countQueryComplex = 0;

    public int countOutputSimple = 0;
    public int countOutputMedium = 0;
    public int countOutputComplex = 0;

    public int countDatasetSimple = 0;
    public int countDatasetMedium = 0;
    public int countDatasetComplex = 0;

    public int countReferenceSimple = 0;
    public int countReferenceMedium = 0;
    public int countReferenceComplex = 0;

    //variables for all weights
    public int weightInputSimple = 3;
    public int weightInputMedium = 4;
    public int weightInputComplex = 6;

    public int weightQuerySimple = 3;
    public int weightQueryMedium = 4;
    public int weightQueryComplex = 6;

    public int weightOutputSimple = 4;
    public int weightOutputMedium = 5;
    public int weightOutputComplex = 7;

    public int weightDatasetSimple = 7;
    public int weightDatasetMedium = 10;
    public int weightDatasetComplex = 15;

    public int weightReferenceSimple = 5;
    public int weightReferenceMedium = 7;
    public int weightReferenceComplex = 10;

    //variables for all calculated sums
    public int sumInputSimple = 0;
    public int sumInputMedium = 0;
    public int sumInputComplex = 0;

    public int sumQuerySimple = 0;
    public int sumQueryMedium = 0;
    public int sumQueryComplex = 0;

    public int sumOutputSimple = 0;
    public int sumOutputMedium = 0;
    public int sumOutputComplex = 0;

    public int sumDatasetSimple = 0;
    public int sumDatasetMedium = 0;
    public int sumDatasetComplex = 0;

    public int sumReferenceSimple = 0;
    public int sumReferenceMedium = 0;
    public int sumReferenceComplex = 0;

    public int e1Sum = 0;

    //variables for factors
    public int factorEntanglement = 0;
    public int factorDecentralization = 0;
    public int factorTransactionrate = 0;

    public int factorProcessingCalculation = 0;
    public int factorProcessingControl = 0;
    public int factorProcessingException = 0;
    public int factorProcessingLogic = 0;

    public int factorReusability = 0;
    public int factorConversion = 0;
    public int factorCustomizability = 0;

    public int e2Sum = 0;
    public double e3Sum = 0;

    public double afp = 0;

    public double jonesDuration = 0;
    public int jonesPersonNo = 0;
    public double jonesPersonMonths = 0;

    public double actualDuration = 0;
    public double correctionFactor = 0;
    public double correctedDuration = 0;

    /**
     * this method sets the corresponding count variable depending on countNo
     * @param countNo
     * @param value
     */
    public void setCountVariable(int countNo, int value){
        switch (countNo) {
            case 10:
                countInputSimple = value;
                break;
            case 11:
                countInputMedium = value;
                break;
            case 12:
                countInputComplex = value;
                break;

            case 20:
                countQuerySimple = value;
                break;
            case 21:
                countQueryMedium = value;
                break;
            case 22:
                countQueryComplex = value;
                break;

            case 30:
                countOutputSimple = value;
                break;
            case 31:
                countOutputMedium = value;
                break;
            case 32:
                countOutputComplex = value;
                break;


            case 40:
                countDatasetSimple = value;
                break;
            case 41:
                countDatasetMedium = value;
                break;
            case 42:
                countDatasetComplex = value;
                break;

            case 50:
                countReferenceSimple = value;
                break;
            case 51:
                countReferenceMedium = value;
                break;
            case 52:
                countReferenceComplex = value;
                break;

            default:
                break;
        }
    }

    //TODO: fix not working yet!!!
    /**
     * sets one factor to the provided value
     * @param factorNo  which factor to change
     * @param value     what value to set it to
     */
    public void setFactor(int factorNo, int value) {
        switch (factorNo) {
            case 1:
                factorEntanglement = value;
                break;
            case 2:
                factorDecentralization = value;
                break;
            case 3:
                factorTransactionrate = value;
                break;
            case 41:
                factorProcessingCalculation = value;
                break;
            case 42:
                factorProcessingControl = value;
                break;
            case 43:
                factorProcessingException = value;
                break;
            case 44:
                factorProcessingLogic = value;
                break;
            case 5:
                factorReusability = value;
                break;
            case 6:
                factorConversion = value;
                break;
            case 7:
                factorCustomizability = value;
                break;
            default:
                // TODO: evtl. besser try catch -> prüfen und wenn besser implementieren
        }
    }

    /**
     * gets the value of the factor
     * @param factorNo  which factor to get
     */
    public int getFactor(int factorNo) {
        switch (factorNo) {
            case 1:
                return factorEntanglement;
            case 2:
                return factorDecentralization;
            case 3:
                return factorTransactionrate;
            case 41:
                return factorProcessingCalculation;
            case 42:
                return factorProcessingControl;
            case 43:
                return factorProcessingException;
            case 44:
                return factorProcessingLogic;
            case 5:
                return factorReusability;
            case 6:
                return factorConversion;
            case 7:
                return factorCustomizability;
            default:
                return 0;
                // TODO: evtl. besser try catch -> prüfen und wenn besser implementieren
        }
    }

    /**
     * calculates the Sum for one row
     * depending on the count and weight
     * @param count total number of type
     * @param weight importance of this factor
     * @return result = count * weight
     */
    public int calculateRowSum(int count, int weight){
        int result = count * weight;
        return result;
    }

    /**
     * calculates and stores the row sum
     * for each count variable
     * it therefore runs the calculateRowSum Method for each count variable and
     * stores the weight in the corresponding weight variables
     */
    public void calculateAllRowSums(){ //TODO: aufgabe des Controllers?
        sumInputSimple = calculateRowSum(countInputSimple, weightInputSimple);
        sumInputMedium = calculateRowSum(countInputMedium, weightInputMedium);
        sumInputComplex = calculateRowSum(countInputComplex, weightInputComplex);

        sumQuerySimple = calculateRowSum(countQuerySimple, weightQuerySimple);
        sumQueryMedium = calculateRowSum(countQueryMedium, weightQueryMedium);
        sumQueryComplex = calculateRowSum(countQueryComplex, weightQueryComplex);

        sumOutputSimple = calculateRowSum(countOutputSimple, weightOutputSimple);
        sumOutputMedium = calculateRowSum( countOutputMedium, weightOutputMedium);
        sumOutputComplex = calculateRowSum(countOutputComplex, weightOutputComplex);

        sumDatasetSimple = calculateRowSum(countDatasetSimple, weightDatasetSimple);
        sumDatasetMedium = calculateRowSum(countDatasetMedium, weightDatasetMedium);
        sumDatasetComplex = calculateRowSum(countDatasetComplex, weightDatasetComplex);

        sumReferenceSimple = calculateRowSum(countReferenceSimple, weightReferenceSimple);
        sumReferenceMedium = calculateRowSum(countReferenceMedium, weightReferenceMedium);
        sumReferenceComplex = calculateRowSum(countReferenceComplex, weightReferenceComplex);
    }

    /**
     * this method calculates the total row Sum E1
     */
    public void calculateTotalRowSumE1() {
        e1Sum = sumInputSimple
                + sumInputMedium
                + sumInputComplex
                + sumQuerySimple
                + sumQueryMedium
                + sumQueryComplex
                + sumOutputSimple
                + sumOutputMedium
                + sumOutputComplex
                + sumDatasetSimple
                + sumDatasetMedium
                + sumDatasetComplex
                + sumReferenceSimple
                + sumReferenceMedium
                + sumReferenceComplex;
    }

    /**
     * method adds all factors and therefore calculates the total sum of all factors E2
     */
    public void calcFactorSumE2() {
        e2Sum = factorEntanglement
                + factorDecentralization
                + factorTransactionrate
                + factorProcessingCalculation
                + factorProcessingControl
                + factorProcessingException
                + factorProcessingLogic
                + factorReusability
                + factorConversion
                + factorCustomizability;
    }

    /**
     * method calculates and sets the influence sum e3
     */
    public void calcInfluenceE3() {
        e3Sum = (double) e2Sum / 100 + 0.7;
    }

    /**
     * method calculates the value for the Adjusted Function Points AFP
     */
    public void calcAdjustedFunctionPoints() {
        afp = e1Sum * e3Sum;
    }

    //TODO: Warum kein Test -> nur Mathe Klasse getestet (die sollte ja korrekt sein)
    /**
     * method calculates values according to the jones estimation and saves them into the model variables
     */
    public void calcJonesEstimation(){
        jonesDuration = Math.pow(afp, 0.4);
        jonesPersonNo = (int) Math.ceil(afp/150);
        jonesPersonMonths = jonesDuration * jonesPersonNo;
    }

    /**
     * this method uses an input for the real duration and calculates a correction factor
     * to estimate the duration better next time
     * @param realTime
     */
    public void calcCorrection(int realTime){
        correctionFactor = Math.log(jonesPersonMonths/realTime);
    }
}
