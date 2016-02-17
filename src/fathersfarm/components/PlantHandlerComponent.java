package fathersfarm.components;

import fathersfarm.Component;
import fathersfarm.Instance;
import fathersfarm.instances.*;


public class PlantHandlerComponent extends Component {


    public PlantHandlerComponent(Instance parent, String name) {
        super(parent, name);
    }


    @Override
    public void draw(int delta) {
        if (this.getParent() instanceof GroundTile) {
            GroundTile tile = (GroundTile) this.getParent();

            if (tile.item instanceof Plant) {
                Plant plant = (Plant) tile.item;
                plant.draw(delta);
            }
        }
    }


    @Override
    public void tick(int delta) {
        if (this.getParent() instanceof GroundTile) {
            GroundTile tile = (GroundTile) this.getParent();

            if (tile.item instanceof Plant) {
                Plant plant = (Plant) tile.item;
            }
        }
    }


    @Override
    public void init(int delta) {}


    @Override
    public void added() {}
}
