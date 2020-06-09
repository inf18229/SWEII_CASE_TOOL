package Model.projectData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="M_projectData_functionPointEstimation_configData")
@XmlAccessorType(XmlAccessType.FIELD)

public class M_projectData_functionPointEstimation_configData {
    private static M_projectData_functionPointEstimation_configData configData;

    private M_projectData_functionPointEstimation_configData() {}

    public static M_projectData_functionPointEstimation_configData getConfigData () {
        if (M_projectData_functionPointEstimation_configData.configData == null) {
            M_projectData_functionPointEstimation_configData.configData = new M_projectData_functionPointEstimation_configData ();
        }
        return M_projectData_functionPointEstimation_configData.configData;
    }

    //@XmlTransient // jumps over first element
    //int stuffElement = 0; // this element is ignored and the export starts with the second element   // TODO: try to fix and remove this

    //variables for factors
    private int factorEntanglement = 0; //TODO: eig. alle privat und nür über set/get aufrufen -> extra Test notwendig?
    private int factorDecentralization = 0;
    private int factorTransactionrate = 0;

    private int factorProcessingCalculation = 0;
    private int factorProcessingControl = 0;
    private int factorProcessingException = 0;
    private int factorProcessingLogic = 0;

    private int factorReusability = 0;
    private int factorConversion = 0;
    private int factorCustomizability = 0;

    private int e2Sum = 0;

    /**
     * sets one factor to the provided value
     *
     * @param factorNo which factor to change
     * @param value    what value to set it to
     */
    /*public void setFactor(int factorNo, int value) {
        switch (factorNo) {
            case 1:
                factorEntanglement = value;
                break;
            case 2:
                factorDecentralization = value;
                break;
            case 3:
                factorTransactionrate = value;
                break;
            case 41:
                factorProcessingCalculation = value;
                break;
            case 42:
                factorProcessingControl = value;
                break;
            case 43:
                factorProcessingException = value;
                break;
            case 44:
                factorProcessingLogic = value;
                break;
            case 5:
                factorReusability = value;
                break;
            case 6:
                factorConversion = value;
                break;
            case 7:
                factorCustomizability = value;
                break;
            default:
                // TODO: evtl. besser try catch -> prüfen und wenn besser implementieren
        }
    }*/

    /**
     * gets the value of the factor
     *
     * @param factorNo which factor to get
     */
    /*public int getFactor(int factorNo) {
        switch (factorNo) {
            case 1:
                return factorEntanglement;
            case 2:
                return factorDecentralization;
            case 3:
                return factorTransactionrate;
            case 41:
                return factorProcessingCalculation;
            case 42:
                return factorProcessingControl;
            case 43:
                return factorProcessingException;
            case 44:
                return factorProcessingLogic;
            case 5:
                return factorReusability;
            case 6:
                return factorConversion;
            case 7:
                return factorCustomizability;
            default:
                return 0;
            // TODO: evtl. besser try catch -> prüfen und wenn besser implementieren
        }
    }*/

    /**
     * sets one factor to the provided value
     *
     * @param factorNo which factor to change
     * @param value    what value to set it to
     */
    public void setFactor(int factorNo, int value) {
        switch (factorNo) {
            case 0:
                factorEntanglement = value;
                break;
            case 1:
                factorDecentralization = value;
                break;
            case 2:
                factorTransactionrate = value;
                break;
            case 3:
                factorProcessingCalculation = value;
                break;
            case 4:
                factorProcessingControl = value;
                break;
            case 5:
                factorProcessingException = value;
                break;
            case 6:
                factorProcessingLogic = value;
                break;
            case 7:
                factorReusability = value;
                break;
            case 8:
                factorConversion = value;
                break;
            case 9:
                factorCustomizability = value;
                break;
            default:
                // TODO: evtl. besser try catch -> prüfen und wenn besser implementieren
        }
    }

    /**
     * gets the value of the factor
     *
     * @param factorNo which factor to get
     */
    public int getFactor(int factorNo) {
        switch (factorNo) {
            case 0:
                return factorEntanglement;
            case 1:
                return factorDecentralization;
            case 2:
                return factorTransactionrate;
            case 3:
                return factorProcessingCalculation;
            case 4:
                return factorProcessingControl;
            case 5:
                return factorProcessingException;
            case 6:
                return factorProcessingLogic;
            case 7:
                return factorReusability;
            case 8:
                return factorConversion;
            case 9:
                return factorCustomizability;
            default:
                return 0;
            // TODO: evtl. besser try catch -> prüfen und wenn besser implementieren
        }
    }

    /**
     * method adds all factors and therefore calculates the total sum of all factors E2
     */
    public void calcFactorSumE2() {
        e2Sum = factorEntanglement
                + factorDecentralization
                + factorTransactionrate
                + factorProcessingCalculation
                + factorProcessingControl
                + factorProcessingException
                + factorProcessingLogic
                + factorReusability
                + factorConversion
                + factorCustomizability;
    }

    /**
     * this method gets the e2Sum
     */
    public int getE2Sum() {
        return e2Sum;
    }
}
