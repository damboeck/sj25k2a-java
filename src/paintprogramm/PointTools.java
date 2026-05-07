package paintprogramm;

import java.awt.*;

public class PointTools {

    /**
     * Abstand eines Punktes zu einer geraden definiert durch zwei Punkte
     * @param p1  erster Punkt der Geraden
     * @param p2  zweiter Punkt der Geraden
     * @param p   Punkt zu dem der Abstand berechnet werden soll
     * @return    Abstand
     */
    public static double normalAbstandPunktGerade(Point p1, Point p2, Point p) {
        double Z = Math.abs((p2.x-p1.x)*(p1.y-p.y)-(p1.x-p.x)*(p2.y-p1.y));
        double N = abstand(p1,p2);
        return Z/N;
    }

    public static double abstand(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x-p1.x,2)+Math.pow(p2.y-p1.y,2));
    }
}
