package paintprogramm;

import java.awt.*;

/**
 * Interface um eine Objekt in ein AWT-Fenster zeichnen zu können
 */
public interface Paintable {

    /** zeichnet das Objekt in eine Graphics2D Objekt */
    void paint(Graphics2D g);

}
