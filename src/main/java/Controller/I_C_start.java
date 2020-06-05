package Controller;

/**
 * I_C_Start is responsible for all actions in the start View I_V_start
 */
public interface I_C_start {
    /**
     * the notifyCreate method has to be implemented to be run by the view
     * it should run any functions necessary when creating a new project
     */
    void notifyCreate();

    /**
     * the notifyOpen method has to be implemented to be run by the view
     * it should run any functions necessary when opening a new project
     */
    void notifyOpen();

    /**
     * this method shows the viewStart and tells the Start Controller, that he is in charge now
     */
    void notifyShow();
}
