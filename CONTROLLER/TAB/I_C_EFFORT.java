package CONTROLLER.TAB;

/**
 * This Interface manages all actions regarding the "Aufwandsschätzung" tab
 */
public interface I_C_EFFORT extends I_C_TAB {

    /**
     * this method updates the V_framePanel_effort
     * therefore all current values are set as View attributes
     */
    public void updateView();

    /**
     * notifies the Controller that the nextButton was pressed
     */
    public void notifyNext();

    /**
     * notifies the Controller that the lastButton was pressed
     */
    public void notifyLast();

    /**
     * notifies the Controller, that a slider was changed
     *
     * @param sliderNo integer to identify the slider that was changed
     * @param value    integer to which the slider was changed to
     */
    public void notifySlider(int sliderNo, int value);

    /**
     * this method triggers all necessary functions to recalculate and show the new values
     */
    public void notifyCalculate();

    /**
     * method iterates through all product functions,
     * adds up the number of elements
     * and saves the calculated value in the corresponding count variable
     */
    public void calculateCounts();

    /**
     * this method should automatically update the values for the factors to meet the e2goal
     * it outputs a message to determine if values could be corrected
     *
     * @return string of output which should be printed to console (mainly for development purposes)
     */
    public String notifyAdjustFactors();

    /**
     * increases Factors by given value
     *
     * @param increase value how much the factors should be increased
     */
    public void increaseFactors(int increase);

    /**
     * decreases Factors by given value
     *
     * @param decrease value how much the factors should be decreased
     */
    public void decreaseFactors(int decrease);
}
