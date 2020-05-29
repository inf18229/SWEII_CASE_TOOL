//======================================================================================================================
//  C_frame
//
//  C_frame is the implementation of I_C_frame
//======================================================================================================================

package Controller;

import Model.M_projectData;
import Model.M_projectData_export;
import View.I_V_basic;
import View.I_V_frame;
import View.V_frame;

import javax.swing.*;

/**
 * implementation of I_C_Start
 * handles all programm functions not regarding special VIEWS.
 */
public class C_frame implements I_C_frame {
    I_V_frame viewFrame;
    I_C_start controllerStart;
    I_C_general controllerGeneral;
    I_C_effort controllerEffort;
    I_C_tab currentController; //stores current active Controller
    M_projectData projectData;  //stores projectData before export TODO: clarify: projectData also stored before pressing the save button?
    M_projectData_export projectData_export;

    public C_frame(M_projectData projData, I_C_start conStart) {
        System.out.println("C_frame created");
        controllerStart = conStart;
        viewFrame = new V_frame(this);
        projectData = projData;
        projectData_export = new M_projectData_export(projectData);
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
        controllerEffort = new C_effort(viewFrame, projectData);
        controllerGeneral = new C_general(viewFrame, projectData);
        System.out.println("General Controller created");
    }

    /**
     * switches to the specified Tab
     * TODO: add better description
     *
     * @param newTab integer of the newly selected tab
     */
    @Override
    public void notifyTabChange(int newTab) {
        switch (newTab) {
            case 0:
                System.out.println("Tab: 0 - General Tab Controller active!");
                currentController = controllerGeneral;
                break;
            case 1:
                System.out.println("Tab: 1");
                break;
            case 2:
                System.out.println("Tab: 2");
                break;
            case 3:
                System.out.println("Tab: 3 - Effort Tab Controller active");
                currentController = controllerEffort;
                currentController.updateProjectData(); //reads project data and refreshes view TODO: maybe add updateView() for all Controllers?
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
        String ObjButtons[] = {"Ja","Nein"};
        int promptResult = JOptionPane.showOptionDialog(
                null,
                "Wirklich zurück zum Startmenü? \nUngespeicherte Änderungen gehen verloren!",
                "Achtung",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                ObjButtons, // uses buttons defined in ObjButtons
                ObjButtons[1]); // uses "Nein" Button as Standard option (when pressing enter without choosing)
        if (promptResult == 0) {  // Back to Home by hiding viewFrame and showing viewStart again
            I_V_basic.hide(viewFrame.getJFrame());
            controllerStart.notifyShow();
        } else {
            //Do nothing
        }
    }

    /**
     * notifies the Controller that he should save the project
     * the controller therefore tells the model to save the data (and asks the user for export)
     */
    @Override
    public void notifySave() {  //TODO: clarify: save means export and changes will disappear when not exported/saved, but programm closed?
        projectData_export.export(projectData);
    }

    /**
     * when notified reload the project data for current view
     */
    @Override
    public void notifyRefresh() {
        System.out.println("Controller of Tab notified to refresh View");
        currentController.updateProjectData();
        //TODO: add implementation
    }

    /**
     * notifies the Controller that the user wants to close the program window
     * the controller therefore asks if the user really want to do it
     * if prompt allowed -> close program
     * else -> do nothing
     */
    @Override
    public void notifyExit() {
        String ObjButtons[] = {"Ja","Nein"};
        int promptResult = JOptionPane.showOptionDialog(
                null,
                "Programm wirklich beenden? \nUngespeicherte Änderungen gehen verloren!",
                "Achtung",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                ObjButtons,
                ObjButtons[1]);
        if (promptResult == 0) {  // close program by exiting
            System.exit(0);
        } else {
            //Do nothing
        }
    }

    //TODO: add prompt if window gets closed "Wirklich beenden? Alle ungespeicherten Änderungen gehen verloren!"


    @Override
    public I_C_tab getCurrentController() {
        return currentController;
    }
}