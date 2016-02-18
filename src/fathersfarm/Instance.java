package fathersfarm;

import java.util.ArrayList;
import org.lwjgl.opengl.GL11;


/**
 * Instance.java
 *
 * Defines a game object.
 */
public abstract class Instance extends Updatable {

    public float x, y, depth = 0f;
    public float dx, dy = 0f;
    public float width, height = 0f;

    public Sprite sprite = new Sprite();
    private ArrayList<Component> components = new ArrayList<Component>();

    
    public Instance(float x, float y) {
        this.x = x;
        this.y = y;
    }


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
     * Ticking all components by default.
     */ 
    @Override
    public void tick(int delta) {
        this.sprite.tick(delta);
        this.tickComponents(delta);
    }


    /**
     * Drawing all components by default.
     */ 
    @Override
    public void draw(int delta) {
        this.sprite.draw(delta);
    }


    /**
     * Sends a tick signal to all components for this instance.
     */ 
    public void tickComponents(int delta) {
        for (int i = 0; i < this.components.size(); i++) {
            Component component = this.components.get(i);

            if (!component.hasBeenInitialized) {
                component.init(delta);
                component.hasBeenInitialized = true;
            } else {
                this.components.get(i).tick(delta);
            }
        }
    }


    /**
     * Sends a draw signal to all components for this instance.
     */
    public void drawComponents(int delta) {
        for (int i = 0; i < this.components.size(); i++) {
            GL11.glPushMatrix();
            this.components.get(i).draw(delta);
            GL11.glPopMatrix();
        }
    }


    public Component getComponent(String name) {
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getName() == name) {
                return components.get(i);
            }
        }

        return null;
    }


    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }
}
