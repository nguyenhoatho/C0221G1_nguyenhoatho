package example.example1;

import java.util.Scanner;

public class Triangle extends Throwable {
    public static void main(String[] args) throws Triangle {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                int slide1 = sc.nextInt();
                int slide2 = sc.nextInt();
                int slide3 = sc.nextInt();
                IllegalTriangleException(slide1, slide2, slide3);
                break;
            } catch (Triangle triangle) {
                System.out.println("unCorrect");
            }catch (Exception e){
                System.out.println("input number");
            }
        }
    }

        public static void IllegalTriangleException(int a, int b, int c) throws Triangle {
            if (a + b <= c || a + c <= b || b + c <= a) {
                throw new Triangle();
            }

        }
    }

