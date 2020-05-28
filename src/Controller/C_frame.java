//======================================================================================================================
//  C_frame
//
//  C_frame is the implementation of I_C_frame
//======================================================================================================================

package Controller;

import Model.M_projectData;
import View.I_V_basic;
import View.I_V_frame;
import View.V_frame;

public class C_frame implements I_C_frame{
    I_V_frame viewFrame;
    I_C_general controllerGeneral;
    I_C_controller currentController; //current active Controller is stored here
    M_projectData projectData;
    I_C_effort conEffort;
    tabs currentTab;

    public enum tabs{
        Tab0, Tab1, Tab2, Aufwand
    }

    public C_frame(M_projectData projectData){
        debugPrint("C_frame created");
        viewFrame = new V_frame(this);
        this.projectData=projectData;
        createControllers();
        I_V_basic.show(viewFrame.getJFrame());
        setCurrentTab(0);
        currentController=controllerGeneral;
    }

    /**
     * creates Controller for each tab
     * method iterates through enum tabs and creates the specific Controller for each
     */
    @Override
    public void createControllers(/*I_C_frame.tabs tabs*/) {
        //controllerEffort = new C_effort();
        controllerGeneral=new C_general(viewFrame,projectData);
        System.out.println("General Controller created");
    }

    /**
     * switches to the specified Tab
     *
     * @param tab
     */
    @Override
    public void setCurrentTab(int tab) {
        /**
         * just for debugging puposes
         * prints index of selected tab to console
         */
        switch (tab){
            case 0:
                debugPrint("Tab: 0 - General");
                currentController=controllerGeneral;
                break;
            case 1:
                currentTab = tabs.Tab1;
                debugPrint("Tab: 1");
                break;
            case 2:
                currentTab = tabs.Tab2;
                debugPrint("Tab: 2");
                break;
            case 3:
                currentTab = tabs.Aufwand;
                debugPrint("Tab: 3 - Aufwandsschätzung");
                //conEffort.updateView();
                break;
        }

    }

    /**
     * notifies the Controller that he should close the project and open the welcome window
     * the controller therefore creates a "Do you really want to close and reject unsaved changes" windows
     * if allowed, the controller opens V_Start again
     */
    @Override
    public void notifyClose() {

    }

    /**
     * notifies the Controller that he should save the project
     * the controller therefore tells the model to save the data (and asks the user for export)
     */
    @Override
    public void notifySave() {

    }

    /**
     * checks which Tab of View is currently displayed
     * notifies the Controller in charge of this view to reload the project data for current view
     */
    @Override
    public void notifyRefresh() {
        switch (currentTab){
            case Tab0:
                debugPrint("Controller of Tab 0 notified to refresh View");
                break;
            case Tab1:
                debugPrint("Controller of Tab 1 notified to refresh View");
                break;
            case Tab2:
                debugPrint("Controller of Tab 2 notified to refresh View");
                break;
            case Aufwand:
                debugPrint("Controller of Tab Aufwandsschätzung notified to refresh View");
                break;
        }
    }

    /**
     * method to simply print the string output as text to console
     *
     * @param output
     */
    @Override
    public void debugPrint(String output) {
        System.out.println(output);
    }

    @Override
    public I_C_controller getcurrentController(){
        return currentController;
    }
}
