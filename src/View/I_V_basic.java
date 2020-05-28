package View;

public interface I_V_basic {
    /**
     * this method tries to show the view if there exists one
     * it should alsways check if view is available and print error if showing is not possible
     */
    public void show(); //TODO: evtl. hier implementieren, da sonst immer gleiche implementierung -> Redundanz
    /**
     * this method tries to show the view if there exists one
     * it should alsways check if view is available and print error if showing is not possible
     */
    public void hide();
}
