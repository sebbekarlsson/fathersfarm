package fathersfarm.scenes;

import fathersfarm.Scene;
import fathersfarm.instances.GroundTile;

public class FarmScene extends Scene {

    public GroundTile[][] tiles = new GroundTile[16][16];

    @Override
    public void init(int delta) {
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[x].length; y++) {
                tiles[x][y] = new GroundTile(x * 32, y * 32);
                this.instances.add(tiles[x][y]);
            }
        }
    }
}
