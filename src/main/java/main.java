import CONTROLLER.C_START;


public class main {
    /**
     * the project is created and started when running the main method
     *
     * @param args arguments for the main Method can be passed here
     */
    public static void main(String[] args) {
        C_START.getInstance();    //create a new Object con which is capable to manage all further actions
    }
}

//================================================wichtige Änderungen===================================================

//TODO: Maven? (bei neuer Installation)


//TODO: ADD DESCRIPTIONS WHENEVER POSSIBLE!

//TODO: updateProjectData bei jedem Controller triggern bevor gespeichert wird -> geänderte Werte in Berechnung mit einbeziehen z.B. Art des FunctionPoints in Estimation Count übernehmen

//============================================sonstige Ideen und Anmerkungen============================================
//TODO: löschen Knopf entfernen/deaktivieren, wenn Liste leer
//TODO: entscheiden in welcher Reihenfolge paramter übergeben werden (model, view, controller oder anders?)

//TODO: throw errors in default case? - System.ou.println

//TODO: ELF und ILF in XML und Programm nicht korrekt gesetzt

//TODO: Modell bereinigen

//TODO: fix warnings in javadoc