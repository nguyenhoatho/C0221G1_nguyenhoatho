package baitap.baitap1;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        double percents=1+(Math.random()*100)/100;
        Shape[] shapes=new Shape[3];
        shapes[0]=new Circle(5);
        shapes[1]=new Rectangle(4,5);
        shapes[2]=new Square(5);
        for (Shape shape :shapes){
            shape.resize(percents);

        }
        System.out.println(Arrays.toString(shapes));


    }
}