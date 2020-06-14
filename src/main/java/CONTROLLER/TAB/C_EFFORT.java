package CONTROLLER.TAB;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTDATA;
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

    /**
     * private Constructor of the C_EFFORT class
     * if the constructor
     */
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
        if (controllerEffort == null) {
            controllerEffort = new C_EFFORT();
        } else {
            System.out.println("C_EFFORT Instance already created");
        }
        return controllerEffort;
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
        for (int i = 0; i <= 14; i++) {
            viewFrame.setEstimationCount(i, projectData.getFunctionPointEstimation().getCount(i));
            viewFrame.setEstimationSum(i, projectData.getFunctionPointEstimation().getSum(i));
            viewFrame.setEstimationWeight(i, projectData.getFunctionPointEstimation().getWeight(i)); //TODO: evtl. nicht jedes mal aufrufen nur am Anfang
        }
        viewFrame.setTotalRowSum(projectData.getFunctionPointEstimation().getE1Sum());
        //initialize slider position and initialize the text fields for each slider
        for (int i = 0; i <= 9; i++) {
            viewFrame.setSliderValue(i, projectData.getFunctionPointEstimation_configData().getFactor(i));
            viewFrame.setSliderText(i, projectData.getFunctionPointEstimation_configData().getFactor(i));
        }
        viewFrame.setFactorSumE2(projectData.getFunctionPointEstimation_configData().getE2Sum(),
                projectData.getFunctionPointEstimation().getE2Correction());
        // update values in tab Calculation
        viewFrame.updateCalculationTab(
                projectData.getFunctionPointEstimation().getE1Sum(),
                projectData.getFunctionPointEstimation_configData().getE2Sum(),
                projectData.getFunctionPointEstimation().getE3Sum(),
                projectData.getFunctionPointEstimation().getAFP(),
                projectData.getFunctionPointEstimation().getJonesDuration(),
                projectData.getFunctionPointEstimation().getJonesPersonNo(),
                projectData.getFunctionPointEstimation().getJonesPersonMonths());
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
        projectData.getFunctionPointEstimation_configData().setFactor(sliderNo, value);
        projectData.getFunctionPointEstimation_configData().calcFactorSumE2();
        viewFrame.setSliderText(sliderNo, value);
        viewFrame.setFactorSumE2(projectData.getFunctionPointEstimation_configData().getE2Sum(),
                projectData.getFunctionPointEstimation().getE2Correction());
    }

    /**
     * this method triggers all necessary functions to recalculate and show the new values
     * garanties that the shown values are up to date
     */
    @Override
    public void notifyCalculate() {
        updateProjectData();    // guaranties that the shown/used values are up to date
        projectData.getFunctionPointEstimation().setActualDuration(viewFrame.getActualDuration());
        projectData.getFunctionPointEstimation().calcCorrection(projectData.getFunctionPointEstimation().getActualDuration());
        projectData.getFunctionPointEstimation().calcE2Needed(projectData.getFunctionPointEstimation().getActualDuration());
        viewFrame.updateCorrectionPanel(
                projectData.getFunctionPointEstimation().getJonesPersonMonths(),
                projectData.getFunctionPointEstimation().getCorrectionFactor(),
                projectData.getFunctionPointEstimation().getE2Correction()
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

        //iterate through all stored product data
        for (M_PROJECTDATA_PRODUCTDATA productData : projectData.getProductDataList()) {
            /**
             * switches on type
             * in type switches on weight
             * according to case adds 1 to the corresponding variable
             */
            switch (productData.functionPointCategory) {
                case "ILF-Interner Datenbestand":
                    switch (productData.functionPointWeighting) {
                        case 0:
                            countDatasetSimple += 1;
                            break;
                        case 1:
                            countDatasetMedium += 1;
                            break;
                        case 2:
                            countDatasetComplex += 1;
                            break;
                        default:
                            break;
                    }
                    break;
                case "ELF-Externer Datenbestand":
                    switch (productData.functionPointWeighting) {
                        case 0:
                            countReferenceSimple += 1;
                            break;
                        case 1:
                            countReferenceMedium += 1;
                            break;
                        case 2:
                            countReferenceComplex += 1;
                            break;
                        default:
                            break;
                    }
                    break;
                default:    //TODO: throw exception?
                    break;
            }
        }

        //store calculated values in project data
        projectData.getFunctionPointEstimation().setCount(0, countInputSimple);
        projectData.getFunctionPointEstimation().setCount(1, countInputMedium);
        projectData.getFunctionPointEstimation().setCount(2, countInputComplex);

        projectData.getFunctionPointEstimation().setCount(3, countQuerySimple);
        projectData.getFunctionPointEstimation().setCount(4, countQueryMedium);
        projectData.getFunctionPointEstimation().setCount(5, countQueryComplex);

        projectData.getFunctionPointEstimation().setCount(6, countOutputSimple);
        projectData.getFunctionPointEstimation().setCount(7, countOutputMedium);
        projectData.getFunctionPointEstimation().setCount(8, countOutputComplex);

        projectData.getFunctionPointEstimation().setCount(9, countDatasetSimple);
        projectData.getFunctionPointEstimation().setCount(10, countDatasetMedium);
        projectData.getFunctionPointEstimation().setCount(11, countDatasetComplex);

        projectData.getFunctionPointEstimation().setCount(12, countReferenceSimple);
        projectData.getFunctionPointEstimation().setCount(13, countReferenceMedium);
        projectData.getFunctionPointEstimation().setCount(14, countReferenceComplex);
    }

    /**
     * this method should automatically update the values for the factors to meet the e2goal
     * it outputs a message to determine if values could be corrected
     *
     * @return string of output which should be printed to console (mainly for development purposes)
     */
    @Override
    public String notifyAdjustFactors() {
        String output;
        int e2Sum = projectData.getFunctionPointEstimation_configData().getE2Sum();
        int e2Correction = projectData.getFunctionPointEstimation().getE2Correction();
        // e2Failure positive if e2Sum > e2Correction
        // e2Failure negative if e2Sum < e2Correction
        int e2Failure = e2Sum - e2Correction;
        // checks if e2Failure can be corrected
        if (e2Failure > 0) {    // e2Sum > e2Correction -> factors should be decreased
            if (e2Sum - e2Failure >= 0) {
                decreaseFactors(Math.abs(e2Failure));
                output = "e2Sum needs to be decreased - Corrected factors";
            } else {
                output = "e2Sum needs to be decreased - Failure can't be corrected by just adjusting factors";
            }
        } else if (e2Failure < 0) { // e2Sum < e2Correction -> factors should be increased
            if (e2Sum + Math.abs(e2Failure) <= 60) {
                increaseFactors(Math.abs(e2Failure));
                output = "e2Sum needs to be increased - Corrected factors";
            } else {
                output = "e2Sum needs to be increased - Failure can't be corrected by just adjusting factors";
            }
        } else {
            output = "No failure to correct";
        }
        return output;
    }

    /**
     * increases Factors by given value
     *
     * @param increase value how much the factors should be increased
     */
    @Override
    public void increaseFactors(int increase) throws IllegalArgumentException, RuntimeException {
        int factorIterator = 0; // Iterator to decide which factor to switch
        int adjustment = -1;    // variable stores how much the selected factor can be adjusted
        if (increase < 0 |
                (projectData.getFunctionPointEstimation_configData().getE2Sum() + increase) > 60) {
            throw new IllegalArgumentException("increase out of bounds");
        } else {
            while (increase > 0) {     // the goal sum is not achieved yet
                if (factorIterator == 0 |                     // factorEntanglement
                        factorIterator == 1 |                 // factorDecentralization
                        factorIterator == 2 |                 // factorTransactionrate
                        factorIterator == 4 |                 // factorProcessingControl
                        factorIterator == 6 |                 // factorProcessingLogic
                        factorIterator == 7 |                 // factorReusability
                        factorIterator == 8 |                 // factorConversion
                        factorIterator == 9) {                // factorCustomizability

                    adjustment = Math.abs(5 - projectData.getFunctionPointEstimation_configData().getFactor(factorIterator));
                    if (adjustment > 0) {
                        projectData.getFunctionPointEstimation_configData().setFactor(factorIterator,
                                projectData.getFunctionPointEstimation_configData().getFactor(factorIterator) + 1);
                        increase--;
                    } else {
                        factorIterator++;
                    }
                } else if (factorIterator == 3 |              // factorProcessingCalculation
                        factorIterator == 5) {                // factorProcessingException

                    adjustment = Math.abs(10 - projectData.getFunctionPointEstimation_configData().getFactor(factorIterator));
                    if (adjustment > 0) {
                        projectData.getFunctionPointEstimation_configData().setFactor(factorIterator,
                                projectData.getFunctionPointEstimation_configData().getFactor(factorIterator) + 1);
                        increase--;
                    } else {
                        factorIterator++;
                    }
                } else {
                    throw new RuntimeException("factorIterator out of bounds");
                }
            }
        }
        projectData.getFunctionPointEstimation_configData().calcFactorSumE2();
    }

    /**
     * decreases Factors by given value
     *
     * @param decrease value how much the factors should be decreased
     */
    @Override
    public void decreaseFactors(int decrease) throws IllegalArgumentException, RuntimeException {
        int factorIterator = 0; // Iterator to decide which factor to switch
        int adjustment = -1;    // variable stores how much the selected factor can be adjusted
        if (decrease < 0
                | (projectData.getFunctionPointEstimation_configData().getE2Sum() - decrease) < 0) {   //TODO: if called with decrease=5, but all factors=0 function never stops
            throw new IllegalArgumentException("decrease out of bounds");
        } else {
            while (decrease > 0) { // the goal sum is not achieved yet
                if (factorIterator == 0 |                     // factorEntanglement
                        factorIterator == 1 |                 // factorDecentralization
                        factorIterator == 2 |                 // factorTransactionrate
                        factorIterator == 3 |              // factorProcessingCalculation
                        factorIterator == 4 |                 // factorProcessingControl
                        factorIterator == 5 |                // factorProcessingException
                        factorIterator == 6 |                 // factorProcessingLogic
                        factorIterator == 7 |                 // factorReusability
                        factorIterator == 8 |                 // factorConversion
                        factorIterator == 9) {                // factorCustomizability
                    adjustment = Math.abs(0 - projectData.getFunctionPointEstimation_configData().getFactor(factorIterator));
                    if (adjustment > 0) {
                        projectData.getFunctionPointEstimation_configData().setFactor(factorIterator, projectData.getFunctionPointEstimation_configData().getFactor(factorIterator) - 1);
                        decrease--;
                    } else {
                        factorIterator++;
                    }
                } else {
                    throw new RuntimeException("factorIterator out of bounds");
                }
            }
            projectData.getFunctionPointEstimation_configData().calcFactorSumE2();
        }
    }

    @Override
    public void updateProjectData() {
        //TODO: get Data from Model
        calculateCounts();
        projectData.getFunctionPointEstimation().calculateAllRowSums();
        projectData.getFunctionPointEstimation().calculateTotalRowSumE1();
        projectData.getFunctionPointEstimation_configData().calcFactorSumE2();
        projectData.getFunctionPointEstimation().calcInfluenceE3();
        projectData.getFunctionPointEstimation().calcAdjustedFunctionPoints();
        projectData.getFunctionPointEstimation().calcJonesEstimation();
        updateView();
    }
}
