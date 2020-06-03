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
     * notifies the Controller that he should reload the project data for current view
     */
    void notifyNext();

    /**
     * notifies the Controller that he should reload the project data for current view
     */
    void notifyLast();

    /**
     * notifies the Controller, that a slider was changed
     * @param sliderNo  integer to identify the slider that was changed
     * @param value integer to which the slider was changed to
     */
    void notifySlider(int sliderNo, int value);

    /**
     * this method triggers all necessary functions to recalculate and show the new values
     */
    void notifyCalculate();
}
