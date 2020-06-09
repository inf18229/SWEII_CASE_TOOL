package VIEW;

import CONTROLLER.I_C_start;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_START implements I_V_START {
    private static I_C_start conStart;
    private JFrame frame;
    private JPanel V_startPanel;
    private JLabel t_newProject;
    private JButton b_createProject;
    private JButton b_openProject;


    /**
     * Constructor of the V_START Class
     * it needs a reference to the C_START Controller as param con
     *
     * @param controllerStart
     */
    public V_START(I_C_start controllerStart) {
        conStart = controllerStart;
        frame = new JFrame("SWE CASE TOOL");
        frame.setContentPane(this.V_startPanel);
        frame.setResizable(false);
        frame.getContentPane().setPreferredSize(new Dimension(400, 120));


        b_createProject.addActionListener(new ActionListener() {
            /**
             * includes all actions that should be processed when the "Neues Projekt" button gets pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                conStart.notifyCreate();
            }
        });
        b_openProject.addActionListener(new ActionListener() {
            /**
             * includes all actions that should be processed when the "Öffne Projekt" button gets pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                conStart.notifyOpen();
            }
        });
        debugPrint("View erstellt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //pack method sizes the frame so that all its contents are at or above their preferred size (form)
        frame.setLocationRelativeTo(null);  //places the window in the center of the screen
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

    /**
     * opens the JFileChooser and returns the chosen path
     *
     * @param existingFile false: new file should be created
     *                true: existing file should be opened
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
