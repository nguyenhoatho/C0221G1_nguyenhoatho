package baitap1;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int result=0;
        int rate=25000;
        System.out.println("input dola");
        int inputDola=sc.nextInt();
        result=inputDola*rate;
        System.out.println("result :"+result);


    }
}
