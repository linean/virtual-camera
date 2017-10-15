package virtualcamera.models;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
public class Scene {

    private final List<Model> models;

    public Scene(@JsonProperty("models") List<Model> models) {
        this.models = models;
    }

    public void reset() {
        //TODO - remove
    }

    public List<Point> getPointsInDrawOrder() {
        List<Point> drawOrder = new ArrayList<>();
        for (Model model : models)
            drawOrder.addAll(model.getPointsInDrawOrder());

        return drawOrder;
    }

    public void moveX(float value) {
        for (Model model : models)
            model.move(value, 0, 0);
    }

    public void moveY(float value) {
        for (Model model : models)
            model.move(0, value, 0);
    }

    public void moveZ(float value) {
        for (Model model : models)
            model.move(0, 0, value);
    }

    public void tiltPitch(float radians) {
        for (Model model : models)
            model.tilt(0, 0, radians);
    }

    public void tiltRoll(float radians) {
        for (Model model : models)
            model.tilt(0, radians, 0);
    }

    public void tiltYaw(float radians) {
        for (Model model : models)
            model.tilt(radians, 0, 0);
    }
}
