import processing.core.PApplet;

public class MyFirstProject extends PApplet {

    public static void main(String[] args) {
        PApplet.main("MyFirstProject");
    }

    public void settings() {
        size (700, 800);
    }

    public void setup() {
        background(255,255,255);
    }

    public void draw() {
        face(100, 300);
    }

    public void face(float xPos, float yPos) {
        fill(12, 99, 241);
        rect(xPos, yPos, 500, 300);
        eyes(xPos + 100, yPos + 100);
        mouth(xPos + 150, yPos + 200);
    }

    public void eyes(float eyesX, float eyesY) {
        fill(25, 25, 25);
        ellipse(eyesX, eyesY, 100, 100);
        ellipse(eyesX + 300, eyesY, 25, 25);
    }

    public void mouth(float mouthX, float mouthY) {
        fill(0, 255, 255);
        triangle(mouthX, mouthY, mouthX + 250, mouthY, mouthX + 100, mouthY + 75);
    }

}