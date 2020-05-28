package Controller;

public interface I_C_effort {

    /**
     * this method updates the V_framePanel_effort
     * therefore all current values ae set as View attributes
     */
    void updateView();

    /**
     * method to simply print the string output as text to console
     * @param output
     */
    void debugPrint(String output);
}
