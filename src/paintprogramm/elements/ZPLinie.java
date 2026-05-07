package paintprogramm.elements;

import paintprogramm.PointTools;
import paintprogramm.symbole.LINESTYLE;

import java.awt.*;

public class ZPLinie extends Zweipunkt {

    public ZPLinie(Point p1, Point p2, Color drawColor, int lineWidth, LINESTYLE lineStyle) {
        super(p1, p2, drawColor, lineWidth, lineStyle);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(getDrawColor());
        if (isSelected()) g.setColor(Color.gray);
        g.setStroke(new BasicStroke(getLineWidth()));
        g.drawLine(getP1().x, getP1().y, getP2().x, getP2().y);
    }

    @Override
    public boolean select(Point mc) {
        double n = PointTools.normalAbstandPunktGerade(p1,p2,mc);
        double a = PointTools.abstand(p2,mc);
        double b = PointTools.abstand(p1,mc);
        double l = PointTools.abstand(p1,p2);
        double delta = 5;
        return (a+b)<(l+delta) && n<delta;
    }

}
