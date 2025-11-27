package schleifen;

public class Dreieck1 {

    /**
     * Gibt ein rechtwinkliges Dreieck der Größe size aus Sternen aus.
     * @param size Die Größe des Dreiecks (Anzahl der Zeilen)
     */
    public static void dreieck1(int size) {
        for (int z=0;z<size;z++) {
            for (int s=0;s<z+1;s++)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void dreieck1_v2(int size) {
        for (int z=0;z<size;z++) {
            for (int s=0;s<size;s++) {
                System.out.print(z<s ? " " : "*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        dreieck1_v2(4);
        System.out.println();
        dreieck1_v2(6);
    }
}
