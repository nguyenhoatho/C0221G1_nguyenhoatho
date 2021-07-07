public class Choi {
    public static void main(String[] args) {
        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 7; j++) {
                if (i == 1 || i == 14 || j == 1 || j == 7)
                    System.out.print("*  ");
                else
                    System.out.print("   ");
            }
            System.out.println("");
        }
    }
}
