package paintprogramm.elements;

import paintprogramm.symbole.LINESTYLE;

import java.awt.*;

public class ZPLinie extends Zweipunkt {

    public ZPLinie(Point p1, Point p2, Color drawColor, int lineWidth, LINESTYLE lineStyle) {
        super(p1, p2, drawColor, lineWidth, lineStyle);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(getDrawColor());
        g.setStroke(new BasicStroke(getLineWidth()));
        g.drawLine(getP1().x, getP1().y, getP2().x, getP2().y);
    }

}
