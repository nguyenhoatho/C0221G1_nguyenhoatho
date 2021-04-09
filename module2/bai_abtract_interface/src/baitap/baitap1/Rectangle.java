package baitap.baitap1;


public class Rectangle extends Shape implements Resizeable {
    private double width = 1.0D;
    private double length = 1.0D;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean fill, double width, double length) {
        super(color, fill);
        this.width = width;
        this.length = length;
    }

    public Rectangle() {
    }

    public double getArea() {
        return this.width * this.length;
    }

    public double getParameter() {
        return (this.width + this.length) * 2.0D;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String toString() {
        return "Rectangle"+getParameter()+getArea();
    }

    public void resize(double present) {
       setLength(present*length);
       setWidth(present*width);
    }
}
