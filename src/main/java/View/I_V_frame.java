package View;

import javax.swing.*;

public interface I_V_frame extends I_V_basic{
    //TODO: alternativ solution to get access to elements of the view in the current tab controller
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
}
