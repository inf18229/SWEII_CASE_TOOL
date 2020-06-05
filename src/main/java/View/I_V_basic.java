package View;

import javax.swing.*;

public interface I_V_basic {
    /**
     * this method returns a reference to the frame Object
     *
     * @return frame
     */
    JFrame getJFrame();

    /**
     * this method tries to show the view if there exists one
     * it should alsways check if view is available and print error if showing is not possible
     */
    static void show(JFrame frame) {
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
     */
    static void hide(JFrame frame) {
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
