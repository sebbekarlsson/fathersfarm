package fathersfarm;

import java.util.ArrayList;
import java.util.Arrays;

import org.lwjgl.opengl.*;

import org.newdawn.slick.opengl.Texture;


public class Sprite extends Updatable {

    public ArrayList<Texture> textures = new ArrayList<Texture>();
    public int texture_index = 0;


    /**
     * Used to get the current texture in the texturebuffer.
     *
     * @return texture Instance of Texture.
     */
    public Texture getCurrentTexture() {
        return this.textures.get(this.texture_index);
    }


    @Override
    public void draw(int delta) {
        this.drawTexture(delta, 0, 0);
    }


    public void drawTexture(int delta, float x, float y) {
        GL11.glPushMatrix();
        Texture texture = this.getCurrentTexture();

        if (texture == null) { return; }
        
        
        texture.bind();
        GL11.glBegin(GL11.GL_QUADS);

        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(0 + x, 0 + y);

        GL11.glTexCoord2f(texture.getWidth(), 0);
        GL11.glVertex2f(texture.getTextureWidth() + x, 0 + y);

        GL11.glTexCoord2f(texture.getWidth(), texture.getHeight());
        GL11.glVertex2f(texture.getTextureWidth() + x, texture.getTextureHeight() + y);

        GL11.glTexCoord2f(0, texture.getHeight());
        GL11.glVertex2f(0 + x, texture.getTextureHeight() + y);

        GL11.glEnd();

        GL11.glPopMatrix();
    }


    public void setTextures(Texture...textures) {
        this.textures = new ArrayList<Texture>(Arrays.asList(textures));
    }

    
    @Override
    public void tick(int delta) {}


    @Override
    public void init(int delta) {}
}
