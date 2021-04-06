package baitap;

import jdk.nashorn.internal.runtime.regexp.joni.SearchAlgorithm;

public class Fan {
    public static final int SLOW=1 ;
    public static final int MEDIUM=2 ;
    public static final int FAST=3;
    private int speed=SLOW ;
    private boolean on=false ;
    private double radius=5;
    private String color="blue";

    public Fan() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;

    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (isOn()==true) {
            return "Fan is on" +
                    "speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color;
        }

            return "Fan is radius"+ radius+" color "+color;

    }
    }
    class Main{
        public static void main(String[] args) {
            Fan Fan1=new Fan();
            Fan1.setOn(true);
            Fan1.setSpeed(Fan.SLOW);
            System.out.println( Fan1.toString());
        }

    }



