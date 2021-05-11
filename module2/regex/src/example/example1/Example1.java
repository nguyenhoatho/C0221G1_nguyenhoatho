package example.example1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Example1 {
    public static void main(String[] args) {
//        ^[ACP]+[0-9]{4}[GHIKLM]$
        Pattern pattern = Pattern.compile("^[0-9]{2}[A-Z][0-9] [0-9]{5}$");



             String text2 = new Scanner(System.in).nextLine();
//            text2.matches(pattern)




    }



}
