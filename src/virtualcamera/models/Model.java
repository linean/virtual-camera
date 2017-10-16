package virtualcamera.models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej Sady on 15-Oct-17.
 * VirtualCamera
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({@JsonSubTypes.Type(value = Rectangle.class, name = "rectangle"), @JsonSubTypes.Type(value = Triangle.class, name = "triangle")})
abstract class Model {
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

    void move(float dx, float dy, float tz) {
        for (Point p : points) {
            p.move(dx, dy, tz);
        }
    }

    void tilt(float yaw, float roll, float pitch) {
        for (Point p : points) {
            p.tilt(yaw, roll, pitch);
        }
    }

    List<Point> getPointsInDrawOrder() {
        return drawOrder;
    }
}
