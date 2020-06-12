package MODEL.PROJECTDATA;

public interface I_M_PROJECTDATA_FUNCTIONPOINTESTIMATION {

    /**
     * this method gets the config data as parameter
     * and therefore updates the reference stored in the estimation object
     *
     * @param confData reference of config data to which the local variable configData is set to
     */
    public void setConfigData(M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA confData);

    /**
     * gets the value of the selected count Variable
     *
     * @param countNo which count Variable to get (-1 if countNo exceeds available variables)
     * @return the selected count
     */
    public int getCount(int countNo);

    /**
     * this method sets the corresponding count variable depending on countNo
     *
     * @param countNo which count to set
     * @param value   value to which the selected count variable should be set to
     */
    public void setCount(int countNo, int value);

    /**
     * gets the value of the selected weight Variable
     *
     * @param weightNo which weight Variable to get (-1 if weightNo exceeds available variables)
     * @return the selected weight
     */
    public int getWeight(int weightNo);

    /**
     * gets the value of the selected sum Variable
     *
     * @param sumNo which sum Variable to get (-1 if sumNo exceeds available variables)
     * @return the selected sum
     */
    public int getSum(int sumNo);

    /**
     * calculates the Sum for one row
     * depending on the count and weight
     *
     * @param count  total number of type
     * @param weight importance of this factor
     * @return result of the row sum calculation
     */
    public int calculateRowSum(int count, int weight);

    /**
     * calculates and stores the row sum for each count variable
     */
    public void calculateAllRowSums();

    /**
     * this method calculates and sets the total row Sum E1 to the corresponding variable
     */
    public void calculateTotalRowSumE1();

    /**
     * method calculates and sets the influence sum e3 to the corresponding variable
     */
    public void calcInfluenceE3();

    /**
     * method calculates the value for the Adjusted Function Points AFP and sets it to the corresponding variable
     */
    public void calcAdjustedFunctionPoints();

    /**
     * method calculates values according to the jones estimation and saves them into the corresponding variables
     */
    public void calcJonesEstimation();

    /**
     * this method uses an input for the real duration and calculates a correction factor
     * to estimate the duration better next time
     *
     * @param realTime time, the project really took till completion
     */
    public void calcCorrection(double realTime);

    /**
     * calculates the sum of all factors needed to achieve the real time
     *
     * @param realTime time, the project really took till completion
     */
    public void calcE2Needed(double realTime);

    /**
     * getter Method for e1Sum
     *
     * @return e1Sum
     */
    public int getE1Sum();

    /**
     * getter Method for e3Sum
     *
     * @return e3Sum
     */
    public double getE3Sum();

    /**
     * getter Method for afp
     *
     * @return afp
     */
    public double getAFP();

    /**
     * getter Method for jonesDuration
     *
     * @return jonesDuration
     */
    public double getJonesDuration();

    /**
     * getter Method for jonesPersonNo
     *
     * @return jonesPersonNo
     */
    public int getJonesPersonNo();

    /**
     * getter Method for jonesPersonMonths
     *
     * @return jonesPersonMonths
     */
    public double getJonesPersonMonths();

    /**
     * getter Method for actualDuration
     *
     * @return actualDuration
     */
    public double getActualDuration();

    /**
     * setter Method for actualDuration
     *
     * @param actualDuration value to which actualDuration is set to
     */
    public void setActualDuration(double actualDuration);

    /**
     * getter Method for correctionFactor
     *
     * @return correctionFactor
     */
    public double getCorrectionFactor();

    /**
     * getter Method for e2Correction
     *
     * @return e2Correction
     */
    public int getE2Correction();

    /**
     * setter Method for e2Correction
     *
     * @param e2Correction value to which e2Correction is set to
     */
    public void setE2Correction(int e2Correction);
}
