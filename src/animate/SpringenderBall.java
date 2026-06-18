package animate;

import animate.fixElements.FixElement;
import animate.fixElements.FixHLine;
import animate.fixElements.FixVLine;
import paintprogramm.Paintable;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Vector;

public class SpringenderBall extends MyFrameAnimate{

    private Vector<Animateable> animateables = new Vector<>();
    private Vector<FixElement>  fixElements = new Vector<>();

    public static void main(String[] args) {
        new SpringenderBall("Springender Ball", 800, 600);
    }

    public SpringenderBall(String title, int width, int height) {
        super(title, width, height);
        animateables.add(new Ball(Color.red,20,100,300,0.15,-0.35,0,2e-4));
        fixElements.add(new FixHLine(20));
        fixElements.add(new FixHLine(height-2));
        fixElements.add(new FixVLine(2));
        fixElements.add(new FixVLine(width-2));
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (Animateable a : animateables)
            a.move(this.getDeltaTimeMs());
        for (Animateable a : animateables) {
            for (FixElement e : fixElements) {
                a.collision(e);
            }
        }
        CollisionService.checkCollisions(animateables);
        for (Animateable a : animateables)
            if (a instanceof Paintable)
                ((Paintable) a).paint(g2);
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
