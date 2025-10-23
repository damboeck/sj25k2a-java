package verzweigungen;

import java.util.Scanner;

public class Rechteck {

    public static void main(String[] args) {
        double a,b;
        Scanner sc=new Scanner(System.in);
        System.out.print("1. Seite :");
        a=sc.nextDouble();
        System.out.print("2. Seite :");
        b=sc.nextDouble();
        if (a==b) {
            System.out.println("Das ist ein Quadrat!");
        } else {
            System.out.println("Das ist ein Rechteck!");
        }

        // Auch möglich aber viel zu lange - schlecht lesbar!
        if (a==b) System.out.println("Das ist ein Quadrat!"); else System.out.println("Das ist ein Rechteck!");

        // Auch möglich - besser lesbar
        if (a==b) System.out.println("Das ist ein Quadrat!");
        else      System.out.println("Das ist ein Rechteck!");

    }

}
