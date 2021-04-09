package baitap1;

public class Cylinder extends Circle {
 private float height;
 public Cylinder(float radius, float height)
 {
        super(radius);
        this.height = height;
 }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +" "+
                super.toString()+
                '}';
    }
    public float volume(){
        return super.getArea()*this.height;
    }
}
class Test{
    public static void main(String[] args) {
        Cylinder c2=new Cylinder(5,4);
        System.out.println(c2.toString());
        System.out.println(c2.getArea());
        System.out.println(c2.volume());
        System.out.println(c2.getRadius());
    }
}
