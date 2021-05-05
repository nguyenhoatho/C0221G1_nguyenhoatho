package models;

public class Container  {
    private float width=3;
    private float length=5;

    public Container() {
    }

    public Container(float width, float length) {
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

    @Override
    public String toString() {
        return
                "width=" + width +
                ", length=" + length;
    }
}
