package paintprogramm.elements;

import paintprogramm.Paintable;
import paintprogramm.Selectable;
import paintprogramm.symbole.LINESTYLE;

import java.awt.*;

public abstract class Zweipunkt
        implements
        Paintable,
        Selectable {

    private Color     drawColor;
    private int       lineWidth = 1;
    private LINESTYLE lineStyle = LINESTYLE.LINIE;
    protected Point   p1, p2;
    private boolean   selected;

    public Zweipunkt(Point p1, Point p2, Color drawColor, int lineWidth, LINESTYLE lineStyle) {
        this.p1 = p1;
        this.p2 = p2;
        this.drawColor = drawColor;
    }

    public Color getDrawColor() {
        return drawColor;
    }

    public void setDrawColor(Color drawColor) {
        this.drawColor = drawColor;
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public LINESTYLE getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(LINESTYLE lineStyle) {
        this.lineStyle = lineStyle;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public boolean isSelected() {
        return selected;
    }

    public void    setSelected(boolean b) {
        this.selected = b;
    }

}
