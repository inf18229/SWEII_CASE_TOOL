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

    }

    @Override
    public void updateProjectData(){
        //TODO: clarify: what should be done in this method?
        //TODO: add implementation
        updateView();
    }
}
