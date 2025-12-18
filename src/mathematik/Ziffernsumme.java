package mathematik;

public class Ziffernsumme {

    public static int countCorrectTests = 0;
    public static int countFailedTests = 0;

    /**
     * Berechnet die Ziffernsumme einer Zahl
     * @param    z  Zahl
     * @return   Ziffernsumme von z
     */
    public static int zs(int z) {
        int zs;
        for (zs=0;z!=0;z/=10) {
            zs += z % 10;
        }
        return zs;
    }

    public static void testeZiffernsumme(int zahl, int erwarteteZs) {
        int berechneteZs = zs(zahl);
        if (berechneteZs != erwarteteZs) {
            System.out.println("Fehler bei Ziffernsumme von " + zahl + ": " + berechneteZs + " != " + erwarteteZs);
            countFailedTests++;
        } else {
            countCorrectTests++;
        }
    }

    public static void main(String[] args) {
        testeZiffernsumme(0, 0);
        testeZiffernsumme(5, 5);
        testeZiffernsumme(9, 9);
        testeZiffernsumme(10, 1);
        testeZiffernsumme(22345,16);
        testeZiffernsumme(-38, -11);
        testeZiffernsumme(12345, 15);
        testeZiffernsumme(99999, 45);
        testeZiffernsumme(100000, 1);
        System.out.println("Tests abgeschlossen. Korrekte Tests: " + countCorrectTests + ", fehlgeschlagene Tests: " + countFailedTests);
    }

}
