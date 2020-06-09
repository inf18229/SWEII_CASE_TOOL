package MODEL.PROJECTDATA;

import java.util.ArrayList;
import java.util.List;

public class M_PROJECTDATA_PRODUCTDATA extends M_PROJECTDATA_PRODUCTCONTENT {
    public String id = "";
    public String memoryContent = "";
    public String reference = "";
    public int functionPointWeighting;
    public int functionPointDET;
    public int functionPointFTR;
    public String functionPointCategory = "";
    public List<M_PROJECTDATA_PRODUCTDATAATTRIBUTE> attributeList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public String getMemoryContent() {
        return memoryContent;
    }

    public String getReference() {
        return reference;
    }

    public int getFunctionPointWeighting() {
        return functionPointWeighting;
    }

    public int getFunctionPointDET() {
        return functionPointDET;
    }

    public int getFunctionPointFTR() {
        return functionPointFTR;
    }

    public String getFunctionPointCategory() {
        return functionPointCategory;
    }

    public List<M_PROJECTDATA_PRODUCTDATAATTRIBUTE> getAttributeList() {
        return attributeList;
    }
}
