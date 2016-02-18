package fathersfarm.components;

import fathersfarm.Component;
import fathersfarm.Instance;

import org.lwjgl.opengl.GL11;


public class SelectableComponent extends Component {

    public boolean selected = false;

    private float animationTime = 255f;
    private float animationTimer = animationTime;
    private float brightness = 0f;
    private boolean animateUp = false;
    private float animationSpeed = 9f;
    

    public SelectableComponent(Instance parent, String name) {
        super(parent, name);
    }


    @Override
    public void draw(int delta) {
        if (animateUp == true && animationTimer <= animationTime) {
            animationTimer += animationSpeed;

            if (animationTimer == animationTime) {
                animateUp = false;
            }
        } else {
            animateUp = false;
            animationTimer -= animationSpeed;

            if (animationTimer <= 0){
                animateUp = true;
            }
        } 

        brightness = animationTimer;

        float width = this.getParent().width;
        float height = this.getParent().height;

        if (this.selected) {
            GL11.glPushMatrix();
            GL11.glDisable(GL11.GL_TEXTURE_2D);

            GL11.glColor4f(brightness/255f, brightness/255f, brightness/255f, 0.5f);
            GL11.glTranslatef(getParent().x, getParent().y, -1f);
            GL11.glBegin(GL11.GL_QUADS);

            GL11.glVertex2f(0, 0);
            GL11.glVertex2f(width, 0);
            GL11.glVertex2f(width, height);
            GL11.glVertex2f(0, height);

            GL11.glEnd();
            GL11.glTranslatef(0, 0, -1);
            GL11.glColor3f(255/255f, 255/255f, 255/255f);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glPopMatrix();
        }
    }


    @Override
    public void added() {}


    @Override
    public void init(int delta) { }


    @Override
    public void tick(int delta) {}
}
