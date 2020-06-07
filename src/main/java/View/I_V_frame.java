package View;

import Model.projectData.M_projectData;
import Model.projectData.M_projectData_productFunction;

import javax.swing.*;

public interface I_V_frame extends I_V_basic {
    //TODO: alternative solution to get access to elements of the view in the current tab controller
    JTextArea getTargetUse();

    JTextArea getProductUse();

    JTextArea getProductEnvironment();

    JTextField getTextFieldReqID();

    JTextField getTextFieldReqFunction();

    JTextField getTextFieldReqProtagonist();

    JTextArea getTextAreaReqDescription();

    JComboBox getComboBoxReqCategory();

    JSpinner getSpinnerReqFTR();

    JSpinner getSpinnerReqDET();

    JList getfunctionalReqIDList();

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
    void setEstimationCount(
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
            int countReferenceComplex);

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
    void setEstimationSum(
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
            int sumReferenceComplex);

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
    void setEstimationWeight(
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
            int weightReferenceComplex);

    /**
     * this method gets the weight values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     *
     * @param sum the totalRowSumE1 of M_projectData_fuctionPointEstimation
     */
    void setTotalRowSum(int sum);

    /**
     * returns the value of the selected slider
     * @param sliderNo
     * @return value of the selected slider
     */
    int getSliderValue(int sliderNo);

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
    void setSliderValues(int slider1,
                         int slider2,
                         int slider3,
                         int slider41,
                         int slider42,
                         int slider43,
                         int slider44,
                         int slider5,
                         int slider6,
                         int slider7);

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
     * @param e2sum sum of all factors
     */
    void setFactorSumE2(int e2sum);

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
    double getRealTime();

    /**
     * this method updates all values of the correction factor panel
     *
     * @param calcEff  effort calculated before
     * @param corrFact correction factor calculated
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
     * this method shows the calculate New button
     */
    void showCalculateNew();

    /**
     * this method hides the calculate New button
     */
    void hideCalculateNew();

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
    void addFuncReqIDListElement(String id);

    /**
     * cgabge ReqID List element with String i
     *
     * @param id is the new value for the list element
     */
    void changeReqIDListElement(String id);

    void reinitializeReqIDList(M_projectData projData);

    /**
     * updates texboxes depending on selected Index
     */
    void updateFuncReqInfo(M_projectData_productFunction projDataFunction);
}
