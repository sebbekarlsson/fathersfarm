package fathersfarm.scenes;

import fathersfarm.Scene;
import fathersfarm.instances.*;
import fathersfarm.components.SelectableComponent;
import fathersfarm.types.*;

import org.lwjgl.input.*;

import org.newdawn.slick.TrueTypeFont;
import java.awt.Font;
import org.newdawn.slick.Color;

import org.lwjgl.opengl.*;


public class FarmScene extends Scene {

    public GroundTile[][] tiles = new GroundTile[16][16];
    public int tilex = 0;
    public int tiley = 0;
    public float keydowntime = 20f;
    public float keydowntimer = keydowntime;

    public PlantType[] plantTypes = PlantType.values();
    public int plantTypeIndex = 0;
    
    public Font awtFont = new Font("Times New Roman", Font.BOLD, 12);
    public TrueTypeFont font = new TrueTypeFont(awtFont, false);



    @Override
    public void init(int delta) {
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[x].length; y++) {
                tiles[x][y] = new GroundTile(x * 32, y * 32, GroundTileType.GRASS);
                this.instances.add(tiles[x][y]);
            }
        }
    }


    @Override
    public void drawGUI(int delta) {
        this.font.drawString(Display.getWidth()-256, Display.getHeight()-16, plantTypes[plantTypeIndex].name(), Color.black);
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
            if (Keyboard.getEventKey() == Keyboard.KEY_C) {
                if (Keyboard.getEventKeyState()) {
                    if (plantTypeIndex < plantTypes.length -1) {
                        plantTypeIndex ++;
                    } else {
                        plantTypeIndex = 0;
                    }
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
        if (Keyboard.isKeyDown(Keyboard.KEY_Z)) {
            tile.setType(GroundTileType.SOIL);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_X)) {
            tile.setType(GroundTileType.GRASS);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            Plant plant = new Plant(tile.x, tile.y, plantTypes[plantTypeIndex]);

            if (tile.getType() == GroundTileType.SOIL)
            tile.setItem(plant);
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
