import processing.core.PApplet;
import java.util.ArrayList;
import javax.swing.JFrame; //for key detection
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.Thread;
import java.io.*;
public class Main extends PApplet {
    private int x1Play = 700, y1Play = 450; //topleft coord on player
    private static int changeX = 0; //change in players location
    private int pWidth = 60, pHite = 120; //width and height of player
    private int numCaught = 0; // number of apples caught
    private static int numApples = 8; //total number of apples;
    private int fps = 30;//frames per second
    public static Main app;
    private static int pSpeed = 50;
    private static boolean gamePlay = false;
    private int level = 1;
    private static ArrayList<Apple> pomme = new ArrayList<Apple>(); //all apples
    private static ArrayList<Apple> fallen = new ArrayList<Apple>(); //apples that have fallen to the ground
    private static ArrayList<Apple> nFallen = new ArrayList<Apple>(); //apples that have not fallen to the ground.. yet

    public Main() {
        super();
        app = this;
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        size(1400, 600);
    }

    public void setup() {
        frameRate(fps);
        noStroke();
        drawBackground();
        updatePlayer();
        restart();
    }

    public void draw() {
        if (gamePlay && level == 1) {
            if (fall(pomme.get(0))) {
                if (fall(pomme.get(2))) {
                    //if (fall(pomme.get(8))) {
                        if (fall(pomme.get(6))) {
                            if (fall(pomme.get(4))) {
                                if (fall(pomme.get(5))) {
                                    if (fall(pomme.get(3))) {
                                        if (fall(pomme.get(1))) {
                                            if (fall(pomme.get(7))) {
                                                //if (fall(pomme.get(9))) {
                                                //}
                                            //}
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if(gamePlay && level ==2){
            if (fall(pomme.get(0))) {
                if (fall(pomme.get(2))) {
                    if (fall(pomme.get(8))) {
                        if (fall(pomme.get(6))) {
                            if (fall(pomme.get(4))) {
                                if (fall(pomme.get(5))) {
                                    if (fall(pomme.get(3))) {
                                        if (fall(pomme.get(1))) {
                                            if (fall(pomme.get(7))) {
                                                if (fall(pomme.get(9))) {
                                                    if (fall(pomme.get(10))) {
                                                        if (fall(pomme.get(12))) {
                                                            if (fall(pomme.get(13))) {
                                                                if (fall(pomme.get(11))) {
                                                                    if (fall(pomme.get(14))) {

                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        updatePlayer();
        for (int i = 0; i < nFallen.size(); i++) {
            Apple a = nFallen.get(i);
            if (intersect(80, a.getxPos(), a.getyPos(), x1Play, y1Play, x1Play + pWidth, y1Play + pHite)) { //player intersects with this apple
                nFallen.remove(a);
                a.setCaught(true);
                numCaught++;
                displayAppleCount();
                i--;
                //Apple temp = new Apple(a.getSpeed(),false,a.getxPos(),a.getyPos());
                //fallen.add(temp); //temporary DELETE LATER makes apples stay when they were " caught"
            }
        }
    }

    public boolean fall(Apple temp) {
        frameRate(temp.getSpeed());
        if (temp.getyPos() < 500) {
            temp.display();
            //System.out.println("x: " + temp.getxPos() + " y: " + temp.getyPos());
            temp.setyPos(temp.getyPos() + temp.getSpeed());
            return false;
        }
        fallen.add(temp);
        nFallen.remove(temp);
        return true;
    }

    public void updatePlayer() {
        drawBackground();
        fill(80, 150, 75); //grassgreen
        rect(x1Play, y1Play, pWidth, pHite);// clearing out the background
        x1Play += changeX;
        fill(255, 255, 255);
        rect(x1Play, y1Play, pWidth, pHite);// draw character
    }

    public void drawBackground() {
        background(154, 212, 237);
        noStroke();
        fill(80, 150, 75); //grassgreen
        rect(0, 400, 2000, 1000);//grass
        fill(128, 100, 69);//trunkbrown
        rect(620, 200, 110, 300); //tree trunk
        fill(37, 89, 39);//leafgreen
        ellipse(700, 50, 1500, 500);// tree leaves
        for (Apple a : fallen) {
            a.display();
        }
        for (Apple a : nFallen) {
            a.display();
        }
        displayAppleCount();
        displayInstructions();
    }

    public boolean intersect(int radius, int xCirc, int yCirc, int xRect1, int yRect1, int xRect2, int yRect2) {
        int xNear = Math.max(xRect1, Math.min(xCirc, xRect2)); //nearest point on rect to circle's center, normally corner
        int yNear = Math.max(yRect1, Math.min(yCirc, yRect2));

        int xDist = Math.abs(xNear - xCirc); // x and y distance to center of circle from closest rect point
        int yDist = Math.abs(yNear - yCirc);

        double distCenter = Math.sqrt(Math.pow(yDist, 2) + Math.pow(xDist, 2)) * 2; //distance from center of circle
        return (distCenter <= radius);
    }

    public void displayAppleCount() {
        fill(0);
        textSize(40);
        text("Apples caught: " + numCaught + " / " + numApples, 800, 100);
    }

    public void displayInstructions() {
        textSize(20);
        fill(0);
        text("Catch the apples! ", 30, 60);
        text("Move using the left and right arrow keys ", 30, 80);
        text("Press the space bar to start :) ", 30, 100);
        if(fallen.size() == numApples){
            text("Press the 'r' restart ", 30, 120);
        } else if(numCaught == numApples){
            text("Press the 'r' restart, or press 'n' to advance to the next level ", 30, 120);
        }
    }

    public void restart() {
        if(level == 1){
            numApples = 8;
        } else if(level ==2){
            numApples = 15;
        }
        nFallen.clear();
        fallen.clear();
        pomme.clear();
        drawBackground();
        for (int i = 0; i < numApples; i++) {// instantiate arraylist
            Apple a = new Apple((int) (Math.random() * 10 + 10), false, (int) (1400 / numApples * (i + 0.5)), (int) (Math.random() * 180 + 45));
            if(level == 2){
                a.setSpeed((int) (Math.random() * 15 + 15));
            }
            pomme.add(a);
            pomme.get(i).display();
            nFallen.add(a);
        }
        gamePlay = false;
        numCaught = 0;
    }

    public void keyPressed() {
        if (keyCode == 37) { //left
            changeX = 0 - pSpeed;
        } else if (keyCode == 39) { //right
            changeX = pSpeed;
        } else if (keyCode == 32) { //space bar
            gamePlay = true;
        } else if (keyCode == 82) { //r key
            restart();
        } else if (keyCode == 78){ //n key
            level = 2;
            restart();
        }
    }

    public void keyReleased() {
        changeX = 0;
    }
}