package CONTROLLER;

import CONTROLLER.TAB.I_C_TAB;
import MODEL.PROJECTDATA.M_PROJECTDATA;

/**
 * main CONTROLLER, that handles all programm functions not regarding special VIEWS.
 * Its only purpose is to create CONTROLLERS for the special VIEWS and handle USER-IO to "switch" between the different
 * views
 */
public interface I_C_FRAME {

    /**
     * this method sets the necessary links after instantiation of the controller
     *
     * @param projData reference to the projectData
     * @param conStart reference to the Start Controller
     * @param path     path of the projectData
     */
    public void setLinks(M_PROJECTDATA projData, I_C_START conStart, String path);

    /**
     * creates Controller for each tab
     */
    public void createTabControllers();

    //TODO: decide if this should be implemented?
    /**
     * calls the required functions dependend on the id given
     * @param id identifier which button was pressed
     *           0: button x
     *           1: button y
     */


    /**
     * switches to the specified Tab
     *
     * @param newTab integer of the newly selected tab
     */
    public void notifyTabChange(int newTab);

    /**
     * should notify C_EFFORT that the tab in V_Effort_Tabs has changed
     */
    public void notifyTabChangeEffort();

    /**
     * notifies the Controller, that a slider was changed
     *
     * @param sliderNo integer to identify the slider that was changed
     * @param value    integer to which the slider was changed to
     */
    public void notifySlider(int sliderNo, int value);

    /**
     * notifies the effort controller to recalculate the estimation
     */
    public void notifyCalculate();

    /**
     * notifies the Controller that he should close the project and open the welcome window
     */
    public void notifyClose();

    /**
     * notifies the Controller that he should save the project
     */
    public void notifySave();

    /**
     * notifies the Controller that he should import new factors
     */
    public void notifyImportFactor();

    /**
     * notifies the Controller that he should export the factors
     */
    public void notifyExportFactor();

    /**
     * notifies the Controller that the next button was pressed
     */
    public void notifyNext();

    /**
     * notifies the Controller that the last button was pressed
     */
    public void notifyLast();

    /**
     * this method should automatically update the values for the factors to meet the e2goal
     */
    public void notifyAdjustFactors();

    /**
     * notifies the Controller that the user wants to close the program window
     */
    public void notifyExit();

    I_C_TAB getCurrentController();

    /**
     * notfies the controller that the new Button in Functional Reqirement Tab is pressed
     */
    public void notifyProductContentNEW();

    /**
     * notifies the controller that save Button in Functional Reqirement Tab is pressed
     */
    public void notifyProductContentDELETE();

    /**
     * notify Controller that selected List Item has changed
     *
     * @param selectedID //TODO: add description
     */
    public void notifySelectedListChange(String selectedID);
}
