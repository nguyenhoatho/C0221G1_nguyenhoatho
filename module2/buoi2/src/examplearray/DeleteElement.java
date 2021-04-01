package examplearray;

import java.util.Scanner;
public class DeleteElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int element= sc.nextInt();
        System.out.println("input element delete: ");
        int deleteElement=sc.nextInt();
        String c=" ";

        int arrNumber[]=new int[element];

        for (int i=0;i<arrNumber.length;i++){
            arrNumber[i]=sc.nextInt();

        }
        for (int j=0;j<arrNumber.length;j++){
            System.out.print(arrNumber[j]);
        }

       for(int k=0;k<arrNumber.length;k++){
           if (arrNumber[k]==deleteElement){
               for (int m=k;m<arrNumber.length-1;m++){
                   arrNumber[m]=arrNumber[m+1];
               }

           }
       }
       for (int f=0;f<arrNumber.length-1;f++){
           System.out.println(arrNumber[f]);
       }



    }

}
