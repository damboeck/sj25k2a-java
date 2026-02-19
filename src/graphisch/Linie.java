package graphisch;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Zeichnet eine Linie in ein Fenster
 */
public class Linie extends Frame implements WindowListener {

    public Linie(int width, int height) {
        super("Linie");
        setSize(width, height);
        this.addWindowListener(this);
        this.setVisible(true);
    }

    public Linie() {
        this(800,600);
    }


    public static void main(String[] args) {
        new Linie(800,600);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.drawLine(100,100,700,500);
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
