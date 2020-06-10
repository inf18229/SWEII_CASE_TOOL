package MODEL.PROJECTDATA;

public class M_PROJECTDATA_FUNCTIONPOINTESTIMATION {
    public M_PROJECTDATA_FUNCTIONPOINTESTIMATION() {

    }

    private M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA configData;

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

    public double e3Sum = 0;

    public double afp = 0;

    public double jonesDuration = 0;
    public int jonesPersonNo = 0;
    public double jonesPersonMonths = 0;

    public double actualDuration = 0;
    public double correctionFactor = 0;
    public double correctedDuration = 0;

    public int e2Correction = -1;    //propably better initialized with -1 or 0?

    /**
     * this method gets the config data and therefore updates the reference stored in the estimation object
     */
    public void setConfigData(M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA confData){
        configData = confData;
    }

    /**
     * this method sets the corresponding count variable depending on countNo
     *
     * @param countNo
     * @param value
     */
    public void setCountVariable(int countNo, int value) {
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

    /**
     * calculates the Sum for one row
     * depending on the count and weight
     *
     * @param count  total number of type
     * @param weight importance of this factor
     * @return result = count * weight
     */
    public int calculateRowSum(int count, int weight) {
        int result = count * weight;
        return result;
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
    /*public void calcFactorSumE2() {
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
    }*/

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
     * this method uses an input for the real duration and calculates a correction factor
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
        double temp = realTime / (Math.exp(0) * jonesPersonNo);
        double temp1 = Math.pow(temp, 1 / 0.4);
        double temp2 = temp1 / e1Sum;
        double temp3 = temp2 - 0.7;
        double tempFinal = (temp3 * 100);
        e2Correction = (int) tempFinal;

        /*double temp = realTime/(Math.exp(correctionFactor)*jonesPersonNo);
        double temp1 = Math.pow(temp, 1/0.4);
        double temp2 = temp1/e1Sum;
        double temp3 = temp2 - 0.7;
        double tempFinal = temp3 * 100;
        return (int) tempFinal;*/
    }

    /**
     * getter Method for actualDuration
     * @return actualDuration
     */
    public double getActualDuration() {
        return actualDuration;
    }

    /**
     * setter Method for actualDuration
     * @param actualDuration value to which actualDuration is set to
     */
    public void setActualDuration(double actualDuration) {
        this.actualDuration = actualDuration;
    }
}
