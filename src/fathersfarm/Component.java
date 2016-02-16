package fathersfarm;


/**
 * Component.java
 *
 * Adds logic or graphics to an instance
 */
public abstract class Component extends Updatable {

    private Instance parent = null;


    public Component(Instance parent) {
        this.parent = parent;
    }


    public Instance getParent() {
        return this.parent;
    }


    public abstract void added();
}
