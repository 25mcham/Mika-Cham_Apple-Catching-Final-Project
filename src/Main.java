import processing.core.PApplet;
import java.util.ArrayList;
public class Main extends PApplet{
    private int currentXCoord = 700; //left most x on player
    private int changeX = 0; //change in players location
    public static Main app;
    private int numApples = 10; //total number of apples;
    //private boolean moving = false; //moving is true when the key is pressed but not released

    private ArrayList<Apple> pomme = new ArrayList<Apple>();
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
        background(154, 212, 237);
        drawBackground();
        updatePlayer();

        for(int i = 0; i < numApples; i++){// instantiate arraylist
            Apple a = new Apple(10,false,true,(int)(1400/ numApples*(i+0.5)),(int)(Math.random()*180+45));
            pomme.add(a);
        }
    }


    public void draw(){
        noStroke();

        for(int i = 0; i < numApples; i++){
            pomme.get(i).display();
        }

        Apple temp = pomme.get(0);

        /*while(temp.getyPos() < 580){
            temp.setyPos(temp.getyPos()-1);
            temp.display();
        }

         */
    }

    public void updatePlayer(){
        fill(80, 150, 75); //grassgreen
        rect(currentXCoord, 450,60, 120);// clearing out the background

        currentXCoord += changeX;
        fill(255,255,255);
        rect(currentXCoord, 450,60, 120);// draw character
    }

    public void drawBackground(){
        noStroke();
        fill(80, 150, 75); //grassgreen
        rect(0,400,2000,1000);//grass
        fill(128, 100, 69);//trunkbrown
        rect(620, 200,110,300); //tree trunk
        fill(37, 89, 39);//leafgreen
        ellipse(700,50,1500,500);// tree leaves
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

    public void fall(){}
}