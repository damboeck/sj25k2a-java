package graphisch.kreis;

import graphisch.MyFrame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MainKreis extends MyFrame {

    private Point lastMC; // Letzte Mausposition
    private EDITMODE editmode = EDITMODE.NORMAL;
    private Kreis k;

    public MainKreis() {
        super("Kreis", 1000, 800);
        k = new Kreis(100,500,400,Color.red,Color.magenta,5);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainKreis();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        k.paint(g2);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch(e.getButton()) {
            case MouseEvent.BUTTON1: // Linke Maustaste
                // Wohin wurde geklickt? (e.getX(), e.getY())
                Point mc = e.getPoint();
                // Ist die Maus auf dem Kreis?
                if (k.onElement(mc)) {
                    lastMC = mc;
                    switch (e.getModifiersEx()) {
                        case MouseEvent.SHIFT_DOWN_MASK: // Shiftgedrückt
                            // Größenänderung
                            editmode = EDITMODE.RESIZE;
                            break;
                        case 0: // Keine  Modifikatortaste gedrückt
                            // Verschiebung
                            editmode = EDITMODE.MOVE;
                            break;
                    }
                }
                break;
            case MouseEvent.BUTTON2: // Mittlere Maustaste

                break;
            case MouseEvent.BUTTON3: // Rechte Maustaste

                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (editmode) {
            case MOVE:
                // Verschiebung beenden
                k.move(e.getX()-lastMC.x, e.getY()-lastMC.y);
                editmode = EDITMODE.NORMAL;
                repaint();
                break;
            case RESIZE:
                // Größenänderung beenden
                break;
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
}
