//package BlobGameAI;
// highest score: 46 points
// longest time: 82 seconds

import java.util.Random;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;

import java.io.FileWriter;

public class BlobGameAI extends PApplet {
    int screenW = 512;
    int screenH = 704;

    int playerSpeed = 5;
    float playerX = 256;
    float playerY = 352;
    boolean left, right, up, down;

    ArrayList<Enemy> enemies = new ArrayList<>();
    float originalEnemySpeed = 2f;
    float enemySpeed = originalEnemySpeed;

    int shotTimer = 0;
    int shotWait = 100;
    float bulletSpeed = 8;
    ArrayList<Bullet> bullets = new ArrayList<>();

    int time = 0;

    String specialMoveName = "shots";
    int specialMoveTimer = 0;
    int specialMoveWait = 600;
    int specialPersent = 0;
    int specialMoveDur = 40;
    boolean specialMove = false;

    float originalSpawnRate = 100;
    float spawnRate = originalSpawnRate;
    PImage backgroundImg;

    PImage[] playerAnim = new PImage[6];
    int animationFrame = 1;

    PImage[][] enemyAnimations = new PImage[3][6];

    PImage[] explosionAnimation = new PImage[6];

    int score = 0;
    int highScore = 0;
    int averageScore = 0;
    int bestTime = 0;
    ArrayList<Integer> scores = new ArrayList<>();
    ArrayList<Integer> times = new ArrayList<>();
    PFont scoreFont;

    int neededForBoost = 20;
    int neededForCircle = 20;
    int neededForShotgun = 60;
    int neededForTeleport = 40;

    String currentStates = "RUNNING";

    PImage gameOverImg;
    PImage restartButton;
    PImage lockSign;

    PImage[] plants = new PImage[5];
    int numOfPlants = 5;

    int gen = 1;
    int AINumInGen = 10;
    int AINum = 1;
    AI ai = new AI();
    AI bestAI = ai;


    public static void main(String[] args) {
        PApplet.main("BlobGameAI");
    }

    public void settings() {
        size(screenW, screenH);
    }

    public void setup() {
        Random rand = new Random();
        backgroundImg = loadImage("Images/Background.png");
        for (int i = 1; i <= 6; i++) {
            playerAnim[i - 1] = loadImage("Images/Bat_Brains_" + i + ".png");
            playerAnim[i - 1].resize(60, 0);
        }
        for (int j = 1; j <= 6; j++) {
            enemyAnimations[0][j - 1] = loadImage("Images/Bat_Purple" + j + ".png");
            enemyAnimations[1][j - 1] = loadImage("Images/Bat_Square" + j + ".png");
            enemyAnimations[2][j - 1] = loadImage("Images/Bat_Booger" + j + ".png");

            enemyAnimations[0][j - 1].resize(60, 0);
            enemyAnimations[1][j - 1].resize(60, 0);
            enemyAnimations[2][j - 1].resize(60, 0);
        }
        for (int i = 1; i <= 6; i++) {
            explosionAnimation[i - 1] = loadImage("Images/Explosion_FX" + i + ".png");
            explosionAnimation[i - 1].resize(60, 0);
        }
        currentStates = "MENU";
        gameOverImg = loadImage("Images/GameOverImg.png");
        gameOverImg.resize(300, 0);
        restartButton = loadImage("Images/WoodButton.png");
        restartButton.resize(240, 50);
        for (int i = 1; i <= 5; i++) {
            plants[i - 1] = loadImage("Images/plant" + i + ".png");
        }
    }

    public void draw() {
        drawBackground();
        switch (currentStates) {
            case "OVER":
                drawGameOver();
                for (int i = 0; i < enemies.size(); i++) {
                    enemies.remove(i);
                }
                for (int i = 0; i < bullets.size(); i++) {
                    bullets.remove(i);
                }
                up = false;
                down = false;
                left = false;
                right = false;
                specialMoveTimer = 0;
                specialPersent = 0;
                specialMove = false;
                enemySpeed = originalEnemySpeed;
                spawnRate  = originalSpawnRate;
                playerSpeed = 5;
                playerX = screenW / 2;
                playerY = screenH / 2;
                break;

            case "PAUSED":
                drawPausedGame();
                break;

            case "MENU":
                for (int i = 0; i < bullets.size(); i++) {
                    bullets.remove(i);
                }
                for (int i = 0; i < enemies.size(); i++) {
                    enemies.remove(i);
                }
                drawMenu();
                break;

            case "STATS":
                drawStatsMenu();
                break;

            case "CHANGE_MOVE":
                drawChangeMoveMenu();
                break;


            case "RUNNING":
//                drawPlants();
                ai.turn();
                shotTimer ++;
                specialMoveTimer ++;
                specialPersent = (specialMoveTimer * 100) / specialMoveWait;
                if (specialMove == true){
                    if(specialMoveName == "shotgun") {
                        specialMoveDur = 40;
                    }
                    if(specialMoveName == "shots") {
                        specialMoveDur = 60;
                    }
                    if(specialMoveName == "circle") {
                        specialMoveDur = 2;
                    }
                    if(specialMoveName == "boost") {
                        specialMoveDur = 200;
                    }
                    if(specialMoveName == "teleport") {
                        specialMoveDur = 2;
                    }
                    if (specialMoveTimer == specialMoveDur){
                        specialMove = false;
                        specialMoveTimer = 0;
                        playerSpeed = 5;
                    }
                    else{
                        if(specialMoveName == "shotgun") {
                            if(specialMoveTimer % 10 == 0) {
                                shotgun();
                            }
                        }
                        if(specialMoveName == "shots") {
                            if(specialMoveTimer % 5 == 0) {
                                shots();
                            }
                        }
                        if(specialMoveName == "circle") {
                            circleShot();
                        }
                        if(specialMoveName == "boost") {
                            playerSpeed = 7;
                        }
                        if(specialMoveName == "teleport") {
                            teleport();
                        }

                    }
                }
                if (frameCount % 60 == 0) {
                    time ++;
                }
                drawScore();
                drawTime();
                noStroke();
                if (frameCount % 5 == 0) {
                    animationFrame++;
                    animationFrame = animationFrame % 6;
                    for (int i = 0; i < enemies.size(); i++) {
                        Enemy en = enemies.get(i);
                        if (en.isDead == true) {
                            en.explosionFrame++;
                            if (en.explosionFrame == 5) {
                                enemies.remove(i);
                            }
                        }
                    }
                }
                drawPlayer();
                increaseDifficulty();

                for (int b = 0; b < bullets.size(); b++) {
                    Bullet bull = bullets.get(b);
                    bull.move();
                    bull.drawBullet();
                    if (bull.x < 0 || bull.x > width || bull.y < 0 || bull.y > height) {
                        bullets.remove(b);
                    }
                }
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy en = enemies.get(i);
                    en.move(playerX, playerY);
                    en.drawEnemy();
                    for (int j = 0; j < bullets.size(); j++) {
                        Bullet b = bullets.get(j);
                        if (abs(b.x - en.x) < 15 && abs(b.y - en.y) < 15 && en.isDead == false) {
                            en.isDead = true;
                            bullets.remove(j);
                            score += 1;
                            break;
                        }
                    }
                    if (abs(playerX - en.x) < 15 && abs(playerY - en.y) < 15 && en.isDead == false) {
                        if (score > highScore) {
                            bestAI = ai;
                            highScore = score;
                        }
                        if (time > bestTime) {
                            bestTime = time;
                        }
                        scores.add(score);
                        times.add(time);
                        averageScore = 0;
                        for(int d = 0; d<scores.size(); d++){
                            averageScore += scores.get(d);
                        }
                        averageScore = averageScore / scores.size();
                        ai.score = score + (time / 2);
                        if (AINum < AINumInGen){
                            print(ai.score + " score for AI " + AINum + ", ");
                            AINum ++;
                            ai = new AI();
                            currentStates = "OVER";
//                            currentStates = "RUNNING";
                        }
                        else{

                            currentStates = "OVER";
                        }
//                        currentStates = "OVER";
                    }
                }
                break;
        }

    }

    public void AIMove() {

    }

    public void shots() {
        float dx = mouseX - playerX;
        float dy = mouseY - playerY;
        float angle = atan2(dy, dx);
        float vx = bulletSpeed * cos(angle);
        float vy = bulletSpeed * sin(angle);
        bullets.add(new Bullet(playerX, playerY, vx, vy));
    }

    public void shotgun() {
        for(int i = -6; i<=6; i+= 3) {
            float dx = mouseX - playerX - (i * 15);
            float dy = mouseY - playerY - (i * 15);
            float angle = atan2(dy, dx);
            float vx = bulletSpeed * cos(angle);
            float vy = bulletSpeed * sin(angle);
            bullets.add(new Bullet(playerX, playerY, vx, vy));
        }
    }

    public void circleShot() {
        for(int i = 0; i<=180; i+= 5) {
            float dx = mouseX - playerX - (i);
            float dy = mouseY - playerY - (i);
            float angle = atan2(dy, dx);
            float vx = bulletSpeed * cos(i);
            float vy = bulletSpeed * sin(i);
            bullets.add(new Bullet(playerX, playerY , vx, vy));
        }
    }

    public void teleport() {
        playerX = mouseX;
        playerY = mouseY;
    }

    public void drawMenu() {
        scoreFont = createFont("Leelawadee UI Bold", 26, true);
        textFont(scoreFont);
        backgroundImg = loadImage("Images/MenuBackground.png");
        backgroundImg.resize(512, 704);
        imageMode(CENTER);
        gameOverImg.resize(300, 70);
        image(gameOverImg, width / 2, height / 3 - 80);
        fill(122, 64, 51);
        text("Menu", width / 2, height / 2 - 190);
        textAlign(CENTER);
        image(restartButton, width / 2, height / 2 - 40);
        image(restartButton, width / 2, height / 2 + 30);
        image(restartButton, width / 2, height / 2 + 100);
        fill(255, 255, 255);
        text("New Game ", width / 2, height / 2 - 35);
        text("Stats ", width / 2, height / 2 + 35);
        text("Special Powers  ", width / 2, height / 2 + 105);
    }

    public void drawStatsMenu() {
        scoreFont = createFont("Leelawadee UI Bold", 26, true);
        textFont(scoreFont);
        backgroundImg = loadImage("Images/MenuBackground.png");
        backgroundImg.resize(512, 704);
        imageMode(CENTER);
        gameOverImg.resize(300, 70);
        image(gameOverImg, width / 2, height / 3 - 80);
        fill(122, 64, 51);
        text("Stats", width / 2, height / 2 - 190);
        textAlign(CENTER);
        image(restartButton, width / 2, height / 2 - 120);
        image(restartButton, width / 2 - 100, height / 2 + 300);
        fill(255, 255, 255);
        text("Save Stats ", width / 2, height / 2 - 115);
        fill(34,139,34);
        ellipse(width / 2, height / 2 + 50, 250, 250);
        fill(255, 255, 255);
        text("High Score: " + highScore, width / 2, height / 2 + 10);
        text("Average Score: " + averageScore, width / 2, height / 2 + 60);
        text("Best Time: " + bestTime, width / 2, height / 2 + 110);
        text("Back", width / 2 - 100, height / 2 + 305);
    }

    public void drawChangeMoveMenu() {
        scoreFont = createFont("Leelawadee UI Bold", 26, true);
        textFont(scoreFont);
        backgroundImg = loadImage("Images/MenuBackground.png");
        backgroundImg.resize(512, 704);
        lockSign = loadImage("Images/sign (3).png");
        imageMode(CENTER);
        image(gameOverImg, width / 2, height / 3 - 80);
        fill(122, 64, 51);
        text("Special Powers ", width / 2, height / 2 - 190);
        textAlign(CENTER);
        image(restartButton, width / 2 - 100, height / 2 - 60);
        image(restartButton, width / 2 + 100, height / 2);
        image(restartButton, width / 2 - 100, height / 2 + 60);
        image(restartButton, width / 2 + 100, height / 2 + 120);
        image(restartButton, width / 2 - 100, height / 2 + 180);

        image(restartButton, width / 2 - 100, height / 2 + 300);
        fill(255, 255, 255);text("Back", width / 2 - 100, height / 2 + 305);
        if (specialMoveName == "shots"){
            fill(0, 255, 0);
            text("Shots ", width / 2 - 95, height / 2 - 55);
            fill(255, 255, 255);
        }else{
            text("Shots ", width / 2 - 95, height / 2 - 55);
        }
        if(bestTime < neededForBoost){
            fill(255, 255, 255);
            image(lockSign, width / 2 + 100, height / 2 - 35);
            scoreFont = createFont("Leelawadee UI Bold", 16, true);
            textFont(scoreFont);
            text("Survive 20 Seconds", width / 2 + 110, height / 2 + 5);
            scoreFont = createFont("Leelawadee UI Bold", 26, true);
            textFont(scoreFont);
        }else {
            if (specialMoveName == "boost") {
                fill(0, 255, 0);
                text("Speed Boost ", width / 2 + 110, height / 2 + 5);
                fill(255, 255, 255);
            } else {
                text("Speed Boost ", width / 2 + 110, height / 2 + 5);
            }
        }
        if(highScore < neededForCircle){
            fill(255, 255, 255);
            image(lockSign, width / 2 - 100, height / 2 + 25);
            scoreFont = createFont("Leelawadee UI Bold", 16, true);
            textFont(scoreFont);
            text("High Score of 20 ", width / 2 - 95, height / 2 + 65);
            scoreFont = createFont("Leelawadee UI Bold", 26, true);
            textFont(scoreFont);
        }else {
            if (specialMoveName == "circle") {
                fill(0, 255, 0);
                text("Circle Shot ", width / 2 - 95, height / 2 + 65);
                fill(255, 255, 255);
            } else {
                text("Circle Shot ", width / 2 - 95, height / 2 + 65);
            }
        }
        if(bestTime < neededForShotgun){
            fill(255, 255, 255);
            image(lockSign, width / 2 + 100, height / 2 + 85);
            scoreFont = createFont("Leelawadee UI Bold", 16, true);
            textFont(scoreFont);
            text("Survive 60 Seconds ", width / 2 + 110, height / 2 + 125);
            scoreFont = createFont("Leelawadee UI Bold", 26, true);
            textFont(scoreFont);
        }else {
            if (specialMoveName == "shotgun") {
                fill(0, 255, 0);
                text("Shotgun ", width / 2 + 110, height / 2 + 125);
                fill(255, 255, 255);
            } else {
                text("Shotgun ", width / 2 + 110, height / 2 + 125);
            }
        }
        if(highScore < neededForTeleport){
            fill(255, 255, 255);
            image(lockSign, width / 2 - 100, height / 2 + 145);
            scoreFont = createFont("Leelawadee UI Bold", 16, true);
            textFont(scoreFont);
            text("High Score of 40", width / 2 - 95, height / 2 + 185);
            scoreFont = createFont("Leelawadee UI Bold", 26, true);
            textFont(scoreFont);
        }else {
            if (specialMoveName == "teleport") {
                fill(0, 255, 0);
                text("Teleport ", width / 2 - 95, height / 2 + 185);
                fill(255, 255, 255);
            } else {
                fill(255, 255, 255);
                text("Teleport ", width / 2 - 95, height / 2 + 185);
            }
        }

    }

    public void drawPausedGame() {
        imageMode(CENTER);
        gameOverImg.resize(300, 700);
        image(gameOverImg, width / 2, height / 2);
        fill(122, 64, 51);
        textAlign(CENTER);
        text("Game Paused ", width / 2, height / 2 - 100);
        image(restartButton, width / 2, height / 2 - 40);
        image(restartButton, width / 2, height / 2 + 30);
        image(restartButton, width / 2, height / 2 + 100);
        fill(255, 255, 255);
        text("Continue ", width / 2, height / 2 - 35);
        text("Menu ", width / 2, height / 2 + 35);
        text("Restart ", width / 2, height / 2 + 105);
    }

    public void drawGameOver() {
        imageMode(CENTER);
        gameOverImg.resize(300, 700);
        image(gameOverImg, width / 2, height / 2);
        fill(122, 64, 51);
        textAlign(CENTER);
        text("Game Over ", width / 2, height / 2 - 100);
        text("Score: " + score, width / 2 - 80, height / 2 - 40);
        text("Time: " + time, width / 2 + 80, height / 2 - 40);
        text("High Score: " + highScore, width / 2, height / 2 + 10);
        image(restartButton, width / 2, height / 2 + 100);
        image(restartButton, width / 2, height / 2 + 170);
        fill(255, 255, 255);
        text("Restart ", width / 2, height / 2 + 105);
        text("Menu ", width / 2, height / 2 + 175);
        if(scores.get(scores.size() - 1) >= 20){
            int fin = 0;
            for (int i = 0; i<scores.size(); i++) {
                if (scores.get(i) >= 20) {
                    fin = i;
                    i = scores.size();
                }
                if (fin == scores.size() - 1){
                    if(frameCount % 100 <= 70) {
                        fill(230, 23, 34);
                        text("Move Unlocked! ", width / 2 + 10, height / 2 + 50);
                    }
                }
            }
        }
        if(scores.get(scores.size() - 1) >= 40){
            int fin = 0;
            for (int i = 0; i<scores.size(); i++) {
                if (scores.get(i) >= 40) {
                    fin = i;
                    i = scores.size();
                }
                if (fin == scores.size() - 1){
                    if(frameCount % 100 <= 70) {
                        fill(230, 23, 34);
                        text("Move Unlocked! ", width / 2 + 10, height / 2 + 50);
                    }
                }
            }
        }
        if(times.get(times.size() - 1) >= 20){
            int fin = 0;
            for (int i = 0; i<times.size(); i++) {
                if (times.get(i) >= 20) {
                    fin = i;
                    i = times.size();
                }
                if (fin == times.size() - 1){
                    if(frameCount % 100 <= 70) {
                        fill(230, 23, 34);
                        text("Move Unlocked! ", width / 2 + 10, height / 2 + 50);
                    }
                }
            }
        }
        if(times.get(times.size() - 1) >= 60){
            int fin = 0;
            for (int i = 0; i<times.size(); i++) {
                if (times.get(i) >= 60) {
                    fin = i;
                    i = times.size();
                }
                if (fin == times.size() - 1){
                    if(frameCount % 100 <= 70) {
                        fill(230, 23, 34);
                        text("Move Unlocked! ", width / 2 + 10, height / 2 + 50);
                    }
                }
            }
        }
    }

    public void drawTime() {
        scoreFont = createFont("Leelawadee UI Bold", 26, true);
        textFont(scoreFont);
        fill(255, 255, 255);
        textAlign(CENTER);
        text("Time: " + time, width - 90, 40);
    }

    public void drawScore() {
        scoreFont = createFont("Leelawadee UI Bold", 26, true);
        textFont(scoreFont);
        fill(255, 255, 255);
        textAlign(CENTER);
        text("Score: " + score, 90, 40);
    }

    public void drawPlants() {
//        for (int i = 0; i < numOfPlants; i++) {
//            int type = rand.nextInt(5);
//            int x = rand.nextInt(width - 70);
//            int y = rand.nextInt(height - 70);
//            image(plants[type], x + 70, y + 70);
//        }
        image(plants[1], 100, 90);
        image(plants[1], 140, 400);
        image(plants[2], 140, 240);
        image(plants[3], 340, 300);
        image(plants[4], 250, 490);
        image(plants[3], 200, 130);
        image(plants[4], 200, 390);
        image(plants[0], 330, 450);
        image(plants[1], 330, 120);
        image(plants[2], 340, 400);
        image(plants[3], 320, 200);
        image(plants[4], 240, 100);
    }

    public void drawBackground() {
        background(250);
        imageMode(CORNER);
        image(backgroundImg, 0, 0);
    }

    public void increaseDifficulty() {
        if (frameCount % spawnRate == 0) {
            generateEnemy();
            if(enemySpeed < playerSpeed - 0.2 && score > 35) {
                enemySpeed += 0.01f;
            }
            else if  (enemySpeed < 4.3) {
                enemySpeed += 0.05f;
            }
            if (spawnRate > 5) {
                spawnRate -= 10;
            }
        }
    }

    public void generateEnemy() {
        int side = (int) random(0, 2);
        int side2 = (int) random(0, 2);
        if (side % 2 == 0) { // top and bottom
            enemies.add(new Enemy(random(0, width), height * (side2 % 2), (int) random(0, 3)));
        } else { // sides
            enemies.add(new Enemy(width * (side2 % 2), random(0, height), (int) random(0, 3)));
        }
    }

    public void drawPlayer() {
        if (up) {
            playerY -= playerSpeed;
        }
        if (left) {
            playerX -= playerSpeed;
        }
        if (right) {
            playerX += playerSpeed;
        }
        if (down) {
            playerY += playerSpeed;
        }
        playerX = constrain(playerX, 70, width - 70);
        playerY = constrain(playerY, 70, height - 70);
        imageMode(CENTER);
        image(playerAnim[animationFrame], playerX, playerY);
        fill(0, 230, 172);
        rectMode(CENTER);
        if (specialMoveTimer < specialMoveWait) {
            fill(51, 204, 204);
            rect( playerX - 15 + (30 * specialPersent / 100 / 2), playerY + 30, 40 * specialPersent / 100, 10);
        }
        else {
            fill(0, 230, 172);
            rect(playerX - 3, playerY + 30, 40, 10);
        }
        if (shotTimer > shotWait) {
            fill(0, 255, 0);
            ellipse(playerX - 2, playerY - 25, 10, 10);
        }
    }

    public void mousePressed() {
        switch (currentStates) {
            case "RUNNING":
                int mouseNum = mouseButton;
                print(mouseNum);
                print(", ");
                if(mouseNum == 37) {
                    if(shotTimer > shotWait) {
                        float dx = mouseX - playerX;
                        float dy = mouseY - playerY;
                        float angle = atan2(dy, dx);
                        float vx = bulletSpeed * cos(angle);
                        float vy = bulletSpeed * sin(angle);
                        bullets.add(new Bullet(playerX, playerY, vx, vy));
                        shotTimer = 0;
                    }
                }
                if(mouseNum == 39) {
                    if (specialMoveTimer > specialMoveWait){
                        //does something
                        specialMoveTimer = 0;
                        specialMove = true;
                    }
                }
                break;

            case "STATS":
                //save
                if (mouseX > (width / 2 - 120) && mouseX < (width / 2 + 120) && mouseY > height / 2 - 120 - 25 && mouseY < (height / 2 - 120 + 25)) {
                    try{
                        FileWriter fw=new FileWriter("Stats.txt");
                        fw.write("Welcome to javaTpoint.");
                        fw.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    System.out.println("Success...");
                }
                if (mouseX > (width / 2  - 100 - 120) && mouseX < (width / 2 - 100 + 120) && mouseY > height / 2 + 300 - 25 && mouseY < (height / 2 + 300 + 25)) {
                    currentStates = "MENU";
                }

            case "CHANGE_MOVE":
                //shotgun
                if (mouseX > (width / 2  - 100 - 120) && mouseX < (width / 2  - 100 + 120) && mouseY > height / 2 - 60 - 25 && mouseY < (height / 2 - 60 + 25)) {
                    specialMoveName = "shots";
                }
                if (mouseX > (width / 2  + 100 - 120) && mouseX < (width / 2  + 100 + 120) && mouseY > height / 2 - 25 && mouseY < (height / 2 + 25) && bestTime >= neededForBoost) {
                    specialMoveName = "boost";
                }
                if (mouseX > (width / 2  - 100 - 120) && mouseX < (width / 2  - 100 + 120) && mouseY > height / 2 + 60 - 25 && mouseY < (height / 2 + 60 + 25) && highScore >= neededForCircle) {
                    specialMoveName = "circle";
                }
                if (mouseX > (width / 2  + 100 - 120) && mouseX < (width / 2  + 100 + 120) && mouseY > height / 2 + 120 - 25 && mouseY < (height / 2 + 120 + 25) && bestTime >= neededForShotgun) {
                    specialMoveName = "shotgun";
                }
                if (mouseX > (width / 2  - 100 - 120) && mouseX < (width / 2  - 100 + 120) && mouseY > height / 2 + 180 - 25 && mouseY < (height / 2 + 180 + 25) && highScore >= neededForTeleport) {
                    specialMoveName = "teleport";
                }

                //back
                if (mouseX > (width / 2  - 100 - 120) && mouseX < (width / 2 - 100 + 120) && mouseY > height / 2 + 300 - 25 && mouseY < (height / 2 + 300 + 25)) {
                    currentStates = "MENU";
                }
                break;

            case "MENU":
                //New level
                if (mouseX > (width / 2 - 120) && mouseX < (width / 2 + 120) && mouseY > height / 2 - 40 - 25 && mouseY < (height / 2 - 40 + 25)) {
                    currentStates = "RUNNING";
                    score = 0;
                    time = 0;
                    specialMoveTimer = 0;
                    specialPersent = 0;
                    specialMove = false;
                    enemySpeed = originalEnemySpeed;
                    spawnRate  = originalSpawnRate;
                    playerSpeed = 5;
                    playerX = 256;
                    playerY = 352;
                    backgroundImg = loadImage("Images/Background.png");
                }
                //Stats
                if (mouseX > (width / 2 - 120) && mouseX < (width / 2 + 120) && mouseY > height / 2 + 30 - 25 && mouseY < (height / 2 + 30 + 25)) {
                    currentStates = "STATS";
                    score = 0;
                    time = 0;
                    animationFrame = 1;
                }
                //Change power
                if (mouseX > (width / 2 - 120) && mouseX < (width / 2 + 120) && mouseY > height / 2 + 100 - 25 && mouseY < (height / 2 + 100 + 25)) {
                    currentStates = "CHANGE_MOVE";
                }
                break;

            case "PAUSED":
                //Continue
                if (mouseX > (width / 2 - 120) && mouseX < (width / 2 + 120) && mouseY > height / 2 - 40 - 25 && mouseY < (height / 2 - 40 + 25)) {
                    currentStates = "RUNNING";
                }
                //menu
                if (mouseX > (width / 2 - 120) && mouseX < (width / 2 + 120) && mouseY > height / 2 + 30 - 25 && mouseY < (height / 2 + 30 + 25)) {
                    currentStates = "MENU";
                    score = 0;
                    time = 0;
                }
                //restart
                if (mouseX > (width / 2 - 120) && mouseX < (width / 2 + 120) && mouseY > height / 2 + 100 - 25 && mouseY < (height / 2 + 100 + 25)) {
                    for (int i = 0; i < enemies.size(); i++) {
                        enemies.remove(i);
                    }
                    currentStates = "RUNNING";
                    enemySpeed = originalEnemySpeed;
                    spawnRate = originalSpawnRate;
                    score = 0;
                    time = 0;
                }
                break;

            case "OVER":
                if (mouseX > (width / 2 - 120) && mouseX < (width / 2 + 120) && mouseY > height / 2 + 100 - 25 && mouseY < (height / 2 + 100 + 25)) {
                    for (int i = 0; i < enemies.size(); i++) {
                        enemies.remove(i);
                        enemySpeed = originalEnemySpeed;
                        spawnRate = originalSpawnRate;
                    }
                    currentStates = "RUNNING";
                    score = 0;
                    time = 0;
                }
                if (mouseX > (width / 2 - 120) && mouseX < (width / 2 + 120) && mouseY > height / 2 + 170 - 25 && mouseY < (height / 2 + 170 + 25)) {
                    currentStates = "MENU";
                }
                break;
        }

    }

    public void keyPressed() {
        if (key == 'w') {
            up = true;
        }
        if (key == 'a') {
            left = true;
        }
        if (key == 's') {
            down = true;
        }
        if (key == 'd')   {
            right = true;
        }
        if (key == ' ')   {
            currentStates = "PAUSED";
        }
    }

    public void keyReleased() {
        if (key == 'w') {
            up = false;
        }
        if (key == 'a') {
            left = false;
        }
        if (key == 's') {
            down = false;
        }
        if (key == 'd') {
            right = false;
        }
    }

    class Enemy {
        float x, y, vx, vy;
        int enemyType = 0;
        boolean isDead = false;
        int explosionFrame = 0;

        Enemy(float x, float y, int enemyType) {
            this.x = x;
            this.y = y;
            this.enemyType = enemyType;
        }

        public void drawEnemy() {
            if (isDead == false) {
                imageMode(CENTER);
                image(enemyAnimations[enemyType][animationFrame], x, y);
            } else {
                image(explosionAnimation[explosionFrame], x, y);
            }
        }

        public void move(float px, float py) {
            if (isDead == false) {
                float angle = atan2(py - y, px - x);
                vx = cos(angle);
                vy = sin(angle);
                x += vx * enemySpeed;
                y += vy * enemySpeed;
            }
        }
    }

    class Bullet {
        float x, y, vx, vy;

        Bullet(float x, float y, float vx, float vy) {
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
        }

        void drawBullet() {
            fill(0, 255, 0);
            ellipse(x, y, 10, 10);
        }

        void move() {
            x += vx;
            y += vy;
        }
    }
    public void print(Object word) {
        System.out.println(word);
        System.out.println(", ");
    }

    class AI {
        int enemyScope, wallScope;
        float enemyImp, wallImp, shotImp;
        int score;
        Random rand = new Random();

        AI() {
//            this.enemyScope = rand.nextInt(500);
//            this.wallScope = rand.nextInt(500);
//            this.enemyImp = rand.nextFloat();
//            this.wallImp = rand.nextFloat();
//            this.shotImp = rand.nextFloat();
            this.enemyScope = 500;
            this.wallScope = 500;
            this.enemyImp = 0.1f;
            this.wallImp = 0.1f;
            this.shotImp = 1;
        }

        void turn(){
            move2();
            shot();
        }

        void move2(){
            left = false;
            right = false;
            up = false;
            down = false;
            int nearEn = 0;
            for (int i = 0; i < enemies.size(); i++) {
                Enemy en = enemies.get(i);
                if(distance(en) > distance(enemies.get(nearEn))){
                    nearEn = i;
                }
            }
            if( enemies.size() > 0) {
                if (left(enemies.get(nearEn)) && playerX > 0) {
                    right = true;
                }
                if (right(enemies.get(nearEn)) && playerX < screenW) {
                    left = true;
                }
                if (up(enemies.get(nearEn)) && playerY > 0) {
                    down = true;
                }
                if (down(enemies.get(nearEn)) && playerY < screenH) {
                    up = true;
                }
            }
        }

        void move() {
            float leftAI = 0f;
            float rightAI = 0f;
            float upAI = 0f;
            float downAI = 0f;
            left = false;
            right = false;
            up = false;
            down = false;

//            print("    New round    ");

            for (int i = 0; i < enemies.size(); i++) {
                Enemy en = enemies.get(i);
//                print(en.x + " X ");
//                print(en.y + " Y ");
                if (distance(en) < enemyScope) {
//                    print(" ok ");
                    if (left(en)) {
                        leftAI += Math.pow(enemyImp, (distance(en) / enemyScope));
                    }
                    if (right(en)) {
                        rightAI += Math.pow(enemyImp, (distance(en) / enemyScope));
                    }
                    if (up(en)) {
                        upAI += Math.pow(enemyImp, (distance(en) / enemyScope));
                    }
                    if (down(en)) {
                        downAI += Math.pow(enemyImp, (distance(en) / enemyScope));
                    }
                }
                if (playerX < wallScope) {
                    leftAI -= Math.pow(wallImp, (playerX / wallScope));
                }
                if (screenW - playerX > wallScope) {
                    rightAI -= Math.pow(wallImp, ((screenW - playerX) / wallScope));
                }
                if (playerY < wallScope) {
                    upAI -= Math.pow(wallImp, (playerY / wallScope));
                }
                if (screenH - playerY > wallScope) {
                    downAI -= Math.pow(wallImp, ((screenH - playerY) / wallScope));

                }
            }
            if (leftAI > rightAI && leftAI > upAI && leftAI > downAI) {
                if (leftAI > rand.nextDouble()) {
                    left = true;
                }
            } else if (rightAI > upAI && rightAI > downAI) {
                if (rightAI > rand.nextDouble()) {
                    right = true;
                }
            } else if (upAI > downAI) {
                if (upAI > rand.nextDouble()) {
                    up = true;
                }
            } else {
                if (downAI > rand.nextDouble()) {
                    down = true;
                }
            }
        }



        void shot(){
            if(shotTimer > shotWait) {
                int enemy = 0;
                for(int i = 0; i < enemies.size(); i++) {
                    Enemy en = enemies.get(i);
                    if(distance(en) < distance(enemies.get(enemy))){
                        enemy = i;
                    }
                }


                float dx = enemies.get(enemy).x - playerX;
                float dy = enemies.get(enemy).y - playerY;
                float angle = atan2(dy, dx);
                float vx = bulletSpeed * cos(angle);
                float vy = bulletSpeed * sin(angle);
                bullets.add(new Bullet(playerX, playerY, vx, vy));
                shotTimer = 0;
            }
        }

        double distance(Enemy to){
            double dist = Math.round(Math.sqrt((playerX - to.x) * (playerX - to.x) +  (playerY - to.y) * (playerY - to.y)));
            return dist;
        }

        boolean left(Enemy to){
            if(playerX - to.x > 0){
                return true;
            }
            else{
                return false;
            }
        }

        boolean right(Enemy to){
            if(playerX - to.x < 0){
                return true;
            }
            else{
                return false;
            }
        }

        boolean up(Enemy to){
            if(playerY - to.y > 0){
                return true;
            }
            else{
                return false;
            }
        }

        boolean down(Enemy to){
            if(playerY - to.y < 0){
                return true;
            }
            else{
                return false;
            }
        }
    }
}