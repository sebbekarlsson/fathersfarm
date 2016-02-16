package fathersfarm;


public abstract class Updatable {

    public boolean hasBeenInitialized = false;

    public abstract void tick(int delta);
    public abstract void draw(int delta);
    public abstract void init(int delta);
}
