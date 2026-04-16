package paintprogramm;

import graphisch.MyFrame;
import paintprogramm.symbole.Toolbar;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class PaintMain extends MyFrame implements WindowInfo {

    private static final int FRAME_TOP    = 30;
    private static final int FRAME_LEFT   = 6;
    private static final int FRAME_BOTTOM = 6;
    private static final int FRAME_RIGHT  = 6;

    private Toolbar toolbar;

    private Color drawColor = Color.BLACK;
    private Color fillColor = Color.RED;

    @Override
    public Color getDrawColor() {
        return drawColor;
    }

    public void setDrawColor(Color drawColor) {
        this.drawColor = drawColor;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }


    public PaintMain() {
        super("Paint", 1000, 800);
        toolbar = new Toolbar(this);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PaintMain();
    }

    @Override
    public int getWidth() {
        return super.getWidth()-FRAME_LEFT-FRAME_RIGHT;
    }

    @Override
    public int getHeight() {
        return super.getHeight()-FRAME_BOTTOM-FRAME_TOP;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // Schiebe das Fenster korrekt!
        g2d.translate(FRAME_LEFT,FRAME_TOP);

        toolbar.paint(g2d);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point mc = new Point(e.getX()-FRAME_LEFT, e.getY()-FRAME_TOP);
        // Symbolleiste verarbeiten
        if (e.getButton()==MouseEvent.BUTTON1)
            if (toolbar.leftMousePressed(mc))  {
                repaint();
                return;
            }
        // restliches Fenster verarbeiten

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
}
