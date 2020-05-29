package Controller;

import Model.M_projectData;
import View.I_V_frame;

/**
 * is the implementation of I_C_effort
 * this Controller has to manage all action regarding the "Aufwandsschätzung" tab
 */
public class C_effort implements I_C_effort{

    I_V_frame viewFrame;    //stores a reference to the viewFrame to update elements of it
    M_projectData projectData;      // stores a reference to the complete data modell

    public C_effort(I_V_frame view, M_projectData projData){
        viewFrame = view;
        projectData = projData;
        updateProjectData();
    }

    /**
     * this method updates the V_framePanel_effort
     * therefore all current values are set as View attributes
     */
    @Override
    public void updateView() {
        System.out.println("Effort - updateView was called");
        //TODO: add implementation
        //projectData.getM_projectData_functionPointEstimation().countInputSimple = 0;
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

    }

    @Override
    public void updateProjectData(){
        //TODO: clarify: what should be done in this method?
        //TODO: add implementation
        updateView();
    }
}
