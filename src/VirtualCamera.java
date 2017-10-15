import models.Point;
import processing.core.PApplet;

import java.util.List;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
public class VirtualCamera extends PApplet {

    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;

    public static void main(String args[]) {
        PApplet.main(VirtualCamera.class.getName());
    }

    private Scene scene;
    private UserInput userInput;

    @Override
    public void settings() {
        size(WINDOW_WIDTH, WINDOW_HEIGHT, P3D);
    }

    @Override
    public void setup() {
        scene = new Scene("");
        userInput = new UserInput(scene);
    }

    @Override
    public void draw() {
        translate(width / 2, height / 2);
        background(0);
        stroke(255);
        text(userInput.getInputDescription(), -width/2 + 20, height/2 - 20);
        drawScene();

        if (keyPressed) userInput.dispatchKey(key);
    }

    private void drawScene() {
        List<Point> points = scene.getPointsInDrawOrder();
        for (int i = 1; i < points.size(); i += 2) {
            Point pointA = points.get(i - 1);
            Point pointB = points.get(i);
            line(pointA.x(), pointA.y(), pointA.z(),
                    pointB.x(), pointB.y(), pointB.z());
        }
    }
}

