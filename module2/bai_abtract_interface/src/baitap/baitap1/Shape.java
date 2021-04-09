package baitap.baitap1;

public abstract class Shape implements Resizeable {
    private String color = "red";
    private boolean fill = true;

    public Shape() {
    }

    public Shape(String color, boolean fill) {
        this.color = color;
        this.fill = fill;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFill() {
        return this.fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public abstract double getArea();

    public abstract double getParameter();

    public String toString() {
        return "Shape{color='" + this.color + '\'' + ", fill=" + this.fill + '}';
    }

    @Override
    public void resize(double percents) {

    }
}
