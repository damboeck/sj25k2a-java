package animate;

public interface Animateable {

    void move(double deltaTimeMs);
    void collission(Animateable a);

}
