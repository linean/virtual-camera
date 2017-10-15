package virtualcamera.models;

import org.codehaus.jackson.annotate.JsonProperty;

import static virtualcamera.Config.Z_OFFSET;

/**
 * Created by Maciej Sady on 15-Oct-17.
 * VirtualCamera
 */
class Triangle extends Model {

    Triangle(@JsonProperty("start_x") float startX,
             @JsonProperty("start_y") float startY,
             @JsonProperty("start_z") float startZ,
             @JsonProperty("height") float height,
             @JsonProperty("width") float width,
             @JsonProperty("length") float length) {
        super(new Point[]{
                new Point(startX, startY, startZ - Z_OFFSET),
                new Point(startX + width, startY, startZ - Z_OFFSET),
                new Point(startX + width, startY, startZ + length - Z_OFFSET),
                new Point(startX, startY, startZ + length - Z_OFFSET),
                new Point(startX + width / 2, startY - height, startZ + (length / 2) - Z_OFFSET),
        });
    }

    @Override
    protected int[] getDrawOrder() {
        return new int[]{0, 1, 1, 2, 2, 3, 3, 0,
                0, 4, 1, 4, 2, 4, 3, 4};
    }
}
