package oop;

public class TestComplex1 {

    public static void main(String[] args) {
        Complex c1;
        Complex c2;
        Complex c3;
        Complex c4;
        c1 = new Complex(2,3);
        c2 = new Complex(4);
        c3 = new Complex(-2,-4);
        c4 = Complex.createImaginary(5);
        System.out.println("c1 = "+c1);
        System.out.println("c2 = "+c2);
        System.out.println("c3 = "+c3);
        System.out.println("c4 = "+c4);
        c1.setAbs(7);
        System.out.println("c1 nach setAbs(7) = "+c1);
    }
}
