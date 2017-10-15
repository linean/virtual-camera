package models;

/**
 * Created by Maciej Sady on 15-Oct-17.
 * VirtualCamera
 */
class ModelFactory {

    private ModelFactory() {}

    public enum ModelType {
        RECTANGLE, TRIANGLE
    }

    static Model createModel(ModelType type, float startX, float startY, float startZ, float height, float width, float length) {
        switch (type) {
            case RECTANGLE:
                return new Rectangle(startX, startY, startZ, height, width, length);

            case TRIANGLE:
                return new Triangle(startX, startY, startZ, height, width, length);

            default:
                throw new IllegalArgumentException("Missing model type");
        }
    }
}
