package baitap;

public class MoveablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MoveablePoint() {
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;

    }
    public float[] getSpeed(){
        float arr3[]=new float[2];
        arr3[0]=this.xSpeed;
        arr3[1]=this.ySpeed;
        return arr3;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")"+" "+
                "speed ("+xSpeed+","+ySpeed+
                ')';
    }
    public MoveablePoint move(){
        super.x+=this.xSpeed;
        super.y+=this.ySpeed;
        return this;

    }

}
class TestMove{
    public static void main(String[] args) {
        MoveablePoint d1=new MoveablePoint(4,5,6,8);
        System.out.println(d1.toString());
        System.out.println(d1.move());
        System.out.println(d1.move());

    }
}
