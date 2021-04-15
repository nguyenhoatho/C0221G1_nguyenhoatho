package example.example1;

import java.util.*;

public class StringCount {
    public static void main(String[] args) {
        TreeMap<Integer, String> stringOfInput = new TreeMap<>();
        String stringInput = new Scanner(System.in).nextLine();
        stringInput = stringInput.toLowerCase();
        String stringClean="";
        for (int j=0;j<stringInput.length();j++){
            if (stringInput.charAt(j)!=44 &&stringInput.charAt(j)!=45 &&stringInput.charAt(j)!=46&&stringInput.charAt(j)!=33&&stringInput.charAt(j)!=58){
                stringClean=stringClean+stringInput.charAt(j);
            }
        }


        String arrayStringInput[] = stringClean.split(" ");

        if (stringOfInput.isEmpty()) {
            for (int i = 0; i < arrayStringInput.length; i++) {
                stringOfInput.put(i, arrayStringInput[i]);
            }
        } else {
            int value = stringOfInput.size();
            for (int i = 0; i < arrayStringInput.length; i++) {
                stringOfInput.put(i + value, arrayStringInput[i]);
            }
        }
        Set<Map.Entry<Integer, String>> setStringOfInput = stringOfInput.entrySet();
        System.out.println(setStringOfInput);

        System.out.println(stringOfInput.size());

    }
}