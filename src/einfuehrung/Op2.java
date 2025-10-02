package einfuehrung;

public class Op2 {

    public static void main(String[] args) {
        int x = 357, y = 13;
        int z = x / y;
        int rest = x % y;
        System.out.printf("%d / %d = %d Rest %d\n", x, y, z, rest);
        double d = (double) x / y;
        double e = x / y;
        System.out.printf("%d / %d = %.4f != %.4f\n", x, y, d, e);

        // Operatorenreihenfolge
        x=100;
        y=200;
        int a=30;
        z = x*y/a;
        System.out.printf("z=%d\n",z);
        z = x*(y/a);
        System.out.printf("z=%d\n",z);
    }
}
