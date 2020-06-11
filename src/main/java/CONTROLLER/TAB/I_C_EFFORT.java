package CONTROLLER.TAB;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import VIEW.I_V_FRAME;

/**
 * This Interface manages all actions regarding the "Aufwandsschätzung" tab
 */
public interface I_C_EFFORT extends I_C_TAB {

    //TODO: getInstance here?

    /**
     * this method sets the necessary links after instantiation of the controller
     *
     * @param view     reference to the view that should be referenced in this object
     * @param projData reference to the project data that should be referenced in this object
     */
    void setLinks(I_V_FRAME view, M_PROJECTDATA projData);

    /**
     * this method updates the V_framePanel_effort
     * therefore all current values are set as View attributes
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
     * it outputs a message to determine if values could be corrected
     *
     * @return string of output which should be printed to console (mainly for development purposes)
     */
    String notifyAdjustFactors();

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
