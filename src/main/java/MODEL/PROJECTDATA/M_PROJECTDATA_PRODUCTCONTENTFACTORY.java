package MODEL.PROJECTDATA;

public class M_PROJECTDATA_PRODUCTCONTENTFACTORY {
    public static M_PROJECTDATA_PRODUCTDATA createProductData(String id) {
        M_PROJECTDATA_PRODUCTDATA productData = new M_PROJECTDATA_PRODUCTDATA();
        productData.id = id;
        return productData;
    }

    public static M_PROJECTDATA_PRODUCTFUNCTION createProductFunction(String id) {
        M_PROJECTDATA_PRODUCTFUNCTION productFunction = new M_PROJECTDATA_PRODUCTFUNCTION();
        productFunction.id = id;
        return productFunction;
    }
}
