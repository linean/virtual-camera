import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
class Scene {

    private final List<Rectangle3D> elements = new ArrayList<>();

    Scene(String scenePlan) {
        //TODO create scene from plan
        elements.add(new Rectangle3D(0, 0, 200,100, 100, 100));
        elements.add(new Rectangle3D(-50, -50, -30,30, 30, 30));
        elements.add(new Rectangle3D(10, 10, 15,80, 80, 80));
    }

    List<PointMatrix> getPointsInDrawOrder(){
        List<PointMatrix> drawOrder = new ArrayList<>();
        for (Rectangle3D rect : elements)
            drawOrder.addAll(rect.drawOrder);

        return drawOrder;
    }

    void moveX(int value) {
        for (Rectangle3D rect : elements)
            rect.move(value, 0, 0);
    }

    void moveY(int value) {
        for (Rectangle3D rect : elements)
            rect.move(0, value, 0);
    }

    void moveZ(int value) {
        for (Rectangle3D rect : elements)
            rect.move(0, 0, value);
    }

    void tiltPitch(float radians) {
        for (Rectangle3D rect : elements)
            rect.tilt(0, 0, radians);
    }

    void tiltRoll(float radians) {
        for (Rectangle3D rect : elements)
            rect.tilt(0, radians, 0);
    }

    void tiltYaw(float radians) {
        for (Rectangle3D rect : elements)
            rect.tilt(radians, 0, 0);
    }


}
