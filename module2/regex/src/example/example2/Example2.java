package example.example2;

import java.util.regex.Pattern;

public class Example2 {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("^\\([0-9]{2}\\)+\\-\\([0-9]{10}\\)");
        String str="(84)-(0978489645)";
        System.out.println(pattern.matcher(str).find());
    }
}
