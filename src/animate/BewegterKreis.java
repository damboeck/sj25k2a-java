package animate;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class BewegterKreis extends MyFrameAnimate{

    //private Point  m = new Point(50,300);
    private double mx = 50;
    private double my = 300;
    private double r  = 50;
    private double v  = 12./50.;

    public static void main(String[] args) {
        new BewegterKreis("Bewegter Kreis", 800, 600);
    }

    public BewegterKreis(String title, int width, int height) {
        super(title, width, height);
        this.setFrameTimeMs(10);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        //m.translate((int)(v*this.getDeltaTimeMs()),0);
        mx += v*this.getDeltaTimeMs();
        g.setColor(Color.BLUE);
        g.fillOval((int)(mx-r), (int)(my-r), (int)(2*r), (int)(2*r));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
}
