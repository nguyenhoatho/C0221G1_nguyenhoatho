package example.example1;

import java.util.*;

public class StringCount {
    public static void main(String[] args) {
        TreeMap<Integer, String> stringOfInput = new TreeMap<>();
        String stringInput = new Scanner(System.in).nextLine();
        stringInput = stringInput.toLowerCase();
        StringBuilder stringClean= new StringBuilder();
        for (int j=0;j<stringInput.length();j++){
            if (stringInput.charAt(j)!=44 &&stringInput.charAt(j)!=45 &&stringInput.charAt(j)!=46&&stringInput.charAt(j)!=33&&stringInput.charAt(j)!=58&&stringInput.charAt(j)!=63){
                stringClean.append(stringInput.charAt(j));
            }
        }


        String[] arrayStringInput = stringClean.toString().split(" ");

        for (int i = 0; i < arrayStringInput.length; i++) {
            stringOfInput.put(i, arrayStringInput[i]);
        }
        System.out.println(stringOfInput.toString());
        System.out.println(stringOfInput.size());

    }
}