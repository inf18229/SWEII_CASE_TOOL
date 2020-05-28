package Controller;

import View.I_V_frame;

public class C_effort implements I_C_effort{
    I_V_frame viewFrame;

    public C_effort(I_V_frame view){
        viewFrame = view;

    }

    /**
     * this method updates the V_framePanel_effort
     * therefore all current values ae set as View attributes
     */
    @Override
    public void updateView() {

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
