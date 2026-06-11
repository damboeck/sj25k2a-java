package animate;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Vector;

public class SpringenderBall extends MyFrameAnimate{

    private Ball ball;
    private Vector<FixElement> fixElements = new Vector<>();

    public static void main(String[] args) {
        new SpringenderBall("Springender Ball", 800, 600);
    }

    public SpringenderBall(String title, int width, int height) {
        super(title, width, height);
        ball = new Ball(Color.red,20,100,300,0.15,-0.15,0,2e-4);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if  (ball!=null) {
            ball.move(this.getDeltaTimeMs());
            // TODO Kollision
            ball.paint(g2);
        }
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
