package examplearray;

public class DiagonalArr {
    public static void main(String[] args) {
        int arrNumber[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int sum = 0;
        for (int i = 0; i < arrNumber.length; i++) {
            for (int j = 0; j < arrNumber.length; j++) {

                if (i == j) {
                    sum += arrNumber[i][j];
                }
            }

        }
        System.out.println(sum);
    }
}
