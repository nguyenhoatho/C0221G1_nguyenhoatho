package example.example1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Example1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^[ACP]+[0-9]{4}[GHIKLM]$");
        String text2 = new Scanner(System.in).nextLine();
        System.out.println( pattern.matcher(text2).find());


    }



}
