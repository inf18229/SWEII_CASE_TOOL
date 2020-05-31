package View;

import Controller.tab.I_C_effort;
import Controller.I_C_frame;
import Model.projectData.M_projectData;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

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
    private JPanel V_effort;
    private JTextArea targetUse;
    private JTextArea productUse;
    private JButton b_nextStep; // button is only visible in effort view and brings the user to next step
    private JButton b_lastStep; // button is only visible in effort view and brings the user to last step
    private JButton b_closeProject;
    private JButton b_saveProject;
    private JLabel labelCountInputSimple;
    private JLabel labelCountInputMedium;
    private JLabel labelCountInputComplex;
    private JLabel labelCountQuerySimple;
    private JLabel labelCountQueryMedium;
    private JLabel labelCountQueryComplex;
    private JLabel labelCountOutputSimple;
    private JLabel labelCountOutputMedium;
    private JLabel labelCountOutputComplex;
    private JLabel labelCountDatasetSimple;
    private JLabel labelCountDatasetMedium;
    private JLabel labelCountDatasetComplex;
    private JLabel labelCountReferenceSimple;
    private JLabel labelCountReferenceMedium;
    private JLabel labelCountReferenceComplex;
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
    private JLabel labelSumSum;
    private JTextArea productEnvironment;
    private JTable productFunctionList;
    private JTabbedPane V_Effort_Tabs;
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
    private JPanel panelCountQuery;
    private JPanel panelCountOutput;
    private JPanel panelCountDataset;
    private JPanel panelCountReference;
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
    private JPanel panelWeightQuery;
    private JPanel panelWeightOutput;
    private JPanel panelWeightDataset;
    private JPanel panelWeightReference;
    private JPanel panelWeightSum;
    private JPanel panelSum;
    private JPanel panelSumInput;
    private JPanel panelSumQuery;
    private JPanel panelSumOutput;
    private JPanel panelSumDataset;
    private JPanel panelSumReference;
    private JPanel panelSumSum;
    private JPanel panelHeadline;
    private JPanel panelFunctionPoint;
    private JPanel panelFactor;
    private JPanel panelFactorDescription;
    private JSlider sliderEntanglement;
    private JPanel panelEntanglement;
    private JPanel panelDecentralization;
    private JPanel panelTransactionrate;
    private JPanel panelReusability;
    private JPanel panelConversion;
    private JPanel panelCustomizability;
    private JPanel panelProcessing;
    private JPanel panelEntanglementValue;
    private JLabel labelEntaglementValue;
    private JPanel panelDecentralizationValue;
    private JLabel labelDecentralizationValue;
    private JPanel panelTransactionrateValue;
    private JPanel panelReusabilityValue;
    private JPanel panelConversionValue;
    private JPanel panelCustomizabilityValue;
    private JLabel labelCustomizabilityValue;
    private JLabel labelConversionValue;
    private JLabel labelReusabilityValue;
    private JLabel labelTransactionrateValue;
    private JLabel panelProcessingHeadline;
    private JPanel panelProcessingParts;
    private JPanel panelProcessingCalculation;
    private JPanel panelProcessingControl;
    private JPanel panelProcessingException;
    private JPanel panelProcessingLogic;
    private JPanel panelProcessingLogicInformation;
    private JPanel panelProcessingLogicValue;
    private JLabel labelProcessingLogicValue;
    private JLabel labelProcessingLogicInformation;
    private JSlider sliderProcessingLogic;
    private JPanel panelProcessingExceptionInformation;
    private JPanel panelProcessingExceptionValue;
    private JPanel panelProcessingControlInformation;
    private JPanel panelProcessingControlValue;
    private JPanel panelProcessingCalculationInformation;
    private JPanel panelProcessingCalculationValue;
    private JLabel labelProcessingExceptionValue;
    private JLabel labelProcessingExceptionInformation;
    private JSlider sliderProcessingException;
    private JLabel labelProcessingControlValue;
    private JLabel labelProcessingCalculationValue;
    private JLabel labelProcessingControlInformation;
    private JLabel labelProcessingCalculationInformation;
    private JSlider sliderProcessingCalculation;
    private JSlider sliderProcessingControl;
    private JPanel panelCalculation;
    private JPanel panelCustomizabilityInformation;
    private JPanel panelConversionInformation;
    private JPanel panelReusabilityInformation;
    private JPanel panelTransactionrateInformation;
    private JPanel panelDecentralizationInformation;
    private JPanel panelEntanglementInformation;
    private JLabel labelEntanglementInformation;
    private JLabel labelDecentralizationInformation;
    private JSlider sliderDecentralization;
    private JLabel labelTransactionrateInformation;
    private JSlider sliderTransactionrate;
    private JLabel labelReusabilityInformation;
    private JSlider sliderReusability;
    private JLabel labelConversionInformation;
    private JSlider sliderConversion;
    private JLabel labelCustomizabilityInformation;
    private JSlider sliderCustomizability;


    /**
     * Constructor of the V_frame class
     * @param conFrame Frame Controller
     */
    public V_frame(I_C_frame conFrame, M_projectData projData) {
        controllerFrame = conFrame;
        frame = new JFrame("SWE CASE TOOL");
        frame.setContentPane(this.V_framePanel);
        frame.setResizable(false);
        frame.getContentPane().setPreferredSize(new Dimension(1000, 800)); //460
        //Set initial Values here
        targetUse.setText(projData.getM_projectData_targetDefinition().getContent());
        productUse.setText(projData.getM_projectData_productUse().getContent());
        productEnvironment.setText(projData.getM_projectData_productEnvironment().getContent());

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
        b_nextStep.addActionListener(new ActionListener() {
            /**
             * notifies C_frame, that the nextStep button was pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyNext();
            }
        });
        b_lastStep.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyLast();
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
        b_nextStep.setVisible(false);
        b_lastStep.setVisible(false);
        frame.setVisible(true);
        //change listeners to notify changes on sliders in factor tab and notify frame controller
        sliderEntanglement.addChangeListener(new ChangeListener() {
                /**
                 * Invoked when the target of the listener has changed its state.
                 *
                 * @param e a ChangeEvent object
                 */
                @Override
                public void stateChanged(ChangeEvent e) {
                    controllerFrame.notifySlider(1, sliderEntanglement.getValue()); //TODO: check if correct listener (always gives more than one event per change)
                }
            });
        sliderDecentralization.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(2, sliderDecentralization.getValue());
            }
        });
        sliderTransactionrate.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(3, sliderTransactionrate.getValue());
            }
        });
        sliderProcessingCalculation.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(41, sliderProcessingCalculation.getValue());
            }
        });
        sliderProcessingControl.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(42, sliderProcessingControl.getValue());
            }
        });
        sliderProcessingException.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(43, sliderProcessingException.getValue());
            }
        });
        sliderProcessingLogic.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(44, sliderProcessingLogic.getValue());
            }
        });
        sliderReusability.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(5, sliderReusability.getValue());
            }
        });
        sliderConversion.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(6, sliderConversion.getValue());
            }
        });
        sliderCustomizability.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(7, sliderCustomizability.getValue());
            }
        });
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

    /**
     * this method gets the weight values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param sum the totalRowSumE1 of M_projectData_fuctionPointEstimation
     */
    @Override
    public void setTotalRowSum(int sum) {
        labelSumSum.setText(String.valueOf(sum));
    }

    /**
     * sets the value of the corresponding text field to the value given
     *
     * @param sliderNo integer to identify the slider that was changed
     * @param value    integer to which the slider was changed to
     */
    @Override
    public void setSliderText(int sliderNo, int value) {
        switch (sliderNo) {
            case 1:
                labelEntaglementValue.setText(String.valueOf(value));
                break;
            case 2:
                labelDecentralizationValue.setText(String.valueOf(value));
                break;
            case 3:
                labelTransactionrateValue.setText(String.valueOf(value));
                break;
            case 41:
                labelProcessingCalculationValue.setText(String.valueOf(value));
                break;
            case 42:
                labelProcessingControlValue.setText(String.valueOf(value));
                break;
            case 43:
                labelProcessingExceptionValue.setText(String.valueOf(value));
                break;
            case 44:
                labelProcessingLogicValue.setText(String.valueOf(value));
                break;
            case 5:
                labelReusabilityValue.setText(String.valueOf(value));
                break;
            case 6:
                labelConversionValue.setText(String.valueOf(value));
                break;
            case 7:
                labelCustomizabilityValue.setText(String.valueOf(value));
                break;
            default:
                // TODO: evtl. besser try catch -> prüfen und wenn besser implementieren
        }
    }

    /**
     * this method shows the next button
     */
    @Override
    public void showNext() {
        b_nextStep.setVisible(TRUE);
    }


    /**
     * this method hides the next button
     */
    @Override
    public void hideNext() {
        b_nextStep.setVisible(FALSE);
    }

    /**
     * this method shows the last button
     */
    @Override
    public void showLast() {
        b_lastStep.setVisible(TRUE);
    }

    /**
     * this method hides the last button
     */
    @Override
    public void hideLast() {
        b_lastStep.setVisible(FALSE);
    }
}
