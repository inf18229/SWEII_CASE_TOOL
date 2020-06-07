package View;

import Controller.I_C_frame;
import Controller.tab.I_C_effort;
import Model.projectData.M_projectData;
import Model.projectData.M_projectData_productFunction;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class V_frame implements I_V_frame {
    I_C_frame controllerFrame;
    I_C_effort conEffort;
    JFrame frame;

    // declaration for the desired decimal format -> improves readability
    private static DecimalFormat df2 = new DecimalFormat("#.##");

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
    private JSlider slider1Entanglement;
    private JPanel panelEntanglement;
    private JPanel panelDecentralization;
    private JPanel panelTransactionrate;
    private JPanel panelReusability;
    private JPanel panelConversion;
    private JPanel panelCustomizability;
    private JPanel panelProcessing;
    private JPanel panelEntanglementValue;
    private JLabel label1EntaglementValue;
    private JPanel panelDecentralizationValue;
    private JLabel label2DecentralizationValue;
    private JPanel panelTransactionrateValue;
    private JPanel panelReusabilityValue;
    private JPanel panelConversionValue;
    private JPanel panelCustomizabilityValue;
    private JLabel label7CustomizabilityValue;
    private JLabel label6ConversionValue;
    private JLabel label5ReusabilityValue;
    private JLabel label3TransactionrateValue;
    private JLabel panelProcessingHeadline;
    private JPanel panelProcessingParts;
    private JPanel panelProcessingCalculation;
    private JPanel panelProcessingControl;
    private JPanel panelProcessingException;
    private JPanel panelProcessingLogic;
    private JPanel panelProcessingLogicInformation;
    private JPanel panelProcessingLogicValue;
    private JLabel label44ProcessingLogicValue;
    private JLabel labelProcessingLogicInformation;
    private JSlider slider44ProcessingLogic;
    private JPanel panelProcessingExceptionInformation;
    private JPanel panelProcessingExceptionValue;
    private JPanel panelProcessingControlInformation;
    private JPanel panelProcessingControlValue;
    private JPanel panelProcessingCalculationInformation;
    private JPanel panelProcessingCalculationValue;
    private JLabel label43ProcessingExceptionValue;
    private JLabel labelProcessingExceptionInformation;
    private JSlider slider43ProcessingException;
    private JLabel label42ProcessingControlValue;
    private JLabel label41ProcessingCalculationValue;
    private JLabel labelProcessingControlInformation;
    private JLabel labelProcessingCalculationInformation;
    private JSlider slider41ProcessingCalculation;
    private JSlider slider42ProcessingControl;
    private JPanel panelCalculation;
    private JPanel panelCustomizabilityInformation;
    private JPanel panelConversionInformation;
    private JPanel panelReusabilityInformation;
    private JPanel panelTransactionrateInformation;
    private JPanel panelDecentralizationInformation;
    private JPanel panelEntanglementInformation;
    private JLabel labelEntanglementInformation;
    private JLabel labelDecentralizationInformation;
    private JSlider slider2Decentralization;
    private JLabel labelTransactionrateInformation;
    private JSlider slider3Transactionrate;
    private JLabel labelReusabilityInformation;
    private JSlider slider5Reusability;
    private JLabel labelConversionInformation;
    private JSlider slider6Conversion;
    private JLabel labelCustomizabilityInformation;
    private JSlider slider7Customizability;
    private JLabel label;
    private JPanel panelE2Sum;
    private JLabel labelE2SumDescription;
    private JLabel labelE2;
    private JLabel labelE2Sum;
    private JLabel labelCalculationE1Value;
    private JLabel labelCalculationE2Value;
    private JButton b_calculateNew;
    private JList functionalReqIDList;
    private JTextField textFieldReqID;
    private JTextField textFieldReqFunction;
    private JTextField textFieldReqProtagonist;
    private JTextArea textAreaReqDescription;
    private JComboBox comboBoxReqCategory;
    private JComboBox comboBoxReqWeight;
    private JSpinner spinnerReqFTR;
    private JSpinner spinnerReqDET;
    private JLabel labelReqDetails;
    private JLabel labelReqFunctionpointDefinition;
    private JPanel panelCalculationDescription;
    private JPanel panelCalculationE1;
    private JLabel labelCalculationE1;
    private JPanel panelCalculationE2;
    private JLabel labelCalculationE2;
    private JPanel panelCalculationE3;
    private JLabel labelCalculationE3;
    private JLabel labelCalculationE3Value;
    private JButton speichernButton;
    private JButton neuButton;
    private JLabel labelCalculationAFPValue;
    private JLabel labelCalculationJPersonMonthsValue;
    private JLabel labelCalculationJPersonNoValue;
    private JLabel labelCalculationJDurationValue;
    private JLabel labelCorrectionCalculated;
    private JSpinner spinnerCorrectionActualValue;
    private JButton newCorrectionFactorButton;
    private JPanel panelCorrection;
    private JLabel labelCorrectionFactor;
    private JLabel labelCorrectionCalculation;
    private JLabel labelWeightDescription;
    private JButton b_deleteProductFunction;
    private JLabel labelE2Correction;
    private JLabel labelE2CorrectioDescription;
    DefaultListModel functionalReqListModell;


    /**
     * Constructor of the V_frame class
     *
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
        b_deleteProductFunction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyFuncReqDELETE();
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

        //Initialize Functional Requirement Tab

        functionalReqIDList.setSelectionMode(2);
        functionalReqListModell = new DefaultListModel();
        for (M_projectData_productFunction productFunction : projData.getProductFunctionList()) {
            functionalReqListModell.addElement(productFunction.id);
        }
        functionalReqIDList.setModel(functionalReqListModell);
        labelReqDetails.setFont(labelReqDetails.getFont().deriveFont(labelReqDetails.getFont().getStyle() | Font.BOLD, 18));
        labelReqFunctionpointDefinition.setFont(labelReqFunctionpointDefinition.getFont().deriveFont(labelReqFunctionpointDefinition.getFont().getStyle() | Font.BOLD, 18));
        textFieldReqID.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Functional Requirement ID: " + textFieldReqID.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("Functional Requirement ID: " + textFieldReqID.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("Functional Requirement ID: " + textFieldReqID.getText());
            }
        });
        textFieldReqFunction.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Functional Requirement Function: " + textFieldReqFunction.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("Functional Requirement ID: " + textFieldReqFunction.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("Functional Requirement ID: " + textFieldReqFunction.getText());
            }
        });
        textFieldReqProtagonist.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Functional Requirement Protagonist: " + textFieldReqProtagonist.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("Functional Requirement Protagonist: " + textFieldReqProtagonist.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("Functional Requirement Protagonist: " + textFieldReqProtagonist.getText());
            }
        });
        textAreaReqDescription.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Functional Requirement Description: " + textAreaReqDescription.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("Functional Requirement Description: " + textAreaReqDescription.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("Functional Requirement Description: " + textAreaReqDescription.getText());
            }
        });
        comboBoxReqCategory.addItem("EI-Eingabe");
        comboBoxReqCategory.addItem("EO-Ausgabe");
        comboBoxReqCategory.addItem("EQ-Abfrage");
        comboBoxReqCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBoxReqCategory.getSelectedItem());
            }
        });
        //TODO: add same limits for estimation Mannmonate
        SpinnerNumberModel nMspinnerReqFTR = new SpinnerNumberModel(0, 0, 1000, 1);
        spinnerReqFTR.setModel(nMspinnerReqFTR);
        spinnerReqFTR.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("Functional Requirment Function Point FTR: " + spinnerReqFTR.getValue());
            }
        });
        SpinnerNumberModel nMspinnerReqDET = new SpinnerNumberModel(0, 0, 1000, 1);
        spinnerReqDET.setModel(nMspinnerReqDET);
        spinnerReqDET.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("Functional Requirment Function Point DET: " + spinnerReqDET.getValue());
            }
        });

        neuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyFuncReqNEW();
                System.out.println("Functional Reqirement Tab - New Button Pressed");
            }
        });
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Functional Reqirement Tab - Save Button Pressed");
                conFrame.getCurrentController().updateProjectData();
            }
        });


        frame.pack(); //pack method sizes the frame so that all its contents are at or above their preferred size (form)
        frame.setLocationRelativeTo(null);  //places the window in the center of the screen
        b_nextStep.setVisible(false);
        b_lastStep.setVisible(false);
        b_calculateNew.setVisible(false);
        frame.setVisible(true);
        //change listeners to notify changes on sliders in factor tab and notify frame controller
        slider1Entanglement.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(1, slider1Entanglement.getValue()); //TODO: check if correct listener (always gives more than one event per change)
            }
        });
        slider2Decentralization.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(2, slider2Decentralization.getValue());
            }
        });
        slider3Transactionrate.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(3, slider3Transactionrate.getValue());
            }
        });
        slider41ProcessingCalculation.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(41, slider41ProcessingCalculation.getValue());
            }
        });
        slider42ProcessingControl.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(42, slider42ProcessingControl.getValue());
            }
        });
        slider43ProcessingException.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(43, slider43ProcessingException.getValue());
            }
        });
        slider44ProcessingLogic.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(44, slider44ProcessingLogic.getValue());
            }
        });
        slider5Reusability.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(5, slider5Reusability.getValue());
            }
        });
        slider6Conversion.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(6, slider6Conversion.getValue());
            }
        });
        slider7Customizability.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(7, slider7Customizability.getValue());
            }
        });
        b_calculateNew.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyCalculate();
            }
        });

        //TODO: add description, what does this listen for?
        functionalReqIDList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(functionalReqIDList.getSelectedValue().toString());  //TODO: fix NullPointerException
                controllerFrame.notifySelectedListChange(functionalReqIDList.getSelectedValue().toString());    //TODO: fix error during compilation ("cannot find symbol")
            }
        });
        newCorrectionFactorButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyCalculate();
            }
        });
        //sets min/max Values for spinnerCorrectionActualValue
        SpinnerNumberModel spinnerCorrectionActualValue2 = new SpinnerNumberModel(0, 0, 1000, 0.1);
        spinnerCorrectionActualValue.setModel(spinnerCorrectionActualValue2);
        /*spinnerCorrectionActualValue.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("Functional Requirment Function Point FTR: " + spinnerReqFTR.getValue());
            }
        });
        spinnerCorrectionActualValue.addComponentListener(new ComponentAdapter() {});*/
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
    public JTextArea getTargetUse() {
        return targetUse;
    }

    @Override
    public JTextArea getProductUse() {
        return productUse;
    }

    @Override
    public JTextArea getProductEnvironment() {
        return productEnvironment;
    }

    @Override
    public JTextField getTextFieldReqID() {
        return textFieldReqID;
    }

    @Override
    public JTextField getTextFieldReqFunction() {
        return textFieldReqFunction;
    }

    @Override
    public JTextField getTextFieldReqProtagonist() {
        return textFieldReqProtagonist;
    }

    @Override
    public JTextArea getTextAreaReqDescription() {
        return textAreaReqDescription;
    }

    @Override
    public JComboBox getComboBoxReqCategory() {
        return comboBoxReqCategory;
    }

    @Override
    public JSpinner getSpinnerReqFTR() {
        return spinnerReqFTR;
    }

    @Override
    public JSpinner getSpinnerReqDET() {
        return spinnerReqDET;
    }

    @Override
    public JList getfunctionalReqIDList() {
        return functionalReqIDList;
    }

    /**
     * this methods sets the description for the weight label in productfunctions view
     * dependent on input value
     *
     * @param weight
     */
    @Override
    public void setWeightDescription(int weight) {
        switch (weight) {
            case 0:
                labelWeightDescription.setText("Einfach");
                break;
            case 1:
                labelWeightDescription.setText("Mittel");
                break;
            case 2:
                labelWeightDescription.setText("Komplex");
                break;
            default:
                labelWeightDescription.setText("Fehler bei der Bestimmung eines Gewichts");
                break;
        }
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
     * returns the value of the selected slider
     *
     * @param sliderNo
     * @return value of the selected slider
     */
    @Override
    public int getSliderValue(int sliderNo) {
        switch (sliderNo) {
            case 1:
                return slider1Entanglement.getValue();
            case 2:
                return slider2Decentralization.getValue();
            case 3:
                return slider3Transactionrate.getValue();
            case 41:
                return slider41ProcessingCalculation.getValue();
            case 42:
                return slider42ProcessingControl.getValue();
            case 43:
                return slider43ProcessingException.getValue();
            case 44:
                return slider44ProcessingLogic.getValue();
            case 5:
                return slider5Reusability.getValue();
            case 6:
                return slider6Conversion.getValue();
            case 7:
                return slider7Customizability.getValue();
            default:
                return 0;
        }

    }

    /**
     * sets sliders to the passed possitions
     *
     * @param slider1
     * @param slider2
     * @param slider3
     * @param slider41
     * @param slider42
     * @param slider43
     * @param slider44
     * @param slider5
     * @param slider6
     * @param slider7
     */
    @Override
    public void setSliderValues(int slider1, int slider2, int slider3, int slider41, int slider42, int slider43, int slider44, int slider5, int slider6, int slider7) {
        slider1Entanglement.setValue(slider1);
        slider2Decentralization.setValue(slider2);
        slider3Transactionrate.setValue(slider3);
        slider41ProcessingCalculation.setValue(slider41);
        slider42ProcessingControl.setValue(slider42);
        slider43ProcessingException.setValue(slider43);
        slider44ProcessingLogic.setValue(slider44);
        slider5Reusability.setValue(slider5);
        slider6Conversion.setValue(slider6);
        slider7Customizability.setValue(slider7);
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
                label1EntaglementValue.setText(String.valueOf(value));
                break;
            case 2:
                label2DecentralizationValue.setText(String.valueOf(value));
                break;
            case 3:
                label3TransactionrateValue.setText(String.valueOf(value));
                break;
            case 41:
                label41ProcessingCalculationValue.setText(String.valueOf(value));
                break;
            case 42:
                label42ProcessingControlValue.setText(String.valueOf(value));
                break;
            case 43:
                label43ProcessingExceptionValue.setText(String.valueOf(value));
                break;
            case 44:
                label44ProcessingLogicValue.setText(String.valueOf(value));
                break;
            case 5:
                label5ReusabilityValue.setText(String.valueOf(value));
                break;
            case 6:
                label6ConversionValue.setText(String.valueOf(value));
                break;
            case 7:
                label7CustomizabilityValue.setText(String.valueOf(value));
                break;
            default:
                // TODO: evtl. besser try catch -> prüfen und wenn besser implementieren
        }
    }

    /**
     * set the value of E2
     *
     * @param e2sum sum of all factors
     */
    @Override
    public void setFactorSumE2(int e2sum) {
        labelE2Sum.setText(String.valueOf(e2sum));
    }

    /**
     * this method updates the value for E1 in the Calculation Tab
     *
     * @param e1            value of the function point sum e1
     * @param e2            value of the factor sum e2
     * @param e3            value of influence e3
     * @param afp           value of Adjusted Function Points
     * @param jDuration     total duration, according to jones estimation
     * @param jPersons      number of persons working, according to jones estimation
     * @param jPersonMonths person months, according to jones estimation
     */
    @Override
    public void updateCalculationTab(int e1, int e2, double e3, double afp, double jDuration, int jPersons, double jPersonMonths) {
        labelCalculationE1Value.setText(String.valueOf(e1));
        labelCalculationE2Value.setText(String.valueOf(e2));
        labelCalculationE3Value.setText(String.valueOf(df2.format(e3)));
        labelCalculationAFPValue.setText(String.valueOf(df2.format(afp)));
        labelCalculationJDurationValue.setText(String.valueOf(df2.format(jDuration)));
        labelCalculationJPersonNoValue.setText(String.valueOf(jPersons));
        labelCalculationJPersonMonthsValue.setText(String.valueOf(df2.format(jPersonMonths)));
    }

    /**
     * this method returns the value of the real Duration entered by the user
     */
    @Override
    public double getRealTime() {
        return (double) spinnerCorrectionActualValue.getValue();
    }

    /**
     * this method updates all values of the correction factor panel
     * the float cast is used to provide better readability as high precision isn't needed here
     *
     * @param calcEff  effort calculated before
     * @param corrFact correction factor calculated
     * @param e2Correction
     */
    @Override
    public void updateCorrectionPanel(double calcEff, double corrFact, int e2Correction) {
        labelCorrectionCalculated.setText(String.valueOf(df2.format(calcEff)) + " Mannmonate");
        labelCorrectionFactor.setText(String.valueOf(df2.format(corrFact)));
        labelCorrectionCalculation.setText(String.valueOf(df2.format(calcEff) + " * e^" + df2.format(corrFact) + " = " + String.valueOf(df2.format((calcEff * Math.exp(corrFact))))));
        /**
         * checks if e2Correction is within the boundaries
         * TODO: maybe better in controller but not so efficient
         */
        if (e2Correction >= 0 & e2Correction<60) {
            labelE2CorrectioDescription.setText("Die Einflussfaktoren müssen geändert werden auf:");
            labelE2Correction.setText(String.valueOf(e2Correction));
        } else {
            labelE2CorrectioDescription.setText("Anpassung der Einflussfaktoren nicht erfolgreich!");
            labelE2Correction.setText("Selbst durch maximale Anpassung kommen Sie nicht auf den tatsächlichen Aufwand.");
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

    /**
     * this method shows the calculate New button
     */
    @Override
    public void showCalculateNew() {
        b_calculateNew.setVisible(TRUE);
    }

    /**
     * this method hides the calculate New button
     */
    @Override
    public void hideCalculateNew() {
        b_calculateNew.setVisible(FALSE);
    }

    /**
     * method goes to the next step in effort analysis
     * it therefore checks which tab is selected currently and goes back one tab
     * if the rightmost tab (2) is selected it does nothing
     */
    @Override
    public void nextStepEffort() {
        switch (V_Effort_Tabs.getSelectedIndex()) {
            case 0:
                V_Effort_Tabs.setSelectedIndex(1);
                break;
            case 1:
                V_Effort_Tabs.setSelectedIndex(2);
                break;
            case 2:
                break;
        }
    }

    /**
     * method goes to the last step in effort analysis
     * it therefore checks which tab is selected currently and goes back one tab
     * if the leftmost tab (0) is selected it does nothing
     */
    @Override
    public void lastStepEffort() {
        switch (V_Effort_Tabs.getSelectedIndex()) {
            case 0:
                break;
            case 1:
                V_Effort_Tabs.setSelectedIndex(0);
                break;
            case 2:
                V_Effort_Tabs.setSelectedIndex(1);
                break;
        }
    }

    @Override
    public void addFuncReqIDListElement(String id) {
        functionalReqListModell.addElement(id);
        System.out.println(functionalReqIDList.getLastVisibleIndex());
        functionalReqIDList.setSelectedIndex(functionalReqIDList.getLastVisibleIndex());
    }

    public void updateFuncReqInfo(M_projectData_productFunction projDataFunction) {
        textFieldReqID.setText(projDataFunction.id);
        textFieldReqFunction.setText(projDataFunction.function);
        textFieldReqProtagonist.setText(projDataFunction.actor);
        textAreaReqDescription.setText(projDataFunction.description);
        switch (projDataFunction.functionPointCategory) {
            case "EI-Eingabe":
                comboBoxReqCategory.setSelectedIndex(0);
                break;
            case "EO-Ausgabe":
                comboBoxReqCategory.setSelectedIndex(1);
                break;
            case "EQ-Abfrage":
                comboBoxReqCategory.setSelectedIndex(2);
        }
        spinnerReqFTR.setValue(projDataFunction.functionPointFTR);
        spinnerReqDET.setValue(projDataFunction.functionPointDET);
    }

    @Override
    public void changeReqIDListElement(String id) {
        functionalReqListModell.setElementAt(id, functionalReqIDList.getSelectedIndex());
    }

    @Override
    public void reinitializeReqIDList(M_projectData projData) {

        functionalReqListModell = new DefaultListModel();
        for (M_projectData_productFunction productFunction : projData.getProductFunctionList()) {
            functionalReqListModell.addElement(productFunction.id);
        }
        try {
            functionalReqIDList.setModel(functionalReqListModell);
        } catch (NullPointerException exception) {

        }


    }
}
