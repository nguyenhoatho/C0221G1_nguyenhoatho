package examplearray;

import java.util.Scanner;

public class SumRowArr {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int arrNumber[][]={{1,2,3},{4,5,6},{7,8,9}};
        int sum=0;
        int inputNumber= sc.nextInt();
        for (int i=0;i<arrNumber.length;i++){
            sum+=arrNumber[i][inputNumber-1];
        }
        System.out.println(sum);

    }
}
