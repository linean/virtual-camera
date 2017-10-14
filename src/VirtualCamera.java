import processing.core.PApplet;

import java.util.List;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
public class VirtualCamera extends PApplet {

    private static final int WINDOW_WIDTH = 640;
    private static final int WINDOW_HEIGHT = 480;

    public static void main(String args[]) {
        PApplet.main(VirtualCamera.class.getName());
    }

    private Rectangle3D rectangle3D;

    @Override
    public void settings() {
        size(WINDOW_WIDTH, WINDOW_HEIGHT, P3D);
    }

    @Override
    public void setup() {
        rectangle3D = new Rectangle3D(0,0,100, 100);
    }

    @Override
    public void draw() {
        translate(width/2, height/2, 0);
        background(0);
        stroke(255);
        drawObject(rectangle3D);

        if (keyPressed){
            dispatchKey();
        }
    }

    private void dispatchKey() {
        System.out.println("Key pressed: " + key);
        switch (key){
            case 'a':
                rectangle3D.move2D(-1, 0);
                break;

            case 'w':
                rectangle3D.move2D(0, -1);
                break;

            case 's':
                rectangle3D.move2D(0, 1);
                break;

            case 'd':
                rectangle3D.move2D(1, 0);
                break;

            case 'q':
                rectangle3D.move3DY(1);
                break;

            case 'e':
                rectangle3D.move3DY(-1);
                break;

            case 'r':
                rectangle3D.move3DX(1);
                break;

            case 'f':
                rectangle3D.move3DX(-1);
                break;


        }
    }

    private void drawObject(Rectangle3D rect) {
        List<Point3D> points = rect.getPointsInDrawOrder();
        for (int i = 1; i < points.size(); i += 2){
            Point3D pointA = points.get(i - 1);
            Point3D pointB = points.get(i);
            line(pointA.getX(), pointA.getY(), pointA.getZ(),
                    pointB.getX(), pointB.getY(), pointB.getZ());
        }
    }
}

