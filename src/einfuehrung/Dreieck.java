package einfuehrung;

import java.util.Scanner;

public class Dreieck {

    /** Seitenlaengen des Dreiecks
     *  als globale Variablen
     */
    public static double a,b,c;

    /**
     * Liest die drei Seitenlaengen eines Dreiecks vom Benutzer ein
     */
    public static void seitenEinlesen() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1. Seite :");
        a = sc.nextDouble();
        System.out.print("2. Seite :");
        b = sc.nextDouble();
        System.out.print("3. Seite :");
        c = sc.nextDouble();
        sc.close();
    }

    /** Sortiert die Seitenlaengen a,b,c
     *  so dass a <= b <= c gilt
     */
    public static void sortiereSeiten() {
        double h;
        if (a > b) { h = a; a = b; b = h; }
        if (a > c) { h = a; a = c; c = h; }
        // Nun ist a sicher die kleinste Seite
        if (b > c) { h = b; b = c; c = h; }
        // Nun ist auch b <= c
    }

    /**
     * Bestimmt die Art des Dreiecks anhand der Seitenlaengen a,b,c
     */
    public static void dreiecksBestimmung() {
        double tol = 0.1; // Toleranz in Prozent
        if (equals(a,c,tol)) System.out.println("gleichseitiges Dreieck");
        else if (equals(c,Math.sqrt(a*a+b*b),tol) && equals(a,b,tol)) System.out.println("gleichschenkelig rechtwinkeliges Dreieck");
        else if (equals(a,b,tol) || equals(b,c,tol)) System.out.println("gleichschenkliges Dreieck");
        else if (equals(c,Math.sqrt(a*a+b*b),tol)) System.out.println("rechtwinkeliges Dreieck");
        else if (a+b>c) System.out.println("allgemeines Dreieck");
        else System.out.println("kein Dreieck");
    }

    /**
     * Vergleicht zwei Gleitkommazahlen auf Gleichheit
     * unter Beruecksichtigung einer Toleranz
     * @param x erste Zahl
     * @param y zweite Zahl
     * @param tol Toleranz in Prozent
     * @return true, wenn x und y innerhalb der Toleranz gleich sind
     */
    public static boolean equals(double x, double y, double tol) {
        double aR = Math.abs(x-y)/Math.max(Math.abs(x),Math.abs(y))*100.;
        boolean result = aR < tol;
        return result;
    }

    public static void main(String[] args) {
        seitenEinlesen();
        sortiereSeiten();
        System.out.printf("Seitenlaengen sortiert: a=%.7f b=%.7f c=%.7f\n",a,b,c);
        dreiecksBestimmung();
    }

}
