package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej Sady on 15-Oct-17.
 * VirtualCamera
 */
public abstract class Model {
    private final Point[] points;
    private final List<Point> drawOrder;

    Model(Point[] points) {
        this.points = points;
        this.drawOrder = createDrawOrderList();
    }

    protected abstract int[] getDrawOrder();

    private List<Point> createDrawOrderList() {
        List<Point> order = new ArrayList<>();
        for (int pointIndex : getDrawOrder()) {
            order.add(points[pointIndex]);
        }

        if (order.size() % 2 != 0)
            throw new IllegalStateException("Missing point in draw order!");

        return order;
    }

    public void move(int dx, int dy, int tz) {
        for (Point p : points) {
            p.move(dx, dy, tz);
        }
    }

    public void tilt(float yaw, float roll, float pitch) {
        for (Point p : points) {
            p.tilt(yaw, roll, pitch);
        }
    }

    public List<Point> getPointsInDrawOrder() {
        return drawOrder;
    }
}
