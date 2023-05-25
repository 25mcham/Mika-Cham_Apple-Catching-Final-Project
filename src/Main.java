import processing.core.PApplet;
import java.util.ArrayList;
import java.lang.Thread;
import java.io.*;
public class Main extends PApplet{
    private int currentXCoord = 700; //left most x on player
    private int fps = 20;
    private int changeX = 0; //change in players location
    public static Main app;
    private int numApples = 10; //total number of apples;

    private ArrayList<Apple> pomme = new ArrayList<Apple>(); //all apples

    private ArrayList<Apple> fallen = new ArrayList<Apple>(); // apples that have fallen to the ground
    private ArrayList<Apple> nFallen = new ArrayList<Apple>(); //apples that have not fallen to the ground.. yet
    public Main(){
        super();
        app = this;
    }

    public static void main(String[] args){
        PApplet.main("Main");
    }

    public void settings(){
        size(1400,600);
    }

    public void setup(){
        frameRate(fps);
        noStroke();
        drawBackground();
        updatePlayer();

        for(int i = 0; i < numApples; i++){// instantiate arraylist
            Apple a = new Apple((int)(Math.random()*20+20),false,true,(int)(1400/ numApples*(i+0.5)),(int)(Math.random()*180+45));
            pomme.add(a);
            pomme.get(i).display();
            nFallen.add(a);
        }
    }

    public void draw(){
            if(fall(pomme.get(0))){
                if(fall(pomme.get(2))){
                    if(fall(pomme.get(8))){
                        if(fall(pomme.get(6))){
                            if(fall(pomme.get(4))){
                                if(fall(pomme.get(5))){
                                    if(fall(pomme.get(3))){
                                        if(fall(pomme.get(7))){
                                            if(fall(pomme.get(1))){
                                                if(fall(pomme.get(9))){
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

    public boolean fall(Apple temp){
        frameRate(temp.getSpeed());
        if(temp.getyPos() < 500) {
            //System.out.println(temp.getyPos());
            drawBackground();
            temp.display();
            //System.out.println("x: " + temp.getxPos() + " y: " + temp.getyPos());
            temp.setyPos(temp.getyPos() + 15);
            return false;
        }
        fallen.add(temp);
        nFallen.remove(temp);
        return true;
    }

    public void updatePlayer(){
        System.out.println("playerupdated");
        fill(80, 150, 75); //grassgreen
        rect(currentXCoord, 450,60, 120);// clearing out the background

        currentXCoord += changeX;
        fill(255,255,255);
        rect(currentXCoord, 450,60, 120);// draw character
    }

    public void drawBackground(){
        background(154, 212, 237);
        noStroke();
        fill(80, 150, 75); //grassgreen
        rect(0,400,2000,1000);//grass
        fill(128, 100, 69);//trunkbrown
        rect(620, 200,110,300); //tree trunk
        fill(37, 89, 39);//leafgreen
        ellipse(700,50,1500,500);// tree leaves
        for(Apple a: fallen){
            a.display();
        }
        for(Apple a: nFallen){
            a.display();
        }
    }

    public void keyPressed() {

        if(key == 81){ //if the key is q
            //gameRunning = !gameRunning;
        }
        /*System.out.println("keypressed");


        */

        //moving = true;
        //while(moving)

        if(key == 37){// if the key pressed is the left arrow
            changeX = -10;
        } else if(key == 38){ //right arrow is pressed
            changeX = 10;
        }
        //updatePlayer();
    }

    public void keyReleased(){
        changeX = 0;
    }

    public void fall(){}
}