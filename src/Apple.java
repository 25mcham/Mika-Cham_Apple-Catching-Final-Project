public class Apple {
    private int speed;
    private boolean caught;
    private boolean show;
    private int xPos;
    private int yPos;

    public Apple(int speed, boolean caught, boolean show, int xPos, int yPos){
        this.speed = speed;
        this. caught = caught;
        this.show = show;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void display(){
        Main.app.fill(232, 60, 26); //red
        Main.app.ellipse(xPos,yPos,80,80);
    }

    public int getxPos(){
        return xPos;
    }

    public int getyPos(){
        return yPos;
    }

    public void setyPos(int sety){
        yPos = sety;
    }

    public void setxPos(int setx){
        xPos = setx;
    }
}
