package CONTROLLER.TAB;

public interface I_C_PRODUCTCONTENT extends I_C_TAB{
    /**
     * new Product Content Element is Reqiested
     */
    void newProductContent();

    /**
     * notifies the controller that a new element is selected
     * @param selectedID is the current selected ID from JList Panel
     */
    void notifySelectionChange(String selectedID);

    /**
     * deletion of Product Content Element is requested
     */
    void deleteProductContent();
}
