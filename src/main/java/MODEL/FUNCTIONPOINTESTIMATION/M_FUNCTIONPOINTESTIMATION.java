package MODEL.FUNCTIONPOINTESTIMATION;

/**
 * Class contains all Information for Functionpoint Estimation
 * Calculates Functionpoint Estimation
 */
public class M_FUNCTIONPOINTESTIMATION {

    private static M_FUNCTIONPOINTESTIMATION functionPointEstimation;
    private M_FUNCTIONPOINTESTIMATION_CONFIGDATA configData; // reference to configData

    private int countInputSimple = 0;
    private int countInputMedium = 0;
    private int countInputComplex = 0;

    private int countQuerySimple = 0;
    private int countQueryMedium = 0;
    private int countQueryComplex = 0;

    private int countOutputSimple = 0;
    private int countOutputMedium = 0;
    private int countOutputComplex = 0;

    private int countDatasetSimple = 0;
    private int countDatasetMedium = 0;
    private int countDatasetComplex = 0;

    private int countReferenceSimple = 0;
    private int countReferenceMedium = 0;
    private int countReferenceComplex = 0;

    private int weightInputSimple = 3;
    private int weightInputMedium = 4;
    private int weightInputComplex = 6;

    private int weightQuerySimple = 3;
    private int weightQueryMedium = 4;
    private int weightQueryComplex = 6;

    private int weightOutputSimple = 4;
    private int weightOutputMedium = 5;
    private int weightOutputComplex = 7;

    private int weightDatasetSimple = 7;
    private int weightDatasetMedium = 10;
    private int weightDatasetComplex = 15;

    private int weightReferenceSimple = 5;
    private int weightReferenceMedium = 7;
    private int weightReferenceComplex = 10;

    private int sumInputSimple = 0;
    private int sumInputMedium = 0;
    private int sumInputComplex = 0;

    private int sumQuerySimple = 0;
    private int sumQueryMedium = 0;
    private int sumQueryComplex = 0;

    private int sumOutputSimple = 0;
    private int sumOutputMedium = 0;
    private int sumOutputComplex = 0;

    private int sumDatasetSimple = 0;
    private int sumDatasetMedium = 0;
    private int sumDatasetComplex = 0;

    private int sumReferenceSimple = 0;
    private int sumReferenceMedium = 0;
    private int sumReferenceComplex = 0;

    private int e1Sum = 0; // Sum of unadjusted Function Points (naming Schema by SWE script)
    private double e3Sum = 0; // factor of influence points
    private double afp = 0; // adjusted Function Points
    private double jonesDuration = 0;
    private int jonesPersonNo = 0;
    private double jonesPersonMonths = 0;
    private double actualDuration = 0;
    private double correctionFactor = 0;
    private int e2Correction = -1; // correction factor for influence points Sum

    /**
     * creates new Object of Function Point Estimation and sets a reference to configData
     */
    private M_FUNCTIONPOINTESTIMATION() {
    }

    /**
     * creates new Object of Function Point Estimation
     *
     * @return function Point Estimation
     */
    public static M_FUNCTIONPOINTESTIMATION getInstance() {
        if (M_FUNCTIONPOINTESTIMATION.functionPointEstimation == null) {
            M_FUNCTIONPOINTESTIMATION.functionPointEstimation = new M_FUNCTIONPOINTESTIMATION();
        } else {
            System.out.println("FunctionPointEstimation Instance already created");
        }
        return M_FUNCTIONPOINTESTIMATION.functionPointEstimation;
    }

    /**
     * gets the config data as parameter
     * and therefore updates the reference stored in the estimation object
     *
     * @param confData reference of config data to which the local variable configData is set to
     */
    public void setConfigData(M_FUNCTIONPOINTESTIMATION_CONFIGDATA confData) {
        configData = confData;
    }

    /**
     * gets the value of the selected count Variable
     *
     * @param countNo which count Variable to get (-1 if countNo exceeds available variables)
     * @return the selected count
     */
    public int getCount(int countNo) {
        switch (countNo) {
            case 0:
                return countInputSimple;
            case 1:
                return countInputMedium;
            case 2:
                return countInputComplex;
            case 3:
                return countQuerySimple;
            case 4:
                return countQueryMedium;
            case 5:
                return countQueryComplex;
            case 6:
                return countOutputSimple;
            case 7:
                return countOutputMedium;
            case 8:
                return countOutputComplex;
            case 9:
                return countDatasetSimple;
            case 10:
                return countDatasetMedium;
            case 11:
                return countDatasetComplex;
            case 12:
                return countReferenceSimple;
            case 13:
                return countReferenceMedium;
            case 14:
                return countReferenceComplex;
            default:
                return -1;
        }
    }

    /**
     * sets the corresponding count variable depending on countNo
     *
     * @param countNo which count to set
     * @param value   value to which the selected count variable should be set to
     */
    public void setCount(int countNo, int value) {
        switch (countNo) {
            case 0:
                countInputSimple = value;
                break;
            case 1:
                countInputMedium = value;
                break;
            case 2:
                countInputComplex = value;
                break;
            case 3:
                countQuerySimple = value;
                break;
            case 4:
                countQueryMedium = value;
                break;
            case 5:
                countQueryComplex = value;
                break;
            case 6:
                countOutputSimple = value;
                break;
            case 7:
                countOutputMedium = value;
                break;
            case 8:
                countOutputComplex = value;
                break;
            case 9:
                countDatasetSimple = value;
                break;
            case 10:
                countDatasetMedium = value;
                break;
            case 11:
                countDatasetComplex = value;
                break;
            case 12:
                countReferenceSimple = value;
                break;
            case 13:
                countReferenceMedium = value;
                break;
            case 14:
                countReferenceComplex = value;
                break;
            default:
                break;
        }
    }

    /**
     * gets the value of the selected weight Variable
     *
     * @param weightNo which weight Variable to get (-1 if weightNo exceeds available variables)
     * @return the selected weight
     */
    public int getWeight(int weightNo) {
        switch (weightNo) {
            case 0:
                return weightInputSimple;
            case 1:
                return weightInputMedium;
            case 2:
                return weightInputComplex;
            case 3:
                return weightQuerySimple;
            case 4:
                return weightQueryMedium;
            case 5:
                return weightQueryComplex;
            case 6:
                return weightOutputSimple;
            case 7:
                return weightOutputMedium;
            case 8:
                return weightOutputComplex;
            case 9:
                return weightDatasetSimple;
            case 10:
                return weightDatasetMedium;
            case 11:
                return weightDatasetComplex;
            case 12:
                return weightReferenceSimple;
            case 13:
                return weightReferenceMedium;
            case 14:
                return weightReferenceComplex;
            default:
                return -1;
        }
    }

    /**
     * gets the value of the selected sum Variable
     *
     * @param sumNo which sum Variable to get (-1 if sumNo exceeds available variables)
     * @return the selected sum
     */
    public int getSum(int sumNo) {
        switch (sumNo) {
            case 0:
                return sumInputSimple;
            case 1:
                return sumInputMedium;
            case 2:
                return sumInputComplex;
            case 3:
                return sumQuerySimple;
            case 4:
                return sumQueryMedium;
            case 5:
                return sumQueryComplex;
            case 6:
                return sumOutputSimple;
            case 7:
                return sumOutputMedium;
            case 8:
                return sumOutputComplex;
            case 9:
                return sumDatasetSimple;
            case 10:
                return sumDatasetMedium;
            case 11:
                return sumDatasetComplex;
            case 12:
                return sumReferenceSimple;
            case 13:
                return sumReferenceMedium;
            case 14:
                return sumReferenceComplex;
            default:
                return -1;
        }
    }

    /**
     * calculates the Sum for one row
     * depending on the count and weight
     *
     * @param count  total number of type
     * @param weight importance of this factor
     * @return count * weight
     */
    public int calculateRowSum(int count, int weight) {
        return count * weight;
    }

    /**
     * calculates and stores the row sum
     * for each count variable
     * it therefore runs the calculateRowSum Method for each count variable and
     * stores the weight in the corresponding weight variables
     */
    public void calculateAllRowSums() {
        sumInputSimple = calculateRowSum(countInputSimple, weightInputSimple);
        sumInputMedium = calculateRowSum(countInputMedium, weightInputMedium);
        sumInputComplex = calculateRowSum(countInputComplex, weightInputComplex);

        sumQuerySimple = calculateRowSum(countQuerySimple, weightQuerySimple);
        sumQueryMedium = calculateRowSum(countQueryMedium, weightQueryMedium);
        sumQueryComplex = calculateRowSum(countQueryComplex, weightQueryComplex);

        sumOutputSimple = calculateRowSum(countOutputSimple, weightOutputSimple);
        sumOutputMedium = calculateRowSum(countOutputMedium, weightOutputMedium);
        sumOutputComplex = calculateRowSum(countOutputComplex, weightOutputComplex);

        sumDatasetSimple = calculateRowSum(countDatasetSimple, weightDatasetSimple);
        sumDatasetMedium = calculateRowSum(countDatasetMedium, weightDatasetMedium);
        sumDatasetComplex = calculateRowSum(countDatasetComplex, weightDatasetComplex);

        sumReferenceSimple = calculateRowSum(countReferenceSimple, weightReferenceSimple);
        sumReferenceMedium = calculateRowSum(countReferenceMedium, weightReferenceMedium);
        sumReferenceComplex = calculateRowSum(countReferenceComplex, weightReferenceComplex);
    }

    /**
     * calculates the total row Sum E1
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
     * method calculates and sets the influence sum e3
     */
    public void calcInfluenceE3() {
        e3Sum = (double) configData.getE2Sum() / 100 + 0.7;
    }

    /**
     * method calculates the value for the Adjusted Function Points AFP
     */
    public void calcAdjustedFunctionPoints() {
        afp = e1Sum * e3Sum;
    }

    /**
     * method calculates values according to the jones estimation and saves them into the model variables
     */
    public void calcJonesEstimation() {
        jonesDuration = Math.pow(afp, 0.4);
        jonesPersonNo = (int) Math.ceil(afp / 150);
        jonesPersonMonths = jonesDuration * jonesPersonNo;
    }

    /**
     * uses an input for the real duration and calculates a correction factor
     * to estimate the duration better next time
     *
     * @param realTime time, the project really took till completion
     */
    public void calcCorrection(double realTime) {
        correctionFactor = Math.log(realTime / jonesPersonMonths);
    }

    /**
     * calculates the sum of all factors needed to achieve the real time
     *
     * @param realTime time, the project really took till completion
     */
    public void calcE2Needed(double realTime) {
        e2Correction = (int) (((Math.pow((realTime / (Math.exp(0) * jonesPersonNo)), (1 / 0.4)) / e1Sum) - 0.7) * 100);

        /*double temp = realTime / (Math.exp(0) * jonesPersonNo);
        double temp1 = Math.pow(temp, 1 / 0.4);
        double temp2 = temp1 / e1Sum;
        double temp3 = temp2 - 0.7;
        double tempFinal = (temp3 * 100);
        e2Correction = (int) tempFinal;*/
    }

    /**
     * getter Method for e1Sum
     *
     * @return e1Sum
     */
    public int getE1Sum() {
        return e1Sum;
    }

    /**
     * getter Method for e3Sum
     *
     * @return e3Sum
     */
    public double getE3Sum() {
        return e3Sum;
    }

    /**
     * getter Method for afp
     *
     * @return afp
     */
    public double getAFP() {
        return afp;
    }

    /**
     * getter Method for jonesDuration
     *
     * @return jonesDuration
     */
    public double getJonesDuration() {
        return jonesDuration;
    }

    /**
     * getter Method for jonesPersonNo
     *
     * @return jonesPersonNo
     */
    public int getJonesPersonNo() {
        return jonesPersonNo;
    }

    /**
     * getter Method for jonesPersonMonths
     *
     * @return jonesPersonMonths
     */
    public double getJonesPersonMonths() {
        return jonesPersonMonths;
    }

    /**
     * getter Method for actualDuration
     *
     * @return actualDuration
     */
    public double getActualDuration() {
        return actualDuration;
    }

    /**
     * setter Method for actualDuration
     *
     * @param actualDuration value to which actualDuration is set to
     */
    public void setActualDuration(double actualDuration) {
        this.actualDuration = actualDuration;
    }

    /**
     * getter Method for correctionFactor
     *
     * @return correctionFactor
     */
    public double getCorrectionFactor() {
        return correctionFactor;
    }

    /**
     * getter Method for e2Correction
     *
     * @return e2Correction
     */
    public int getE2Correction() {
        return e2Correction;
    }

    /**
     * setter Method for e2Correction
     *
     * @param e2Correction value to which e2Correction is set to
     */
    public void setE2Correction(int e2Correction) {
        this.e2Correction = e2Correction;
    }
}
