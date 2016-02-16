package fathersfarm;

import java.util.ArrayList;


/**
 * Instance.java
 *
 * Defines a game object.
 */
public abstract class Instance extends Updatable {

    public float x, y = 0f;
    public float dx, dy = 0f;

    private ArrayList<Component> components = new ArrayList<Component>();


    /**
     * Adds a given component to the instance.
     *
     * @param component an instance of type Component class.
     */     
    public void addComponent(Component component) {
        this.components.add(component);

        component.added();
    }


    /**
     * Ticking and drawing all components by default.
     */ 
    public void tick() {
        this.tickComponents();
        this.drawComponents();
    }


    /**
     * Sends a tick signal to all components for this instance.
     */ 
    public void tickComponents() {
        for (int i = 0; i < this.components.size(); i++) {
            this.components.get(i).tick(1);
        }
    }


    /**
     * Sends a draw signal to all components for this instance.
     */
    public void drawComponents() {
        for (int i = 0; i < this.components.size(); i++) {
            this.components.get(i).draw(1);
        }
    }
}
