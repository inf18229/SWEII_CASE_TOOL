package Controller;

/**
 * main CONTROLLER, that handles all programm functions not regarding special VIEWS.
 * Its only purpose is to create CONTROLLERS for the special VIEWS and handle USER-IO to "switch" between the different
 * views
 */
public interface I_C_frame{
    //TODO: create CONTROLLERS for each special VIEW
    //TODO: create the main frame of the programm V_frame

    /**
     * in the enum tab every tab of the V_frame should be specified
     */
    enum tabs{};

    /**
     * creates Controller for each tab
     */
    void createTabControllers(/*I_C_frame.tabs tabs*/);

    /**
     * switches to the specified Tab
     * @param newTab integer of the newly selected tab
     */
    void notifyTabChange(int newTab);

    /**
     * notifies the Controller that he should close the project and open the welcome window
     */
    void notifyClose();

    /**
     * notifies the Controller that he should save the project
     */
    void notifySave();

    /**
     * notifies the Controller that he should reload the project data for current view
     */
    void notifyRefresh();

    /**
     * notifies the Controller that the user wants to close the program window
     */
    void notifyExit();

    I_C_tab getCurrentController();
}
