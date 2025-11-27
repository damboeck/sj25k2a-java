package einfuehrung;

public class Demo03 {

    public static void main(String[] args) {
        Dreieck.a=7;
        Dreieck.b=2;
        Dreieck.c=5;
        Dreieck.sortiereSeiten();
        System.out.printf("a=%f, b=%f, c=%f\n", Dreieck.a,Dreieck.b,Dreieck.c);

    }
}
