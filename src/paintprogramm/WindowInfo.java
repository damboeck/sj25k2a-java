package paintprogramm;

import java.awt.*;
import java.util.Vector;

/**
 * Informationen über das Fenster in dem eine weiteres Element eingebunden ist
 */
public interface WindowInfo {

    int   getWidth();
    int   getHeight();
    Vector<Paintable> getElements();

}
