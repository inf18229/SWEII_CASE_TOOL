package CONTROLLER.TAB;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import VIEW.I_V_FRAME;

public class C_TABCONTROLLERFACTORY {
    /**
     * @param view           reference to I_V_FRAME Object
     * @param projData       reference to M_PROJECTDATA Object
     * @param controllerType Type of controller that has to be created. Either EFFORT,GENERAL,PRODUCTDATA or PRODUCTFUNCTION
     * @param <Any>          type that is expected to return
     * @return returns an object of type  I_C_EFFORT, I_C_GENERAL or I_C_PRODUCTCONTENT depending on controller Type. If Type is not supported function returns string
     */
    public static <Any> Any createController(I_V_FRAME view, M_PROJECTDATA projData, String controllerType) {
        switch (controllerType) {
            case "EFFORT":
                I_C_EFFORT controllerEffort = C_EFFORT.getInstance();
                controllerEffort.setLinks(view, projData);
                return ((Any) controllerEffort);
            case "GENERAL":
                I_C_GENERAL controllerGeneral = C_GENERAL.getInstance();
                controllerGeneral.setLinks(view, projData);
                return ((Any) controllerGeneral);
            case "PRODUCTDATA":
                I_C_PRODUCTCONTENT controllerProductData = C_PRODUCTDATA.getInstance();
                controllerProductData.setLinks(view, projData);
                return ((Any) controllerProductData);
            case "PRODUCTFUNCTION":
                I_C_PRODUCTCONTENT controllerProductFunction = C_PRODUCTFUNCTION.getInstance();
                controllerProductFunction.setLinks(view, projData);
                return ((Any) controllerProductFunction);
        }
        return ((Any) "Object cant be created");
    }

}
