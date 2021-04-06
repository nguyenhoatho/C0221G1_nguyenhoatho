package baitap;

public class Circle {
    private float radius;

    public Circle() {
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
    public float getArea(){
        return (float) (this.radius*this.radius*Math.PI);
    }

}
class TestCycle{
    public static void main(String[] args) {
        Circle c1= new Circle(5);
        System.out.println(c1.getRadius());
        System.out.println(c1.getArea());
    }
}