package Controller.tab;
// helpful links: https://junit.org/junit5/docs/current/user-guide/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class C_EFFORTTest {

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
}