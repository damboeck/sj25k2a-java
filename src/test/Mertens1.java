package test;

public class Mertens1 {

    public static void paintQuadrat(int size) {
        if (size < 1) {
            System.out.println("Größe muss mindestens 1 sein!");
            return;
        }
        System.out.print("+");
        for (int i = 0; i < size; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        for (int i = 0; i < size; i++) {
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }

        System.out.print("+");
        for (int i = 0; i < size; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    public static void main(String[] args) {
        System.out.println("Test mit Größe 4:");
        paintQuadrat(7);
    }
}
