//======================================================================================================================
//  main
//
//  The main-Method creates a new Object of the type C_start and shouldn't be used after creation
//======================================================================================================================

import View.V_Start;

//TODO import main Controller file
public class main {
    public static void main(String[] args) {
        //System.out.println("Hallo Test Welt");
        //TODO: create an Controller Object (Main Controller)
        //C_start con = new C_start();
        V_Start view = new V_Start();
        V_Start.main();
    }
}
