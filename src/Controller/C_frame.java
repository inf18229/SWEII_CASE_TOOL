//======================================================================================================================
//  C_frame
//
//  C_frame is the implementation of I_C_frame
//======================================================================================================================

package Controller;

import View.I_V_frame;
import View.V_frame;

public class C_frame implements I_C_frame{
    I_V_frame viewFrame;

    public enum tabs{
        Tab1, Tab2, Tab3, Aufwand
    }

    public C_frame(){
        debugPrint("C_frame created");
        viewFrame = new V_frame(this);
        createControllers();
        viewFrame.show();
    }

    /**
     * creates Controller for each tab
     * method iterates through enum tabs and creates the specific Controller for each
     */
    @Override
    public void createControllers(/*I_C_frame.tabs tabs*/) {
        //controllerEffort = new C_effort();
    }

    /**
     * switches to the specified Tab
     *
     * @param tab
     */
    @Override
    public void switchToTab(I_C_frame.tabs tab) {

    }

    /**
     * method to simply print the string output as text to console
     *
     * @param output
     */
    @Override
    public void debugPrint(String output) {
        System.out.println(output);
    }
}
