package graphisch;

import java.awt.*;

public class Linie2 extends Linie {

    public static void main(String[] args) {
        new Linie2();
    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        g.setColor(Color.blue);
        int d=40;
        //g.drawLine(100,500,700,100);
        for (int y=d; y<this.getHeight(); y+=d) {
            g.drawLine(0, y, this.getWidth(), y);
        }
    }
}
