package View;

import Controller.I_C_effort;
import Controller.I_C_frame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_frame implements I_V_frame {
    I_C_effort conEffort;
    JFrame frame;
    /**
     * Declarations of Variables for V_frame
     * all detailed information are saved in V_frame.form
     */
    private JPanel V_framePanel;
    private JTabbedPane tabbedPane;
    private JPanel V_framePanel_General;
    private JPanel V_framePanel_FuncReq;
    private JPanel V_framePanel_NonFuncReq;
    private JPanel panelHeadline;
    private JPanel panelSum;
    private JPanel panelWeight;
    private JPanel panelClassification;
    private JPanel panelCount;
    private JPanel panelCategory;
    private JPanel V_framePanel_effort;
    private JPanel V_framePanel_effort_mainContainer;
    private JPanel panelCategoryInput;
    private JPanel panelCategoryQuery;
    private JPanel panelCategoryOutput;
    private JPanel panelCategoryDataset;
    private JPanel panelCategoryReference;
    private JPanel panelCategorySum;
    private JPanel panelCountInput;
    private JPanel panelCountQuery;
    private JPanel panelCountOutput;
    private JPanel panelCountDataset;
    private JPanel panelCountReference;
    private JPanel panelCountSum;
    private JLabel labelCountInputSimple;
    private JLabel labelCountInputMedium;
    private JLabel labelCountInputComplex;
    private JLabel labelCountQuerySimple;
    private JLabel labelCountQueryMedium;
    private JLabel labelCountQueryComplex;
    private JLabel labelCategoryInput;
    private JLabel labelCategoryQuery;
    private JLabel labelCategoryOutput;
    private JLabel labelCategoryDataset;
    private JLabel labelCategoryReference;
    private JLabel labelCategorySum;
    private JLabel labelCountOutputSimple;
    private JLabel labelCountOutputMedium;
    private JLabel labelCountOutputComplex;
    private JLabel labelCountDatasetSimple;
    private JLabel labelCountDatasetMedium;
    private JLabel labelCountDatasetComplex;
    private JLabel labelCountReferenceSimple;
    private JLabel labelCountReferenceMedium;
    private JLabel labelCountReferenceComplex;
    private JPanel panelClassificationInput;
    private JPanel panelClassificationQuery;
    private JPanel panelClassificationOutput;
    private JPanel panelClassificationDataset;
    private JPanel panelClassificationReference;
    private JPanel panelClassificationSum;
    private JLabel labelClassificationInputSimple;
    private JLabel labelClassificationInputMedium;
    private JLabel labelClassificationInputComplex;
    private JLabel labelClassificationQuerySimple;
    private JLabel labelClassificationQueryMedium;
    private JLabel labelClassificationQueryComplex;
    private JLabel labelClassificationOutputSimple;
    private JLabel labelClassificationOutputMedium;
    private JLabel labelClassificationOutputComplex;
    private JLabel labelClassificationDatasetSimple;
    private JLabel labelClassificationDatasetMedium;
    private JLabel labelClassificationDatasetComplex;
    private JLabel labelClassificationReferenceSimple;
    private JLabel labelClassificationReferenceMedium;
    private JLabel labelClassificationReferenceComplex;
    private JPanel panelWeightInput;
    private JPanel panelWeightQuery;
    private JPanel panelWeightOutput;
    private JPanel panelWeightDataset;
    private JPanel panelWeightReference;
    private JPanel panelWeightSum;
    private JLabel labelWeightInputSimple;
    private JLabel labelWeightInputMedium;
    private JLabel labelWeightInputComplex;
    private JLabel labelWeightQuerySimple;
    private JLabel labelWeightQueryMedium;
    private JLabel labelWeightQueryComplex;
    private JLabel labelWeightOutputSimple;
    private JLabel labelWeightOutputMedium;
    private JLabel labelWeightOutputComplex;
    private JLabel labelWeightDatasetSimple;
    private JLabel labelWeightDatasetMedium;
    private JLabel labelWeightDatasetComplex;
    private JLabel labelWeightReferenceSimple;
    private JLabel labelWeightReferenceMedium;
    private JLabel labelWeightReferenceComplex;
    private JPanel panelSumInput;
    private JPanel panelSumQuery;
    private JPanel panelSumOutput;
    private JPanel panelSumDataset;
    private JPanel panelSumReference;
    private JLabel labelSumInputSimple;
    private JLabel labelSumInputMedium;
    private JLabel labelSumInputComplex;
    private JLabel labelSumQuerySimple;
    private JLabel labelSumQueryMedium;
    private JLabel labelSumQueryComplex;
    private JLabel labelSumOutputSimple;
    private JLabel labelSumOutputMedium;
    private JLabel labelSumOutputComplex;
    private JLabel labelSumDatasetSimple;
    private JLabel labelSumDatasetMedium;
    private JLabel labelSumDatasetComplex;
    private JLabel labelSumReferenceSimple;
    private JLabel labelSumReferenceMedium;
    private JLabel labelSumReferenceComplex;
    private JPanel panelSumSum;
    private JLabel labelSumSum;
    private JButton b_refreshData;
    private JButton b_closeProject;
    private JButton b_saveProject;

    /**
     * Constructor of the V_frame class
     * @param conFrame
     */
    public V_frame(I_C_frame conFrame) {
        frame = new JFrame("SWE CASE TOOL");
        frame.setContentPane(this.V_framePanel);
        frame.setResizable(false);
        frame.getContentPane().setPreferredSize(new Dimension(1000, 600));
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
        b_closeProject.addActionListener(new ActionListener() {
            /**
             * notifies C_frame, that the closeProject button was pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                conFrame.notifyOpen();
            }
        });
        b_saveProject.addActionListener(new ActionListener() {
            /**
             * notifies C_frame, that the saveProject button was pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                conFrame.notifyOpen();
            }
        });
        b_refreshData.addActionListener(new ActionListener() {
            /**
             * notifies C_frame, that the refreshData button was pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                conFrame.notifyOpen();
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //pack method sizes the frame so that all its contents are at or above their preferred size (form)
        frame.setLocationRelativeTo(null);  //places the window in the center of the screen
        frame.setVisible(true);
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
