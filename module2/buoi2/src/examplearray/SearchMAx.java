package examplearray;

import java.util.Scanner;

public class SearchMAx {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arrNumber[][]=new int[2][2];
        for (int i=0;i<arrNumber.length;i++){
            for (int j=0;j<arrNumber[i].length;j++){
                arrNumber[i][j]=sc.nextInt();
            }

        }
        int max=arrNumber[0][0];
        for (int n=0;n<arrNumber.length;n++){
            for (int m=0;m<arrNumber[n].length;m++){
                if (max<arrNumber[n][m]){
                    max=arrNumber[n][m];
                }
            }
        }
        System.out.println(max);
    }
}
