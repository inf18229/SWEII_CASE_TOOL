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

//TODO: change Open Dialogue -> no file should be selected when opening
// wenn ich nen neues Projekt anlegen will, habe ich ja noch keine XML-Datei?
//TODO: Information hiding - variable prefix public/private aktualisieren
//TODO: add Interfaces to the Model-Classes
//TODO: combine export and import into one file with export and import methods? if not -> Begründung in Doku
//TODO: Maven???
//TODO: rename packages and classes in CAPSLOCK
//TODO: Optimierung nicht vergessen