package fathersfarm;

import java.util.ArrayList;
import org.lwjgl.opengl.GL11;


/**
 * Scene.java
 *
 * Holds game objects/instances and handles their logic.
 */ 
public abstract class Scene extends Updatable {


    public Camera camera = new Camera();
    public ArrayList<Instance> instances = new ArrayList<Instance>();


    public void tickAll(int delta) {
        for (int i = 0; i < instances.size(); i++) {
            Instance instance = instances.get(i);

            if (!instance.hasBeenInitialized) {
                instance.init(delta);
                instance.hasBeenInitialized = true;
            } else {
                GL11.glPushMatrix();
                GL11.glTranslatef(instance.x, instance.y, instance.depth);
                instance.tick(delta);
                GL11.glPopMatrix();
            }
        }
    }


    public void drawAll(int delta) {
        for (int i = 0; i < instances.size(); i++) {
            Instance instance = instances.get(i);
            
            GL11.glPushMatrix();
            GL11.glTranslatef(instance.x, instance.y, instance.depth);
            instance.draw(delta);
            GL11.glPopMatrix();

            GL11.glPushMatrix();
            instance.drawComponents(delta);
            GL11.glPopMatrix();
        }
    }


    @Override
    public void draw(int delta) {
        drawAll(delta);
    }

    
    @Override
    public void tick(int delta) {
        tickAll(delta);
    }


    public abstract void drawGUI(int delta);
}
