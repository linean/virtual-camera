import static processing.core.PApplet.*;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
public class Point3D {
    private static final int MATRIX_SIZE = 4;
    private float[] pointMatrix = new float[MATRIX_SIZE];

    Point3D(int x, int y, int z) {
        pointMatrix[0] = x;
        pointMatrix[1] = y;
        pointMatrix[2] = z;
        pointMatrix[3] = 1;
    }

    void move2D(int tx, int ty, int tz) {
        float[][] moveMatrix = {
                {1, 0, 0, tx},
                {0, 1, 0, ty},
                {0, 0, 1, tz},
                {0, 0, 0, 1}
        };

        multipleByMatrix(moveMatrix);
    }

    void move3DY(int degree) {
        float rad = radians(degree);
        float[][] moveMatrix = {
                {cos(rad), 0, sin(rad), 0},
                {0, 1, 0, 0},
                {-sin(rad), 0, cos(rad), 0},
                {0, 0, 0, 1}
        };

        multipleByMatrix(moveMatrix);
    }

    void move3DX(int degree) {
        float rad = radians(degree);
        float[][] moveMatrix = {
                {1, 0, 0, 0},
                {0, cos(rad), -sin(rad), 0},
                {0, sin(rad), cos(rad), 0},
                {0, 0, 0, 1}
        };

        multipleByMatrix(moveMatrix);
    }

    private void multipleByMatrix(float[][] matrix) {
        float[] result = new float[MATRIX_SIZE];
        for (int i = 0; i < matrix.length; i++) {
            float val = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                val += matrix[i][j] * pointMatrix[j];
            }
            result[i] = val;
        }

        pointMatrix = result;
    }

    float getX() {
        return pointMatrix[0];
    }

    float getY() {
        return pointMatrix[1];
    }

    float getZ() {
        return pointMatrix[2];
    }
}
