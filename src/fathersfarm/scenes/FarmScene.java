package fathersfarm.scenes;

import fathersfarm.Scene;
import fathersfarm.instances.GroundTile;
import fathersfarm.components.SelectableComponent;

import org.lwjgl.input.*;

public class FarmScene extends Scene {

    public GroundTile[][] tiles = new GroundTile[16][16];
    public int tilex = 0;
    public int tiley = 0;
    public float keydowntime = 20f;
    public float keydowntimer = keydowntime;

    @Override
    public void init(int delta) {
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[x].length; y++) {
                tiles[x][y] = new GroundTile(x * 32, y * 32);
                this.instances.add(tiles[x][y]);
            }
        }
    }

    @Override
    public void tick(int delta) {
        tickAll(delta);
        resetTileSelectors();

        GroundTile tile = tiles[tilex][tiley];
        SelectableComponent selectableComponent =
            (SelectableComponent) tile.getComponent("SelectableComponent");

        selectableComponent.selected = true;

        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
                if (Keyboard.getEventKeyState()) {
                    if (tilex < tiles.length - 1 ) {
                        tilex++;
                    }
                } else {
                    keydowntimer = keydowntime;
                }
            }
            if (Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
                if (Keyboard.getEventKeyState()) {
                    if (tilex > 0) {
                        tilex--;
                    }
                } else {
                    keydowntimer = keydowntime;
                }
            }

            if (Keyboard.getEventKey() == Keyboard.KEY_UP) {
                if (Keyboard.getEventKeyState()) {
                    if (tiley > 0) {
                        tiley--;
                    }
                } else {
                    keydowntimer = keydowntime;
                }
            }
            if (Keyboard.getEventKey() == Keyboard.KEY_DOWN) {
                if (Keyboard.getEventKeyState()) {
                    if (tiley < tiles[tilex].length - 1)
                        tiley++;
                } else {
                    keydowntimer = keydowntime;
                }
            }
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
            if (keydowntimer > 0) {
                keydowntimer -= 1f;
            } else {
                if (tilex < tiles.length - 1 ) {
                    tilex++;
                }
            }
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
            if (keydowntimer > 0) {
                keydowntimer -= 1f;
            } else {
                if (tilex > 0) {
                    tilex--;
                }
            }
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
            if (keydowntimer > 0) {
                keydowntimer -= 1f;
            } else {
                if (tiley > 0) {
                    tiley--;
                }
            }
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
            if (keydowntimer > 0) {
                keydowntimer -= 1f;
            } else {
                if (tiley < tiles[tilex].length - 1) {
                    tiley++;
                }
            }
        }
    }


    public void resetTileSelectors() {
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[x].length; y++) {
                GroundTile tile = tiles[x][y];
                SelectableComponent selectableComponent =
                    (SelectableComponent) tile.getComponent("SelectableComponent");

                selectableComponent.selected = false;
            }
        } 
    }
}
