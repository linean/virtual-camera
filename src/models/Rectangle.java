package models;


/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
class Rectangle extends Model {
    public Rectangle(int startX, int startY, int startZ, int height, int width, int length) {
        super(new Point[]{
                new Point(startX, startY, startZ),
                new Point(startX + width, startY, startZ),
                new Point(startX, startY + height, startZ),
                new Point(startX + width, startY + height, startZ),
                new Point(startX, startY, startZ + length),
                new Point(startX + width, startY, startZ + length),
                new Point(startX, startY + height, startZ + length),
                new Point(startX + width, startY + height, startZ + length),
        });
    }

    @Override
    public int[] getDrawOrder() {
        return new int[]{0, 1, 1, 3, 3, 2, 2, 0,
                4, 5, 5, 7, 7, 6, 6, 4,
                0, 4, 1, 5, 3, 7, 2, 6};
    }
}
