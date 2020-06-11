/**
 * @autor: Florian
 * Responsible: Florian
 * Last edit date: 10.06.2020
 */

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

    /**
     * this method tests the path where the e2Sum doesn't need to be decreased or increased
     * as it is already corresponding the goal sum
     * e2Sum = 10
     * e2Correction = 10
     */
    @Test
    void notifyAdjustFactorsEqual(){
        int e2Sum = 10;
        int e2Correction = 10;
        String expectedOutput = "No failure to correct";

        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_adjustFactors.xml"; // fixed path relative
        File xmlFile = new File(path);

        M_PROJECTDATA projectData = new M_PROJECTDATA();
        projectData = m__import.importProject(path);
        projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData());
        projectData.getM_projectData_functionPointEstimation_configData().setE2Sum(e2Sum);
        projectData.getM_projectData_functionPointEstimation().setE2Correction(e2Correction);

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        assertEquals(expectedOutput, controllerEffort.notifyAdjustFactors());
    }

    /**
     * this method tests the path when e2Sum needs to and can be decreased
     * e2Sum = 10
     * e2Correction = 5
     */
    @Test
    void notifyAdjustFactorsDecreaseCorrected(){
        int e2Sum = 10;
        int e2Correction = 5;
        String expectedOutput = "e2Sum needs to be decreased - Corrected factors";

        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_adjustFactors.xml"; // fixed path relative
        File xmlFile = new File(path);

        M_PROJECTDATA projectData = new M_PROJECTDATA();
        projectData = m__import.importProject(path);
        projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData());
        projectData.getM_projectData_functionPointEstimation_configData().setE2Sum(e2Sum);
        projectData.getM_projectData_functionPointEstimation().setE2Correction(e2Correction);

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        assertEquals(expectedOutput, controllerEffort.notifyAdjustFactors());
    }

    /**
     * this method tests the path when e2Sum needs to but can't be decreased
     * e2Sum = 10
     * e2Correction = -10
     */
    @Test
    void notifyAdjustFactorsDecreaseFailed(){
        int e2Sum = 10;
        int e2Correction = -10;
        String expectedOutput = "e2Sum needs to be decreased - Failure can't be corrected by just adjusting factors";

        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_adjustFactors.xml"; // fixed path relative
        File xmlFile = new File(path);

        M_PROJECTDATA projectData = new M_PROJECTDATA();
        projectData = m__import.importProject(path);
        projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData());
        projectData.getM_projectData_functionPointEstimation_configData().setE2Sum(e2Sum);
        projectData.getM_projectData_functionPointEstimation().setE2Correction(e2Correction);

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        assertEquals(expectedOutput, controllerEffort.notifyAdjustFactors());
    }

    /**
     * this method tests the path when e2Sum needs to and can be increased
     * e2Sum = 5
     * e2Correction = 10
     */
    @Test
    void notifyAdjustFactorsIncreaseCorrected(){
        int e2Sum = 5;
        int e2Correction = 10;
        String expectedOutput = "e2Sum needs to be increased - Corrected factors";

        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_adjustFactors.xml"; // fixed path relative
        File xmlFile = new File(path);

        M_PROJECTDATA projectData = new M_PROJECTDATA();
        projectData = m__import.importProject(path);
        projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData());
        projectData.getM_projectData_functionPointEstimation_configData().setE2Sum(e2Sum);
        projectData.getM_projectData_functionPointEstimation().setE2Correction(e2Correction);

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        assertEquals(expectedOutput, controllerEffort.notifyAdjustFactors());
    }

    /**
     * this method tests the path when e2Sum needs to but can't be increased
     * e2Sum = 10
     * e2Correction = 80
     */
    @Test
    void notifyAdjustFactorsIncreaseFailed(){
        int e2Sum = 10;
        int e2Correction = 80;
        String expectedOutput = "e2Sum needs to be increased - Failure can't be corrected by just adjusting factors";

        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_adjustFactors.xml"; // fixed path relative
        File xmlFile = new File(path);

        M_PROJECTDATA projectData = new M_PROJECTDATA();
        projectData = m__import.importProject(path);
        projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData());
        projectData.getM_projectData_functionPointEstimation_configData().setE2Sum(e2Sum);
        projectData.getM_projectData_functionPointEstimation().setE2Correction(e2Correction);

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        assertEquals(expectedOutput, controllerEffort.notifyAdjustFactors());
    }

    @Test
    void increaseFactors() {
        /**
         * e2Sum und e2Goal beide Integer -> ganze Zahlen
         *
         * Äquivalenzklassen:
         *
         *      1. increase >= 0 und e2Sum + increase <= 60
         *          -> Methode ausführen mit z.B. 0 und 60 als maximale Werte und 0 bzw. 60 am Ende für e2Sum
         *
         *      2. increase <0 oder e2Sum + increase > 60
         *          -> Methode ausführen mit z.B. -1 und IllegalArgumentException erwarten
         */
    }

    /**
     * test with the min value 0 for increase -> e2Sum should not be changed
     */
    @Test
    void increaseFactorsCleanMin() {
        int increaseValue = 0;
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_effort_zero.xml"; // fixed path relative
        File xmlFile = new File(path);

        M_PROJECTDATA projectData = new M_PROJECTDATA();
        projectData = m__import.importProject(path);
        projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData());
        int e2SumStart = projectData.getM_projectData_functionPointEstimation_configData().getE2Sum();   // speichert e2Sum zu Beginn zwischen

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);
        controllerEffort.increaseFactors(increaseValue);

        assertEquals(e2SumStart + increaseValue, projectData.getM_projectData_functionPointEstimation_configData().getE2Sum());
    }

    /**
     * test with the max value for increase -> all "positive" paths run
     */
    @Test
    void increaseFactorsCleanMax() {
        int increaseValue = 60;
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_effort_zero.xml"; // fixed path relative
        File xmlFile = new File(path);

        M_PROJECTDATA projectData = new M_PROJECTDATA();
        projectData = m__import.importProject(path);
        projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData());
        int e2SumStart = projectData.getM_projectData_functionPointEstimation_configData().getE2Sum();   // speichert e2Sum zu Beginn zwischen

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);
        controllerEffort.increaseFactors(increaseValue);

        assertEquals(e2SumStart + increaseValue, projectData.getM_projectData_functionPointEstimation_configData().getE2Sum());
    }

    /**
     * test with a negative value for increase -> out of bounds
     */
    @Test
    void increaseFactorsOutOfBounds() {
        int increaseValue = -1;
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_effort_zero.xml"; // fixed path relative
        File xmlFile = new File(path);

        M_PROJECTDATA projectData = new M_PROJECTDATA();
        projectData = m__import.importProject(path);
        projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData());

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        assertThrows(IllegalArgumentException.class, () -> controllerEffort.decreaseFactors(-5));
    }

    @Test
    void decreaseFactors() {
        /**
         * e2Sum und e2Goal beide Integer -> ganze Zahlen
         *
         * Äquivalenzklassen:
         *      1. decrease >= 0 und (e2Sum - deccrease) >= 0
         *          -> Methode ausführen mit z.B. 0 und 60 als maximale Werte und (e2SumStart - 0) bzw. (e2SumStart - 60) am Ende für e2Sum
         *
         *      2. decrease < 0 oder (e2Sum - decrease) <= 0
         *          -> Methode ausführen mit z.B. -1 und IllegalArgumentException erwarten
         */
    }

    /**
     * test with the min value for decrease -> e2Sum should not be changed
     */
    @Test
    void decreaseFactorsCleanMin() {
        int decreaseValue = 0;
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_effort_max.xml"; // fixed path relative
        File xmlFile = new File(path);

        M_PROJECTDATA projectData = new M_PROJECTDATA();
        projectData = m__import.importProject(path);
        projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData());
        int e2SumStart = projectData.getM_projectData_functionPointEstimation_configData().getE2Sum();   // speichert e2Sum zu Beginn zwischen

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);
        controllerEffort.decreaseFactors(decreaseValue);

        assertEquals(e2SumStart - decreaseValue, projectData.getM_projectData_functionPointEstimation_configData().getE2Sum());
    }

    /**
     * test with the max value for decrease -> all "positive" paths run
     */
    @Test
    void decreaseFactorsCleanMax() {
        int decreaseValue = 60;
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_effort_max.xml"; // fixed path relative
        File xmlFile = new File(path);

        M_PROJECTDATA projectData = new M_PROJECTDATA();
        projectData = m__import.importProject(path);
        projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData());
        int e2SumStart = projectData.getM_projectData_functionPointEstimation_configData().getE2Sum();   // speichert e2Sum zu Beginn zwischen

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);
        controllerEffort.decreaseFactors(decreaseValue);

        assertEquals(e2SumStart - decreaseValue, projectData.getM_projectData_functionPointEstimation_configData().getE2Sum());
    }

    /**
     * test with a negative value for decrease -> out of boundaries
     */
    @Test
    void decreaseFactorsOutOfBounds() {
        int decreaseValue = -1;
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_effort_max.xml"; // fixed path relative
        File xmlFile = new File(path);

        M_PROJECTDATA projectData = new M_PROJECTDATA();
        projectData = m__import.importProject(path);
        projectData.setM_projectData_functionPointEstimation_configData(projectData.getM_projectData_functionPointEstimation_configData());

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        assertThrows(IllegalArgumentException.class, () -> controllerEffort.decreaseFactors(decreaseValue));
    }
}