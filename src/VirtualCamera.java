import models.Point;
import models.Scene;
import processing.core.PApplet;

import java.util.List;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
public class VirtualCamera extends PApplet {

    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;
    private static final int Z_OFFSET = 600;

    public static void main(String args[]) {
        PApplet.main(VirtualCamera.class.getName());
    }

    private Scene scene;
    private UserInput userInput;
    private int backgroundColor;
    private int sceneColor;

    @Override
    public void settings() {
        size(WINDOW_WIDTH, WINDOW_HEIGHT, P3D);
    }

    @Override
    public void setup() {
        scene = new Scene("", Z_OFFSET);
        userInput = new UserInput(scene);
        backgroundColor = 0;
        sceneColor = 255;
    }

    @Override
    public void draw() {
        translate(width / 2, height / 2, Z_OFFSET);
        background(backgroundColor);
        stroke(sceneColor);

        text(userInput.getInputDescription(), -width/2 + 20, height/2 - 20);
        drawScene();

        if (keyPressed) userInput.dispatchKey(key);
    }

    private void drawScene() {
        List<Point> points = scene.getPointsInDrawOrder();
        for (int i = 1; i < points.size(); i += 2)
            drawLine(points.get(i - 1), points.get(i));
    }

    private void drawLine(Point a, Point b) {
        line(a.x(), a.y(), a.z(), b.x(), b.y(), b.z());
    }
}

