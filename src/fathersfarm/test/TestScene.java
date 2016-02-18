package fathersfarm.test;

import fathersfarm.Scene;


public class TestScene extends Scene {
    
    @Override
    public void init(int delta) {
        this.instances.add(new TestInstance(120f, 120f));
    }


    @Override
    public void drawGUI(int delta) {}

}
