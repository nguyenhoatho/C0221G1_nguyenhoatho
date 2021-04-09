package baitap1;

import java.util.Arrays;

public class Point {
    protected float x;
    protected float y;

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }


    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }
    public void setXY(float x,float y)
    {
        this.x=x;
        this.y=y;

    }
    public float[] getXY()
    {
        float arr[]=new float[2];
        arr[0]=this.x;
        arr[1]=this.y;
        return arr;

    }

    @Override
    public String toString() {
        return "("+
                x+", "+y+
                ')';
    }
}
class testPoint
{
    public static void main(String[] args)
    {
       Point p=new Point(5,4);
        System.out.println(Arrays.toString(p.getXY()));
        System.out.println(p.toString());
    }
}





