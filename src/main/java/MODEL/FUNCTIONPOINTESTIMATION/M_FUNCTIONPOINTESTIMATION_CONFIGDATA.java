package MODEL.FUNCTIONPOINTESTIMATION;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA")
@XmlAccessorType(XmlAccessType.FIELD)

/**
 * Class holds all configuration Data for the function Point Estimation Class
 */
public class M_FUNCTIONPOINTESTIMATION_CONFIGDATA {
    private static M_FUNCTIONPOINTESTIMATION_CONFIGDATA configData;

    private int factorEntanglement = 0;
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
     * Constructs M_FUNCTIONPOINTESTIMATION_CONFIGDATA Object
     */
    private M_FUNCTIONPOINTESTIMATION_CONFIGDATA() {
    }

    /**
     * Singleton Method to get Instance of M_FUNCTIONPOINTESTIMATION_CONFIGDATA Class
     *
     * @return M_FUNCTIONPOINTESTIMATION_CONFIGDATA Object
     */
    public static M_FUNCTIONPOINTESTIMATION_CONFIGDATA getInstance() {
        if (M_FUNCTIONPOINTESTIMATION_CONFIGDATA.configData == null) {
            M_FUNCTIONPOINTESTIMATION_CONFIGDATA.configData = new M_FUNCTIONPOINTESTIMATION_CONFIGDATA();
        } else {
            System.out.println("ConfigData Instance already created");
        }
        return M_FUNCTIONPOINTESTIMATION_CONFIGDATA.configData;
    }

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
        }
    }

    /**
     * gets the value of the factor
     *
     * @param factorNo which factor to get
     * @return the selected factor
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
     * getter Method for e2Sum
     *
     * @return e2Sum
     */
    public int getE2Sum() {
        return e2Sum;
    }

    /**
     * setter Method for e2Sum
     *
     * @param e2Sum value to which e2Sum is set to
     */
    public void setE2Sum(int e2Sum) {
        this.e2Sum = e2Sum;
    } //TODO: evtl besser entfernen
}
