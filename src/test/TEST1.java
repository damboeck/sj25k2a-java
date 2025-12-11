package test;

/**
 * Einfaches Quadrat malen
 */
public class TEST1 {

    /**
     * Ober- und Unterseite malen
     * @param size Größe der Seite
     */
    public static void paintA(int size) {
        System.out.print("+");
        for (int i=0;i<size;i++)
            System.out.print("-");
        System.out.println("+");
    }
    /**
     * Seiten malen
     * @param size Größe der Seite
     */
    public static void paintB(int size) {
        System.out.print("|");
        for (int i=0;i<size;i++)
            System.out.print(" ");
        System.out.println("|");
    }

    /**
     * Quadrat malen
     * @param size Größe des Quadrats
     */
    public static void paintQuadrat(int size) {
        paintA(size);
        for (int i=0;i<size;i++)
            paintB(size);
        paintA(size);
    }

    public static void main(String[] args) {
        paintQuadrat(4);
        paintQuadrat(7);
    }

}
