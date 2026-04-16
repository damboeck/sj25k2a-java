package paintprogramm;

import java.awt.*;

/**
 * Informationen über das Fenster in dem eine weiteres Element eingebunden ist
 */
public interface WindowInfo {

    int   getWidth();
    int   getHeight();
    Color getDrawColor();
    Color getFillColor();

}
