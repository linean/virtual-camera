import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
class Rectangle3D {
    final List<PointMatrix> drawOrder = new ArrayList<>();
    private final PointMatrix[] points = new PointMatrix[8];

    Rectangle3D (int startX, int startY, int startZ, int height, int width, int length) {
        points[0] = new PointMatrix(startX, startY, startZ);
        points[1] = new PointMatrix(startX + width, startY, startZ);
        points[2] = new PointMatrix(startX, startY + height, startZ);
        points[3] = new PointMatrix(startX + width, startY + height, startZ);
        points[4] = new PointMatrix(startX, startY, startZ + length);
        points[5] = new PointMatrix(startX + width, startY, startZ + length);
        points[6] = new PointMatrix(startX, startY + height, startZ + length);
        points[7] = new PointMatrix(startX + width, startY + height, startZ + length);

        setDrawOrder();
    }

    private void setDrawOrder(){
        //First rectangle
        drawOrder.add(points[0]);
        drawOrder.add(points[1]);
        drawOrder.add(points[1]);
        drawOrder.add(points[3]);
        drawOrder.add(points[3]);
        drawOrder.add(points[2]);
        drawOrder.add(points[2]);
        drawOrder.add(points[0]);

        //Second rectangle
        drawOrder.add(points[4]);
        drawOrder.add(points[5]);
        drawOrder.add(points[5]);
        drawOrder.add(points[7]);
        drawOrder.add(points[7]);
        drawOrder.add(points[6]);
        drawOrder.add(points[6]);
        drawOrder.add(points[4]);

        //Connections
        drawOrder.add(points[0]);
        drawOrder.add(points[4]);
        drawOrder.add(points[1]);
        drawOrder.add(points[5]);
        drawOrder.add(points[3]);
        drawOrder.add(points[7]);
        drawOrder.add(points[2]);
        drawOrder.add(points[6]);

        if (drawOrder.size() % 2 != 0)
            throw new IllegalStateException("Missing point in draw order!");
    }

    void move(int dx, int dy, int tz) {
        for (PointMatrix p : points) {
            p.move(dx, dy, tz);
        }
    }

    void tilt(float yaw, float roll, float pitch) {
        for (PointMatrix p : points) {
            p.tilt(yaw, roll, pitch);
        }
    }
}
