package CONTROLLER;

import CONTROLLER.TAB.*;
import MODEL.M_EXPORT;
import MODEL.M_IMPORT;
import MODEL.PROJECTDATA.M_PROJECTDATA;
import VIEW.I_V_BASIC;
import VIEW.I_V_FRAME;
import VIEW.V_FRAME;

import javax.swing.*;
import java.nio.file.InvalidPathException;

/**
 * implementation of I_C_FRAME
 * handles all programm functions not regarding special VIEWS.
 */
public class C_FRAME implements I_C_FRAME {
    private static C_FRAME controllerFrame;

    I_V_FRAME viewFrame;
    I_C_start controllerStart;
    I_C_GENERAL controllerGeneral;
    I_C_PRODUCTCONTENT controllerProductFunction;
    I_C_PRODUCTCONTENT controllerProductData;
    I_C_EFFORT controllerEffort;
    I_C_TAB currentController; //stores current active Controller
    M_PROJECTDATA projectData;  //stores projectData before export TODO: clarify: projectData also stored before pressing the save button?
    M_EXPORT projectData_export;
    M_IMPORT projectData_import;
    String projPath = "";
    String confPath = "";

    private C_FRAME(){}

    /**
     * this method checks if controller was already created
     * if it wasn't it creates a new controller
     * it always returns a reference to the controller
     * @return reference to controller
     */
    public static C_FRAME getInstance () {
        if (C_FRAME.controllerFrame == null) {
            C_FRAME.controllerFrame = new C_FRAME();
        }
        return C_FRAME.controllerFrame;
    }

    /**
     * this method sets the necessary links after instantiation of the controller
     */
    public void setLinks(M_PROJECTDATA projData, I_C_start conStart, String path) {
        //System.out.println("C_FRAME created");
        controllerStart = conStart;
        projectData = projData;
        viewFrame = new V_FRAME(this, projectData);
        projectData_export = new M_EXPORT();
        projectData_import = new M_IMPORT();    //TODO: check if necessary or better when used?
        createTabControllers();
        I_V_BASIC.show(viewFrame.getJFrame());
        currentController = controllerGeneral;
        projPath = path;
        confPath = path.replace(".xml", "_config.xml");
    }
    /*public C_FRAME(M_PROJECTDATA projData, I_C_start conStart, String path) {
        System.out.println("C_FRAME created");
        controllerStart = conStart;
        projectData = projData;
        viewFrame = new V_FRAME(this, projectData);
        projectData_export = new M_EXPORT();
        projectData_import = new M_IMPORT();    //TODO: check if necessary or better when used?
        createTabControllers();
        I_V_BASIC.show(viewFrame.getJFrame());
        currentController = controllerGeneral;
        projPath = path;
        confPath = path.replace(".xml", "_config.xml");
    }*/

    /**
     * creates Controller for each tab
     * method iterates through enum tabs and creates the specific Controller for each
     */
    @Override
    public void createTabControllers(/*I_C_FRAME.tabs tabs*/) {
        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(viewFrame, projectData);
        controllerProductFunction = new C_PRODUCTFUNCTION(viewFrame, projectData);
        controllerProductData = new C_PRODUCTDATA(viewFrame,projectData);
        controllerGeneral = new C_GENERAL(viewFrame, projectData);
        System.out.println("General Controller created");
    }

    /**
     * depending on the int newTab it switches to the specified Tab
     * and runs the necessary functions in the view to show/hide buttons needed/not needed
     *
     * @param newTab integer of the newly selected tab
     */
    @Override
    public void notifyTabChange(int newTab) {
        switch (newTab) {
            case 0:
                viewFrame.hideNext();
                viewFrame.hideLast();
                viewFrame.hideFactorImport();
                viewFrame.hideFactorExport();
                System.out.println("Tab: 0 - General Tab Controller active!");
                currentController = controllerGeneral;
                break;
            case 1:
                viewFrame.hideNext();
                viewFrame.hideLast();
                viewFrame.hideFactorImport();
                viewFrame.hideFactorExport();
                System.out.println("Tab: 1 - Product Data Controller active");
                currentController = controllerProductFunction;
                break;
            case 2:
                viewFrame.hideNext();
                viewFrame.hideLast();
                viewFrame.hideFactorImport();
                viewFrame.hideFactorExport();
                System.out.println("Tab: 2 - Product Data Controller active");
                currentController = controllerProductData;
                break;
            case 3:
                System.out.println("Tab: 3 - Effort Tab Controller active");
                currentController = controllerEffort;
                currentController.updateProjectData(); //reads project data and refreshes view TODO: maybe add updateView() for all Controllers?
                viewFrame.showNext();
                viewFrame.showLast();
                viewFrame.showFactorImport();
                viewFrame.showFactorExport();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + newTab);
        }
    }

    /**
     * should notify C_EFFORT that the tab in V_Effort_Tabs has changed
     */
    @Override
    public void notifyTabChangeEffort() {
        if (currentController == controllerEffort) {
            controllerEffort.updateProjectData();
        }
        //else do nothing
    }

    /**
     * notifies the Controller, that a slider was changed
     *
     * @param sliderNo integer to identify the slider that was changed
     * @param value    integer to which the slider was changed to
     */
    @Override
    public void notifySlider(int sliderNo, int value) {
        if (currentController == controllerEffort) {
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
        String ObjButtons[] = {"Ja", "Nein"};
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
            I_V_BASIC.hide(viewFrame.getJFrame());
            controllerStart.notifyShow();
        } else {
            //Do nothing
        }
    }

    /**
     * notifies the Controller that he should save the project
     * the controller therefore tells the model to save the data
     */
    @Override
    public void notifySave() {  //TODO: clarify: save means export and changes will disappear when not exported/saved, but programm closed?
        try{
            projectData_export.export(projectData, projPath);
        }
        catch(InvalidPathException e){
            JOptionPane.showMessageDialog(null,
                    "Sie müssen einen korrekten Dateipfad angeben",
                    "Achtung",
                    JOptionPane.WARNING_MESSAGE);
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null,
                    "Ein Fehler ist aufgetreten, bitte versuchen Sie es erneut",
                    "Achtung",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * notifies the Controller that he should import new factors
     */
    @Override
    public void notifyImportFactor() {
        System.out.println("Importiere Faktoren !");
        projectData_import.importProject(projectData, confPath);
        controllerEffort.updateProjectData();
    }

    /**
     * notifies the Controller that he should export the factors
     */
    @Override
    public void notifyExportFactor() {
        System.out.println("Exportiere Faktoren !");
        projectData_export.export(projectData.getM_projectData_functionPointEstimation_configData(), confPath);
    }

    /**
     * when notified reload the project data for current view
     */
    @Override
    public void notifyNext() {
        if (currentController == controllerEffort) {
            controllerEffort.notifyNext();
        }
    }

    /**
     * when notified reload the project data for current view
     */
    @Override
    public void notifyLast() {
        if (currentController == controllerEffort) {
            controllerEffort.notifyLast();
        }
    }

    /**
     * this method should automatically update the values for the factors to meet the e2goal
     */
    @Override
    public void notifyAdjustFactors() {
        if (currentController == controllerEffort) {
            System.out.println(controllerEffort.notifyAdjustFactors());
            controllerEffort.updateProjectData();
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
        String ObjButtons[] = {"Ja", "Nein"};
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
    public I_C_TAB getCurrentController() {
        return currentController;
    }

    @Override
    public void notifyProductContentNEW() {
        if(currentController == controllerProductFunction){
            controllerProductFunction.newProductContent();
        }
        else if(currentController == controllerProductData){
            controllerProductData.newProductContent();
        }

    }

    @Override
    public void notifyProductContentDELETE() {
        if(currentController == controllerProductFunction){
            controllerProductFunction.deleteProductContent();
        }
        else if(currentController == controllerProductData){
            controllerProductData.deleteProductContent();
        }
    }

    /**
     * notify Controller that selected List Item has changed
     *
     * @param selectedID
     */
    @Override
    public void notifySelectedListChange(String selectedID) {
        if (currentController == controllerProductFunction) {
            controllerProductFunction.notifySelectionChange(selectedID);
        }
        else if(currentController == controllerProductData){
            controllerProductData.notifySelectionChange(selectedID);
        }
    }
}
