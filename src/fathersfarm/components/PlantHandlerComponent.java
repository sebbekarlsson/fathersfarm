package fathersfarm.components;

import fathersfarm.Component;
import fathersfarm.Instance;
import fathersfarm.instances.*;
import fathersfarm.types.*;

import org.lwjgl.opengl.GL11;


public class PlantHandlerComponent extends Component {


    public PlantHandlerComponent(Instance parent, String name) {
        super(parent, name);
    }


    @Override
    public void draw(int delta) {
        if (this.getParent() instanceof GroundTile) {
            GroundTile tile = (GroundTile) this.getParent();

            if (tile.getItem() instanceof Plant) {
                Plant plant = (Plant) tile.getItem();
                GL11.glPushMatrix();
                GL11.glTranslatef(getParent().x, getParent().y, -5f);
                plant.draw(delta);
                GL11.glPopMatrix();
            }
        }
    }


    @Override
    public void tick(int delta) {
        if (this.getParent() instanceof GroundTile) {
            GroundTile tile = (GroundTile) this.getParent();

            if (tile.getItem() instanceof Plant) {
                Plant plant = (Plant) tile.getItem();

                if (tile.getType() != GroundTileType.SOIL) {
                    tile.setItem(null);
                }
            }
        }
    }


    @Override
    public void init(int delta) {}


    @Override
    public void added() {}
}
