package exampleloop;

import java.util.Scanner;

public class DisplayFigure {
    public static void main(String[] args) {
        System.out.println("1.Print the rectangle");
        System.out.println("2.Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
        System.out.println("3.Print isosceles triangle");
        System.out.println("4.exit");
        Scanner sc=new Scanner(System.in);
        String choose=sc.nextLine();
        if (Integer.parseInt(choose)==2){
            String choose1=sc.nextLine();

                switch (Integer.parseInt(choose1)){
                    case 1:
                        triangleTopleft();
                        break;
                    case 2:
                        triangleBottonLeft();
                        break;
                    default:
                        break;
                }

        }

//        Integer.parseInt(choose);
        switch (Integer.parseInt(choose)){
            case 1:
                rectangle(5,4);
                break;

            case 3:
                isoscelesTriangle(5);
                break;
            case 4:
                break;
            default:
                System.out.println("no number on menu");
        }


    }

    public static final void rectangle(int length, int height) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                System.out.println("*");
            }
        }

    }

    public static final void triangleBottonLeft() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j < i; j++) {
                System.out.println("*");
            }
        }
    }

    public static final void triangleTopleft() {
        for (int i = 7; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.println("*");
            }
        }
    }
    public static final void isoscelesTriangle(int height){
        for (int i=0;i<height;i++){
            for (int j=0;j<height*2;j++){
                if (j<height-i||j>height+i){
                    System.out.println(" ");
                } else {
                    System.out.println("*");;
                }

            }
            System.out.println("\n");
        }
    }

}
