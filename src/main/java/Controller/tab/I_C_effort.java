package Controller.tab;

/**
 * This Interface manages all actions regarding the "Aufwandsschätzung" tab
 */
public interface I_C_effort extends I_C_tab {

    /**
     * this method updates the V_framePanel_effort
     * therefore all current values are set as View attributes //TODO: <- implement this
     */
    void updateView();

    /**
     * notifies the Controller that the nextButton was pressed
     */
    void notifyNext();

    /**
     * notifies the Controller that the lastButton was pressed
     */
    void notifyLast();

    /**
     * notifies the Controller, that a slider was changed
     *
     * @param sliderNo integer to identify the slider that was changed
     * @param value    integer to which the slider was changed to
     */
    void notifySlider(int sliderNo, int value);

    /**
     * this method triggers all necessary functions to recalculate and show the new values
     */
    void notifyCalculate();

    /**
     * method iterates through all product functions,
     * adds up the number of elements
     * and saves the calculated value in the corresponding count variable
     */
    void calculateCounts();

    /**
     * this method should automatically update the values for the factors to meet the e2goal
     */
    void notifyAdjustFactors();

    /**
     * increases Factors by given value
     *
     * @param increase value how much the factors should be increased
     */
    void increaseFactors(int increase);

    /**
     * decreases Factors by given value
     *
     * @param decrease value how much the factors should be decreased
     */
    void decreaseFactors(int decrease);
}
