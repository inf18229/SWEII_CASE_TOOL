package View;

import Controller.I_C_start;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_start implements I_V_start {
    private static I_C_start con;
    private JPanel V_startPanel;
    private JLabel t_newProject;
    private JButton b_createProject;
    private JButton b_openProject;




    public V_start(I_C_start con) {

        JFrame frame = new JFrame("SWE CASE TOOL");
        frame.setContentPane(this.V_startPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        b_createProject.addActionListener(new ActionListener() {
            /**
             * includes all actions that should be processed when the "Neues Projekt" button gets pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                con.notifyCreate();
            }
        });
        b_openProject.addActionListener(new ActionListener() {
            /**
             * includes all actions that should be processed when the "Öffne Projekt" button gets pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                con.notifyOpen();
            }
        });
        debugPrint("View erstellt");

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * debugPrint()
     * is a method to simply print the input string output as text to console
     * @param output
     * @return nothing, but print output to console
     */
    @Override
    public void debugPrint(String output){
        System.out.println(output);
    }

    @Override
    public String getPath(){
        //TODO: open JFileChooser
        try{
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("XML", "xml");
            chooser.setFileFilter(filter);
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.setMultiSelectionEnabled(false);

            int returnVal = chooser.showOpenDialog(null);

            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                System.out.println("Gewählte Datei: " +
                        chooser.getSelectedFile().getName());
            }

            //TODO: Importfunktion aufrufen
        }
        catch (Exception exc){
            JOptionPane.showMessageDialog(null,
                    "Dateiauswahl fehlgeschlagen!\n Probiere es erneut.\n" + exc.getMessage(),
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
        }
        return "test";
    }
}
