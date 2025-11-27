package einfuehrung;

public class Demo02 {

    public static void main(String[] args) {
        double a,b;
        a=Math.sqrt(2.5*2.5+3*3);
        b=3.9;
        if (Dreieck.equals(a,b,0.1)) System.out.println("gleich");
        else System.out.println("ungleich");
    }
}
