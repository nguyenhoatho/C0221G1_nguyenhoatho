package baitap.baitap1;

import baitap.baitap2.Colorable;

public class Square extends Rectangle implements Resizeable, Colorable {
    private double slide;

    public Square() {
    }

    public double getArea() {
        return Math.pow(this.slide, 2.0D);
    }

    public double getParameter() {
        return this.slide * 4.0D;
    }

    public Square(double slide) {
        this.slide = slide;
    }

    public double getSlide() {
        return this.slide;
    }

    public void setSlide(double slide) {
        this.slide = slide;
    }

    public String toString() {
        return "Square"+getArea()+" "+getParameter();
    }

    public void resize(double present) {
       setSlide(present*slide);

    }

    @Override
    public void howToColor() {
        System.out.println("Color all four side");
    }
}