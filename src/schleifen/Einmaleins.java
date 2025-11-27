package schleifen;

public class Einmaleins {

    public static void main(String[] args) {
        for (int z=1; z<=10; z++){
            //System.out.println("z="+z);
            for (int s=1; s<=10;s++){
                int e = z*s;
                System.out.printf("%2dx%2d=%3d ",s,z,e);
            }
            System.out.println();
        }
    }
}
