package examplearray;

public class AddArr{
    public static void main(String[] args) {
        int arr1[]={1,2,3,4,5};
        int arr2[]={6,7,8,9};
        int arr3[]= new int[arr1.length+arr2.length];
        for (int i=0;i<arr1.length;i++){
            arr3[i]=arr1[i];
            for (int j=0;j<(arr3.length-arr1.length);j++){
                arr3[arr1.length+j]=arr2[j];
            }
        }
        for (int k=0;k<arr3.length;k++){
            System.out.println(arr3[k]);
        }
    }
}
