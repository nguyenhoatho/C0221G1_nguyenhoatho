package models;

public class Car {
    private float width=2;
    private float length=3;

    public Car(float width, float length) {
        this.width = width;
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "width=" + width +
                ", length=" + length;
    }
}
