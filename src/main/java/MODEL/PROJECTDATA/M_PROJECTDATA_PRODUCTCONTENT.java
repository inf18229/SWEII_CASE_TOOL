package MODEL.PROJECTDATA;

/**
 * Class contains product Content Item of a project
 */
public abstract class M_PROJECTDATA_PRODUCTCONTENT {
    public String id = "";
    public int functionPointDET;
    public int functionPointWeighting;
    public String functionPointCategory = "";

    /**
     * calculates Weight of a Product Content Item
     * will be overwritten by subclasses
     */
    public void calculateWeight() {
    }
}
