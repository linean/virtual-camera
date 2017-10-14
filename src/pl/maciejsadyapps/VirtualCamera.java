package pl.maciejsadyapps;

import processing.core.PApplet;

/**
 * Created by Maciej Sady on 14-Oct-17.
 * VirtualCamera
 */
public class VirtualCamera extends PApplet {

    private static final int WINDOW_WIDTH = 640;
    private static final int WINDOW_HEIGHT = 480;

    public static void main(String args[]) {
        PApplet.main(VirtualCamera.class.getName());
    }

    @Override
    public void settings() {
        size(WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    @Override
    public void setup() {
        clear();
    }

    @Override
    public void draw() {
        fill(255);
        rect(50, 50, 100, 100);
    }
}

