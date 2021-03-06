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

    private I_V_FRAME viewFrame;
    private I_C_START controllerStart;
    private I_C_GENERAL controllerGeneral;
    private I_C_PRODUCTCONTENT controllerProductFunction;
    private I_C_PRODUCTCONTENT controllerProductData;
    private I_C_EFFORT controllerEffort;
    private I_C_TAB currentController; //stores current active Controller
    private M_PROJECTDATA projectData;  //stores projectData before export
    private M_EXPORT projectData_export;
    private M_IMPORT projectData_import;
    private String projPath = "";
    private String confPath = "";

    /**
     * Singlton consturctor of C_FRAME
     */
    private C_FRAME() {
    }

    /**
     * checks if controller was already created
     * if it wasn't it creates a new controller
     * it always returns a reference to the controller
     *
     * @return reference to controller
     */
    public static C_FRAME getInstance() {
        if (C_FRAME.controllerFrame == null) {
            C_FRAME.controllerFrame = new C_FRAME();
        }
        return C_FRAME.controllerFrame;
    }

    /**
     * sets the necessary links after instantiation of the controller
     */
    public void setLinks(M_PROJECTDATA projData, I_C_START conStart, String path) {
        controllerStart = conStart;
        projectData = projData;
        viewFrame = new V_FRAME(this, projectData);
        projectData_export = new M_EXPORT();
        projectData_import = new M_IMPORT();
        createTabControllers();
        I_V_BASIC.show(viewFrame.getJFrame());
        currentController = controllerGeneral;
        projPath = path;
        confPath = path.replace(".xml", "_config.xml");
    }


    /**
     * creates Controller for each tab
     * method iterates through enum tabs and creates the specific Controller for each
     */
    @Override
    public void createTabControllers(/*I_C_FRAME.tabs tabs*/) {
        controllerEffort = C_TABCONTROLLERFACTORY.createController(viewFrame, projectData, "EFFORT");
        controllerProductFunction = C_TABCONTROLLERFACTORY.createController(viewFrame, projectData, "PRODUCTFUNCTION");
        controllerProductData = C_TABCONTROLLERFACTORY.createController(viewFrame, projectData, "PRODUCTDATA");
        controllerGeneral = C_TABCONTROLLERFACTORY.createController(viewFrame, projectData, "GENERAL");
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
                currentController.updateProjectData(); //reads project data and refreshes view
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
     * the export class handles the export to a xml file
     * changes will disappear when not exported/saved, but program closed
     */
    @Override
    public void notifySave() {
        try {
            projectData_export.export(projectData, projPath);
        } catch (InvalidPathException e) {
            JOptionPane.showMessageDialog(null,
                    "Sie müssen einen korrekten Dateipfad angeben",
                    "Achtung",
                    JOptionPane.WARNING_MESSAGE);
        } catch (NullPointerException e) {
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
        try {
            projectData_import.importProject(projectData, confPath);
            controllerEffort.updateProjectData();
        } catch (InvalidPathException e) {
            JOptionPane.showMessageDialog(null,
                    "XML Faktoren Konfigurations Datei existiert nicht.\nBitte Konfigurationsdatei in Projektordner ablegen.\n('Projektname'_config.xml)",
                    "Achtung",
                    JOptionPane.WARNING_MESSAGE);
        }

    }

    /**
     * notifies the Controller that he should export the factors
     */
    @Override
    public void notifyExportFactor() {
        projectData_export.export(projectData.getFunctionPointEstimation_configData(), confPath);
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
     * automatically updates the values for the factors to meet the e2goal
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
     * if prompt allowed - close program
     * else - do nothing
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

    /**
     * returns active Tab Controller
     *
     * @return returns a I_C_TAB Object
     */
    @Override
    public I_C_TAB getCurrentController() {
        return currentController;
    }

    /**
     * notifies the current Tab Controller that New Button is pressed
     */
    @Override
    public void notifyProductContentNEW() {
        if (currentController == controllerProductFunction) {
            controllerProductFunction.newProductContent();
        } else if (currentController == controllerProductData) {
            controllerProductData.newProductContent();
        }

    }

    /**
     * notifies the current Tab Controller that Delete Button is pressed
     */
    @Override
    public void notifyProductContentDELETE() {
        if (currentController == controllerProductFunction) {
            controllerProductFunction.deleteProductContent();
        } else if (currentController == controllerProductData) {
            controllerProductData.deleteProductContent();
        }
    }

    /**
     * notify Controller that selected List Item has changed
     *
     * @param selectedID ID that is selected in JList Element
     */
    @Override
    public void notifySelectedListChange(String selectedID) {
        if (currentController == controllerProductFunction) {
            controllerProductFunction.notifySelectionChange(selectedID);
        } else if (currentController == controllerProductData) {
            controllerProductData.notifySelectionChange(selectedID);
        }
    }
}
