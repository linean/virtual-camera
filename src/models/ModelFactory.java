package models;

/**
 * Created by Maciej Sady on 15-Oct-17.
 * VirtualCamera
 */
public class ModelFactory {

    private ModelFactory() {}

    public enum ModelType {
        RECTANGLE
    }

    public static Model createModel(ModelType type, int startX, int startY, int startZ, int height, int width, int length) {
        switch (type) {
            case RECTANGLE:
                return new Rectangle(startX, startY, startZ, height, width, length);

            default:
                throw new IllegalArgumentException("Missing model type");
        }
    }
}
