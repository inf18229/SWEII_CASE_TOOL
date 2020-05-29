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

    public C_effort(I_V_frame view, M_projectData projectData){
        viewFrame = view;
        this.projectData = projectData;
    }

    /**
     * this method updates the V_framePanel_effort
     * therefore all current values are set as View attributes
     */
    @Override
    public void updateView() {
        //viewFrame.
        //TODO: add implementation
    }

    @Override
    public void updateProjectData(){

        //TODO: clarify: what should be done in this method?
        //TODO: add implementation
    }
}
