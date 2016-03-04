package fathersfarm.instances;

import fathersfarm.Instance;
import fathersfarm.TextureBank;
import fathersfarm.components.SelectableComponent;
import fathersfarm.components.PlantHandlerComponent;
import fathersfarm.types.GroundTileType;


public class GroundTile extends Instance {

    private GroundTileType type = GroundTileType.GRASS;
    private Instance item = null;

    public GroundTile(float x, float y, GroundTileType type) {
        super(x, y);

        setType(type);
        setSize(32, 32);
        addComponent(new SelectableComponent(this, "SelectableComponent"));
        addComponent(new PlantHandlerComponent(this, "PlantHandlerComponent"));
    }

    @Override
    public void init(int delta) {}


    public void setType(GroundTileType type) {
        this.type = type;
        this.sprite.textures.clear();
        this.sprite.textures.add(TextureBank.getTexture(type.texture));
    }


    public GroundTileType getType() {
        return this.type;
    }


    public void setItem(Instance item) {
        this.item = item;
    }


    public Instance getItem() {
        return this.item;
    }
}
