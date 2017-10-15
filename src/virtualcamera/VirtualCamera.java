package virtualcamera;

import org.codehaus.jackson.map.ObjectMapper;
import processing.core.PApplet;
import virtualcamera.models.Point;
import virtualcamera.models.Scene;

import java.io.File;
import java.util.List;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
public class VirtualCamera extends PApplet {

    public static void main(String args[]) {
        PApplet.main(VirtualCamera.class.getName());
    }

    private Scene scene;
    private UserInput userInput;
    private int backgroundColor;
    private int sceneColor;

    @Override
    public void settings() {
        size(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT, P3D);
    }

    @Override
    public void setup() {
        loadScene();
        userInput = new UserInput(scene);
        backgroundColor = 0;
        sceneColor = 255;
    }

    private void loadScene() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            scene = mapper.readValue(new File("scenes/scene_1.json"), Scene.class);
        } catch (Exception e) {
            throw new IllegalStateException("Scene file not found!");
        }
    }

    @Override
    public void draw() {
        translate(width / 2, height / 2, Config.Z_OFFSET);
        background(backgroundColor);
        stroke(sceneColor);

        text(userInput.getInputDescription(), -width / 2 + 20, height / 2 - 20);
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

