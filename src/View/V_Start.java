package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
*   Testbeschreibung
*
*
* Last Edit:
* Author: Stefan Maier
 */
public class V_Start implements I_V_projectPath {
    private JTextField txtf_projectName;
    private JButton btn_loadProject;
    public JButton btn_newProject;
    public JPanel pnl_start;
    private JPanel pnl_projectName;
    private JPanel pnl_load;
    private JPanel pnl_create;

    public V_Start() {

        btn_newProject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.print("Hallo Welt");
            }
        });
    }

    @Override
    public String getPath()
    {
        System.out.println("Hallo Welt");
        return "Test";
    }
}

