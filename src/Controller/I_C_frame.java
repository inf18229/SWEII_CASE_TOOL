//======================================================================================================================
//  I_C_frame
//
//  C_frame is the main CONTROLLER, that handles all programm functions not regarding special VIEWS.
//  Its only purpose is to create CONTROLLERS for the special VIEWS and handle USER-IO to switch between the different
//  VIEWS
//======================================================================================================================

package Controller;

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
    public void createControllers(/*I_C_frame.tabs tabs*/);

    /**
     * switches to the specified Tab
     * @param tab integer of the selected tab
     */
    public void switchToTab(int tab);

    /**
     * method to simply print the string output as text to console
     * @param output
     */
    public void debugPrint(String output);

    public I_C_controller getcurrentController();
}
