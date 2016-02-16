package fathersfarm;

import org.lwjgl.*;
import org.lwjgl.opengl.*;
import java.awt.Dimension;


/**
 * The main class for the application.
*/
public class Main {

    public static final String TITLE = "Fathers Farm";
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 16 * 9;
    public static final int SCALE = 2;
    public static final Dimension DISPLAY_SIZE = new Dimension(
            WIDTH * SCALE,
            HEIGHT * SCALE
            );

    
    /**
     * Main calls for the application.
    */
    public Main() throws LWJGLException {
        this.initialize();
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

            Display.update();
        }
        System.exit(0);
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
