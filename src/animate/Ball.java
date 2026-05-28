package animate;

import paintprogramm.Paintable;

import java.awt.*;

public class Ball implements Paintable,Animateable {

    private Color  color;
    private double r;
    // Position
    private Vect2D m;
    // Geschwindigkeit
    private Vect2D v;
    // Beschleunigung
    private Vect2D a;

    public Ball(Color c, double r, Vect2D m, Vect2D v, Vect2D a) {
        this.color = c;
        this.r = r;
        this.m = m;
        this.v = v;
        this.a = a;
    }
    public Ball(Color c, double r, double mx, double my, double vx, double vy, double ax,double ay) {
        this(c,r,new Vect2D(mx,my), new Vect2D(vx,vy), new Vect2D(ax,ay));
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(color);
        g.fillOval((int)(m.x-r), (int)(m.y-r), (int)(2*r), (int)(2*r));
    }

    @Override
    public void move(double deltaTimeMs) {

    }

    @Override
    public void collission(Animateable a) {

    }
}
