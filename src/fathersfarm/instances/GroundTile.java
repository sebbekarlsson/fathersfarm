package fathersfarm.instances;

import fathersfarm.Instance;
import fathersfarm.TextureBank;
import fathersfarm.components.SelectableComponent;
import fathersfarm.types.GroundTileType;


public class GroundTile extends Instance {

    private GroundTileType type = GroundTileType.GRASS;

    public GroundTile(float x, float y, GroundTileType type) {
        super(x, y);

        setType(type);
        setSize(32, 32);
    }

    @Override
    public void init(int delta) {
        addComponent(new SelectableComponent(this, "SelectableComponent"));
    }

    public void setType(GroundTileType type) {
        this.type = type;
        this.sprite.textures.clear();
        this.sprite.textures.add(TextureBank.getTexture(type.texture));
    }


    public GroundTileType getType() {
        return this.type;
    }
}
