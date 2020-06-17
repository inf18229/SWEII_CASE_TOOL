package CONTROLLER;

/**
 * I_C_Start is responsible for all actions in the start View I_V_START
 */
public interface I_C_START {

    /**
     * the notifyCreate method has to be implemented to be run by the view
     * it should run any functions necessary when creating a new project
     */
    public void notifyCreate();

    /**
     * the notifyOpen method has to be implemented to be run by the view
     * it should run any functions necessary when opening a new project
     */
    public void notifyOpen();

    /**
     * shows the viewStart and tells the Start Controller, that he is in charge now
     */
    public void notifyShow();
}
