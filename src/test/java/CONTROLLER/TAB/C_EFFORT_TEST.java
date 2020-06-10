package CONTROLLER.TAB;
// helpful links: https://junit.org/junit5/docs/current/user-guide/

import MODEL.M_IMPORT;
import MODEL.PROJECTDATA.M_PROJECTDATA;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class C_EFFORT_TEST {

    @Test
    void notifyAdjustFactors() {
        /**
         * e2Sum und e2Goal beide Integer -> ganze Zahlen
         *
         * Äquivalenzklassen:
         *      1. e2Failure > 0
         *          -> e2Sum > e2Goal (z.B. e2Sum = 10, e2Goal = 5)
         *      2. e2Failure < 0
         *          -> e2Sum < e2Goal (z.B. e2Sum = 5, e2Goal = 10)
         *      3. e2Failure = 0
         *          -> e2Sum = e2Goal (z.B. e2Sum = 5, e2Goal = 5)
         *          can int be null? -> https://stackoverflow.com/questions/2254435/can-an-int-be-null-in-java (it depends)
         *
         *      + evtl. abfangen wenn e2Sum > 60 | < 0 ist? evtl. auch bei Berechnung abfangen? (kann eigentlich nicht passieren, wäre hier aber auch egal)
         */
    }

    @Test
    void increaseFactors() {
        /**
         * e2Sum und e2Goal beide Integer -> ganze Zahlen
         *
         * Äquivalenzklassen:
         *      1. increase > 0
         *          -> in while-Schleife
         *          1.1  factorIterator < 0 oder factorIterator > 9 (1 oder 2 Klassen?)
         *          1.2 factorIterator zw. 0 und 9 (jeweils einzeln testen oder ein gemeinsamer Test?
         *
         *      2. increase <= 0
         *          -> while-Schleife überspringen
         *
         *          wie adjustment testen + Abbruchbedingung nach 60 Durchläufen oder davon ausgehen, das Funktion nur aufgerufen wird, wenn factors angepasst werden können?
         */
    }

    @Test
    void decreaseFactors() {
        /**
         * e2Sum und e2Goal beide Integer -> ganze Zahlen
         *
         * Äquivalenzklassen:
         *      1. decrease > 0
         *          -> in while-Schleife
         *          1.1  factorIterator < 0 oder factorIterator > 9 (1 oder 2 Klassen?)
         *          1.2 factorIterator zw. 0 und 9 (jeweils einzeln testen oder ein gemeinsamer Test?
         *
         *      2. decrease <= 0
         *          -> while-Schleife überspringen
         *
         *          wie adjustment testen + Abbruchbedingung nach 60 Durchläufen oder davon ausgehen, das Funktion nur aufgerufen wird, wenn factors angepasst werden können?
         */
    }

    /**
     * test with the min value for decrease -> e2Sum should not be changed
     */
    @Test
    void decreaseFactorsCleanMin(){
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "test_effort_max.xml"; // fixed path relative
        File xmlFile = new File(path);

        M_PROJECTDATA projectData = new M_PROJECTDATA();
        projectData = m__import.importProject(path);
        projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData());

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);
        controllerEffort.decreaseFactors(0);

        assertEquals(60, projectData.getM_projectData_functionPointEstimation_configData().e2Sum);
    }

    /**
     * test with the max value for decrease -> all "positive" paths run
     */
    @Test
    void decreaseFactorsCleanMax(){
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "test_effort_max.xml"; // fixed path relative
        File xmlFile = new File(path);

        M_PROJECTDATA projectData = new M_PROJECTDATA();
        projectData = m__import.importProject(path);
        projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData());

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);
        controllerEffort.decreaseFactors(60);

        assertEquals(0, projectData.getM_projectData_functionPointEstimation_configData().e2Sum);
    }

    /**
     * test with a negative value for decrease -> out of boundaries
     */
    @Test
    void decreaseFactorsOutOfBounds(){
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "test.xml"; // fixed path relative
        File xmlFile = new File(path);

        M_PROJECTDATA projectData = new M_PROJECTDATA();
        projectData = m__import.importProject(path);
        projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData());

        /*if (xmlFile.exists()) {
            M_PROJECTDATA projectData = new M_PROJECTDATA();
            if (path instanceof String) {
                try{
                    projectData = m__import.importProject(path);
                    projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData());
                }
                catch(InvalidPathException e)
                {
                    e.getStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Sie müssen einen korrekten Dateipfad angeben",
                            "Achtung",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "Sie müssen einen korrekten Dateipfad angeben",
                        "Achtung",
                        JOptionPane.WARNING_MESSAGE);
            }
//            I_C_FRAME controllerFrame = C_FRAME.getInstance();
//            controllerFrame.setLinks(projectData, this, path);//new C_FRAME(new M_PROJECTDATA(), this, path);
            controllerEffort = C_EFFORT.getInstance();
            controllerEffort.setLinks(null, projectData);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Sie müssen einen korrekten Dateipfad angeben",
                    "Achtung",
                    JOptionPane.WARNING_MESSAGE);
        }*/

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        assertThrows(IllegalArgumentException.class, () -> controllerEffort.decreaseFactors(-5));
    }
}