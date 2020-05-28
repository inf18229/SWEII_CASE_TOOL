package Controller;

import Model.M_projectData;
import View.I_V_basic;
import View.I_V_start;
import View.V_start;

/**
 *  C_start is the basic controller, that is always created first.
 *  Its only purpose is to handle USER-IO during the start sequence
 */
public class C_start implements I_C_start {
    //TODO: create Model and store in local Variable
    //TODO: create VIEW and store in local Variable
    I_V_start viewStart;
    //I_C_frame controllerFrame;

    /**
     * creates Object of Class C_start
     * creates the startwindow of the programm viewStart
     * it passes itself as C_start controllerStart into the main
     * and therefore creates a reference to itself in the viewStart
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
        I_C_frame controllerFrame = new C_frame(new M_projectData());
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
        I_V_basic.hide(viewStart.getJFrame());
        //TODO: initialize C_Frame with Project Data from XML file
        I_C_frame controllerFrame = new C_frame(new M_projectData());
    }
}
