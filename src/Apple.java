public class Apple {
    private int speed;
    private boolean caught;
    private int xPos;//center of apple
    private int yPos;

    public Apple(int speed, boolean caught, int xPos, int yPos){
        this.speed = speed;
        this. caught = caught;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void display(){
        if(!caught){
            Main.app.ellipse(xPos,yPos,80,80);
        }
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
    public int getSpeed(){ return speed; }
    public void setSpeed(int s){ speed = s; }
    public void setCaught(boolean a){ caught = a; }
    public boolean getCaught(){ return caught; }
}
