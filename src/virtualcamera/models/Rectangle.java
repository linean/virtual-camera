package virtualcamera.models;


import org.codehaus.jackson.annotate.JsonProperty;

import static virtualcamera.Config.Z_OFFSET;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
class Rectangle extends Model {

    Rectangle(@JsonProperty("start_x") float startX,
                     @JsonProperty("start_y") float startY,
                     @JsonProperty("start_z") float startZ,
                     @JsonProperty("height") float height,
                     @JsonProperty("width") float width,
                     @JsonProperty("length") float length) {
        super(new Point[]{
                new Point(startX, startY, startZ - Z_OFFSET),
                new Point(startX + width, startY, startZ - Z_OFFSET),
                new Point(startX + width, startY - height, startZ  -Z_OFFSET),
                new Point(startX, startY - height, startZ - Z_OFFSET),
                new Point(startX, startY, startZ + length - Z_OFFSET),
                new Point(startX + width, startY, startZ + length - Z_OFFSET),
                new Point(startX + width, startY - height, startZ + length - Z_OFFSET),
                new Point(startX, startY - height, startZ + length - Z_OFFSET),
        });
    }

    @Override
    public int[] getDrawOrder() {
        return new int[]{0, 1, 1, 2, 2, 3, 3, 0,
                4, 5, 5, 6, 6, 7, 7, 4,
                0, 4, 1, 5, 2, 6, 3, 7};
    }
}
