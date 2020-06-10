package VIEW;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTFUNCTION;

import javax.swing.*;

public interface I_V_FRAME extends I_V_BASIC {
    //TODO: alternative solution to get access to elements of the view in the current tab controller
    JTextArea getTargetUse();

    JTextArea getProductUse();

    JTextArea getProductEnvironment();

    JTextField getTextFieldProdFuncID();

    JTextField getTextFieldProdFunc();

    JTextField getTextFieldProdFuncProtagonist();

    JTextArea getTextAreaprodFuncDescription();

    JComboBox getComboBoxProdFuncCategory();

    JSpinner getSpinnerProdFuncFTR();

    JSpinner getSpinnerProdFuncDET();

    JList getProdFuncIDList();

    public JList getListproductDataID();

    public JTextField getTextFieldproductDataID();

    public JTextField getTextFieldproductDataReference();

    public JTextArea getTextAreaproductDataDescription();

    public JSpinner getSpinnerproductDataRET();

    public JSpinner getSpinnerproductDataDET();

    public JComboBox getComboBoxProdDataCategory();


    /**
     * this methods sets the description for the weight label in productfunctions view
     * dependent on input value
     *
     * @param weight
     */
    void setWeightDescription(int weight);

    /**
     * this method gets the count values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param countNo which count to update
     * @param value value to the selected count
     */
    void setEstimationCount(int countNo, int value);

    /**
     * this method gets the weight values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param weightNo which count to update
     * @param value value to the selected count
     */
    void setEstimationWeight(int weightNo, int value);

    /**
     * this method gets the sum values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param sumNo which count to update
     * @param value value to the selected count
     */
    void setEstimationSum(int sumNo, int value);

    /**
     * this method gets the weight values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param sum the totalRowSumE1 of M_projectData_fuctionPointEstimation
     */
    void setTotalRowSum(int sum);

    /**
     * returns the value of the selected slider
     *
     * @param sliderNo
     * @return value of the selected slider
     */
    int getSliderValue(int sliderNo);

    /**
     * sets slider to the passed possition
     *
     * @param sliderNo defines which slider to change
     * @param value    defines the value to which the slider should be set
     */
    void setSliderValue(int sliderNo, int value);

    /**
     * sets the value of the corresponding text field to the value given
     *
     * @param sliderNo integer to identify the slider that was changed
     * @param value    integer to which the slider was changed to
     */
    void setSliderText(int sliderNo, int value);

    /**
     * set the value of E2
     *
     * @param e2sum  sum of all factors
     * @param e2Goal sum to achieve the same effort in calculation as in the real project
     */
    void setFactorSumE2(int e2sum, int e2Goal);

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
    void updateCalculationTab(int e1, int e2, double e3, double afp, double jDuration, int jPersons, double jPersonMonths);

    /**
     * this method returns the value of the real Duration entered by the user
     */
    double getActualDuration();

    /**
     * this method updates all values of the correction factor panel
     *
     * @param calcEff      effort calculated before
     * @param corrFact     correction factor calculated
     * @param e2Correction
     */
    void updateCorrectionPanel(double calcEff, double corrFact, int e2Correction);

    /**
     * this method shows the next button
     */
    void showNext();

    /**
     * this method hides the next button
     */
    void hideNext();

    /**
     * this method shows the last button
     */
    void showLast();

    /**
     * this method hides the last button
     */
    void hideLast();

    /**
     * this method shows the import button to import all factors
     */
    void showFactorImport();

    /**
     * this method hides the import button to import all factors
     */
    void hideFactorImport();

    /**
     * this method shows the export button to export all factors
     */
    void showFactorExport();

    /**
     * this method hides the export button to export all factors
     */
    void hideFactorExport();

    /**
     * method goes to the next step in effort analysis
     */
    void nextStepEffort();

    /**
     * method goes to the last step in effort analysis
     */
    void lastStepEffort();

    /**
     * adds the FuncReqID List in Tab
     */
    void addProdFuncIDListElement(String id);

    /**
     * change ReqID List element with String i
     *
     * @param id is the new value for the list element
     */
    void changeprodFuncIDListElement(String id);

    /**
     * function can reinitialize complente Product Function ID List with new Project Data
     * @param projData referenece to new project data
     */
    void reinitializeProdFuncIDList(M_PROJECTDATA projData);

    /**
     * updates texboxes depending on selected Index
     */
    void updateProdFuncInfo(M_PROJECTDATA_PRODUCTFUNCTION projDataFunction);

    /**
     * adds new Product Data List Element in Tab Product Data
     * @param id new Element ID
     */
    void addProdDataIDListElement(String id);

    /**
     * change the current selected List Elment with a new Element
     * @param id
     */
    void changeProdDataIDListElement(String id);

    /**
     * function can reinitialize complente Product Data ID List with new Project Data
     * @param projData referenece to new project data
     */
    void reinitializeProdDataIDList(M_PROJECTDATA projData);

    /**
     * updates textboxes depending on selected Index
     * @param projDataProductData new Product Data content
     */
    void updateProdDataInfo(M_PROJECTDATA_PRODUCTDATA projDataProductData);
}
