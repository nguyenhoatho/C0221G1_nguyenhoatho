package baitap;

import java.util.Arrays;

public class Point3d extends Point {
    private float z;

    public Point3d() {
    }

    public Point3d(float z) {
        this.z = z;
    }

    public Point3d(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }
    public void setXYZ(float x, float y, float z){
       this.x=x;
       this.y=y;
       this.z=z;

    }
    public float[] getXYZ()
    {
        float arr1[]=new float[3];
        arr1[0]=x;
        arr1[1]=y;
        arr1[2]=z;
        return arr1;
    }

    @Override
    public String toString() {
        return "Point3d{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +" "+
                Arrays.toString(getXYZ())+
                '}';
    }
}
class TestPoint3d{
    public static void main(String[] args) {
        Point3d b=new Point3d(5);
        b.setXYZ(3,6,7);
        System.out.println(Arrays.toString(b.getXYZ()));
        System.out.println(b.toString());
    }
}
