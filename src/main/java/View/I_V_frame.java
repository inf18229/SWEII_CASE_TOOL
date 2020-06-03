package View;

import javax.swing.*;

public interface I_V_frame extends I_V_basic{
    //TODO: alternative solution to get access to elements of the view in the current tab controller
    public JTextArea getTargetUse();
    public JTextArea getProductUse();
    public JTextArea getProductEnvironment();
    public JLabel getLabel(JLabel label);

    /**
     * this method gets the count values from the controller
     * and adds all corresponding labels in the estimation tab of the view
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
            int countReferenceComplex);

    /**
     * this method gets the sum values from the controller
     * and adds all corresponding labels in the estimation tab of the view
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
            int sumReferenceComplex);

    /**
     * this method gets the weight values from the controller
     * and adds all corresponding labels in the estimation tab of the view
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
            int weightReferenceComplex);

    /**
     * this method gets the weight values from the controller
     * and adds all corresponding labels in the estimation tab of the view
     * @param sum the totalRowSumE1 of M_projectData_fuctionPointEstimation
     */
    public void setTotalRowSum(int sum);

    /**
     * sets sliders to the passed possitions
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
    void setSliderValues(int slider1, int slider2, int slider3, int slider41, int slider42, int slider43, int slider44, int slider5, int slider6, int slider7);

    /**
     * sets the value of the corresponding text field to the value given
     *
     * @param sliderNo integer to identify the slider that was changed
     * @param value    integer to which the slider was changed to
     */
    void setSliderText(int sliderNo, int value);

    /**
     * set the value of E2
     * @param e2sum sum of all factors
     */
    void setFactorSumE2(int e2sum);

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
     * method goes to the next step in effort analysis
     */
    void nextStepEffort();

    /**
     * method goes to the last step in effort analysis
     */
    void lastStepEffort();
}
