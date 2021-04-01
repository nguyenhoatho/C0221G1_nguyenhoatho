package examplearray;

import java.util.Scanner;

public class AddArr1 {
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        int arr1[]=new int[arr.length+1];
        Scanner sc=new Scanner(System.in);
        int index= sc.nextInt();
        for (int i=0;i<arr.length;i++){
            if (i<index-1) {
                arr1[i] = arr[i];
            }else if (i>=index){
                arr1[i+1]=arr[i];
            }else {
                arr1[index]=arr[i];
            }
        }
        for (int j=0;j<arr1.length;j++)
        {
            if (j==index-1){
                arr1[j]=sc.nextInt();
            }
        }
        for (int k=0;k<arr1.length;k++){
            System.out.println(arr1[k]);
        }
    }
}
