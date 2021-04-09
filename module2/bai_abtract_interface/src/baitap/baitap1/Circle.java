package baitap.baitap1;

public class Circle extends Shape implements Resizeable {
    private double radius = 1.0D;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean fill, double radius) {
        super(color, fill);
        this.radius = radius;
    }

    public Circle() {
    }

    public double getArea() {
        return this.radius * Math.pow(this.radius, 2.0D);
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getParameter() {
        return this.radius * 2.0D * 3.141592653589793D;
    }

    public String toString() {
        return this.getParameter() + " " + this.getArea();
    }

    public void resize(double present) {
        setRadius(present*radius);
    }
}
