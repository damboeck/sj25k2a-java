package einfuehrung;

import java.util.Scanner;

/**
 * Entwickle ein Java-Programm, welches folgende Aufgabenstellung erfüllt:
 *
 * Lies vom Benutzer einen Winkel in Grad ein und gib den Winkel in Radiant aus.
 *
 * Verwende eine formatierte Ausgabe mit vier Nachkommastellen!
 */
public class Winkel {

    public static void main(String[] args) {
        double winkelRad,winkelGrad;
        Scanner sc=new Scanner(System.in);
        System.out.print("Gib den Winkel in Grad ein:");
        winkelGrad =  sc.nextDouble();
        winkelRad = winkelGrad*Math.PI/180.0;
        System.out.printf("Rad : %.4f\n",winkelRad);
        // Bereinigung
        sc.close();
    }
}
