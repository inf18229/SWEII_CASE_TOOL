package MODEL.PROJECTDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA")
@XmlAccessorType(XmlAccessType.FIELD)

public class M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA {
    private static M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA configData;

    private M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA() {}

    public static M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA getConfigData () {
        if (M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA.configData == null) {
            M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA.configData = new M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA();
        }
        return M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA.configData;
    }

    //@XmlTransient // jumps over first element
    //int stuffElement = 0; // this element is ignored and the export starts with the second element   // TODO: try to fix and remove this

    //variables for factors
    public int factorEntanglement = 0; //TODO: eig. alle privat und nür über set/get aufrufen -> extra Test notwendig?
    public int factorDecentralization = 0;
    public int factorTransactionrate = 0;

    public int factorProcessingCalculation = 0;
    public int factorProcessingControl = 0;
    public int factorProcessingException = 0;
    public int factorProcessingLogic = 0;

    public int factorReusability = 0;
    public int factorConversion = 0;
    public int factorCustomizability = 0;

    public int e2Sum = 0;

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
}
