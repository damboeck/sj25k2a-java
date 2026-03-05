package graphisch;

import java.awt.*;
import java.awt.event.*;

public abstract class MyFrame extends Frame
   implements
        WindowListener,       // Fensterereignisse wie Öffnen, Schließen, Minimieren, etc.
        KeyListener,          // Tastaturereignisse wie Tastenanschläge, Loslassen, etc.
        MouseListener,        // Mausklicks, Mausbetreten, Mausverlassen, etc.
        MouseMotionListener,  // Mausbewegungen wie Bewegen, Ziehen, etc.
        MouseWheelListener,   // Mausradbewegungen
        ComponentListener     // Komponentenereignisse wie Größenänderung, Verschiebung, etc.
{

    public MyFrame(String title, int width, int height) {
        super(title);
        setSize(width, height);
        this.addWindowListener(this);
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addMouseWheelListener(this);
        this.addComponentListener(this);
    }

    @Override
    public abstract void paint(Graphics g);

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

    @Override
    public void componentResized(ComponentEvent e) {
        repaint();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public abstract void mousePressed(MouseEvent e);

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public abstract void mouseWheelMoved(MouseWheelEvent e);

}
