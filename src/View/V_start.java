package View;

import Controller.C_start;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_start {
    private static C_start con;
    private JPanel V_startPanel;
    private JLabel t_newProject;
    private JButton b_createProject;
    private JButton b_openProject;




    public static void main(C_start con) {
        JFrame frame = new JFrame("SWE CASE TOOL");
        frame.setContentPane(new V_start(con).V_startPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public V_start(C_start con) {
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
    }

    /**
     * debugPrint()
     * is a method to simply print the input string output as text to console
     * @param output
     * @return nothing, but print output to console
     */
    public static void debugPrint(String output){
        System.out.println(output);
    }
}
