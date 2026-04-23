package paintprogramm.elements;

import paintprogramm.Paintable;
import paintprogramm.symbole.LINESTYLE;

import java.awt.*;

public abstract class Zweipunkt implements Paintable {

    private Color drawColor;
    private int   lineWidth = 1;
    private LINESTYLE lineStyle = LINESTYLE.LINIE;


}
