package MODEL.PROJECTDATA;

/**
 * Factory Class that createsProduct Content Object on runtime
 */
public class M_PROJECTDATA_PRODUCTCONTENTFACTORY {

    /**
     * Method creates Producontent depending on the content Type
     *
     * @param id          is the new ID of the Object
     * @param contentType is either PRODUCTDATA or PRODUCTFUNCTION
     * @param <Any>       is the Datatype that is expected to return
     * @return returns either M_PROJECTDATA_PRODUCTDATA Object, M_PROJECTDATA_PRODUCTFUNCTION, or a String if content Type is not supported
     */
    public static <Any> Any createProductContent(String id, String contentType) {
        switch (contentType) {
            case "PRODUCTDATA":
                M_PROJECTDATA_PRODUCTDATA productData = new M_PROJECTDATA_PRODUCTDATA();
                productData.id = id;
                return ((Any) productData);
            case "PRODUCTFUNCTION":
                M_PROJECTDATA_PRODUCTFUNCTION productFunction = new M_PROJECTDATA_PRODUCTFUNCTION();
                productFunction.id = id;
                return ((Any) productFunction);
        }
        return ((Any) "content Type not supported");
    }
}
