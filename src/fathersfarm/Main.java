package fathersfarm;

import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;

import java.awt.Dimension;

import java.util.ArrayList;

import javax.swing.JOptionPane;


/**
 * The main class for the application.
 */
public class Main extends Updatable {

    public static final String TITLE = "Fathers Farm";
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 16 * 9;
    public static final int SCALE = 2;
    public static final Dimension DISPLAY_SIZE = new Dimension(
            WIDTH * SCALE,
            HEIGHT * SCALE
            );

    public static ArrayList<Scene> scenes = new ArrayList<Scene>();
    public static int SCENE_INDEX = 0;


    /**
     * Main calls for the application.
     */
    public Main() throws LWJGLException {
        this.initialize();
        this.initializeGraphics();

        ArrayList<String> errors = this.checkEnvironment();
        if (errors.size() > 0) {
            for (int i = 0; i < errors.size(); i++) {
                JOptionPane.showMessageDialog(null, errors.get(i));
            }

            System.exit(0);
        }

        this.loop();
    }


    /**
     * This function is used to initialize the game,
     * setting up the display etc.
     */
    private void initialize() throws LWJGLException {
        Display.setTitle(TITLE);
        Display.setDisplayMode(
                new DisplayMode(
                    DISPLAY_SIZE.width,
                    DISPLAY_SIZE.height
                    )
                );
        Display.create();
    }


    /**
     * The initial game loop.
     */
    private void loop () {
        while (!Display.isCloseRequested()) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            GL11.glClearColor(255/255f, 255/255f, 255/255f, 1);
            GL11.glColor3f(0, 0 ,0);

            this.tick(1);
            this.draw(1);

            Display.update();
        }
        System.exit(0);
    }


    /**
     * This function initializes the 2D graphics.
     */
    private void initializeGraphics(){
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, Display.getWidth(), Display.getHeight(), 0,-1f,1000 );
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }


    /**
     * This function is called once and checks for erros before we load the
     * game loop.
     */
    private ArrayList<String> checkEnvironment() {
        ArrayList<String> errors = new ArrayList<String>();

        if (scenes.size() == 0) {
            errors.add("No scenes were loaded, terminating.");
        }

        return errors;
    }


    /**
     * Updates game logick.
     */
    @Override
    public void tick(int delta) {
        getCurrentScene().tick(delta);
    }


    /**
     * Updates game graphics.
     */
    @Override
    public void draw(int delta) {
        getCurrentScene().draw(delta);
    }


    /**
     * Used to get the current scene.
     *
     * @return Scene instance of Scene.
     */
    public static Scene getCurrentScene() {
        return scenes.get(SCENE_INDEX);
    }


    /**
     * Opening endpoint for the application.
     */
    public static void main(String[] args) {
        try {
            new Main();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }
}
