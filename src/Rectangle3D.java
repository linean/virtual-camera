import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
public class Rectangle3D {
    private final Point3D[] points = new Point3D[4];
    private List<Point3D> drawOrder = new ArrayList<>();

    Rectangle3D (int startX, int startY, int height, int width) {
        points[0] = new Point3D(startX, startY, 0);
        points[1] = new Point3D(startX + width, startY, 0);
        points[2] = new Point3D(startX, startY + height, 0);
        points[3] = new Point3D(startX + width, startY + height, 0);
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
    }

    public void move2D(int dx, int dy) {
        for (Point3D p : points) {
            p.move2D(dx, dy, 0);
        }
    }

    public void move3DX(int degree) {
        for (Point3D p : points) {
            p.move3DX(degree);
        }
    }

    public void move3DY(int degree) {
        for (Point3D p : points) {
            p.move3DY(degree);
        }
    }

    public List<Point3D> getPointsInDrawOrder() {
        return drawOrder;
    }
}
