package example.example1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Queue stringOfInput = new LinkedList();
        String stringInput = new Scanner(System.in).nextLine();
        stringInput=stringInput.toLowerCase();
        int length=stringInput.length();
        for (int i =length-1;i>=0; i--) {
            stringOfInput.add(stringInput.charAt(i));
        }
        String stringCheck ="";
        while (!stringOfInput.isEmpty()) {
            stringCheck = stringCheck +stringOfInput.remove();


        }
        boolean equals = stringInput.equals(stringCheck);
        if (equals) {
            System.out.println("is string palindrome");
        }else {
            System.out.println("is  not string palindrome ");
        }


    }
}
