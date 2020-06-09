package CONTROLLER.TAB;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTFUNCTION;
import VIEW.I_V_FRAME;

/**
 * is the implementation of I_C_EFFORT
 * this Controller has to manage all action regarding the "Aufwandsschätzung" tab
 */
public class C_EFFORT implements I_C_EFFORT {
    private static C_EFFORT controllerEffort;

    private I_V_FRAME viewFrame;    //  stores a reference to the viewFrame to update elements of it
    private M_PROJECTDATA projectData;      // stores a reference to the complete data modell

    private C_EFFORT() {
    }

    /**
     * this method checks if controllerEffort was already created
     * if it wasn't it creates a new controllerEffort
     * it always returns a reference to the controllerEffort
     *
     * @return C_EFFORT.controllerEffort - reference to controllerEffort
     */
    public static C_EFFORT getInstance() {
        if (C_EFFORT.controllerEffort == null) {
            C_EFFORT.controllerEffort = new C_EFFORT();
        }
        return C_EFFORT.controllerEffort;
    }

    /**
     * this method sets the necessary links after instantiation of the controller
     */
    public void setLinks(I_V_FRAME view, M_PROJECTDATA projData) {
        viewFrame = view;
        projectData = projData;
    }

    /**
     * this method updates the V_framePanel_effort
     * therefore all current values are set as View attributes
     */
    @Override
    public void updateView() {
        //TODO: evtl. aufteilen je gewähltem Tab
        System.out.println("Effort - updateView was called");
        viewFrame.setEstimationCount(
                projectData.getM_projectData_functionPointEstimation().countInputSimple,
                projectData.getM_projectData_functionPointEstimation().countInputMedium,
                projectData.getM_projectData_functionPointEstimation().countInputComplex,
                projectData.getM_projectData_functionPointEstimation().countQuerySimple,
                projectData.getM_projectData_functionPointEstimation().countQueryMedium,
                projectData.getM_projectData_functionPointEstimation().countQueryComplex,
                projectData.getM_projectData_functionPointEstimation().countOutputSimple,
                projectData.getM_projectData_functionPointEstimation().countOutputMedium,
                projectData.getM_projectData_functionPointEstimation().countOutputComplex,
                projectData.getM_projectData_functionPointEstimation().countDatasetSimple,
                projectData.getM_projectData_functionPointEstimation().countDatasetMedium,
                projectData.getM_projectData_functionPointEstimation().countDatasetComplex,
                projectData.getM_projectData_functionPointEstimation().countReferenceSimple,
                projectData.getM_projectData_functionPointEstimation().countReferenceMedium,
                projectData.getM_projectData_functionPointEstimation().countReferenceComplex);
        viewFrame.setEstimationWeight(
                projectData.getM_projectData_functionPointEstimation().weightInputSimple,
                projectData.getM_projectData_functionPointEstimation().weightInputMedium,
                projectData.getM_projectData_functionPointEstimation().weightInputComplex,
                projectData.getM_projectData_functionPointEstimation().weightQuerySimple,
                projectData.getM_projectData_functionPointEstimation().weightQueryMedium,
                projectData.getM_projectData_functionPointEstimation().weightQueryComplex,
                projectData.getM_projectData_functionPointEstimation().weightOutputSimple,
                projectData.getM_projectData_functionPointEstimation().weightOutputMedium,
                projectData.getM_projectData_functionPointEstimation().weightOutputComplex,
                projectData.getM_projectData_functionPointEstimation().weightDatasetSimple,
                projectData.getM_projectData_functionPointEstimation().weightDatasetMedium,
                projectData.getM_projectData_functionPointEstimation().weightDatasetComplex,
                projectData.getM_projectData_functionPointEstimation().weightReferenceSimple,
                projectData.getM_projectData_functionPointEstimation().weightReferenceMedium,
                projectData.getM_projectData_functionPointEstimation().weightReferenceComplex);
        viewFrame.setEstimationSum(
                projectData.getM_projectData_functionPointEstimation().sumInputSimple,
                projectData.getM_projectData_functionPointEstimation().sumInputMedium,
                projectData.getM_projectData_functionPointEstimation().sumInputComplex,
                projectData.getM_projectData_functionPointEstimation().sumQuerySimple,
                projectData.getM_projectData_functionPointEstimation().sumQueryMedium,
                projectData.getM_projectData_functionPointEstimation().sumQueryComplex,
                projectData.getM_projectData_functionPointEstimation().sumOutputSimple,
                projectData.getM_projectData_functionPointEstimation().sumOutputMedium,
                projectData.getM_projectData_functionPointEstimation().sumOutputComplex,
                projectData.getM_projectData_functionPointEstimation().sumDatasetSimple,
                projectData.getM_projectData_functionPointEstimation().sumDatasetMedium,
                projectData.getM_projectData_functionPointEstimation().sumDatasetComplex,
                projectData.getM_projectData_functionPointEstimation().sumReferenceSimple,
                projectData.getM_projectData_functionPointEstimation().sumReferenceMedium,
                projectData.getM_projectData_functionPointEstimation().sumReferenceComplex);
        viewFrame.setTotalRowSum(projectData.getM_projectData_functionPointEstimation().e1Sum);
        //initialize slider position and initialize the text fields for each slider
        for (int i = 0; i <= 9; i++) {
            viewFrame.setSliderValue(i, projectData.getM_projectData_functionPointEstimation_configData().getFactor(i));
            viewFrame.setSliderText(i, projectData.getM_projectData_functionPointEstimation_configData().getFactor(i));
        }
        viewFrame.setFactorSumE2(projectData.getM_projectData_functionPointEstimation_configData().e2Sum,
                projectData.getM_projectData_functionPointEstimation().e2Correction);
        // update values in tab Calculation
        viewFrame.updateCalculationTab(
                projectData.getM_projectData_functionPointEstimation().e1Sum,
                projectData.getM_projectData_functionPointEstimation_configData().e2Sum,
                projectData.getM_projectData_functionPointEstimation().e3Sum,
                projectData.getM_projectData_functionPointEstimation().afp,
                projectData.getM_projectData_functionPointEstimation().jonesDuration,
                projectData.getM_projectData_functionPointEstimation().jonesPersonNo,
                projectData.getM_projectData_functionPointEstimation().jonesPersonMonths);
    }

    /**
     * notifies the controller, that the next Button was pressed
     */
    @Override
    public void notifyNext() {
        updateProjectData();
        viewFrame.nextStepEffort();
    }

    /**
     * notifies the Controller that he should reload the project data for current view
     */
    @Override
    public void notifyLast() {
        updateProjectData();
        viewFrame.lastStepEffort();
    }

    /**
     * notifies the Controller, that a slider was changed
     *
     * @param sliderNo integer to identify the slider that was changed
     * @param value    integer to which the slider was changed to
     */
    @Override
    public void notifySlider(int sliderNo, int value) {
        projectData.getM_projectData_functionPointEstimation_configData().setFactor(sliderNo, value);
        projectData.getM_projectData_functionPointEstimation_configData().calcFactorSumE2();
        viewFrame.setSliderText(sliderNo, value);
        viewFrame.setFactorSumE2(projectData.getM_projectData_functionPointEstimation_configData().e2Sum,
                projectData.getM_projectData_functionPointEstimation().e2Correction);
    }

    /**
     * this method triggers all necessary functions to recalculate and show the new values
     * garanties that the shown values are up to date
     */
    @Override
    public void notifyCalculate() {
        updateProjectData();    // guaranties that the shown/used values are up to date
        projectData.getM_projectData_functionPointEstimation().calcCorrection(viewFrame.getRealTime());
        projectData.getM_projectData_functionPointEstimation().calcE2Needed(viewFrame.getRealTime());
        viewFrame.updateCorrectionPanel(
                projectData.getM_projectData_functionPointEstimation().jonesPersonMonths,
                projectData.getM_projectData_functionPointEstimation().correctionFactor,
                projectData.getM_projectData_functionPointEstimation().e2Correction
        );
        updateView();

    }

    /**
     * method iterates through all product functions,
     * adds up the number of elements
     * and saves the calculated value in the corresponding count variable
     */
    @Override
    public void calculateCounts() {
        int countInputSimple = 0;
        int countInputMedium = 0;
        int countInputComplex = 0;

        int countQuerySimple = 0;
        int countQueryMedium = 0;
        int countQueryComplex = 0;

        int countOutputSimple = 0;
        int countOutputMedium = 0;
        int countOutputComplex = 0;

        int countDatasetSimple = 0;
        int countDatasetMedium = 0;
        int countDatasetComplex = 0;

        int countReferenceSimple = 0;
        int countReferenceMedium = 0;
        int countReferenceComplex = 0;

        //iterate through all stored product functions
        for (M_PROJECTDATA_PRODUCTFUNCTION productFunction : projectData.getProductFunctionList()) {
            /**
             * switches on type
             * in type switches on weight
             * according to case adds 1 to the corresponding variable
             */
            switch (productFunction.functionPointCategory) {
                case "EI-Eingabe":
                    switch (productFunction.functionPointWeighting) {
                        case 0:
                            countInputSimple += 1;
                            break;
                        case 1:
                            countInputMedium += 1;
                            break;
                        case 2:
                            countInputComplex += 1;
                            break;
                        default:
                            break;
                    }
                    break;
                case "EQ-Abfrage":
                    switch (productFunction.functionPointWeighting) {
                        case 0:
                            countQuerySimple += 1;
                            break;
                        case 1:
                            countQueryMedium += 1;
                            break;
                        case 2:
                            countQueryComplex += 1;
                            break;
                        default:
                            break;
                    }
                    break;
                case "EO-Ausgabe":
                    switch (productFunction.functionPointWeighting) {
                        case 0:
                            countOutputSimple += 1;
                            break;
                        case 1:
                            countOutputMedium += 1;
                            break;
                        case 2:
                            countOutputComplex += 1;
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        //store calculated values in project data
        projectData.getM_projectData_functionPointEstimation().setCountVariable(10, countInputSimple);
        projectData.getM_projectData_functionPointEstimation().setCountVariable(11, countInputMedium);
        projectData.getM_projectData_functionPointEstimation().setCountVariable(12, countInputComplex);

        projectData.getM_projectData_functionPointEstimation().setCountVariable(20, countQuerySimple);
        projectData.getM_projectData_functionPointEstimation().setCountVariable(21, countQueryMedium);
        projectData.getM_projectData_functionPointEstimation().setCountVariable(22, countQueryComplex);

        projectData.getM_projectData_functionPointEstimation().setCountVariable(30, countOutputSimple);
        projectData.getM_projectData_functionPointEstimation().setCountVariable(31, countOutputMedium);
        projectData.getM_projectData_functionPointEstimation().setCountVariable(32, countOutputComplex);

        projectData.getM_projectData_functionPointEstimation().setCountVariable(40, countDatasetSimple);
        projectData.getM_projectData_functionPointEstimation().setCountVariable(41, countDatasetMedium);
        projectData.getM_projectData_functionPointEstimation().setCountVariable(42, countDatasetComplex);

        projectData.getM_projectData_functionPointEstimation().setCountVariable(50, countReferenceSimple);
        projectData.getM_projectData_functionPointEstimation().setCountVariable(51, countReferenceMedium);
        projectData.getM_projectData_functionPointEstimation().setCountVariable(52, countReferenceComplex);
    }

    /**
     * this method should automatically update the values for the factors to meet the e2goal
     */
    @Override
    public void notifyAdjustFactors() {
        System.out.println("Automatische Anpassung gedrückt");
        int e2Sum = projectData.getM_projectData_functionPointEstimation_configData().e2Sum;
        int e2Goal = projectData.getM_projectData_functionPointEstimation().e2Correction;
        // e2Failure positive if e2Sum > e2Goal
        // e2Failure negative if e2Sum < e2Goal
        int e2Failure = e2Sum - e2Goal;
        // checks if e2Failure can be corrected
        if (e2Failure > 0) {    // e2Sum > e2Goal -> factors should be decreased
            System.out.println("e2Sum needs to be decreased");
            if (e2Sum - e2Failure >= 0) {
                System.out.println("Correcting Factors");
                decreaseFactors(Math.abs(e2Failure));
            } else {
                System.out.println("Failure can't be corrected by adjusting factors.");
            }
        } else if (e2Failure < 0) { // e2Sum < e2Goal -> factors should be increased
            System.out.println("e2Sum needs to be increased");
            if (e2Sum + Math.abs(e2Failure) <= 60) {
                System.out.println("Correcting Factors");
                increaseFactors(Math.abs(e2Failure));
            } else {
                System.out.println("Failure can't be corrected by adjusting factors.");
            }
        } else {
            System.out.println("no failure to correct");
        }
    }

    /**
     * increases Factors by given value
     *
     * @param increase value how much the factors should be increased
     */
    @Override
    public void increaseFactors(int increase) {
        int factorIterator = 0; // Iterator to decide which factor to switch
        int adjustment = -1;    // variable stores how much the selected factor can be adjusted
        while (increase > 0) {     // the goal sum is not achieved yet
            switch (factorIterator) {
                case 0: // factorEntanglement
                    adjustment = Math.abs(5 - projectData.getM_projectData_functionPointEstimation_configData().factorEntanglement);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorEntanglement++;
                        increase--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 1: // factorDecentralization
                    adjustment = Math.abs(5 - projectData.getM_projectData_functionPointEstimation_configData().factorDecentralization);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorDecentralization++;
                        increase--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 2: // factorTransactionrate
                    adjustment = Math.abs(5 - projectData.getM_projectData_functionPointEstimation_configData().factorTransactionrate);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorTransactionrate++;
                        increase--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 3: // factorProcessingCalculation
                    adjustment = Math.abs(10 - projectData.getM_projectData_functionPointEstimation_configData().factorProcessingCalculation);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorProcessingCalculation++;
                        increase--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 4: // // factorProcessingControl
                    adjustment = Math.abs(5 - projectData.getM_projectData_functionPointEstimation_configData().factorProcessingControl);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorProcessingControl++;
                        increase--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 5: // factorProcessingException
                    adjustment = Math.abs(10 - projectData.getM_projectData_functionPointEstimation_configData().factorProcessingException);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorProcessingException++;
                        increase--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 6: // factorProcessingLogic
                    adjustment = Math.abs(5 - projectData.getM_projectData_functionPointEstimation_configData().factorProcessingLogic);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorProcessingLogic++;
                        increase--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 7: // factorReusability
                    adjustment = Math.abs(5 - projectData.getM_projectData_functionPointEstimation_configData().factorReusability);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorReusability++;
                        increase--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 8: // factorConversion
                    adjustment = Math.abs(5 - projectData.getM_projectData_functionPointEstimation_configData().factorConversion);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorConversion++;
                        increase--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 9: // factorCustomizability
                    adjustment = Math.abs(5 - projectData.getM_projectData_functionPointEstimation_configData().factorCustomizability);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorCustomizability++;
                        increase--;
                    } else {
                        factorIterator++;
                    }
                    break;
                default:
                    break;
            }
        }
        updateProjectData();
    }

    /**
     * decreases Factors by given value
     *
     * @param decrease value how much the factors should be decreased
     */
    @Override
    public void decreaseFactors(int decrease) {
        int factorIterator = 0; // Iterator to decide which factor to switch
        int adjustment = -1;    // variable stores how much the selected factor can be adjusted
        while (decrease > 0) { // the goal sum is not achieved yet
            switch (factorIterator) {
                case 0:  // factorEntanglement
                    adjustment = Math.abs(0 - projectData.getM_projectData_functionPointEstimation_configData().factorEntanglement);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorEntanglement--;
                        decrease--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 1: // factorDecentralization
                    adjustment = Math.abs(0 - projectData.getM_projectData_functionPointEstimation_configData().factorDecentralization);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorDecentralization--;
                        decrease--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 2: // factorTransactionrate
                    adjustment = Math.abs(0 - projectData.getM_projectData_functionPointEstimation_configData().factorTransactionrate);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorTransactionrate--;
                        decrease--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 3: // factorProcessingCalculation
                    adjustment = Math.abs(0 - projectData.getM_projectData_functionPointEstimation_configData().factorProcessingCalculation);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorProcessingCalculation--;
                        decrease--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 4: // factorProcessingControl
                    adjustment = Math.abs(0 - projectData.getM_projectData_functionPointEstimation_configData().factorProcessingControl);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorProcessingControl--;
                        decrease--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 5: // factorProcessingException
                    adjustment = Math.abs(0 - projectData.getM_projectData_functionPointEstimation_configData().factorProcessingException);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorProcessingException--;
                        decrease--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 6: // factorProcessingLogic
                    adjustment = Math.abs(0 - projectData.getM_projectData_functionPointEstimation_configData().factorProcessingLogic);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorProcessingLogic--;
                        decrease--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 7: // factorReusability
                    adjustment = Math.abs(0 - projectData.getM_projectData_functionPointEstimation_configData().factorReusability);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorReusability--;
                        decrease--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 8: // factorConversion
                    adjustment = Math.abs(0 - projectData.getM_projectData_functionPointEstimation_configData().factorConversion);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorConversion--;
                        decrease--;
                    } else {
                        factorIterator++;
                    }
                    break;
                case 9: // factorCustomizability
                    adjustment = Math.abs(0 - projectData.getM_projectData_functionPointEstimation_configData().factorCustomizability);
                    if (adjustment > 0) {
                        projectData.getM_projectData_functionPointEstimation_configData().factorCustomizability--;
                        decrease--;
                    } else {
                        factorIterator++;
                    }
                    break;
                default:
                    //updateProjectData();
                    break;
            }
        }
        updateProjectData();
    }

    @Override
    public void updateProjectData() {
        //TODO: get Data from Model
        calculateCounts();
        projectData.getM_projectData_functionPointEstimation().calculateAllRowSums();
        projectData.getM_projectData_functionPointEstimation().calculateTotalRowSumE1();
        projectData.getM_projectData_functionPointEstimation_configData().calcFactorSumE2();
        projectData.getM_projectData_functionPointEstimation().calcInfluenceE3();
        projectData.getM_projectData_functionPointEstimation().calcAdjustedFunctionPoints();
        projectData.getM_projectData_functionPointEstimation().calcJonesEstimation();
        updateView();
    }
}
