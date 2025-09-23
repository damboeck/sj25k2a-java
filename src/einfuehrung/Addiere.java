package einfuehrung;

import java.util.Scanner;

/**
 * Das Programm soll eine Addition auf den Bildschirm schreiben
 */
public class Addiere {

    public static void main(String[] args) {
        int x,y,summe;
        Scanner sc=new Scanner(System.in);
        System.out.print("Gib x ein:");
        x=sc.nextInt();
        System.out.print("Gib y ein:");
        y=sc.nextInt();
        //Berechne
        summe=x+y;
        // Ausgabe
        System.out.printf("Erste Zahl: %d\n",x);
        System.out.printf("Zweite Zahl: %d\n",y);
        System.out.printf("Summe: %d",summe);
    }
}
