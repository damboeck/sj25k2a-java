package animate;

import animate.fixElements.FixElement;

public interface Animateable {

    void move(double deltaTimeMs);
    void collission(Animateable a);
    void collision(FixElement f);

}
