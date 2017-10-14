/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
class UserInput {
    private final Scene scene;

    UserInput(Scene scene) {
        this.scene = scene;
    }

    void dispatchKey(char key) {
        switch (key) {
            case 'a':
            case 'A':
                scene.tiltYaw((float) -Math.PI/360);
                break;

            case 'w':
            case 'W':
                scene.moveZ(1);
                break;

            case 's':
            case 'S':
                scene.moveZ(-1);
                break;

            case 'd':
            case 'D':
                scene.tiltYaw((float) Math.PI/360);
                break;

            case 'q':
            case 'Q':
                scene.moveX(1);
                break;

            case 'e':
            case 'E':
                scene.moveX(-1);
                break;

            case 'r':
            case 'R':
                scene.tiltPitch((float) Math.PI/360);
                break;

            case 'f':
            case 'F':
                scene.tiltPitch((float) -Math.PI/360);

                break;

            case 't':
            case 'T':

                break;

            case 'g':
            case 'G':

                break;
        }
    }

    String getInputDescription() {
        return "W - up S - down A - left D - right";
    }
}
