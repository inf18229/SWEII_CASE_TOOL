package VIEW;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTFUNCTION;
import javax.swing.*;

/**
 * Interface defines all functions that are needed from a View Frame Object
 */
public interface I_V_FRAME extends I_V_BASIC {

    /**
     * get Target Use Text Area Element
     * @return returns a JTextArea Swing Element
     */
    public JTextArea getTargetUse();

    /**
     * get Product Use Text Area Element
     * @return returns a JTextArea Swing Element
     */
    public JTextArea getProductUse();

    /**
     * get Product Environment Text Area Element
     * @return returns a JTextArea Swing Element
     */
    public JTextArea getProductEnvironment();

    /**
     * get Product Function ID Text Field Element
     * @return returns a JTextField Swing Element
     */
    public JTextField getTextFieldProdFuncID();

    /**
     * get Product Function Function Text Field Element
     * @return returns a JTextField Swing Element
     */
    public JTextField getTextFieldProdFunc();

    /**
     * get Product Function Protagonis Text Field Element
     * @return returns a JTextField Swing Element
     */
    public JTextField getTextFieldProdFuncProtagonist();

    /**
     * get Product Function Description Text Area Element
     * @return returns a JTextField Swing Element
     */
    public JTextArea getTextAreaprodFuncDescription();

    /**
     * get Product Function Category Combo Box
     * @return returns a JComboBox Swing Element
     */
    public JComboBox getComboBoxProdFuncCategory();

    /**
     * get Product Function FTR JSpinner Element
     * @return returns a JSpinner Swing Element
     */
    public JSpinner getSpinnerProdFuncFTR();

    /**
     * get Product Function DET JSpinner Element
     * @return returns a JSpinner Swing Element
     */
    public JSpinner getSpinnerProdFuncDET();

    /**
     * get Product Function List Element
     * @return returns a JList Swing Element
     */
    public JList getProdFuncIDList();

    /**
     * get ProductData List Element
     * @return returns a JList Swing Element
     */
    public JList getListproductDataID();

    /**
     * get Product Data Id Text Field
     * @return returns a JTextField Swing Element
     */
    public JTextField getTextFieldproductDataID();

    /**
     * get Product Data Refernece Text Field
     * @return returns a JTextField Swing Element
     */
    public JTextField getTextFieldproductDataReference();

    /**
     * get Product Data Description Text Area Element
     * @return returns a JTextArea Swing Element
     */
    public JTextArea getTextAreaproductDataDescription();

    /**
     * get Product Data RET Spinner Element
     * @return returns JSpinner Swing Element
     */
    public JSpinner getSpinnerproductDataRET();

    /**
     * get Product Data DET Spinner Element
     * @return returns JSpinner Swing Element
     */
    public JSpinner getSpinnerproductDataDET();

    /**
     * get Product Data Category Combo Box Element
     * @return returns JComboBox Swing Element
     */
    public JComboBox getComboBoxProdDataCategory();


    /**
     * this methods sets the description for the weight label in productfunctions view
     * dependent on input value
     *
     * @param weight value to which the weight should be set to
     */
    public void setWeightDescription(int weight);

    /**
     * this method gets the count values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param countNo which count to update
     * @param value   value to the selected count
     */
    public void setEstimationCount(int countNo, int value);

    /**
     * this method gets the weight values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param weightNo which count to update
     * @param value    value to the selected count
     */
    public void setEstimationWeight(int weightNo, int value);

    /**
     * this method gets the sum values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param sumNo which count to update
     * @param value value to the selected count
     */
    public void setEstimationSum(int sumNo, int value);

    /**
     * this method gets the weight values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param sum the totalRowSumE1 of M_projectData_fuctionPointEstimation
     */
    public void setTotalRowSum(int sum);

    /**
     * sets slider to the passed possition
     *
     * @param sliderNo defines which slider to change
     * @param value    defines the value to which the slider should be set
     */
    public void setSliderValue(int sliderNo, int value);

    /**
     * sets the value of the corresponding text field to the value given
     *
     * @param sliderNo integer to identify the slider that was changed
     * @param value    integer to which the slider was changed to
     */
    public void setSliderText(int sliderNo, int value);

    /**
     * set the value of E2
     *
     * @param e2sum  sum of all factors
     * @param e2Goal sum to achieve the same effort in calculation as in the real project
     */
    public void setFactorSumE2(int e2sum, int e2Goal);

    /**
     * this method updates the value for E1, E2 and E3 in the Calculation Tab
     *
     * @param e1            value of the function point sum e1
     * @param e2            value of the factor sum e2
     * @param e3            value of influence e3
     * @param afp           value of Adjusted Function Points
     * @param jDuration     total duration, according to jones estimation
     * @param jPersons      number of persons working, according to jones estimation
     * @param jPersonMonths person months, according to jones estimation
     */
    public void updateCalculationTab(int e1, int e2, double e3, double afp, double jDuration, int jPersons, double jPersonMonths);

    /**
     * this method returns the value of the real Duration entered by the user
     *
     * @return actualDuration
     */
    public double getActualDuration();

    /**
     * this method updates all values of the correction factor panel
     *
     * @param calcEff      effort calculated before
     * @param corrFact     correction factor
     * @param e2Correction goal for e2Sum
     */
    public void updateCorrectionPanel(double calcEff, double corrFact, int e2Correction);

    /**
     * this method shows the next button
     */
    public void showNext();

    /**
     * this method hides the next button
     */
    public void hideNext();

    /**
     * this method shows the last button
     */
    public void showLast();

    /**
     * this method hides the last button
     */
    public void hideLast();

    /**
     * this method shows the import button to import all factors
     */
    public void showFactorImport();

    /**
     * this method hides the import button to import all factors
     */
    public void hideFactorImport();

    /**
     * this method shows the export button to export all factors
     */
    public void showFactorExport();

    /**
     * this method hides the export button to export all factors
     */
    public void hideFactorExport();

    /**
     * method goes to the next step in effort analysis
     */
    public void nextStepEffort();

    /**
     * method goes to the last step in effort analysis
     */
    public void lastStepEffort();

    /**
     * adds the FuncReqID List in Tab
     *
     * @param id //TODO: add description for id
     */
    public void addProdFuncIDListElement(String id);

    /**
     * change ReqID List element with String i
     *
     * @param id is the new value for the list element
     */
    public void changeprodFuncIDListElement(String id);

    /**
     * function can reinitialize complente Product Function ID List with new Project Data
     *
     * @param projData referenece to new project data
     */
    public void reinitializeProdFuncIDList(M_PROJECTDATA projData);

    /**
     * updates textboxes depending on the selected Index
     *
     * @param projDataFunction //TODO: add description
     */
    public void updateProdFuncInfo(M_PROJECTDATA_PRODUCTFUNCTION projDataFunction);

    /**
     * adds new Product Data List Element in Tab Product Data
     *
     * @param id new Element ID
     */
    public void addProdDataIDListElement(String id);

    /**
     * change the current selected List Element with a new Element
     *
     * @param id defines what exact Element to change
     */
    public void changeProdDataIDListElement(String id);

    /**
     * function can reinitialize complente Product Data ID List with new Project Data
     *
     * @param projData referenece to new project data
     */
    public void reinitializeProdDataIDList(M_PROJECTDATA projData);

    /**
     * updates textboxes depending on selected Index
     *
     * @param projDataProductData new Product Data content
     */
    public void updateProdDataInfo(M_PROJECTDATA_PRODUCTDATA projDataProductData);
}
