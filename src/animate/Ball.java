package animate;

import animate.fixElements.FixElement;
import animate.fixElements.FixHLine;
import animate.fixElements.FixVLine;
import paintprogramm.Paintable;

import java.awt.*;

public class Ball implements Paintable,Animateable {

    private static final double gummiR = 0.85;
    private static final double gummiB = 0.95;

    private Color  color;
    private double r;
    // Position
    private Vect2D m,mOld;
    // Geschwindigkeit
    private Vect2D v,vOld;
    // Beschleunigung
    private Vect2D a,aOld;

    public Ball(Color c, double r, Vect2D m, Vect2D v, Vect2D a) {
        this.color = c;
        this.r = r;
        this.m = m;
        this.v = v;
        this.a = a;
        calcOld();
    }
    public Ball(Color c, double r, double mx, double my, double vx, double vy, double ax,double ay) {
        this(c,r,new Vect2D(mx,my), new Vect2D(vx,vy), new Vect2D(ax,ay));
    }

    private void calcOld() {
        mOld = m;
        vOld = v;
        aOld = a;
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(color);
        g.fillOval((int)(m.x-r), (int)(m.y-r), (int)(2*r), (int)(2*r));
    }

    @Override
    public void move(double deltaTimeMs) {
        calcOld();
        v = vOld.add(aOld.mult(deltaTimeMs));
        m = mOld.add(vOld.mult(deltaTimeMs));
        // Beschleunigung wird aktuell nicht verändert
    }

    @Override
    public void collision(FixElement f) {
        if (f instanceof FixHLine) {
            double y = ((FixHLine)f).getY();
            if (mOld.y<y-r && m.y>=y-r) { // Reflexion nach oben
                v = new Vect2D(vOld.x* gummiB, -vOld.y*gummiR);
                m = new Vect2D(m.x, 2*y-2*r-m.y);
            } else if (mOld.y>y+r && m.y<=y+r) { // Reflexion nach unten
                v = new Vect2D(v.x* gummiB, -v.y*gummiR);
                m = new Vect2D(m.x, 2*y+2*r-m.y);
            }
        } else if (f instanceof FixVLine) {
            double x = ((FixVLine)f).getX();
            if (mOld.x<x-r && m.x>=x-r) { // Reflexion nach rechts
                v = new Vect2D(-v.x*gummiR, v.y* gummiB);
                m = new Vect2D(2*x-2*r-m.x, m.y);
            } else if (mOld.x>x+r && m.x<=x+r) { // Reflexion nach links
                v = new Vect2D(-v.x*gummiR, v.y* gummiB);
                m = new Vect2D(2*x+2*r-m.x, m.y);
            }
        } else throw new RuntimeException("Unbekanntes FixElement");
    }

    public void collide(Ball b) {
       double d = m.sub(b.m).abs();
       if (d<r+b.r) {
           
       }
    }

}
