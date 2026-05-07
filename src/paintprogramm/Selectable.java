package paintprogramm;

import java.awt.*;

public interface Selectable {

    /** Prüft ob die Koordinaten auf dem Objekt liegen */
    boolean select(Point mc);
    boolean isSelected();
    void    setSelected(boolean b);

}
