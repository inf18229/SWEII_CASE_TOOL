package VIEW;

import CONTROLLER.I_C_FRAME;
import CONTROLLER.TAB.I_C_EFFORT;
import MODEL.PROJECTDATA.M_PROJECTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTFUNCTION;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;


public class V_FRAME implements I_V_FRAME {
    private I_C_FRAME controllerFrame;
    private I_C_EFFORT conEffort;
    private JFrame frame;

    // declaration for the desired decimal format -> improves readability
    private static DecimalFormat decimalFormat2 = new DecimalFormat("#.##");

    /**
     * Declarations of Variables for V_FRAME
     * all detailed information are saved in V_FRAME.form
     */
    private JPanel panelFrame;
    private JTabbedPane tabbedPane;
    private JPanel panelGeneral;
    private JPanel panelProductFunction;
    private JPanel panelProductData;
    private JPanel panelEffort;
    private JTextArea targetUse;
    private JTextArea productUse;
    private JButton buttonNextStep; // button is only visible in effort view and brings the user to next step
    private JButton buttonLastStep; // button is only visible in effort view and brings the user to last step
    private JButton buttonCloseProject;
    private JButton buttonSaveProject;
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
    private JTabbedPane tabbedPaneEffort;
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
    private JSlider slider0Entanglement;
    private JPanel panelEntanglement;
    private JPanel panelDecentralization;
    private JPanel panelTransactionrate;
    private JPanel panelReusability;
    private JPanel panelConversion;
    private JPanel panelCustomizability;
    private JPanel panelProcessing;
    private JPanel panelEntanglementValue;
    private JLabel label0EntaglementValue;
    private JPanel panelDecentralizationValue;
    private JLabel label1DecentralizationValue;
    private JPanel panelTransactionrateValue;
    private JPanel panelReusabilityValue;
    private JPanel panelConversionValue;
    private JPanel panelCustomizabilityValue;
    private JLabel label9CustomizabilityValue;
    private JLabel label8ConversionValue;
    private JLabel label7ReusabilityValue;
    private JLabel label2TransactionrateValue;
    private JLabel panelProcessingHeadline;
    private JPanel panelProcessingParts;
    private JPanel panelProcessingCalculation;
    private JPanel panelProcessingControl;
    private JPanel panelProcessingException;
    private JPanel panelProcessingLogic;
    private JPanel panelProcessingLogicInformation;
    private JPanel panelProcessingLogicValue;
    private JLabel label6ProcessingLogicValue;
    private JLabel labelProcessingLogicInformation;
    private JSlider slider6ProcessingLogic;
    private JPanel panelProcessingExceptionInformation;
    private JPanel panelProcessingExceptionValue;
    private JPanel panelProcessingControlInformation;
    private JPanel panelProcessingControlValue;
    private JPanel panelProcessingCalculationInformation;
    private JPanel panelProcessingCalculationValue;
    private JLabel label5ProcessingExceptionValue;
    private JLabel labelProcessingExceptionInformation;
    private JSlider slider5ProcessingException;
    private JLabel label4ProcessingControlValue;
    private JLabel label3ProcessingCalculationValue;
    private JLabel labelProcessingControlInformation;
    private JLabel labelProcessingCalculationInformation;
    private JSlider slider3ProcessingCalculation;
    private JSlider slider4ProcessingControl;
    private JPanel panelCalculation;
    private JPanel panelCustomizabilityInformation;
    private JPanel panelConversionInformation;
    private JPanel panelReusabilityInformation;
    private JPanel panelTransactionrateInformation;
    private JPanel panelDecentralizationInformation;
    private JPanel panelEntanglementInformation;
    private JLabel labelEntanglementInformation;
    private JLabel labelDecentralizationInformation;
    private JSlider slider1Decentralization;
    private JLabel labelTransactionrateInformation;
    private JSlider slider2Transactionrate;
    private JLabel labelReusabilityInformation;
    private JSlider slider7Reusability;
    private JLabel labelConversionInformation;
    private JSlider slider8Conversion;
    private JLabel labelCustomizabilityInformation;
    private JSlider slider9Customizability;
    private JLabel label;
    private JPanel panelE2Sum;
    private JLabel labelE2SumDescription;
    private JLabel labelE2;
    private JLabel labelE2Sum;
    private JLabel labelCalculationE1Value;
    private JLabel labelCalculationE2Value;
    private JList listProductFunctionID;
    private JTextField textFieldProductFunctionID;
    private JTextField textFieldProductFunctionFunction;
    private JTextField textFieldProductFunctionProtagonist;
    private JTextArea textAreaProductFunctionDescription;
    private JComboBox comboBoxProductFunctionCategory;
    private JComboBox comboBoxProductFunctionWeight;
    private JSpinner spinnerProductFunctionFTR;
    private JSpinner spinnerProductFunctionDET;
    private JLabel labelProductFunctionDetails;
    private JLabel labelProductFunctionFunctionpointDefinition;
    private JPanel panelCalculationDescription;
    private JPanel panelCalculationE1;
    private JLabel labelCalculationE1;
    private JPanel panelCalculationE2;
    private JLabel labelCalculationE2;
    private JPanel panelCalculationE3;
    private JLabel labelCalculationE3;
    private JLabel labelCalculationE3Value;
    private JButton buttonSaveProductFunction;
    private JButton buttonNewProductFunction;
    private JLabel labelCalculationAFPValue;
    private JLabel labelCalculationJPersonMonthsValue;
    private JLabel labelCalculationJPersonNoValue;
    private JLabel labelCalculationJDurationValue;
    private JLabel labelCorrectionCalculated;
    private JSpinner spinnerCorrectionActualValue;
    private JButton buttonNewCorrectionFactor;
    private JPanel panelCorrection;
    private JLabel labelCorrectionFactor;
    private JLabel labelCorrectionCalculation;
    private JLabel labelWeightDescription;
    private JButton buttonDeleteProductFunction;
    private JLabel labelE2Correction;
    private JLabel labelE2CorrectioDescription;
    private JButton buttonAutomaticSliderValues;    // button is only visible in effort view/factors and randomly updates some slider to achieve the desired project effort
    private JLabel labelE2SumGoalDescription;
    private JLabel labelE2SumGoal;
    private JButton buttonFactorImport;             // button is only visible in effort view and imports a saved set of factors from XML
    private JButton buttonFactorExport;             // button is only visible in effort view and exports a saved set of factors to XML
    private JProgressBar progressBarE2Sum;
    private JLabel labelprogressBarE2SumDescription;
    private JButton buttonAutomaticSliderValuesCorrection;
    private JList listproductDataID;
    private JLabel labelproductDataDetails;
    private JLabel labelproductDataFP;
    private JTextField textFieldproductDataID;
    private JTextField textFieldproductDataReference;
    private JTextArea textAreaproductDataDescription;
    private JSpinner spinnerproductDataRET;
    private JSpinner spinnerproductDataDET;
    private JLabel labelproductDataFPWeight;
    private JButton buttonproductDataSave;
    private JButton buttonproductDataDelete;
    private JButton buttonproductDataNew;
    private JComboBox comboBoxproductDataCategory;
    private DefaultListModel listModelProductFunction;
    private DefaultListModel listModelProductData;

    /**
     * Constructor of the V_FRAME class
     *
     * @param conFrame reference to the Frame Controller
     * @param projData reference to the projectData
     */
    public V_FRAME(I_C_FRAME conFrame, M_PROJECTDATA projData) {
        controllerFrame = conFrame;
        frame = new JFrame("SWE CASE TOOL");
        frame.setContentPane(this.panelFrame);
        frame.setResizable(false);
        frame.getContentPane().setPreferredSize(new Dimension(1200, 800)); //460
        //Set initial Values here
        targetUse.setText(projData.getTargetDefinition().content);
        productUse.setText(projData.getProductUse().content);
        productEnvironment.setText(projData.getProductEnvironment().content);

        tabbedPane.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifyTabChange(tabbedPane.getSelectedIndex());
            }
        });
        buttonCloseProject.addActionListener(new ActionListener() {
            /**
             * notifies C_FRAME, that the closeProject button was pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyClose();
            }
        });
        buttonSaveProject.addActionListener(new ActionListener() {
            /**
             * notifies C_FRAME, that the saveProject button was pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifySave();
            }
        });
        buttonNextStep.addActionListener(new ActionListener() {
            /**
             * notifies C_FRAME, that the nextStep button was pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyNext();
            }
        });
        buttonLastStep.addActionListener(new ActionListener() {
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
        buttonDeleteProductFunction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyProductContentDELETE();
                textFieldProductFunctionID.setText("");
                textFieldProductFunctionFunction.setText("");
                textFieldProductFunctionProtagonist.setText("");
                textAreaProductFunctionDescription.setText("");
                spinnerProductFunctionFTR.setValue(0);
                getSpinnerProdFuncDET().setValue(1);
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

        //Initialize Product Function Tab

        listProductFunctionID.setSelectionMode(2);
        listModelProductFunction = new DefaultListModel();
        for (M_PROJECTDATA_PRODUCTFUNCTION productFunction : projData.getProductFunctionList()) {
            listModelProductFunction.addElement(productFunction.id);
        }
        listProductFunctionID.setModel(listModelProductFunction);
        /**
         * listen for a change of selection in the list
         */
        listProductFunctionID.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                controllerFrame.notifySelectedListChange(listProductFunctionID.getSelectedValue().toString());
            }
        });
        labelProductFunctionDetails.setFont(labelProductFunctionDetails.getFont().deriveFont(labelProductFunctionDetails.getFont().getStyle() | Font.BOLD, 18));
        labelProductFunctionFunctionpointDefinition.setFont(labelProductFunctionFunctionpointDefinition.getFont().deriveFont(labelProductFunctionFunctionpointDefinition.getFont().getStyle() | Font.BOLD, 18));

        comboBoxProductFunctionCategory.addItem("EI-Eingabe");
        comboBoxProductFunctionCategory.addItem("EO-Ausgabe");
        comboBoxProductFunctionCategory.addItem("EQ-Abfrage");

        SpinnerNumberModel nMSpinnerProductFunctionFTR = new SpinnerNumberModel(0, 0, 1000, 1);
        spinnerProductFunctionFTR.setModel(nMSpinnerProductFunctionFTR);

        SpinnerNumberModel nMSpinnerProductFunctionDET = new SpinnerNumberModel(1, 1, 1000, 1);
        spinnerProductFunctionDET.setModel(nMSpinnerProductFunctionDET);

        buttonNewProductFunction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyProductContentNEW();
                System.out.println("Product Function Tab - New Button Pressed");
            }
        });
        buttonSaveProductFunction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Product Function Tab - Save Button Pressed");
                conFrame.getCurrentController().updateProjectData();
            }
        });

        //Initialize Product Data Tab
        listproductDataID.setSelectionMode(2);
        listModelProductData = new DefaultListModel();
        for (M_PROJECTDATA_PRODUCTDATA productData : projData.getProductDataList()) {
            listModelProductData.addElement(productData.id);
        }
        listproductDataID.setModel(listModelProductData);
        listproductDataID.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                controllerFrame.notifySelectedListChange(listproductDataID.getSelectedValue().toString());
            }
        });
        labelproductDataDetails.setFont(labelproductDataDetails.getFont().deriveFont(labelproductDataDetails.getFont().getStyle() | Font.BOLD, 18));
        labelproductDataFP.setFont(labelproductDataFP.getFont().deriveFont(labelproductDataFP.getFont().getStyle() | Font.BOLD, 18));


        comboBoxproductDataCategory.addItem("ILF-Interner Datenbestand");
        comboBoxproductDataCategory.addItem("ELF-Externer Datenbestand");

        SpinnerNumberModel nMSpinnerproductFunctionRET = new SpinnerNumberModel(1,1,1000,1);
        spinnerproductDataRET.setModel(nMSpinnerproductFunctionRET);


        SpinnerNumberModel nMSpinnerproductFunctionDET = new SpinnerNumberModel(1,1,1000,1);
        spinnerproductDataDET.setModel(nMSpinnerproductFunctionDET);

        buttonproductDataNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("NEW Product Data Element requested");
                controllerFrame.notifyProductContentNEW();
            }
        });
        buttonproductDataDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    controllerFrame.notifyProductContentDELETE();
                    textFieldproductDataID.setText("");
                    textAreaproductDataDescription.setText("");
                    textFieldproductDataReference.setText("");
                    spinnerproductDataRET.setValue(1);
                    spinnerproductDataDET.setValue(1);
                    System.out.println("DELETE Product Data Element requested");
            }
        });
        buttonproductDataSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.getCurrentController().updateProjectData();
                System.out.println("SAVE Product Data Element requested");
            }
        });

        frame.pack(); //pack method sizes the frame so that all its contents are at or above their preferred size (form)
        frame.setLocationRelativeTo(null);  //places the window in the center of the screen
        buttonNextStep.setVisible(false);
        buttonLastStep.setVisible(false);
        buttonFactorImport.setVisible(false);
        buttonFactorExport.setVisible(false);
        frame.setVisible(true);
        //change listeners to notify changes on sliders in factor tab and notify frame controller
        slider0Entanglement.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(0, slider0Entanglement.getValue()); //TODO: check if correct listener (always gives more than one event per change)
            }
        });
        slider1Decentralization.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(1, slider1Decentralization.getValue());
            }
        });
        slider2Transactionrate.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(2, slider2Transactionrate.getValue());
            }
        });
        slider3ProcessingCalculation.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(3, slider3ProcessingCalculation.getValue());
            }
        });
        slider4ProcessingControl.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(4, slider4ProcessingControl.getValue());
            }
        });
        slider5ProcessingException.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(5, slider5ProcessingException.getValue());
            }
        });
        slider6ProcessingLogic.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(6, slider6ProcessingLogic.getValue());
            }
        });
        slider7Reusability.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(7, slider7Reusability.getValue());
            }
        });
        slider8Conversion.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(8, slider8Conversion.getValue());
            }
        });
        slider9Customizability.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifySlider(9, slider9Customizability.getValue());
            }
        });

        buttonNewCorrectionFactor.addActionListener(new ActionListener() {
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
        buttonAutomaticSliderValues.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyAdjustFactors();
            }
        });
        buttonAutomaticSliderValues.setEnabled(false);  // button is disabled when created
        tabbedPaneEffort.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                controllerFrame.notifyTabChangeEffort();
            }
        });
        buttonFactorImport.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyImportFactor();
            }
        });
        buttonFactorExport.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyExportFactor();
            }
        });
        buttonAutomaticSliderValuesCorrection.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerFrame.notifyAdjustFactors();
                controllerFrame.notifyLast();
            }
        });
        buttonAutomaticSliderValuesCorrection.setEnabled(false);  // button is disabled when created
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


    /**
     * get Target Use Text Area Element
     *
     * @return returns a JTextArea Swing Element
     */
    @Override
    public JTextArea getTargetUse() {
        return targetUse;
    }

    /**
     * get Product Use Text Area Element
     * @return returns a JTextArea Swing Element
     */
    @Override
    public JTextArea getProductUse() {
        return productUse;
    }

    /**
     * get Product Environment Text Area Element
     * @return returns a JTextArea Swing Element
     */
    @Override
    public JTextArea getProductEnvironment() {
        return productEnvironment;
    }

    /**
     * get Product Function ID Text Field Element
     * @return returns a JTextField Swing Element
     */
    @Override
    public JTextField getTextFieldProdFuncID() {
        return textFieldProductFunctionID;
    }

    /**
     * get Product Function Function Text Field Element
     * @return returns a JTextField Swing Element
     */
    @Override
    public JTextField getTextFieldProdFunc() {
        return textFieldProductFunctionFunction;
    }

    /**
     * get Product Function Protagonis Text Field Element
     * @return returns a JTextField Swing Element
     */
    @Override
    public JTextField getTextFieldProdFuncProtagonist() {
        return textFieldProductFunctionProtagonist;
    }

    /**
     * get Product Function Description Text Area Element
     * @return returns a JTextField Swing Element
     */
    @Override
    public JTextArea getTextAreaprodFuncDescription() {
        return textAreaProductFunctionDescription;
    }

    /**
     * get Product Function Category Combo Box
     * @return returns a JComboBox Swing Element
     */
    @Override
    public JComboBox getComboBoxProdFuncCategory() {
        return comboBoxProductFunctionCategory;
    }

    /**
     * get Product Function FTR JSpinner Element
     * @return returns a JSpinner Swing Element
     */
    @Override
    public JSpinner getSpinnerProdFuncFTR() {
        return spinnerProductFunctionFTR;
    }

    /**
     * get Product Function DET JSpinner Element
     * @return returns a JSpinner Swing Element
     */
    @Override
    public JSpinner getSpinnerProdFuncDET() {
        return spinnerProductFunctionDET;
    }

    /**
     * get Product Function List Element
     * @return returns a JList Swing Element
     */
    @Override
    public JList getProdFuncIDList() {
        return listProductFunctionID;
    }

    /**
     * get ProductData List Element
     * @return returns a JList Swing Element
     */
    @Override
    public JList getListproductDataID() {
        return listproductDataID;
    }

    /**
     * get Product Data Id Text Field
     * @return returns a JTextField Swing Element
     */
    @Override
    public JTextField getTextFieldproductDataID() {
        return textFieldproductDataID;
    }

    /**
     * get Product Data Refernece Text Field
     * @return returns a JTextField Swing Element
     */
    @Override
    public JTextField getTextFieldproductDataReference() {
        return textFieldproductDataReference;
    }

    /**
     * get Product Data Description Text Area Element
     * @return returns a JTextArea Swing Element
     */
    @Override
    public JTextArea getTextAreaproductDataDescription() {
        return textAreaproductDataDescription;
    }

    /**
     * get Product Data RET Spinner Element
     * @return returns JSpinner Swing Element
     */
    @Override
    public JSpinner getSpinnerproductDataRET() {
        return spinnerproductDataRET;
    }

    /**
     * get Product Data DET Spinner Element
     * @return returns JSpinner Swing Element
     */
    @Override
    public JSpinner getSpinnerproductDataDET() {
        return spinnerproductDataDET;
    }

    /**
     * get Product Data Category Combo Box Element
     * @return returns JComboBox Swing Element
     */
    @Override
    public JComboBox getComboBoxProdDataCategory() {
        return comboBoxproductDataCategory;
    }

    /**
     * this methods sets the description for the weight label in productfunctions view
     * dependent on input value
     *
     * @param weight value of weight is given as int
     */
    @Override
    public void setWeightDescription(int weight) {

        if(controllerFrame.getCurrentController().toString().contains("CONTROLLER.TAB.C_PRODUCTFUNCTION")) {
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
        else if(controllerFrame.getCurrentController().toString().contains("CONTROLLER.TAB.C_PRODUCTDATA")) {
            switch (weight) {
                case 0:
                    labelproductDataFPWeight.setText("Einfach");
                    break;
                case 1:
                    labelproductDataFPWeight.setText("Mittel");
                    break;
                case 2:
                    labelproductDataFPWeight.setText("Komplex");
                    break;
                default:
                    labelproductDataFPWeight.setText("Fehler bei der Bestimmung eines Gewichts");
                    break;
            }
        }
    }

    /**
     * this method gets the count values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param countNo which count to update
     * @param value   value to the selected count
     */
    @Override
    public void setEstimationCount(int countNo, int value) {
        switch (countNo){
            case 0:
                labelCountInputSimple.setText(String.valueOf(value));
                break;
            case 1:
                labelCountInputMedium.setText(String.valueOf(value));
                break;
            case 2:
                labelCountInputComplex.setText(String.valueOf(value));
                break;
            case 3:
                labelCountQuerySimple.setText(String.valueOf(value));
                break;
            case 4:
                labelCountQueryMedium.setText(String.valueOf(value));
                break;
            case 5:
                labelCountQueryComplex.setText(String.valueOf(value));
                break;
            case 6:
                labelCountOutputSimple.setText(String.valueOf(value));
                break;
            case 7:
                labelCountOutputMedium.setText(String.valueOf(value));
                break;
            case 8:
                labelCountOutputComplex.setText(String.valueOf(value));
                break;
            case 9:
                labelCountDatasetSimple.setText(String.valueOf(value));
                break;
            case 10:
                labelCountDatasetMedium.setText(String.valueOf(value));
                break;
            case 11:
                labelCountDatasetComplex.setText(String.valueOf(value));
                break;
            case 12:
                labelCountReferenceSimple.setText(String.valueOf(value));
                break;
            case 13:
                labelCountReferenceMedium.setText(String.valueOf(value));
                break;
            case 14:
                labelCountReferenceComplex.setText(String.valueOf(value));
                break;
            default:
                break;
        }
    }

    /**
     * this method gets the weight values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param weightNo which count to update
     * @param value   value to the selected count
     */
    @Override
    public void setEstimationWeight(int weightNo, int value) {
        switch (weightNo){
            case 0:
                labelWeightInputSimple.setText("x " + String.valueOf(value));
                break;
            case 1:
                labelWeightInputMedium.setText("x " + String.valueOf(value));
                break;
            case 2:
                labelWeightInputComplex.setText("x " + String.valueOf(value));
                break;
            case 3:
                labelWeightQuerySimple.setText("x " + String.valueOf(value));
                break;
            case 4:
                labelWeightQueryMedium.setText("x " + String.valueOf(value));
                break;
            case 5:
                labelWeightQueryComplex.setText("x " + String.valueOf(value));
                break;
            case 6:
                labelWeightOutputSimple.setText("x " + String.valueOf(value));
                break;
            case 7:
                labelWeightOutputMedium.setText("x " + String.valueOf(value));
                break;
            case 8:
                labelWeightOutputComplex.setText("x " + String.valueOf(value));
                break;
            case 9:
                labelWeightDatasetSimple.setText("x " + String.valueOf(value));
                break;
            case 10:
                labelWeightDatasetMedium.setText("x " + String.valueOf(value));
                break;
            case 11:
                labelWeightDatasetComplex.setText("x " + String.valueOf(value));
                break;
            case 12:
                labelWeightReferenceSimple.setText("x " + String.valueOf(value));
                break;
            case 13:
                labelWeightReferenceMedium.setText("x " + String.valueOf(value));
                break;
            case 14:
                labelWeightReferenceComplex.setText("x " + String.valueOf(value));
                break;
            default:
                break;
        }
    }

    /**
     * this method gets the count values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param sumNo which count to update
     * @param value   value to the selected count
     */
    @Override
    public void setEstimationSum(int sumNo, int value) {
        switch (sumNo){
            case 0:
                labelSumInputSimple.setText(String.valueOf(value));
                break;
            case 1:
                labelSumInputMedium.setText(String.valueOf(value));
                break;
            case 2:
                labelSumInputComplex.setText(String.valueOf(value));
                break;
            case 3:
                labelSumQuerySimple.setText(String.valueOf(value));
                break;
            case 4:
                labelSumQueryMedium.setText(String.valueOf(value));
                break;
            case 5:
                labelSumQueryComplex.setText(String.valueOf(value));
                break;
            case 6:
                labelSumOutputSimple.setText(String.valueOf(value));
                break;
            case 7:
                labelSumOutputMedium.setText(String.valueOf(value));
                break;
            case 8:
                labelSumOutputComplex.setText(String.valueOf(value));
                break;
            case 9:
                labelSumDatasetSimple.setText(String.valueOf(value));
                break;
            case 10:
                labelSumDatasetMedium.setText(String.valueOf(value));
                break;
            case 11:
                labelSumDatasetComplex.setText(String.valueOf(value));
                break;
            case 12:
                labelSumReferenceSimple.setText(String.valueOf(value));
                break;
            case 13:
                labelSumReferenceMedium.setText(String.valueOf(value));
                break;
            case 14:
                labelSumReferenceComplex.setText(String.valueOf(value));
                break;
            default:
                break;
        }
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
     * @param sliderNo which slider to return
     * @return value of the selected slider
     */
    @Override
    public int getSliderValue(int sliderNo) {
        //TODO: rename cases
        switch (sliderNo) {
            case 1:
                return slider0Entanglement.getValue();
            case 2:
                return slider1Decentralization.getValue();
            case 3:
                return slider2Transactionrate.getValue();
            case 41:
                return slider3ProcessingCalculation.getValue();
            case 42:
                return slider4ProcessingControl.getValue();
            case 43:
                return slider5ProcessingException.getValue();
            case 44:
                return slider6ProcessingLogic.getValue();
            case 5:
                return slider7Reusability.getValue();
            case 6:
                return slider8Conversion.getValue();
            case 7:
                return slider9Customizability.getValue();
            default:
                return 0;
        }

    }

    /**
     * sets slider to the passed possition
     *
     * @param sliderNo defines which slider to change
     * @param value    defines the value to which the slider should be set
     */
    @Override
    public void setSliderValue(int sliderNo, int value) {
        switch (sliderNo) {
            case 0:
                slider0Entanglement.setValue(value);
                break;
            case 1:
                slider1Decentralization.setValue(value);
                break;
            case 2:
                slider2Transactionrate.setValue(value);
                break;
            case 3:
                slider3ProcessingCalculation.setValue(value);
                break;
            case 4:
                slider4ProcessingControl.setValue(value);
                break;
            case 5:
                slider5ProcessingException.setValue(value);
                break;
            case 6:
                slider6ProcessingLogic.setValue(value);
                break;
            case 7:
                slider7Reusability.setValue(value);
                break;
            case 8:
                slider8Conversion.setValue(value);
                break;
            case 9:
                slider9Customizability.setValue(value);
                break;
            default:
        }
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
            case 0:
                label0EntaglementValue.setText(String.valueOf(value));
                break;
            case 1:
                label1DecentralizationValue.setText(String.valueOf(value));
                break;
            case 2:
                label2TransactionrateValue.setText(String.valueOf(value));
                break;
            case 3:
                label3ProcessingCalculationValue.setText(String.valueOf(value));
                break;
            case 4:
                label4ProcessingControlValue.setText(String.valueOf(value));
                break;
            case 5:
                label5ProcessingExceptionValue.setText(String.valueOf(value));
                break;
            case 6:
                label6ProcessingLogicValue.setText(String.valueOf(value));
                break;
            case 7:
                label7ReusabilityValue.setText(String.valueOf(value));
                break;
            case 8:
                label8ConversionValue.setText(String.valueOf(value));
                break;
            case 9:
                label9CustomizabilityValue.setText(String.valueOf(value));
                break;
            default:
        }
    }

    /**
     * sets the value of E2
     * and set the color of the label which shows e2Sum corresponding on deviation from e2Goal
     *
     * @param e2Sum  sum of all factors
     * @param e2Goal sum to achieve the same effort in calculation as in the real project
     */
    @Override
    public void setFactorSumE2(int e2Sum, int e2Goal) {
        if (e2Goal == -1) {
            buttonAutomaticSliderValues.setEnabled(false);
            buttonAutomaticSliderValuesCorrection.setEnabled(false); // disables button as factor correction is not possible/not necessary as it isn't initialized yet
            labelE2Sum.setForeground(Color.black);
        } else if (e2Sum == e2Goal) {
            buttonAutomaticSliderValues.setEnabled(false);
            buttonAutomaticSliderValuesCorrection.setEnabled(false); // enables button as factor correction is not necessary
            labelE2Sum.setForeground(Color.green.darker());
        } else if (e2Sum <= e2Goal + 5 & e2Sum >= e2Goal - 5) { // e2Sum == e2Goal +-5
            buttonAutomaticSliderValues.setEnabled(true);
            buttonAutomaticSliderValuesCorrection.setEnabled(true); // enables button as factor correction is possible
            labelE2Sum.setForeground(Color.orange.darker());
        } else if (e2Goal < 0 | e2Goal > 60) {  // e2Goal was not yet calculated or is out of the correctable range
            buttonAutomaticSliderValues.setEnabled(false);
            buttonAutomaticSliderValuesCorrection.setEnabled(false); // enables button as factor correction is not possible
            labelE2Sum.setForeground(Color.black);
        } else {
            buttonAutomaticSliderValues.setEnabled(true);
            buttonAutomaticSliderValuesCorrection.setEnabled(true); // enables button as factor correction is possible
            labelE2Sum.setForeground(Color.red.darker());   // e2Goal was calculated but e2Sum is more than 5 off its value
        }
        labelE2Sum.setText(String.valueOf(e2Sum));
        progressBarE2Sum.setValue(e2Sum);
        labelprogressBarE2SumDescription.setText(String.valueOf(e2Sum - 30) + " %");
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
        labelCalculationE3Value.setText(String.valueOf(decimalFormat2.format(e3)));
        labelCalculationAFPValue.setText(String.valueOf(decimalFormat2.format(afp)));
        labelCalculationJDurationValue.setText(String.valueOf(decimalFormat2.format(jDuration)));
        labelCalculationJPersonNoValue.setText(String.valueOf(jPersons));
        labelCalculationJPersonMonthsValue.setText(String.valueOf(decimalFormat2.format(jPersonMonths)));
    }

    /**
     * this method returns the value of the real Duration entered by the user
     */
    @Override
    public double getActualDuration() {
        return (double) spinnerCorrectionActualValue.getValue();
    }

    /**
     * this method updates all values of the correction factor panel
     * the float cast is used to provide better readability as high precision isn't needed here
     *
     * @param calcEff      effort calculated before
     * @param corrFact     correction factor calculated
     * @param e2Correction  value that should be achieved for e2Sum
     */
    @Override
    public void updateCorrectionPanel(double calcEff, double corrFact, int e2Correction) {
        labelCorrectionCalculated.setText(String.valueOf(decimalFormat2.format(calcEff)) + " Mannmonate");
        labelCorrectionFactor.setText(String.valueOf(decimalFormat2.format(corrFact)));
        labelCorrectionCalculation.setText(String.valueOf(decimalFormat2.format(calcEff) + " * e^" + decimalFormat2.format(corrFact) + " = " + String.valueOf(decimalFormat2.format((calcEff * Math.exp(corrFact))))));
        /**
         * checks if e2Correction is within the boundaries //TODO: move to controller and give string to model function?
         */
        if (e2Correction >= 0 & e2Correction < 60) {
            labelE2CorrectioDescription.setText("Die Einflussfaktoren müssen geändert werden auf:");
            labelE2Correction.setText(String.valueOf(e2Correction));
            labelE2SumGoal.setText(String.valueOf(e2Correction));
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
        buttonNextStep.setVisible(true);
    }


    /**
     * this method hides the next button
     */
    @Override
    public void hideNext() {
        buttonNextStep.setVisible(false);
    }

    /**
     * this method shows the last button
     */
    @Override
    public void showLast() {
        buttonLastStep.setVisible(true);
    }

    /**
     * this method hides the last button
     */
    @Override
    public void hideLast() {
        buttonLastStep.setVisible(false);
    }

    /**
     * this method shows the import button to import all factors
     */
    @Override
    public void showFactorImport() {
        buttonFactorImport.setVisible(true);
    }

    /**
     * this method hides the import button to import all factors
     */
    @Override
    public void hideFactorImport() {
        buttonFactorImport.setVisible(false);
    }

    /**
     * this method shows the export button to export all factors
     */
    @Override
    public void showFactorExport() {
        buttonFactorExport.setVisible(true);
    }

    /**
     * this method hides the export button to export all factors
     */
    @Override
    public void hideFactorExport() {
        buttonFactorExport.setVisible(false);
    }

    /**
     * method goes to the next step in effort analysis
     * it therefore checks which tab is selected currently and goes back one tab
     * if the rightmost tab (2) is selected it does nothing
     */
    @Override
    public void nextStepEffort() {
        switch (tabbedPaneEffort.getSelectedIndex()) {
            case 0:
                tabbedPaneEffort.setSelectedIndex(1);
                break;
            case 1:
                tabbedPaneEffort.setSelectedIndex(2);
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
        switch (tabbedPaneEffort.getSelectedIndex()) {
            case 0:
                break;
            case 1:
                tabbedPaneEffort.setSelectedIndex(0);
                break;
            case 2:
                tabbedPaneEffort.setSelectedIndex(1);
                break;
        }
    }

    /**
     * adds new Product Function List Element in Tab Product Data
     *
     * @param id new Element ID
     */
    @Override
    public void addProdFuncIDListElement(String id) {
        try{
            listModelProductFunction.addElement(id);
            listProductFunctionID.setSelectedIndex(listProductFunctionID.getLastVisibleIndex());
        }
        catch (NullPointerException e){
        }

    }

    /**
     * updates textboxes depending on selected Index
     *
     * @param projDataFunction new Product Function content
     */
    public void updateProdFuncInfo(M_PROJECTDATA_PRODUCTFUNCTION projDataFunction) {
        textFieldProductFunctionID.setText(projDataFunction.id);
        textFieldProductFunctionFunction.setText(projDataFunction.function);
        textFieldProductFunctionProtagonist.setText(projDataFunction.actor);
        textAreaProductFunctionDescription.setText(projDataFunction.description);
        switch (projDataFunction.functionPointCategory) {
            case "EI-Eingabe":
                comboBoxProductFunctionCategory.setSelectedIndex(0);
                break;
            case "EO-Ausgabe":
                comboBoxProductFunctionCategory.setSelectedIndex(1);
                break;
            case "EQ-Abfrage":
                comboBoxProductFunctionCategory.setSelectedIndex(2);
        }
        spinnerProductFunctionFTR.setValue(projDataFunction.functionPointFTR);
        spinnerProductFunctionDET.setValue(projDataFunction.functionPointDET);
    }

    /**
     * change the current selected List Element with a new Element
     *
     * @param id defines what exact Element to change
     */
    @Override
    public void changeprodFuncIDListElement(String id) {
        listModelProductFunction.setElementAt(id, listProductFunctionID.getSelectedIndex());
    }

    /**
     * function can reinitialize complente Product Function ID List with new Project Data
     *
     * @param projData referenece to new project data
     */
    @Override
    public void reinitializeProdFuncIDList(M_PROJECTDATA projData) {

        listModelProductFunction = new DefaultListModel();
        for (M_PROJECTDATA_PRODUCTFUNCTION productFunction : projData.getProductFunctionList()) {
            listModelProductFunction.addElement(productFunction.id);
        }
        try {
            listProductFunctionID.setModel(listModelProductFunction);
        } catch (NullPointerException exception) {
            //Nullpointer exception expected when List is empty
        }


    }

    /**
     * change the current selected List Element with a new Element
     *
     * @param id defines what exact Element to change
     */
    @Override
    public void addProdDataIDListElement(String id) {
        listModelProductData.addElement(id);
        listproductDataID.setSelectedIndex(listproductDataID.getLastVisibleIndex());

    }

    /**
     * change the current selected List Element with a new Element
     *
     * @param id defines what exact Element to change
     */
    @Override
    public void changeProdDataIDListElement(String id) {
        listModelProductData.setElementAt(id, listproductDataID.getSelectedIndex());
    }

    /**
     * function can reinitialize complente Product Data ID List with new Project Data
     *
     * @param projData referenece to new project data
     */
    @Override
    public void reinitializeProdDataIDList(M_PROJECTDATA projData) {
        listModelProductData = new DefaultListModel();
        for (M_PROJECTDATA_PRODUCTDATA productData : projData.getProductDataList()) {
            listModelProductData.addElement(productData.id);
        }
        try {
            listproductDataID.setModel(listModelProductData);
        } catch (NullPointerException exception) {

        }
    }

    /**
     * updates textboxes depending on selected Index
     *
     * @param projDataProductData new Product Data content
     */
    @Override
    public void updateProdDataInfo(M_PROJECTDATA_PRODUCTDATA projDataProductData) {
        textFieldproductDataID.setText(projDataProductData.id);
        textFieldproductDataReference.setText(projDataProductData.reference);
        textAreaproductDataDescription.setText(projDataProductData.memoryContent);
        switch (projDataProductData.functionPointCategory) {
            case "ILF-Interner Datenbestand":
                comboBoxproductDataCategory.setSelectedIndex(0);
                break;
            case "ELF-Externer Datenbestand":
                comboBoxproductDataCategory.setSelectedIndex(1);
                break;
        }
        spinnerproductDataRET.setValue(projDataProductData.functionPointRET);
        spinnerproductDataDET.setValue(projDataProductData.functionPointDET);
    }
}
