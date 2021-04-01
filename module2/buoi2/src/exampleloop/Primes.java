package exampleloop;

import java.util.Scanner;

public class Primes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=0;
        System.out.println("input times primes");
        String timesPrimes=sc.nextLine();
        int number=2;
        while (count <Integer.parseInt(timesPrimes)) {
            if (check(number)) {
                System.out.println(number);
                count++;
            }
            number++;
        }
    }
    public static boolean  check(int number){
        if ( number< 2) {
            return false;
        }
        int i;
        int squareRoot = (int) Math.sqrt(number);
        for (i = 2; i <= squareRoot; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
