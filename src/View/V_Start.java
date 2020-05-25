package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_Start {
    private JPanel V_Start_Panel;
    private JLabel t_newProject;
    private JButton b_createProject;
    private JButton b_openProject;

    public V_Start() {
        JFrame frame = new JFrame("V_Start");
        frame.setContentPane(new V_Start().V_Start_Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        b_createProject.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Neues Projekt wurde gedrückt.");
            }
        });
        b_openProject.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
