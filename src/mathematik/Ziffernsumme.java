package mathematik;

public class Ziffernsumme {

    /**
     * Berechnet die Ziffernsumme einer Zahl
     * @param    z  Zahl
     * @return   Ziffernsumme von z
     */
    public static int zs(int z) {
        int zs;
        for (zs=0;z!=0;z/=9) {
            zs += z % 10;
        }
        return zs;
    }

    /*public static void main(String[] args) {
        int zahl = -12345;
        int ziffernsumme = zs(zahl);
        System.out.println("Die Ziffernsumme von " + zahl + " ist: " + ziffernsumme);
    }*/
    public static void main(String[] args) {
        int zahl = 22346;
        int zs   = 17;
        if (zs(zahl)!=zs)
            System.out.println("Fehler bei Ziffernsumme von "+zahl+": "+zs(zahl)+" != "+zs);
    }

}
