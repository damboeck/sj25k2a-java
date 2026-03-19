package graphisch.kreis;

import graphisch.MyFrame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Vector;

public class MainKreis extends MyFrame {

    private Point lastMC; // Letzte Mausposition
    private EDITMODE editmode = EDITMODE.NORMAL;
    private Vector<Kreis> kreise ;
    private Kreis selectedKreis=null;

    public MainKreis() {
        super("Kreis", 1000, 800);
        kreise = new Vector<>();
        Kreis k = new Kreis(100,500,400,Color.red,Color.magenta,5);
        kreise.add(k);
        kreise.add(new Kreis(50,100,400,Color.blue,null,10));
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainKreis();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (Kreis k : kreise) {
            k.paint(g2);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch(e.getButton()) {
            case MouseEvent.BUTTON1: // Linke Maustaste
                // Wohin wurde geklickt? (e.getX(), e.getY())
                Point mc = e.getPoint();
                // Ist die Maus auf dem Kreis?
                for (Kreis k : kreise) {
                    if (k.onElement(mc)) {
                        lastMC = mc;
                        selectedKreis = k;
                        if ((e.getModifiersEx() & MouseEvent.SHIFT_DOWN_MASK) != 0) {
                            // jetzt ist die Hochstelltaste gedrückt
                            // Größenänderung
                            editmode = EDITMODE.RESIZE;
                        } else {
                            // Verschiebung
                            editmode = EDITMODE.MOVE;
                        }
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
                //k.move(e.getX()-lastMC.x, e.getY()-lastMC.y);
                editmode = EDITMODE.NORMAL;
                //repaint();
                break;
            case RESIZE:
                // Größenänderung beenden
                //k.resize(e.getPoint());
                editmode = EDITMODE.NORMAL;
                //repaint();
                break;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (editmode) {
            case MOVE:
                selectedKreis.move(e.getX()-lastMC.x, e.getY()-lastMC.y);
                lastMC = e.getPoint();
                repaint();
                break;
            case  RESIZE:
                selectedKreis.resize(e.getPoint());
                repaint();
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
