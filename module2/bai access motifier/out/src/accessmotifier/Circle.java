package accessmotifier;

import java.util.Scanner;

public class Circle {
    private double radius=1;
    private String color="red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    double getRadius() {
        return radius;
    }
    protected double getArea() {
        if (this.radius > 0) {
            return Math.PI * this.radius;
        }
        return 0;
    }
}
class TestCircle{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int radius=sc.nextInt();
        Circle c1=new Circle(radius);
        System.out.println(c1.getRadius());
        System.out.println(c1.getArea());
    }
}
