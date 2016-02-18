package fathersfarm.instances;

import fathersfarm.Instance;
import fathersfarm.types.PlantType;
import fathersfarm.TextureBank;


public class Plant extends Instance {

    public int growth = 0;
    private PlantType type = null;


    public Plant(float x, float y, PlantType type) {
        super(x, y);

        setType(type);
    }


    @Override
    public void init (int delta) {}


    public void setType(PlantType type) {
        this.type = type;
        this.sprite.textures.clear();
        this.sprite.textures.add(TextureBank.getTexture(type.texture));
    }


    public PlantType getType() {
        return this.type;
    }
}
