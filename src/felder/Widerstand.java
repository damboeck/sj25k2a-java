package felder;

import java.util.Scanner;

/**
 * Berechne den Serien und Parallelwiderstand von beliebig vielen Widerständen
 */
public class Widerstand {

    /**
     * Berechnet den Parallelwiderstand aus einem Array von Widerständen
     * @param r Array von Widerständen
     * @return  Parallelwiderstand
     */
    public static double berechneParallelWiderstand(double[] r) {
        double rpar = 0;
        for (double rx:r) {
            rpar += 1.0/rx;
        }
        rpar = 1.0/rpar;
        return rpar;
    }

    /**
     * Berechnet den Serienwiderstand aus einem Array von Widerständen
     * @param r Array von Widerständen
     * @return  Serienwiderstand
     */
    public static double berechneSerienWiderstand(double[] r) {
        double rser = 0;
        for (double rx:r) {
            rser += rx;
        }
        return rser;
    }

    public static void main(String[] args) {
        double[] r;
        int anzahl;
        double rser;
        double rpar;
        Scanner sc = new Scanner(System.in);

        System.out.print("Anzahl der Widerstände: ");
        anzahl = sc.nextInt();
        r = new double[anzahl];
        for (int i=0; i<anzahl; i++) {
            System.out.print("Widerstand R"+(i+1)+" in Ohm: ");
            r[i] = sc.nextDouble();
        }
        //Berechnung Serienwiderstand
        rser = 0;
        for (int i=0;i<r.length;i++) {
            double rx = r[i];
            rser += rx;
        }
        System.out.printf("Serienwiderstand: %f Ohm\n",rser);
        // nochmals mit foreach
        rser=0;
        for (double rx:r) {
            rser += rx;
        }
        System.out.printf("Serienwiderstand: %f Ohm\n",rser);
        // Parallelwiderstand
        rpar = berechneParallelWiderstand(r);
        System.out.printf("Parallelwiderstand: %f Ohm\n",rpar);
    }
}
