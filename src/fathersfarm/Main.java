package fathersfarm;

import org.lwjgl.*;
import org.lwjgl.opengl.*;
import java.awt.Dimension;


public class Main {

    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 16 * 9;
    public static final int SCALE = 2;
    public static final Dimension DISPLAY_SIZE = new Dimension(
            WIDTH * SCALE,
            HEIGHT * SCALE
            );

    public Main() throws LWJGLException {
        this.initialize();
        this.loop();
    }


    private void initialize() throws LWJGLException {
        Display.setTitle("Game");
        Display.setDisplayMode(new DisplayMode(DISPLAY_SIZE.width, DISPLAY_SIZE.height));
        Display.create();
    }

    private void loop () {
        while (! Display.isCloseRequested()) {

            Display.update();
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        try {
            new Main();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }
}
