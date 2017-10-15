import models.Model;
import models.ModelFactory;
import models.Point;

import java.util.ArrayList;
import java.util.List;

import static models.ModelFactory.ModelType.RECTANGLE;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
class Scene {

    private final List<Model> models = new ArrayList<>();

    Scene(String scenePlan) {
        //TODO create scene from plan
        models.add(ModelFactory.createModel(RECTANGLE, 0, 0, 200, 100, 100, 100));
        models.add(ModelFactory.createModel(RECTANGLE, -50, -50, -30, 30, 30, 30));
        models.add(ModelFactory.createModel(RECTANGLE, 10, 10, 15, 80, 80, 80));
    }

    List<Point> getPointsInDrawOrder() {
        List<Point> drawOrder = new ArrayList<>();
        for (Model model : models)
            drawOrder.addAll(model.getPointsInDrawOrder());

        return drawOrder;
    }

    void moveX(int value) {
        for (Model model : models)
            model.move(value, 0, 0);
    }

    void moveY(int value) {
        for (Model model : models)
            model.move(0, value, 0);
    }

    void moveZ(int value) {
        for (Model model : models)
            model.move(0, 0, value);
    }

    void tiltPitch(float radians) {
        for (Model model : models)
            model.tilt(0, 0, radians);
    }

    void tiltRoll(float radians) {
        for (Model model : models)
            model.tilt(0, radians, 0);
    }

    void tiltYaw(float radians) {
        for (Model model : models)
            model.tilt(radians, 0, 0);
    }


}
