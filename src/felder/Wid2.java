package felder;

import java.util.Scanner;

public class Wid2 {

    public static double[] einlesenVonWiderstandswerten() {
        double[] r;
        int anzahl;
        Scanner sc = new Scanner(System.in);
        System.out.print("Anzahl der Widerstandswerte: ");
        anzahl = sc.nextInt();
        r = new double[anzahl];
        for (int i = 0; i < anzahl; i++) {
            System.out.print("Widerstandswert " + (i + 1) + " in Ohm: ");
            r[i] = sc.nextDouble();
        }
        return r;
    }

    public static boolean wiederholen() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Möchten Sie eine weitere Berechnung durchführen? (j/n): ");
        String antwort = sc.nextLine();
        return antwort.equalsIgnoreCase("j");
    }

    public static void main(String[] args) {
        double[] r;
        do {
            r = einlesenVonWiderstandswerten();
            double rser = Widerstand.berechneSerienWiderstand(r);
            double rpar = Widerstand.berechneParallelWiderstand(r);
            System.out.printf("Gesamtwiderstand in Serie: %.2f Ohm\n", rser);
            System.out.printf("Gesamtwiderstand Parallel: %.2f Ohm\n", rpar);
        } while (wiederholen());
    }
}
