package example.example1;

import java.util.Scanner;

public class RecursiveSearch {
    public int binarySearch(int array[],int x,int low,int high){
        if (low<high){
            int middle=(high-low)/2;
            if (array[middle]==x){
                return  middle;
            }
            else if (x<array[middle]){
                return binarySearch(array,x,low,middle-1);
            }
                return binarySearch(array,x,middle+1,high+1);


        }
            return -1;

    }

    public static void main(String[] args) {
        RecursiveSearch binarySearch=new RecursiveSearch();
        System.out.println("input array length");
        int arrayLength=new Scanner(System.in).nextInt();
        int array[]=new int[arrayLength];
        for (int i=0;i<array.length;i++){
            System.out.println("input value array"+i);
            array[i]=new Scanner(System.in).nextInt();
        }

        int high=array.length;
        int low=0;
        System.out.println("input name search");
        int nameSearch=new Scanner(System.in).nextInt();
        int result=binarySearch.binarySearch(array,nameSearch,low,high-1);
        if (result==-1){
            System.out.println("not found");
        }else {
            System.out.println("result"+result);
        }


    }

}
