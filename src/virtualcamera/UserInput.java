package virtualcamera;

import virtualcamera.models.Scene;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
class UserInput {
    private static final float MOVE_STEP = 2;
    private static final float TILT_STEP = (float) Math.PI / 180;
    private final Scene scene;


    UserInput(Scene scene) {
        this.scene = scene;
    }

    void dispatchKey(char key) {
        switch (key) {
            case 'a':
            case 'A':
                scene.tiltYaw(-TILT_STEP);
                break;

            case 'w':
            case 'W':
                scene.moveZ(MOVE_STEP);
                break;

            case 's':
            case 'S':
                scene.moveZ(-MOVE_STEP);
                break;

            case 'd':
            case 'D':
                scene.tiltYaw(TILT_STEP);
                break;

            case 'q':
            case 'Q':
                scene.moveX(MOVE_STEP);
                break;

            case 'e':
            case 'E':
                scene.moveX(-MOVE_STEP);
                break;

            case 'r':
            case 'R':
                scene.tiltPitch(TILT_STEP);
                break;

            case 'f':
            case 'F':
                scene.tiltPitch(-TILT_STEP);
                break;

            case 'z':
            case 'Z':
                scene.tiltRoll(-TILT_STEP);
                break;

            case 'x':
            case 'X':
                scene.tiltRoll(TILT_STEP);
                break;

            case 'l':
            case 'L':
                scene.reset();
                break;
        }
    }

    String getInputDescription() {
        return "W - up S - down A - left D - right";
    }
}
