package fathersfarm;


/**
 * Component.java
 *
 * Adds logic or graphics to an instance
 */
public abstract class Component extends Updatable {

    private Instance parent = null;
    private String name = null;


    public Component(Instance parent, String name) {
        this.parent = parent;
        this.name = name;
    }


    public Instance getParent() {
        return this.parent;
    }


    public String getName() {
        return this.name;
    }
   
    public abstract void added();
}
