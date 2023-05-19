import processing.core.PApplet;
import java.util.ArrayList;
public class Main extends PApplet{
    private int currentXCoord = 700;
    private int changeX = 0; //change in players location
    public static Main app;
    //private boolean moving = false; //moving is true when the key is pressed but not released
    public Main(){
        super();
        app = this;
    }

    public void settings(){
        size(1400,600);
    }

    public void setup(){
        background(154, 212, 237);
        drawBackground();
    }


    public void draw(){
        noStroke();
    }

    public void updatePlayer(){
        fill(154, 212, 237);
        rect(currentXCoord, 300,currentXCoord +60, 600);// clearing out the background

        currentXCoord += changeX;
        fill(255,255,255);
        rect(currentXCoord,300,currentXCoord+60,450);// draw character
    }

    public void drawBackground(){
        fill(80, 150, 75);
        ellipse(700,100,800,60);
    }

    public void keyPressed() {
        //moving = true;
        //while(moving)

        if(key == 37){// if the key pressed is the left arrow
            changeX = -10;
        } else if(key == 38){ //right arrow is pressed
            changeX = 10;
        }
        updatePlayer();
    }

    public void keyReleased(){
        changeX = 0;
    }
}