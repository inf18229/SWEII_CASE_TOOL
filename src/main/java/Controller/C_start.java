package Controller;

import Model.M_projectData;
import Model.M_projectData_import;
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
    M_projectData_import m_projectData_import;
    //I_C_frame controllerFrame;

    /**
     * creates Object of Class C_start
     * creates the startwindow of the programm viewStart and makes it visible
     * it passes itself as C_start controllerStart into the main
     * and therefore creates a reference to itself in the viewStart
     */
    public C_start() {
        viewStart = new V_start(this);
        I_V_basic.show(viewStart.getJFrame());  // makes viewStart visible and enables user input
        m_projectData_import = new M_projectData_import();
    }

    /**
     * this message gets called by Views to notify the start Controller that a new project should be created
     * the Controller therefore asks the viewStart for a path where the new project should get created
     * after getting the path the Controller has to close viewStart (hide) and pass the job of handeling the project
     * to the newly created controllerFrame
     */
    public void notifyCreate(){
        System.out.println("Neues Projekt wurde gedrückt.");
        //viewStart.getPath();
        //TODO: Model den Pfad (in createData(path)) übergeben
        I_V_basic.hide(viewStart.getJFrame());  // makes viewStart invisible and disables user input
        I_C_frame controllerFrame = new C_frame(new M_projectData(), this);
    }

    /**
     * notifyOpen()
     *
     * this message gets called by Views to notify the start Controller that a existing project should be opened
     * the Controller therefore asks the viewStart for a path to the file that should be opened
     */
    public void notifyOpen(){
        System.out.println("Öffne Projekt wurde gedrückt.");
        //viewStart.getPath();
        // TODO: an Model/M_projectData_import. den Pfad (an load(path)) übergeben
        String path  = "";

        I_V_basic.hide(viewStart.getJFrame());  // makes viewStart invisible and disables user input
        //TODO: initialize C_Frame with Project Data from XML file
        I_C_frame controllerFrame = new C_frame(new M_projectData(), this);
    }

    /**
     * this method shows the viewStart and tells the Start Controller, that he is in charge now
     */
    @Override
    public void notifyShow() {
        I_V_basic.show(viewStart.getJFrame());
    }
}
