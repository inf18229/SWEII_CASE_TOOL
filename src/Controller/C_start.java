/**
 * C_start
 *
 * C_start is the implementation if I_C_start
 * @param: nothing
 * @result: nothing2
 */


package Controller;
//TODO: import Model
import View.I_V_start;
import View.V_start;


public class C_start implements I_C_start {
    //TODO: create Model and store in local Variable
    //TODO: create VIEW and store in local Variable

    /**
     * Contructor of C_start
     *
     * creates one Object of Class C_start
     * which runs V_Start.main() and therefore creates the startwindow of the programm
     * it passes itself as C_start con into the main and therfore creates a reference to itself in the V_Start
     */
    public C_start() {
        I_V_start startView=new V_start(this);
        //V_start viewStart = new V_start(this);
        //V_start.debugPrint();
    }

    /**
     * notifyCreate()
     *
     * this message gets called by Views to notify the start Controller that a new project should be created
     */
    public void notifyCreate(){
        System.out.println("Neues Projekt wurde gedrückt.");
    }

    /**
     * notifyOpen()
     *
     * this message gets called by Views to notify the start Controller that a existing project should be opened
     */
    public void notifyOpen(){
        System.out.println("Öffne Projekt wurde gedrückt.");
    }


    //TODO: initialize View and make it visible
    //TODO: decide which links are necessary between Model, View and Controller

}
