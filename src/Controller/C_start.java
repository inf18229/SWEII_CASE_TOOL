/**
 * C_start
 *
 * C_start is the implementation if I_C_start
 * @param: nothing
 * @result: nothing2
 */


package Controller;
//TODO: import Model
import View.I_V_basic;
import View.I_V_start;
import View.V_start;

public class C_start implements I_C_start {
    //TODO: create Model and store in local Variable
    //TODO: create VIEW and store in local Variable
    I_V_start viewStart;
    //I_C_frame controllerFrame;

    /**
     * creates one Object of Class C_start
     * which runs V_Start.main() and therefore creates the startwindow of the programm
     * it passes itself as C_start con into the main and therfore creates a reference to itself in the V_Start
     */
    public C_start() {
        viewStart = new V_start(this);
        I_V_basic.show(viewStart.getJFrame());
        //V_start.debugPrint();
    }

    /**
     * this message gets called by Views to notify the start Controller that a new project should be created
     * the Controller therefore asks the viewStart for a path where the new project should get created
     */
    public void notifyCreate(){
        System.out.println("Neues Projekt wurde gedrückt.");
//        viewStart.getPath();
        //TODO: Model den Pfad in createData(path) übergeben
        //TODO: Create C_frame and open V_frame
        I_V_basic.hide(viewStart.getJFrame());
        I_C_frame controllerFrame = new C_frame();
    }

    /**
     * notifyOpen()
     *
     * this message gets called by Views to notify the start Controller that a existing project should be opened
     * the Controller therefore asks the viewStart for a path to the file that should be opened
     */
    public void notifyOpen(){
        System.out.println("Öffne Projekt wurde gedrückt.");
//        viewStart.getPath();
        // TODO: an Model/M_projectData_import. den Pfad an load(path) übergeben
        //TODO: Create C_frame and open V_frame
        I_V_basic.hide(viewStart.getJFrame());
        I_C_frame controllerFrame = new C_frame();
    }


    //TODO: initialize View and make it visible
    //TODO: decide which links are necessary between Model, View and Controller

}
