package CONTROLLER.TAB;

import MODEL.M_IMPORT;
import MODEL.PROJECTDATA.M_PROJECTDATA;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test optimisation module in C_EFFORT
 */
class C_EFFORT_TEST {

    /**
     * this test shows Zweigüberdeckung as the correct value is calculated correctly and the if Zweig therefore was run
     *
     * the test file is initialized with:
     * double realTime = 4.0;
     * int jonesPersonNo = 1;
     * int e1Sum = 38;
     * double expectedE2 = 14;
     */
    @Test
    void calcE2NeededClean(){
        System.out.println("    /**\n" +
                "     * this test shows Zweigüberdeckung as the correct value is calculated correctly and the if Zweig therefore was run\n" +
                "     *\n" +
                "     * the test file is initialized with:\n" +
                "     * double realTime = 4.0;\n" +
                "     * int jonesPersonNo = 1;\n" +
                "     * int e1Sum = 38;\n" +
                "     * double expectedE2 = 14;\n" +
                "     */");
        double realTime = 4.0;
        int jonesPersonNo = 1;
        int e1Sum = 38;
        double expectedE2 = 14;
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_calcE2Needed.xml"; // fixed path to calcE2Needed file
        File xmlFile = new File(path);

        M_PROJECTDATA projectData;
        projectData = m__import.importProject(path);

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        projectData.getFunctionPointEstimation().calcE2Needed(realTime, jonesPersonNo, e1Sum); //calculation of e2Correction
        System.out.println("Test");
        assertEquals(expectedE2, projectData.getFunctionPointEstimation().getE2Correction());
    }

    /**
     * this test shows Zweigüberdeckung as the gets thrown and the else Zweig therefore was run
     *
     * the test file is initialized with:
     * double realTime = -1;
     * int jonesPersonNo = 1;
     * int e1Sum = 38;
     */
    @Test
    void calcE2NeededNegative(){
        System.out.println("    /**\n" +
                "     * this test shows Zweigüberdeckung as the gets thrown and the else Zweig therefore was run\n" +
                "     *\n" +
                "     * the test file is initialized with:\n" +
                "     * double realTime = -1;\n" +
                "     * int jonesPersonNo = 1;\n" +
                "     * int e1Sum = 38;\n" +
                "     */");
        double realTime = -1;
        int jonesPersonNo = 1;
        int e1Sum = 38;
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_calcE2Needed.xml"; // fixed path to calcE2Needed file
        File xmlFile = new File(path);

        M_PROJECTDATA projectData;
        projectData = m__import.importProject(path);

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        assertThrows(IllegalArgumentException.class, () -> projectData.getFunctionPointEstimation().calcE2Needed(realTime, jonesPersonNo, e1Sum));
    }

    /**
     * this test shows Zweigüberdeckung as the correct value is calculated and the if Zweig therefore was run
     *
     * the test file is initialized with:
     * double realTime = Double.MAX_VALUE;
     * System.out.println(realTime);
     * int jonesPersonNo = 1;
     * int e1Sum = 38;
     * double expectedE2 = Integer.MAX_VALUE;
     */
    @Test
    void calcE2NeededMax(){
        System.out.println("    /**\n" +
                "     * this test shows Zweigüberdeckung as the correct value is calculated and the if Zweig therefore was run\n" +
                "     *\n" +
                "     * the test file is initialized with:\n" +
                "     * double realTime = Double.MAX_VALUE;\n" +
                "     * System.out.println(realTime);\n" +
                "     * int jonesPersonNo = 1;\n" +
                "     * int e1Sum = 38;\n" +
                "     * double expectedE2 = Integer.MAX_VALUE;\n" +
                "     */");
        double realTime = Double.MAX_VALUE;
        int jonesPersonNo = 1;
        int e1Sum = 38;
        double expectedE2 = Integer.MAX_VALUE;
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_calcE2Needed.xml"; // fixed path to calcE2Needed file
        File xmlFile = new File(path);

        M_PROJECTDATA projectData;
        projectData = m__import.importProject(path);

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        projectData.getFunctionPointEstimation().calcE2Needed(realTime, jonesPersonNo, e1Sum); //calculation of e2Correction
        assertEquals(expectedE2, projectData.getFunctionPointEstimation().getE2Correction());
    }

    /**
     * this method tests the path when e2Sum needs to and can be decreased
     * e2Sum = 10
     * e2Correction = 5
     */
    @Test
    void notifyAdjustFactorsDecreaseCorrected() {
        System.out.println("    /**\n" +
                "     * this method tests the path when e2Sum needs to and can be decreased\n" +
                "     * e2Sum = 10\n" +
                "     * e2Correction = 5\n" +
                "     */");
        int e2Sum = 10;
        int e2Correction = 5;
        String expectedOutput = "e2Sum needs to be decreased - Corrected factors";

        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_adjustFactors.xml"; // fixed path to test file
        File xmlFile = new File(path);

        M_PROJECTDATA projectData;
        projectData = m__import.importProject(path);
        projectData.setFunctionPointEstimation_configData(projectData.getFunctionPointEstimation_configData());
        projectData.getFunctionPointEstimation_configData().setE2Sum(e2Sum);
        projectData.getFunctionPointEstimation().setE2Correction(e2Correction);

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
    void notifyAdjustFactorsDecreaseFailed() {
        System.out.println("    /**\n" +
                "     * this method tests the path when e2Sum needs to but can't be decreased\n" +
                "     * e2Sum = 10\n" +
                "     * e2Correction = -10\n" +
                "     */");
        int e2Sum = 10;
        int e2Correction = -10;
        String expectedOutput = "e2Sum needs to be decreased - Failure can't be corrected by just adjusting factors";

        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_adjustFactors.xml"; // fixed path to test file
        File xmlFile = new File(path);

        M_PROJECTDATA projectData;
        projectData = m__import.importProject(path);
        projectData.setFunctionPointEstimation_configData(projectData.getFunctionPointEstimation_configData());
        projectData.getFunctionPointEstimation_configData().setE2Sum(e2Sum);
        projectData.getFunctionPointEstimation().setE2Correction(e2Correction);

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
    void notifyAdjustFactorsIncreaseCorrected() {
        System.out.println("    /**\n" +
                "     * this method tests the path when e2Sum needs to and can be increased\n" +
                "     * e2Sum = 5\n" +
                "     * e2Correction = 10\n" +
                "     */");
        int e2Sum = 5;
        int e2Correction = 10;
        String expectedOutput = "e2Sum needs to be increased - Corrected factors";

        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_adjustFactors.xml"; // fixed path to test file
        File xmlFile = new File(path);

        M_PROJECTDATA projectData;
        projectData = m__import.importProject(path);
        projectData.setFunctionPointEstimation_configData(projectData.getFunctionPointEstimation_configData());
        projectData.getFunctionPointEstimation_configData().setE2Sum(e2Sum);
        projectData.getFunctionPointEstimation().setE2Correction(e2Correction);

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
    void notifyAdjustFactorsIncreaseFailed() {
        System.out.println("    /**\n" +
                "     * this method tests the path when e2Sum needs to but can't be increased\n" +
                "     * e2Sum = 10\n" +
                "     * e2Correction = 80\n" +
                "     */");
        int e2Sum = 10;
        int e2Correction = 80;
        String expectedOutput = "e2Sum needs to be increased - Failure can't be corrected by just adjusting factors";

        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_adjustFactors.xml"; // fixed path to test file
        File xmlFile = new File(path);

        M_PROJECTDATA projectData;
        projectData = m__import.importProject(path);
        projectData.setFunctionPointEstimation_configData(projectData.getFunctionPointEstimation_configData());
        projectData.getFunctionPointEstimation_configData().setE2Sum(e2Sum);
        projectData.getFunctionPointEstimation().setE2Correction(e2Correction);

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        assertEquals(expectedOutput, controllerEffort.notifyAdjustFactors());
    }

    /**
     * this method tests the path where the e2Sum doesn't need to be decreased or increased
     * as it is already corresponding the goal sum
     * e2Sum = 10
     * e2Correction = 10
     */
    @Test
    void notifyAdjustFactorsEqual() {
        System.out.println("    /**\n" +
                "     * this method tests the path where the e2Sum doesn't need to be decreased or increased\n" +
                "     * as it is already corresponding the goal sum\n" +
                "     * e2Sum = 10\n" +
                "     * e2Correction = 10\n" +
                "     */");
        int e2Sum = 10;
        int e2Correction = 10;
        String expectedOutput = "No failure to correct";

        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_adjustFactors.xml"; // fixed path to test file
        File xmlFile = new File(path);

        M_PROJECTDATA projectData = M_PROJECTDATA.getInstance();
        projectData = m__import.importProject(path);
        projectData.setFunctionPointEstimation_configData(projectData.getFunctionPointEstimation_configData());
        projectData.getFunctionPointEstimation_configData().setE2Sum(e2Sum);
        projectData.getFunctionPointEstimation().setE2Correction(e2Correction);

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        assertEquals(expectedOutput, controllerEffort.notifyAdjustFactors());
    }

    /**
     * test with the min value 0 for increase - e2Sum should not be changed
     */
    @Test
    void increaseFactorsCleanMin() {
        System.out.println("    /**\n" +
                "     * test with the min value 0 for increase - e2Sum should not be changed\n" +
                "     */");
        int increaseValue = 0;
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_effort_zero.xml"; // fixed path to test file where all factors are set to zero
        File xmlFile = new File(path);

        M_PROJECTDATA projectData;
        projectData = m__import.importProject(path);
        projectData.setFunctionPointEstimation_configData(projectData.getFunctionPointEstimation_configData());
        int e2SumStart = projectData.getFunctionPointEstimation_configData().getE2Sum();   // saves current value of e2Sum before running the desired function

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);
        controllerEffort.increaseFactors(increaseValue);

        assertEquals(e2SumStart, projectData.getFunctionPointEstimation_configData().getE2Sum());
    }

    /**
     * test with the max value for increase - all "positive" paths run
     */
    @Test
    void increaseFactorsCleanMax() {
        System.out.println("    /**\n" +
                "     * test with the max value for increase - all \"positive\" paths run\n" +
                "     */");
        int increaseValue = 60;
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_effort_zero.xml"; // fixed path to test file where all factors are set to zero
        File xmlFile = new File(path);

        M_PROJECTDATA projectData;
        projectData = m__import.importProject(path);
        projectData.setFunctionPointEstimation_configData(projectData.getFunctionPointEstimation_configData());
        int e2SumStart = projectData.getFunctionPointEstimation_configData().getE2Sum();   // saves current value of e2Sum before running the desired function

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);
        controllerEffort.increaseFactors(increaseValue);

        assertEquals(e2SumStart + increaseValue, projectData.getFunctionPointEstimation_configData().getE2Sum());
    }

    /**
     * test with a negative value for increase - out of bounds
     */
    @Test
    void increaseFactorsOutOfBounds() {
        System.out.println("    /**\n" +
                "     * test with a negative value for increase - out of bounds\n" +
                "     */");
        int increaseValue = -1;
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_effort_zero.xml"; // fixed path to test file where all factors are set to zero
        File xmlFile = new File(path);

        M_PROJECTDATA projectData;
        projectData = m__import.importProject(path);
        projectData.setFunctionPointEstimation_configData(projectData.getFunctionPointEstimation_configData());

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        assertThrows(IllegalArgumentException.class, () -> controllerEffort.decreaseFactors(-5));
    }

    /**
     * this method tests what happens when nothing can be increased, but increase greater 0
     * only happens if notify adjustFactors gets run with wrong value for e2Sum
     * e2Sum = 10
     * e2Correction = 60
     * increase = 50 all factors are already set to their maximum (test_effort_max.xml)
     */
    @Test
    void increaseFactorIteratorOutOfBounds() {
        System.out.println("    /**\n" +
                "     * this method tests what happens when nothing can be increased, but increase greater 0\n" +
                "     * only happens if notify adjustFactors gets run with wrong value for e2Sum\n" +
                "     * e2Sum = 10\n" +
                "     * e2Correction = 60\n" +
                "     * increase = 50 all factors are already set to their maximum (test_effort_max.xml)\n" +
                "     */");
        int e2Sum = 10;
        int e2Correction = 60;
        String expectedOutput = "e2Sum needs to be increased - Corrected factors";

        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_effort_max.xml"; // fixed path to test file where all factors are set to max
        File xmlFile = new File(path);

        M_PROJECTDATA projectData;
        projectData = m__import.importProject(path);
        projectData.setFunctionPointEstimation_configData(projectData.getFunctionPointEstimation_configData());
        projectData.getFunctionPointEstimation_configData().setE2Sum(e2Sum);
        projectData.getFunctionPointEstimation().setE2Correction(e2Correction);

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        assertThrows(RuntimeException.class, () -> controllerEffort.notifyAdjustFactors());
    }

    /**
     * test with the min value for decrease - e2Sum should not be changed
     */
    @Test
    void decreaseFactorsCleanMin() {
        System.out.println("    /**\n" +
                "     * test with the min value for decrease - e2Sum should not be changed\n" +
                "     */");
        int decreaseValue = 0;
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_effort_max.xml"; // fixed path to test file where all factors are set to max
        File xmlFile = new File(path);

        M_PROJECTDATA projectData;
        projectData = m__import.importProject(path);
        projectData.setFunctionPointEstimation_configData(projectData.getFunctionPointEstimation_configData());
        int e2SumStart = projectData.getFunctionPointEstimation_configData().getE2Sum();   // saves current value of e2Sum before running the desired function

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);
        controllerEffort.decreaseFactors(decreaseValue);

        assertEquals(e2SumStart, projectData.getFunctionPointEstimation_configData().getE2Sum());
    }

    /**
     * test with the max value for decrease - all "positive" paths run
     */
    @Test
    void decreaseFactorsCleanMax() {
        System.out.println("    /**\n" +
                "     * test with the max value for decrease - all \"positive\" paths run\n" +
                "     */");
        int decreaseValue = 60;
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_effort_max.xml"; // fixed path to test file where all factors are set to max
        File xmlFile = new File(path);

        M_PROJECTDATA projectData;
        projectData = m__import.importProject(path);
        projectData.setFunctionPointEstimation_configData(projectData.getFunctionPointEstimation_configData());
        int e2SumStart = projectData.getFunctionPointEstimation_configData().getE2Sum();   // speichert e2Sum zu Beginn zwischen

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);
        controllerEffort.decreaseFactors(decreaseValue);

        assertEquals(e2SumStart - decreaseValue, projectData.getFunctionPointEstimation_configData().getE2Sum());
    }

    /**
     * test with a negative value for decrease - out of boundaries
     */
    @Test
    void decreaseFactorsOutOfBounds() {
        System.out.println("    /**\n" +
                "     * test with a negative value for decrease - out of boundaries\n" +
                "     */");
        int decreaseValue = -1;
        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_effort_max.xml"; // fixed path to test file where all factors are set to max
        File xmlFile = new File(path);

        M_PROJECTDATA projectData;
        projectData = m__import.importProject(path);
        projectData.setFunctionPointEstimation_configData(projectData.getFunctionPointEstimation_configData());

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        assertThrows(IllegalArgumentException.class, () -> controllerEffort.decreaseFactors(decreaseValue));
    }

    /**
     * this method tests what happens when nothing can be decreased, but decrease greater 0
     * only happens if notify adjustFactors gets run with wrong value for e2Sum
     * e2Sum = 10
     * e2Correction = 5
     * int decrease = 5 all factors are already set to their minimum (0)  (test_effort_zero.xml)
     */
    @Test
    void decreaseFactorIteratorOutOfBounds() {
        System.out.println("    /**\n" +
                "     * this method tests what happens when nothing can be decreased, but decrease greater 0\n" +
                "     * only happens if notify adjustFactors gets run with wrong value for e2Sum\n" +
                "     * e2Sum = 10\n" +
                "     * e2Correction = 5\n" +
                "     * int decrease = 5 all factors are already set to their minimum (0)  (test_effort_zero.xml)\n" +
                "     */");
        int e2Sum = 10;
        int e2Correction = 5;
        String expectedOutput = "e2Sum needs to be decreased - Corrected factors";

        M_IMPORT m__import = new M_IMPORT();
        I_C_EFFORT controllerEffort;
        String path = "testFiles/test_effort_zero.xml"; // fixed path to test file where all factors are set to zero
        File xmlFile = new File(path);

        M_PROJECTDATA projectData;
        projectData = m__import.importProject(path);
        projectData.setFunctionPointEstimation_configData(projectData.getFunctionPointEstimation_configData());
        projectData.getFunctionPointEstimation_configData().setE2Sum(e2Sum);
        projectData.getFunctionPointEstimation().setE2Correction(e2Correction);

        controllerEffort = C_EFFORT.getInstance();
        controllerEffort.setLinks(null, projectData);

        assertThrows(RuntimeException.class, () -> controllerEffort.notifyAdjustFactors());
    }
}