package virtualcamera;

import org.codehaus.jackson.map.ObjectMapper;
import processing.core.PApplet;
import processing.core.PFont;
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

    @Override
    public void settings() {
        size(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT, P3D);
    }

    @Override
    public void setup() {
        loadScene();
        setFont();
        userInput = new UserInput(scene);
    }

    private void loadScene() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            scene = mapper.readValue(new File("scenes/scene_1.json"), Scene.class);
        } catch (Exception e) {
            throw new IllegalStateException("Scene file not found!");
        }
    }

    private void setFont() {
        PFont font = createFont("Arial", 12);
        textFont(font);
        textSize(12);
    }

    @Override
    public void draw() {
        background(userInput.getBackgroundColor());
        drawDescription();
        drawScene();

        if (keyPressed) userInput.keyPressed(key);
        else userInput.keyReleased();
    }

    private void drawDescription() {
        fill(userInput.getSceneColor());
        text(userInput.getInputDescription(), 5,height / 2 + 65);
    }

    private void drawScene() {
        translate(width / 2, height / 2, Config.Z_OFFSET);
        stroke(userInput.getSceneColor());
        List<Point> points = scene.getPointsInDrawOrder();
        for (int i = 1; i < points.size(); i += 2)
            drawLine(points.get(i - 1), points.get(i));
    }

    private void drawLine(Point a, Point b) {
        line(a.x(), a.y(), a.z(), b.x(), b.y(), b.z());
    }
}

