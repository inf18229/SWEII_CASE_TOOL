import View.V_Start;
import javax.naming.ldap.Control;
import javax.swing.*;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new V_Start().pnl_start);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
