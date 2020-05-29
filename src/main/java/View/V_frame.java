package View;

import Controller.I_C_effort;
import Controller.I_C_frame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class V_frame implements I_V_frame {
    I_C_frame controllerFrame;
    I_C_effort conEffort;
    JFrame frame;
    /**
     * Declarations of Variables for V_frame
     * all detailed information are saved in V_frame.form
     */
    private JPanel V_framePanel;
    private JTabbedPane tabbedPane;
    private JPanel V_General;
    private JPanel V_FuncReq;
    private JPanel V_NonFuncReq;
    private JPanel V_frame_effort;
    private JTextArea targetUse;
    private JTextArea productUse;
    private JButton b_refreshData;
    private JButton b_closeProject;
    private JButton b_saveProject;
    private JPanel panelMainContainer;
    private JPanel panelCategory;
    private JPanel panelCategoryInput;
    private JLabel labelCategoryInput;
    private JPanel panelCategoryQuery;
    private JLabel labelCategoryQuery;
    private JPanel panelCategoryOutput;
    private JLabel labelCategoryOutput;
    private JPanel panelCategoryDataset;
    private JLabel labelCategoryDataset;
    private JPanel panelCategoryReference;
    private JLabel labelCategoryReference;
    private JPanel panelCategorySum;
    private JLabel labelCategorySum;
    private JPanel panelCount;
    private JPanel panelCountInput;
    private JLabel labelCountInputSimple;
    private JLabel labelCountInputMedium;
    private JLabel labelCountInputComplex;
    private JPanel panelCountQuery;
    private JLabel labelCountQuerySimple;
    private JLabel labelCountQueryMedium;
    private JLabel labelCountQueryComplex;
    private JPanel panelCountOutput;
    private JLabel labelCountOutputSimple;
    private JLabel labelCountOutputMedium;
    private JLabel labelCountOutputComplex;
    private JPanel panelCountDataset;
    private JLabel labelCountDatasetSimple;
    private JLabel labelCountDatasetMedium;
    private JLabel labelCountDatasetComplex;
    private JPanel panelCountReference;
    private JLabel labelCountReferenceSimple;
    private JLabel labelCountReferenceMedium;
    private JLabel labelCountReferenceComplex;
    private JPanel panelCountSum;
    private JPanel panelClassification;
    private JPanel panelClassificationInput;
    private JLabel labelClassificationInputSimple;
    private JLabel labelClassificationInputMedium;
    private JLabel labelClassificationInputComplex;
    private JPanel panelClassificationQuery;
    private JLabel labelClassificationQuerySimple;
    private JLabel labelClassificationQueryMedium;
    private JLabel labelClassificationQueryComplex;
    private JPanel panelClassificationOutput;
    private JLabel labelClassificationOutputSimple;
    private JLabel labelClassificationOutputMedium;
    private JLabel labelClassificationOutputComplex;
    private JPanel panelClassificationDataset;
    private JLabel labelClassificationDatasetSimple;
    private JLabel labelClassificationDatasetMedium;
    private JLabel labelClassificationDatasetComplex;
    private JPanel panelClassificationReference;
    private JLabel labelClassificationReferenceSimple;
    private JLabel labelClassificationReferenceMedium;
    private JLabel labelClassificationReferenceComplex;
    private JPanel panelClassificationSum;
    private JPanel panelWeight;
    private JPanel panelWeightInput;
    private JLabel labelWeightInputSimple;
    private JLabel labelWeightInputMedium;
    private JLabel labelWeightInputComplex;
    private JPanel panelWeightQuery;
    private JLabel labelWeightQuerySimple;
    private JLabel labelWeightQueryMedium;
    private JLabel labelWeightQueryComplex;
    private JPanel panelWeightOutput;
    private JLabel labelWeightOutputSimple;
    private JLabel labelWeightOutputMedium;
    private JLabel labelWeightOutputComplex;
    private JPanel panelWeightDataset;
    private JLabel labelWeightDatasetSimple;
    private JLabel labelWeightDatasetMedium;
    private JLabel labelWeightDatasetComplex;
    private JPanel panelWeightReference;
    private JLabel labelWeightReferenceSimple;
    private JLabel labelWeightReferenceMedium;
    private JLabel labelWeightReferenceComplex;
    private JPanel panelWeightSum;
    private JPanel panelSum;
    private JPanel panelSumInput;
    private JLabel labelSumInputSimple;
    private JLabel labelSumInputMedium;
    private JLabel labelSumInputComplex;
    private JPanel panelSumQuery;
    private JLabel labelSumQuerySimple;
    private JLabel labelSumQueryMedium;
    private JLabel labelSumQueryComplex;
    private JPanel panelSumOutput;
    private JLabel labelSumOutputSimple;
    private JLabel labelSumOutputMedium;
    private JLabel labelSumOutputComplex;
    private JPanel panelSumDataset;
    private JLabel labelSumDatasetSimple;
    private JLabel labelSumDatasetMedium;
    private JLabel labelSumDatasetComplex;
    private JPanel panelSumReference;
    private JLabel labelSumReferenceSimple;
    private JLabel labelSumReferenceMedium;
    private JLabel labelSumReferenceComplex;
    private JPanel panelSumSum;
    private JLabel labelSumSum;
    private JPanel panelHeadline;
    private JTextArea productEnvironment;
    private JTable productFunctionList;

    /**
     * Constructor of the V_frame class
     * @param conFrame Frame Controller
     */
    public V_frame(I_C_frame conFrame) {
        controllerFrame = conFrame;
        frame = new JFrame("SWE CASE TOOL");
        frame.setContentPane(this.V_framePanel);
        frame.setResizable(false);
        frame.getContentPane().setPreferredSize(new Dimension(1000, 460));
        tabbedPane.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                //TODO: activate Controller depending on open tab
                controllerFrame.notifyTabChange(tabbedPane.getSelectedIndex());
            }
        });
        b_closeProject.addActionListener(new ActionListener() {
            /**
             * notifies C_frame, that the closeProject button was pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyClose();
            }
        });
        b_saveProject.addActionListener(new ActionListener() {
            /**
             * notifies C_frame, that the saveProject button was pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifySave();
            }
        });
        b_refreshData.addActionListener(new ActionListener() {
            /**
             * notifies C_frame, that the refreshData button was pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyRefresh();
            }
        });

        /**
         * Document Listener for targetUse that informs current Controller on update
         */
        targetUse.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                controllerFrame.getCurrentController().updateProjectData();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                controllerFrame.getCurrentController().updateProjectData();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                controllerFrame.getCurrentController().updateProjectData();
            }
        });

        /**
         * Document Listener for productUse that informs current Controller on update
         */
        productUse.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                controllerFrame.getCurrentController().updateProjectData();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                controllerFrame.getCurrentController().updateProjectData();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                controllerFrame.getCurrentController().updateProjectData();
            }
        });
        /**
         * Document Listener for productEnvironment that informs current Controller on update
         */
        //TODO: Ersatzhandlungen bei change oder remove für Document Listener
        productEnvironment.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                controllerFrame.getCurrentController().updateProjectData();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                controllerFrame.getCurrentController().updateProjectData();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                controllerFrame.getCurrentController().updateProjectData();
            }
        });

        /**
         * handle what should be done when closing the window:
         * do nothing, but notify Controller Frame, that user wants to close the window
         */
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
                                    @Override
                                    public void windowClosing(WindowEvent we) {
                                        controllerFrame.notifyExit();
                                    }

                                });
        String[] columnNames = {"ID","Beschreibung"};
        productFunctionList=new JTable(null,columnNames);
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

    @Override
    public JTextArea getTargetUse(){
        return targetUse;
    }

    @Override
    public JTextArea getProductUse(){
        return productUse;
    }

    @Override
    public JTextArea getProductEnvironment(){
        return productEnvironment;
    }

    @Override
    public JLabel getLabel(JLabel label) {
        //label =
        return label;
    }

    /**
     * this method gets the count values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param countInputSimple
     * @param countInputMedium
     * @param countInputComplex
     * @param countQuerySimple
     * @param countQueryMedium
     * @param countQueryComplex
     * @param countOutputSimple
     * @param countOutputMedium
     * @param countOutputComplex
     * @param countDatasetSimple
     * @param countDatasetMedium
     * @param countDatasetComplex
     * @param countReferenceSimple
     * @param countReferenceMedium
     * @param countReferenceComplex
     */
    @Override
    public void setEstimationCount(
            int countInputSimple,
            int countInputMedium,
            int countInputComplex,
            int countQuerySimple,
            int countQueryMedium,
            int countQueryComplex,
            int countOutputSimple,
            int countOutputMedium,
            int countOutputComplex,
            int countDatasetSimple,
            int countDatasetMedium,
            int countDatasetComplex,
            int countReferenceSimple,
            int countReferenceMedium,
            int countReferenceComplex) {
        System.out.println("setEstimationCount was called");
        labelCountInputSimple.setText(String.valueOf(countInputSimple));
        labelCountInputMedium.setText(String.valueOf(countInputMedium));
        labelCountInputComplex.setText(String.valueOf(countInputComplex));
        labelCountQuerySimple.setText(String.valueOf(countQuerySimple));
        labelCountQueryMedium.setText(String.valueOf(countQueryMedium));
        labelCountQueryComplex.setText(String.valueOf(countQueryComplex));
        labelCountOutputSimple.setText(String.valueOf(countOutputSimple));
        labelCountOutputMedium.setText(String.valueOf(countOutputMedium));
        labelCountOutputComplex.setText(String.valueOf(countOutputComplex));
        labelCountDatasetSimple.setText(String.valueOf(countDatasetSimple));
        labelCountDatasetMedium.setText(String.valueOf(countDatasetMedium));
        labelCountDatasetComplex.setText(String.valueOf(countDatasetComplex));
        labelCountReferenceSimple.setText(String.valueOf(countReferenceSimple));
        labelCountReferenceMedium.setText(String.valueOf(countReferenceMedium));
        labelCountReferenceComplex.setText(String.valueOf(countReferenceComplex));
    }

    /**
     * this method gets the sum values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param sumInputSimple
     * @param sumInputMedium
     * @param sumInputComplex
     * @param sumQuerySimple
     * @param sumQueryMedium
     * @param sumQueryComplex
     * @param sumOutputSimple
     * @param sumOutputMedium
     * @param sumOutputComplex
     * @param sumDatasetSimple
     * @param sumDatasetMedium
     * @param sumDatasetComplex
     * @param sumReferenceSimple
     * @param sumReferenceMedium
     * @param sumReferenceComplex
     */
    @Override
    public void setEstimationSum(
            int sumInputSimple,
            int sumInputMedium,
            int sumInputComplex,
            int sumQuerySimple,
            int sumQueryMedium,
            int sumQueryComplex,
            int sumOutputSimple,
            int sumOutputMedium,
            int sumOutputComplex,
            int sumDatasetSimple,
            int sumDatasetMedium,
            int sumDatasetComplex,
            int sumReferenceSimple,
            int sumReferenceMedium,
            int sumReferenceComplex) {
        System.out.println("setEstimationSum was called");
        labelSumInputSimple.setText(String.valueOf(sumInputSimple));
        labelSumInputMedium.setText(String.valueOf(sumInputMedium));
        labelSumInputComplex.setText(String.valueOf(sumInputComplex));
        labelSumQuerySimple.setText(String.valueOf(sumQuerySimple));
        labelSumQueryMedium.setText(String.valueOf(sumQueryMedium));
        labelSumQueryComplex.setText(String.valueOf(sumQueryComplex));
        labelSumOutputSimple.setText(String.valueOf(sumOutputSimple));
        labelSumOutputMedium.setText(String.valueOf(sumOutputMedium));
        labelSumOutputComplex.setText(String.valueOf(sumOutputComplex));
        labelSumDatasetSimple.setText(String.valueOf(sumDatasetSimple));
        labelSumDatasetMedium.setText(String.valueOf(sumDatasetMedium));
        labelSumDatasetComplex.setText(String.valueOf(sumDatasetComplex));
        labelSumReferenceSimple.setText(String.valueOf(sumReferenceSimple));
        labelSumReferenceMedium.setText(String.valueOf(sumReferenceMedium));
        labelSumReferenceComplex.setText(String.valueOf(sumReferenceComplex));
    }

    /**
     * this method gets the weight values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param weightInputSimple
     * @param weightInputMedium
     * @param weightInputComplex
     * @param weightQuerySimple
     * @param weightQueryMedium
     * @param weightQueryComplex
     * @param weightOutputSimple
     * @param weightOutputMedium
     * @param weightOutputComplex
     * @param weightDatasetSimple
     * @param weightDatasetMedium
     * @param weightDatasetComplex
     * @param weightReferenceSimple
     * @param weightReferenceMedium
     * @param weightReferenceComplex
     */
    @Override
    public void setEstimationWeight(
            int weightInputSimple,
            int weightInputMedium,
            int weightInputComplex,
            int weightQuerySimple,
            int weightQueryMedium,
            int weightQueryComplex,
            int weightOutputSimple,
            int weightOutputMedium,
            int weightOutputComplex,
            int weightDatasetSimple,
            int weightDatasetMedium,
            int weightDatasetComplex,
            int weightReferenceSimple,
            int weightReferenceMedium,
            int weightReferenceComplex) {
        System.out.println("setEstimationWeight was called");
        labelWeightInputSimple.setText("x " + String.valueOf(weightInputSimple));
        labelWeightInputMedium.setText("x " + String.valueOf(weightInputMedium));
        labelWeightInputComplex.setText("x " + String.valueOf(weightInputComplex));
        labelWeightQuerySimple.setText("x " + String.valueOf(weightQuerySimple));
        labelWeightQueryMedium.setText("x " + String.valueOf(weightQueryMedium));
        labelWeightQueryComplex.setText("x " + String.valueOf(weightQueryComplex));
        labelWeightOutputSimple.setText("x " + String.valueOf(weightOutputSimple));
        labelWeightOutputMedium.setText("x " + String.valueOf(weightOutputMedium));
        labelWeightOutputComplex.setText("x " + String.valueOf(weightOutputComplex));
        labelWeightDatasetSimple.setText("x " + String.valueOf(weightDatasetSimple));
        labelWeightDatasetMedium.setText("x " + String.valueOf(weightDatasetMedium));
        labelWeightDatasetComplex.setText("x " + String.valueOf(weightDatasetComplex));
        labelWeightReferenceSimple.setText("x " + String.valueOf(weightReferenceSimple));
        labelWeightReferenceMedium.setText("x " + String.valueOf(weightReferenceMedium));
        labelWeightReferenceComplex.setText("x " + String.valueOf(weightReferenceComplex));
    }
}
