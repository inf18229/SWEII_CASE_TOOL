package VIEW;

import CONTROLLER.I_C_START;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * implements the start screen
 */
public class V_START implements I_V_START {
    private static I_C_START controllerStart;
    private JFrame frame;
    private JPanel panelStart;
    private JLabel labelNewProject;
    private JButton buttonCreateProject;
    private JButton buttonOpenProject;

    /**
     * Constructor of the V_START Class
     * it needs a reference to the C_START Controller as param con
     *
     * @param conStart reference to the Start Controller
     */
    public V_START(I_C_START conStart) {
        controllerStart = conStart;
        frame = new JFrame("SWE CASE TOOL");
        frame.setContentPane(this.panelStart);
        frame.setResizable(false);
        frame.getContentPane().setPreferredSize(new Dimension(400, 120));


        buttonCreateProject.addActionListener(new ActionListener() {
            /**
             * includes all actions that should be processed when the "Neues Projekt" button gets pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerStart.notifyCreate();
            }
        });
        buttonOpenProject.addActionListener(new ActionListener() {
            /**
             * includes all actions that should be processed when the "Öffne Projekt" button gets pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerStart.notifyOpen();
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //pack method sizes the frame so that all its contents are at or above their preferred size (form)
        frame.setLocationRelativeTo(null);  //places the window in the center of the screen
    }

    /**
     * opens the JFileChooser and returns the chosen path
     *
     * @param existingFile false: new file should be created
     *                     true: existing file should be opened
     * @return path to the chosen file
     */
    @Override
    public String getPath(boolean existingFile) {
        String path = "";
        if (existingFile == true) { // existing file should be opened
            try {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("XML", "xml");
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.setMultiSelectionEnabled(false);
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    path = chooser.getSelectedFile().getAbsolutePath();
                    //System.out.println("Gewählte Datei: " + path);
                }
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null,
                        "Dateiauswahl fehlgeschlagen!\n Probiere es erneut.\n" + exc.getMessage(),
                        "Fehler",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {    // new file should be created
            try {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("XML", "xml");
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.setMultiSelectionEnabled(false);
                int returnVal = chooser.showSaveDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    path = chooser.getSelectedFile().getAbsolutePath();
                    path += ".xml";
                    //System.out.println("Gewählte Datei: " + path);
                }
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null,
                        "Pfadauswahl fehlgeschlagen!\n Probiere es erneut.\n" + exc.getMessage(),
                        "Fehler",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return path;
    }

    /**
     * this method returns a reference to the frame Object
     *
     * @return frame
     */
    @Override
    public JFrame getJFrame() {
        return frame;
    }
}
