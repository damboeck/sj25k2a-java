package animate;

import animate.fixElements.FixElement;

public interface Animateable {

    void move(double deltaTimeMs);
    void collision(FixElement f);

}
