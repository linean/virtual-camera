package models;

import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
public class Point {
    private static final int MATRIX_SIZE = 4;
    private float[] pointMatrix = new float[MATRIX_SIZE];

    Point(int x, int y, int z) {
        pointMatrix[0] = x;
        pointMatrix[1] = y;
        pointMatrix[2] = z;
        pointMatrix[3] = 1;
    }

    void move(int tx, int ty, int tz) {
        float[][] moveMatrix = {
                {1, 0, 0, tx},
                {0, 1, 0, ty},
                {0, 0, 1, tz},
                {0, 0, 0, 1}
        };

        multipleByMatrix(moveMatrix);
    }

    void tilt(float yaw, float roll, float pitch) {
        float[][] tiltMatrix = null;

        if (yaw != 0) {
            tiltMatrix = new float[][]{
                    {cos(yaw), 0, sin(yaw), 0},
                    {0, 1, 0, 0},
                    {-sin(yaw), 0, cos(yaw), 0},
                    {0, 0, 0, 1}
            };
        } else if (roll != 0) {
            //TODO roll matrix

        } else if (pitch != 0) {
            tiltMatrix = new float[][]{
                    {1, 0, 0, 0},
                    {0, cos(pitch), -sin(pitch), 0},
                    {0, sin(pitch), cos(pitch), 0},
                    {0, 0, 0, 1}
            };
        }

        if (tiltMatrix != null) multipleByMatrix(tiltMatrix);
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

    public float x() {
        return pointMatrix[0];
    }

    public float y() {
        return pointMatrix[1];
    }

    public float z() {
        return pointMatrix[2];
    }
}
