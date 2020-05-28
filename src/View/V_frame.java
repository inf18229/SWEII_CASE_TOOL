package View;

import Controller.I_C_frame;

import javax.swing.*;
import java.awt.*;

public class V_frame implements I_V_frame {
    JFrame frame;
    private JPanel V_framePanel;
    private JTabbedPane tabbedPane;
    private JPanel V_General;
    private JPanel V_FuncReq;
    private JPanel V_NonFuncReq;
    private JPanel V_Effort;

    /**
     * Constructor of the V_frame class
     * @param conFrame
     */
    public V_frame(I_C_frame conFrame) {
        frame = new JFrame("SWE CASE TOOL");
        frame.setContentPane(this.V_framePanel);
        frame.setResizable(false);
        frame.getContentPane().setPreferredSize(new Dimension(1000, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //pack method sizes the frame so that all its contents are at or above their preferred size (form)
        frame.setLocationRelativeTo(null);  //places the window in the center of the screen
        frame.setVisible(true);
    }

    /**
     * this method tries to show the view if there exists one
     * it should alsways check if view is available and print error if showing is not possible
     */
    @Override
    public void show() {
        try{
            frame.setVisible(true);
        }
        catch (Exception exc){
            JOptionPane.showMessageDialog(null,
                    "Das Fenster kann nicht geöffnet werden.\n Starten Sie das Programm bitte erneut.\n" + exc.getMessage(),
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * this method tries to show the view if there exists one
     * it should alsways check if view is available and print error if showing is not possible
     */
    @Override
    public void hide() {
        try{
            frame.setVisible(false);
        }
        catch (Exception exc){
            JOptionPane.showMessageDialog(null,
                    "Das Fenster kann nicht geschlossen werden.\n Starten Sie das Programm bitte erneut.\n" + exc.getMessage(),
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
