package Controller.tab;

import Model.projectData.M_projectData;
import Model.projectData.M_projectData_productFunction;
import View.I_V_frame;

/**
 * is the implementation of I_C_effort
 * this Controller has to manage all action regarding the "Aufwandsschätzung" tab
 */
public class C_effort implements I_C_effort{

    I_V_frame viewFrame;    //  stores a reference to the viewFrame to update elements of it
    M_projectData projectData;      // stores a reference to the complete data modell

    public C_effort(I_V_frame view, M_projectData projData){
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
        //TODO: initialize slider position
        /*viewFrame.setSliderValues(
                projectData.getM_projectData_functionPointEstimation().getFactor(1),
                projectData.getM_projectData_functionPointEstimation().getFactor(2),
                projectData.getM_projectData_functionPointEstimation().getFactor(3),
                projectData.getM_projectData_functionPointEstimation().getFactor(41),
                projectData.getM_projectData_functionPointEstimation().getFactor(42),
                projectData.getM_projectData_functionPointEstimation().getFactor(43),
                projectData.getM_projectData_functionPointEstimation().getFactor(44),
                projectData.getM_projectData_functionPointEstimation().getFactor(5),
                projectData.getM_projectData_functionPointEstimation().getFactor(6),
                projectData.getM_projectData_functionPointEstimation().getFactor(7));*/
        // use the setSliderText Function to initialize the text fields for each slider
        viewFrame.setSliderText(1, projectData.getM_projectData_functionPointEstimation().getFactor(1));
        viewFrame.setSliderText(2, projectData.getM_projectData_functionPointEstimation().getFactor(2));
        viewFrame.setSliderText(3, projectData.getM_projectData_functionPointEstimation().getFactor(3));
        viewFrame.setSliderText(41, projectData.getM_projectData_functionPointEstimation().getFactor(41));
        viewFrame.setSliderText(42, projectData.getM_projectData_functionPointEstimation().getFactor(42));
        viewFrame.setSliderText(43, projectData.getM_projectData_functionPointEstimation().getFactor(43));
        viewFrame.setSliderText(44, projectData.getM_projectData_functionPointEstimation().getFactor(44));
        viewFrame.setSliderText(5, projectData.getM_projectData_functionPointEstimation().getFactor(5));
        viewFrame.setSliderText(6, projectData.getM_projectData_functionPointEstimation().getFactor(6));
        viewFrame.setSliderText(7, projectData.getM_projectData_functionPointEstimation().getFactor(7));
        viewFrame.setFactorSumE2(projectData.getM_projectData_functionPointEstimation().e2Sum);
        // update values in tab Calculation
        viewFrame.updateCalculationTab(
                projectData.getM_projectData_functionPointEstimation().e1Sum,
                projectData.getM_projectData_functionPointEstimation().e2Sum,
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
        viewFrame.nextStepEffort();
    }

    /**
     * notifies the Controller that he should reload the project data for current view
     */
    @Override
    public void notifyLast() {
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
        //System.out.println("Slider " + String.valueOf(sliderNo) + " was changed to Value " + String.valueOf(value));  //just for debugging
        projectData.getM_projectData_functionPointEstimation().setFactor(sliderNo, value);
        viewFrame.setSliderText(sliderNo, value);
    }

    /**
     * this method triggers all necessary functions to recalculate and show the new values
     * garanties that the shown values are up to date
     */
    @Override
    public void notifyCalculate() {
        updateProjectData();    // guaranties that the shown/used values are up to date
        projectData.getM_projectData_functionPointEstimation().calcCorrection(viewFrame.getRealTime());
        viewFrame.updateCorrectionPanel(
                projectData.getM_projectData_functionPointEstimation().jonesPersonMonths,
                projectData.getM_projectData_functionPointEstimation().correctionFactor
        );
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
        for (M_projectData_productFunction productFunction : projectData.getProductFunctionList()){
            /**
             * switches on type
             * in type switches on weight
             * according to case adds 1 to the corresponding variable
             */
            switch  (productFunction.functionPointCategory) {
                case "EI-Eingabe":
                    switch (productFunction.functionPointWeighting){
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
                case "EQ-Abrage":
                    switch (productFunction.functionPointWeighting){
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
                    switch (productFunction.functionPointWeighting){
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

    @Override
    public void updateProjectData(){
        //TODO: get Data from Model
        calculateCounts();
        projectData.getM_projectData_functionPointEstimation().calculateAllRowSums();
        projectData.getM_projectData_functionPointEstimation().calculateTotalRowSumE1();
        projectData.getM_projectData_functionPointEstimation().calcFactorSumE2();
        projectData.getM_projectData_functionPointEstimation().calcInfluenceE3();
        projectData.getM_projectData_functionPointEstimation().calcAdjustedFunctionPoints();
        projectData.getM_projectData_functionPointEstimation().calcJonesEstimation();
        updateView();
    }
}
