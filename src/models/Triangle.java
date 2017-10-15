package models;

/**
 * Created by Maciej Sady on 15-Oct-17.
 * VirtualCamera
 */
class Triangle extends Model{


    Triangle(float startX, float startY, float startZ, float height, float width, float length) {
        super(new Point[]{

        });
    }

    @Override
    protected int[] getDrawOrder() {
        return new int[0];
    }
}
