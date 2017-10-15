package utils;

import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
public class MatrixTransformationUtils {

    private MatrixTransformationUtils() {
    }

    public static float[][] createMoveMatrix(float tx, float ty, float tz) {
        return new float[][]{
                {1, 0, 0, tx},
                {0, 1, 0, ty},
                {0, 0, 1, tz},
                {0, 0, 0, 1}
        };
    }

    public static float[][] createYawMatrix(float yaw) {
        return new float[][]{
                {cos(yaw), 0, sin(yaw), 0},
                {0, 1, 0, 0},
                {-sin(yaw), 0, cos(yaw), 0},
                {0, 0, 0, 1}
        };
    }

    public static float[][] createPitchMatrix(float pitch) {
        return new float[][]{
                {1, 0, 0, 0},
                {0, cos(pitch), -sin(pitch), 0},
                {0, sin(pitch), cos(pitch), 0},
                {0, 0, 0, 1}
        };
    }

    public static float[][] createRollMatrix(float pitch) {
        return new float[][]{
                {cos(pitch), -sin(pitch), 0, 0},
                {sin(pitch), cos(pitch), 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
    }

    public static float[] applyMatrixTransformation(float[][] transformationMatrix, float[] pointMatrix) {
        float[] result = new float[pointMatrix.length];
        for (int i = 0; i < transformationMatrix.length; i++) {
            float val = 0;
            for (int j = 0; j < transformationMatrix[i].length; j++) {
                val += transformationMatrix[i][j] * pointMatrix[j];
            }
            result[i] = val;
        }

        return result;
    }
}
