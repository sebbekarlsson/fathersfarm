package fathersfarm.test;

import fathersfarm.Instance;
import fathersfarm.TextureBank;


class TestInstance extends Instance {

    public TestInstance(float x, float y) {
        super(x, y);

        this.sprite.textures.add(TextureBank.getTexture("grass.jpg"));
        this.addComponent(new TestComponent(this, "test"));
    }

    @Override
    public void init(int delta) {}
}
