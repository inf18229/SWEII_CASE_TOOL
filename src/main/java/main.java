//======================================================================================================================
//  main
//
//  The main-Method creates a new Object of the type C_start and shouldn't be used after creation
//======================================================================================================================

import Controller.C_start;
import Controller.I_C_start;


public class main {
    /**
     * the project is created and started when running the main method
     */
    public static void main(String[] args) {
        I_C_start con = new C_start();    //create a new Object con which is capable to manage all further actions
    }
}
