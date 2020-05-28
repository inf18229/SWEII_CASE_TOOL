package View;

import Controller.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;

public class V_frame implements I_V_frame {
    I_C_effort conEffort;
    JFrame frame;
    private JPanel V_framePanel;
    private JTabbedPane tabbedPane;
    private JPanel V_General;
    private JPanel V_FuncReq;
    private JPanel V_NonFuncReq;
    private JPanel V_frame_effort;
    private JPanel panelCategories;
    private JTextArea targetUse;
    private JTextArea productUse;
    private JButton saveButton;

    /**
     * Constructor of the V_frame class
     * @param conFrame
     */
    public V_frame(I_C_frame conFrame) {
        frame = new JFrame("SWE CASE TOOL");
        frame.setContentPane(this.V_framePanel);
        frame.setResizable(false);
        frame.getContentPane().setPreferredSize(new Dimension(1000, 800));
        tabbedPane.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                //TODO: activate Controller depending on open tab
                conFrame.switchToTab(tabbedPane.getSelectedIndex());
            }
        });

        /**
         * Document Listener for targetUse that informs current Controller on update
         */
        targetUse.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                conFrame.getcurrentController().updateProjectData();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                conFrame.getcurrentController().updateProjectData();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                conFrame.getcurrentController().updateProjectData();
            }
        });

        /**
         * Document Listener for productUse that informs current Controller on update
         */
        productUse.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                conFrame.getcurrentController().updateProjectData();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                conFrame.getcurrentController().updateProjectData();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                conFrame.getcurrentController().updateProjectData();
            }
        });
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

    @Override
    /**
     * this method returns a reference to the targetUse Text area of the frame
     */
    public JTextArea getTargetUse(){
        return targetUse;
    }

    @Override
    /**
     * this method returns a reference to the productUse Text area of the frame
     */
    public JTextArea getProductUse(){
        return productUse;
    }
}
