package fathersfarm;

import java.util.ArrayList;


/**
 * Scene.java
 *
 * Holds game objects/instances and handles their logic.
 */ 
public abstract class Scene extends Updatable {

    public ArrayList<Instance> instances = new ArrayList<Instance>();
}
