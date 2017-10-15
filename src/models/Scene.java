package models;
import java.util.ArrayList;
import java.util.List;

import static models.ModelFactory.ModelType.RECTANGLE;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
public class Scene {

    private final int zOffset;
    private final List<Model> models = new ArrayList<>();

    public Scene(String scenePlan, int zOffset) {
        this.zOffset = zOffset;
        //TODO create scene from plan
        loadModels("");
    }

    private void loadModels(String plan) {
        models.add(ModelFactory.createModel(RECTANGLE, 0, 0, 200 - zOffset, 100, 100, 100));
        models.add(ModelFactory.createModel(RECTANGLE, -50, -50, -30 - zOffset, 30, 30, 30));
        models.add(ModelFactory.createModel(RECTANGLE, 10, 10, 15 - zOffset, 80, 80, 80));
    }

    public void reset() {
        models.clear();
        loadModels("");
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
