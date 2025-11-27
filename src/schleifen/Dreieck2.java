package schleifen;

public class Dreieck2 {

    /**
     * Gibt ein rechtwinkliges Dreieck der Größe size aus Sternen aus.
     * @param size Die Größe des Dreiecks (Anzahl der Zeilen)
     */
    public static void dreieck2(int size) {
        for (int z=0;z<size;z++) {
            for (int s=0;s<size-z-1;s++)
                System.out.print(" ");
            for (int s=0;s<z+1;s++)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void dreieck2_v2(int size) {
        for (int z=0;z<size;z++) {
            for (int s=0;s<size;s++) {
                System.out.print(z<(size-s-1) ? " " : "*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        dreieck2(4);
        System.out.println();
        dreieck2(6);
        System.out.println();
        dreieck2_v2(4);
        System.out.println();
        dreieck2_v2(6);
    }
}
