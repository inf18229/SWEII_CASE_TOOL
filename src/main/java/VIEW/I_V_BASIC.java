package VIEW;

import javax.swing.*;

/**
 * Basic Interface defines all basic methods that are required from a frame
 */
public interface I_V_BASIC {
    /**
     * this method returns a reference to the frame Object
     *
     * @return frame
     */
    public JFrame getJFrame();

    /**
     * this method tries to show the view if there exists one
     * it should alsways check if view is available and print error if showing is not possible
     *
     * @param frame reference to the JFrame which should be shown
     */
    public static void show(JFrame frame) {
        try {
            frame.setVisible(true);
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null,
                    "Das Fenster kann nicht geöffnet werden.\n Starten Sie das Programm bitte erneut.\n" + exc.getMessage(),
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * this method tries to hide the view if there exists one
     * it should alsways check if view is available and print error if showing is not possible
     *
     * @param frame reference to the JFrame which should be hidden
     */
    public static void hide(JFrame frame) {
        try {
            frame.setVisible(false);
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null,
                    "Das Fenster kann nicht geschlossen werden.\n Starten Sie das Programm bitte erneut.\n" + exc.getMessage(),
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
