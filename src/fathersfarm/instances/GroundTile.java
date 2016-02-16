package fathersfarm.instances;

import fathersfarm.Instance;
import fathersfarm.TextureBank;
import fathersfarm.components.SelectableComponent;


public class GroundTile extends Instance {

    public GroundTile(float x, float y) {
        super(x, y);

        this.sprite.textures.add(TextureBank.getTexture("grass.jpg"));
    }

    @Override
    public void init(int delta) {
        addComponent(new SelectableComponent(this, "SelectableComponent"));

        System.out.println(getComponent("SelectableComponent"));
    }
}
