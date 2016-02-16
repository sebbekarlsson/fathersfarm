package fathersfarm.components;

import fathersfarm.Component;
import fathersfarm.Instance;

import org.lwjgl.opengl.GL11;


public class SelectableComponent extends Component {

    public boolean selected = false;


    public SelectableComponent(Instance parent, String name) {
        super(parent, name);
    }


    @Override
    public void draw(int delta) {
        float x = getParent().x;
        float y = getParent().y;

        if (this.selected) {
            GL11.glDisable(GL11.GL_TEXTURE_2D);

            GL11.glColor3f(255/255f, 0/255f, 0/255f);
            GL11.glTranslatef(0, 0, 1);
            GL11.glBegin(GL11.GL_LINE_LOOP);
                
            GL11.glVertex2f(0, 0);
            GL11.glVertex2f(32, 0);
            GL11.glVertex2f(32, 32);
            GL11.glVertex2f(0, 32);

            GL11.glEnd();
            GL11.glTranslatef(0, 0, -1);
            GL11.glColor3f(255/255f, 255/255f, 255/255f);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
        }
    }


    @Override
    public void added() {}


    @Override
    public void init(int delta) { }


    @Override
    public void tick(int delta) {}
}
