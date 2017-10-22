package virtualcamera;

import virtualcamera.models.Scene;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
class UserInput {
    private static final float MOVE_STEP = 3;
    private static final float MOVE_STEP_FAST = 5;
    private static final float TILT_STEP = (float) Math.PI / 180;
    private static final float TILT_STEP_FAST = (float) Math.PI / 90;
    private static final float PERSPECTIVE_FACTOR_STEP = 1 / 0.95f;
    private static final int WHITE = 255;
    private static final int BLACK = 0;

    private final Scene scene;
    private float moveStep;
    private float tiltStep;
    private int backgroundColor;
    private int sceneColor;
    private boolean isInputLocked;


    UserInput(Scene scene) {
        this.scene = scene;
        this.moveStep = MOVE_STEP;
        this.tiltStep = TILT_STEP;
        this.backgroundColor = BLACK;
        this.sceneColor = WHITE;
        this.isInputLocked = false;
    }

    void keyPressed(char key) {
        if (isInputLocked) return;

        switch (key) {
            case 'a':
            case 'A':
                scene.tiltYaw(-tiltStep);
                break;

            case 'w':
            case 'W':
                scene.moveZ(moveStep);
                break;

            case 's':
            case 'S':
                scene.moveZ(-moveStep);
                break;

            case 'd':
            case 'D':
                scene.tiltYaw(tiltStep);
                break;

            case 'q':
            case 'Q':
                scene.moveX(moveStep);
                break;

            case 'e':
            case 'E':
                scene.moveX(-moveStep);
                break;

            case 'r':
            case 'R':
                scene.tiltPitch(tiltStep);
                break;

            case 'f':
            case 'F':
                scene.tiltPitch(-tiltStep);
                break;

            case 't':
            case 'T':
                scene.moveY(moveStep);
                break;

            case 'g':
            case 'G':
                scene.moveY(-moveStep);
                break;

            case 'z':
            case 'Z':
                scene.tiltRoll(tiltStep);
                break;

            case 'x':
            case 'X':
                scene.tiltRoll(-tiltStep);
                break;

            case 'y':
            case 'Y':
                isInputLocked = true;
                scene.changePerspective(1 / PERSPECTIVE_FACTOR_STEP);
                break;

            case 'h':
            case 'H':
                isInputLocked = true;
                scene.changePerspective(PERSPECTIVE_FACTOR_STEP);
                break;

            case 'c':
            case 'C':
                isInputLocked = true;
                moveStep = moveStep == MOVE_STEP ? MOVE_STEP_FAST : MOVE_STEP;
                tiltStep = tiltStep == TILT_STEP ? TILT_STEP_FAST : TILT_STEP;
                break;

            case 'v':
            case 'V':
                isInputLocked = true;
                sceneColor = sceneColor == WHITE ? BLACK : WHITE;
                backgroundColor = backgroundColor == WHITE ? BLACK : WHITE;
                break;
        }
    }

    void keyReleased() {
        isInputLocked = false;
    }

    int getBackgroundColor(){
        return backgroundColor;
    }

    int getSceneColor(){
        return sceneColor;
    }

    String getInputDescription() {
        return "W - idź do przodu\n" +
                "A - spójrz w lewo\n" +
                "D - spójrz w prawo\n" +
                "S - idź w dół\n" +
                "R - spójrz do góry\n" +
                "F - spójrz w dół\n" +
                "T - idź do góry\n" +
                "G - idź na dół\n" +
                "Q - idź w lewo\n" +
                "E - idź w prawo\n" +
                "Z - obróć w lewo\n" +
                "X - obróć w prawo\n" +
                "Y - zmniejsz kąt widzenia\n" +
                "H - zwiększ kąt widzenia\n" +
                "C - zmień prędkość poruszania\n" +
                "V - odwróć kolory";
    }
}
