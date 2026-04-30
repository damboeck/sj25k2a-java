package paintprogramm.elements;

import paintprogramm.symbole.LINESTYLE;

import java.awt.*;

public class ZPRect extends ZPF {

    public ZPRect(Point p1, Point p2, Color drawColor, Color fillColor, int lineWidth, LINESTYLE lineStyle) {
        super(p1, p2, drawColor, fillColor, lineWidth, lineStyle);
    }

    @Override
    public void paint(Graphics2D g) {
        int  left   = Integer.min(getP1().x,getP2().x);
        int  top    = Integer.min(getP1().y,getP2().y);
        int  width  = Integer.max(getP1().x,getP2().x) - left;
        int  height = Integer.max(getP1().y,getP2().y) - top;
        g.setColor(getFillColor());
        g.fillRect(left,top,width,height);
        g.setColor(getDrawColor());
        g.setStroke(new BasicStroke(getLineWidth()));
        g.drawRect(left,top,width,height);
    }

}
