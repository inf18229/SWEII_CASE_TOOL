import CONTROLLER.C_START;


public class main {
    /**
     * the project is created and started when running the main method
     */
    public static void main(String[] args) {
        C_START.getInstance();    //create a new Object con which is capable to manage all further actions
    }
}

//================================================wichtige Änderungen===================================================
//TODO: Information hiding - variable prefix public/private aktualisieren
//TODO: add Interfaces to the Model-Classes
//TODO: combine export and import into one file with export and import methods? if not -> Begründung in Doku
//TODO: Maven???

//TODO: rename packages and classes in CAPSLOCK
//TODO: refactor funcReq to product function

//TODO: check variable names (english or german?)
//TODO: ADD DESCRIPTIONS WHENEVER POSSIBLE!
//TODO: Controller and ProjectData to Singleton
//TODO: updateProjectData bei jedem Controller triggern bevor gespeichert wird -> geänderte Werte in Berechnung mit einbeziehen z.B. Art des FunctionPoints in Estimation Count übernehmen
//TODO: Auskommentieren unwichtiger Komentare s. C_FRAME
//============================================sonstige Ideen und Anmerkungen============================================
//TODO: Verwirrung zwischen neu und speichern welcher Knopf in Produktfunktionen bewirkt was -> besser darstellen bloß wie?
//TODO: löschen Knopf entfernen/deaktivieren, wenn Liste leer
//TODO: entscheiden in welcher Reihenfolge paramter übergeben werden (model, view, controller oder anders?)
//TODO: add notifyButton(int id); which calls the required functions depending on the id
