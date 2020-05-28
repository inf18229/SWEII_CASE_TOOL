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

/**
 * implementation of I_C_Start
 * handles all programm functions not regarding special VIEWS.
 */
public class C_frame implements I_C_frame{
    I_V_frame viewFrame;
    I_C_general controllerGeneral;
    I_C_effort controllerEffort;
    I_C_tab currentController; //stores current active Controller
    M_projectData projectData;  //stores projectData before export TODO: clarify: projectData also stored before pressing the save button?

    public C_frame(M_projectData projectData){
        System.out.println("C_frame created");
        viewFrame = new V_frame(this);
        this.projectData = projectData;
//        this.projectData_export = new M_projectData_export(this.projectData); TODO: fix this
        createTabControllers();
        I_V_basic.show(viewFrame.getJFrame());
        currentController = controllerGeneral;
    }

    /**
     * creates Controller for each tab
     * method iterates through enum tabs and creates the specific Controller for each
     */
    @Override
    public void createTabControllers(/*I_C_frame.tabs tabs*/) {
        //controllerEffort = new C_effort();
        controllerGeneral=new C_general(viewFrame,projectData);
        System.out.println("General Controller created");
    }

    /**
     * switches to the specified Tab
     * TODO: add better description
     * @param newTab integer of the newly selected tab
     */
    @Override
    public void notifyTabChange(int newTab) {
        switch (newTab){
            case 0:
                System.out.println("Tab: 0 - General");
                currentController=controllerGeneral;
                break;
            case 1:
                System.out.println("Tab: 1");
                break;
            case 2:
                System.out.println("Tab: 2");
                break;
            case 3:
                System.out.println("Tab: 3 - Aufwandsschätzung");
                currentController = controllerEffort;
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
        System.out.println("Safe pressed");
//        projectData_export.export(projectData); TODO: fix this
    }

    /**
     * when notified reload the project data for current view
     */
    @Override
    public void notifyRefresh() {
        System.out.println("Controller of Tab Aufwandsschätzung notified to refresh View");
        //TODO: add implementation
    }


    @Override
    public I_C_tab getCurrentController(){
        return currentController;
    }
}
