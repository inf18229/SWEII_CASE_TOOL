package MODEL.PROJECTDATA;

import java.util.ArrayList;
import java.util.List;

public class M_PROJECTDATA_PRODUCTDATA extends M_PROJECTDATA_PRODUCTCONTENT {
    public String id = "";
    public String memoryContent = "";
    public String reference = "";
    public int functionPointWeighting;
    public int functionPointDET;
    public int functionPointRET;
    public String functionPointCategory = "";

    @Override
    public void calculateWeight() {
        if(functionPointRET==1){
            if(functionPointDET>=1 && functionPointDET<=19){
                functionPointWeighting=0;
            }
            else if(functionPointDET>=20 && functionPointDET<=50){
                functionPointWeighting=0;
            }
            else if(functionPointDET>50){
                functionPointWeighting=1;
            }
        }
        if(functionPointRET>=2 && functionPointRET<=5){
            if(functionPointDET>=1 && functionPointDET<=19){
                functionPointWeighting=0;
            }
            else if(functionPointDET>=20 && functionPointDET<=50){
                functionPointWeighting=1;
            }
            else if(functionPointDET>50){
                functionPointWeighting=2;
            }
        }
        if(functionPointRET>5){
            if(functionPointDET>=1 && functionPointDET<=19){
                functionPointWeighting=1;
            }
            else if(functionPointDET>=20 && functionPointDET<=50){
                functionPointWeighting=2;
            }
            else if(functionPointDET>50){
                functionPointWeighting=2;
            }
        }
    }

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

    public int getFunctionPointRET() {
        return functionPointRET;
    }

    public String getFunctionPointCategory() {
        return functionPointCategory;
    }

}
