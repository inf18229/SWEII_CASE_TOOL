//======================================================================================================================
//  C_frame
//
//  C_frame is the implementation of I_C_frame
//======================================================================================================================

package Controller;

import Controller.tab.*;
import Model.projectData.M_projectData;
import Model.M_export;
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
    I_C_functionalReqirement controllerFunctionalReqirement;
    I_C_effort controllerEffort;
    I_C_tab currentController; //stores current active Controller
    M_projectData projectData;  //stores projectData before export TODO: clarify: projectData also stored before pressing the save button?
    M_export projectData_export;
    String projPath = "";

    public C_frame(M_projectData projData, I_C_start conStart, String path) {
        System.out.println("C_frame created");
        controllerStart = conStart;
        projectData = projData;
        viewFrame = new V_frame(this,projectData);
        projectData_export = new M_export();
        createTabControllers();
        I_V_basic.show(viewFrame.getJFrame());
        currentController = controllerGeneral;
        projPath = path;
    }

    /**
     * creates Controller for each tab
     * method iterates through enum tabs and creates the specific Controller for each
     */
    @Override
    public void createTabControllers(/*I_C_frame.tabs tabs*/) {
        controllerEffort = new C_effort(viewFrame, projectData);
        controllerFunctionalReqirement=new C_functionalReqirement(viewFrame,projectData);
        controllerGeneral = new C_general(viewFrame, projectData);
        System.out.println("General Controller created");
    }

    /**
     * depending on the int newTab it switches to the specified Tab
     * and runs the necessary functions in the view to show/hide buttons needed/not needed
     * @param newTab integer of the newly selected tab
     */
    @Override
    public void notifyTabChange(int newTab) {
        switch (newTab) {
            case 0:
                viewFrame.hideNext();
                viewFrame.hideLast();
                viewFrame.hideCalculateNew();
                viewFrame.hideCalculateNew();
                System.out.println("Tab: 0 - General Tab Controller active!");
                currentController = controllerGeneral;
                break;
            case 1:
                viewFrame.hideNext();
                viewFrame.hideLast();
                viewFrame.hideCalculateNew();
                viewFrame.hideCalculateNew();
                System.out.println("Tab: 1 - Functional Reqirement Controller acitve");
                currentController = controllerFunctionalReqirement;
                break;
            case 2:
                viewFrame.hideNext();
                viewFrame.hideLast();
                viewFrame.hideCalculateNew();
                viewFrame.hideCalculateNew();
                System.out.println("Tab: 2");
                break;
            case 3:
                System.out.println("Tab: 3 - Effort Tab Controller active");
                currentController = controllerEffort;
                currentController.updateProjectData(); //reads project data and refreshes view TODO: maybe add updateView() for all Controllers?
                viewFrame.showNext();
                viewFrame.showLast();
                viewFrame.showCalculateNew();
                viewFrame.showCalculateNew();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + newTab);
        }
    }

    /**
     * notifies the Controller, that a slider was changed
     *
     * @param sliderNo integer to identify the slider that was changed
     * @param value    integer to which the slider was changed to
     */
    @Override
    public void notifySlider(int sliderNo, int value) {
        if (currentController == controllerEffort){
            controllerEffort.notifySlider(sliderNo, value);
        }
        //else do nothing
    }

    /**
     * notifies the effort controller to recalculate time
     */
    @Override
    public void notifyCalculate() {
        if (currentController == controllerEffort) {
            controllerEffort.notifyCalculate();
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
        projectData_export.export(projectData, projPath);
    }

    /**
     * when notified reload the project data for current view
     */
    @Override
    public void notifyNext() {
        if (currentController == controllerEffort){
            controllerEffort.notifyNext();
        }
    }

    /**
     * when notified reload the project data for current view
     */
    @Override
    public void notifyLast() {
        if (currentController == controllerEffort){
            controllerEffort.notifyLast();
        }
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
        if (promptResult == 0) {  // if desired (promptResult == 0) close program by exiting
            System.exit(0);
        }
    }

    @Override
    public I_C_tab getCurrentController() {
        return currentController;
    }

    @Override
    public void notifyFuncReqNEW(){
        controllerFunctionalReqirement.newFuncReqElement();
    }

    @Override
    public void notifyFuncReqDELETE(){
        controllerFunctionalReqirement.deleteFuncReqElement();
    }
    @Override
    public void notifyselectedListChange(String selectedID){
        controllerFunctionalReqirement.notifyChangeSelectedListItem(selectedID);
    }
}
