package exampleloop;

public class HundredPrimes {
    public static void main(String[] args) {
        for (int i=2;i<100;i++){
            if (check(i)){
                System.out.println(i);
            }
        }

    }
    public static boolean  check(int number){
        if (number< 2) {
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
