package CONTROLLER.TAB;

public interface I_C_PRODUCTCONTENT extends I_C_TAB{
    /**
     * new Product Content Element is Reqiested
     */
    void newProductContent();

    /**
     * save of a selecte Product Content Element is requested
     * @param selectedID is the current selected ID from JList Panel
     */
    void saveProductContent(String selectedID);

    /**
     * deletion of Product Content Element is requested
     */
    void deleteProductContent();
}
