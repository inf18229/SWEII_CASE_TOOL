package MODEL.PROJECTDATA;

/**
 * Class holds all Information of product data element
 */
public class M_PROJECTDATA_PRODUCTDATA extends M_PROJECTDATA_PRODUCTCONTENT {
    public String memoryContent = "";
    public String reference = "";
    public int functionPointRET;

    /**
     * calculates the weight of Product data
     * 0 = low
     * 1 = avarage
     * 2 = high
     */
    @Override
    public void calculateWeight() {
        if (functionPointRET == 1) {
            if (functionPointDET >= 1 && functionPointDET <= 19) {
                functionPointWeighting = 0;
            } else if (functionPointDET >= 20 && functionPointDET <= 50) {
                functionPointWeighting = 0;
            } else if (functionPointDET > 50) {
                functionPointWeighting = 1;
            }
        }
        if (functionPointRET >= 2 && functionPointRET <= 5) {
            if (functionPointDET >= 1 && functionPointDET <= 19) {
                functionPointWeighting = 0;
            } else if (functionPointDET >= 20 && functionPointDET <= 50) {
                functionPointWeighting = 1;
            } else if (functionPointDET > 50) {
                functionPointWeighting = 2;
            }
        }
        if (functionPointRET > 5) {
            if (functionPointDET >= 1 && functionPointDET <= 19) {
                functionPointWeighting = 1;
            } else if (functionPointDET >= 20 && functionPointDET <= 50) {
                functionPointWeighting = 2;
            } else if (functionPointDET > 50) {
                functionPointWeighting = 2;
            }
        }
    }
}
