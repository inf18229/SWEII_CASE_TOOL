package MODEL.PROJECTDATA;

/**
 * Factory Class that createsProduct Content Object on runtime
 */
public class M_PROJECTDATA_PRODUCTCONTENTFACTORY {
    /**
     * creates Product Data Object
     * @param id contains the new ID of an Product Data Object
     * @return M_PROJECTDATA_PRODUCTDATA Object
     */
    public static M_PROJECTDATA_PRODUCTDATA createProductData(String id) {
        M_PROJECTDATA_PRODUCTDATA productData = new M_PROJECTDATA_PRODUCTDATA();
        productData.id = id;
        return productData;
    }

    /**
     *creates Product Function Object
     * @param id contains new ID of an Product Function Object
     * @return M_PROJECTDATA_PRODUCTFUNCTION Object
     */
    public static M_PROJECTDATA_PRODUCTFUNCTION createProductFunction(String id) {
        M_PROJECTDATA_PRODUCTFUNCTION productFunction = new M_PROJECTDATA_PRODUCTFUNCTION();
        productFunction.id = id;
        return productFunction;
    }
}
