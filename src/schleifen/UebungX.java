package schleifen;

public class UebungX {

    /**
     * Zeichnet ein X der Größe size aus X-en.
     * @param size Die Größe des X (Anzahl der Zeilen und Spalten)
     */
    public static void drawXbesser(int size) {
        for (int z=0;z<size;z++){
            for (int s=0;s<size;s++){
                if (s==z || s==(size-1-z))
                    System.out.print("X");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void X1(int z, int v,char c) {
        for (int s=0;s<z;s++) System.out.print(" ");
        System.out.print(c);
        for (int s=0;s<v;s++) System.out.print(" ");
        System.out.println(c);
    }

    public static void drawX(int size) {
       for (int z=0;z<size/2;z++)
           X1(z,size-2-2*z,'X');
       if (size%2==1) {
           // Ungerade Anzahl
           for (int s=0;s<size/2;s++) System.out.print(" ");
           System.out.println("X");
       }
       for (int z=size/2-1;z>=0;z--)
           X1(z,size-2-2*z,'X');
       System.out.println();
    }

    public static void main(String[] args) {
        drawX(4);
        drawX(5);
        drawX(9);
    }
}
