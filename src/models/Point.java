package models;

import static utils.MatrixTransformationUtils.*;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
public class Point {
    private static final int MATRIX_SIZE = 4;
    private float[] pointMatrix = new float[MATRIX_SIZE];

    Point(float x, float y, float z) {
        pointMatrix[0] = x;
        pointMatrix[1] = y;
        pointMatrix[2] = z;
        pointMatrix[3] = 1;
    }

    void move(float tx, float ty, float tz) {
        float[][] moveMatrix = createMoveMatrix(tx, ty, tz);
        pointMatrix = applyMatrixTransformation(moveMatrix, pointMatrix);
    }

    void tilt(float yaw, float roll, float pitch) {
        float[][] tiltMatrix = null;

        if (yaw != 0)
            tiltMatrix = createYawMatrix(yaw);

        else if (roll != 0)
            tiltMatrix = createRollMatrix(roll);

        else if (pitch != 0)
            tiltMatrix = createPitchMatrix(pitch);

        pointMatrix = applyMatrixTransformation(tiltMatrix, pointMatrix);
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
