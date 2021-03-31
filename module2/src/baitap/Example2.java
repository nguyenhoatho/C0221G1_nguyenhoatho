package baitap;

import java.util.Scanner;
public class Example2 {
    public static void main(String[] args)
    {
        String result = "";
        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        int hundredsDigit = inputNumber / 100;
        int tensDigits = (inputNumber - hundredsDigit * 100) / 10;
        int unitDigits = (inputNumber - hundredsDigit * 100 - tensDigits * 10);
        if (inputNumber==0){
            result="zero";
        }
        else if (inputNumber>0 && inputNumber<10)
        {
            result=approx1_9(unitDigits);
        }else if (inputNumber<20){
            result=approx10_19(unitDigits);
        }else if(inputNumber<100){
            if (unitDigits==0){
               result= approx20_99(tensDigits);
            }
            else {
                result=approx20_99(tensDigits)+" "+approx1_9(unitDigits);
            }
        }
        else {
            if (tensDigits==0 && unitDigits==0){
                result=approx100_999(hundredsDigit);
            }else if (tensDigits==0 && unitDigits !=0){
                result=approx100_999(hundredsDigit)+" and "+approx1_9(unitDigits);
            }else if (tensDigits==1 && unitDigits>=0 && unitDigits<10){
                result=approx100_999(hundredsDigit)+" and "+approx10_19(unitDigits);
            }else {
                result=approx100_999(hundredsDigit)+" and "+approx20_99(tensDigits)+" "+approx1_9(unitDigits);
            }
        }
        System.out.println(result);
    }
    public static String approx1_9(int unitDigits) {
        String units = "";
        switch (unitDigits){
            case 1:
                units = "one";
            break;
            case 2:
                 units = "two";
            break;
            case 3:
                units = "three";
            break;
            case 4:
                units = "four";
            break;
            case 5:
                units = "five";
            break;
            case 6:
                units = "six";
            break;
            case 7:
                units = "seven";
            break;
            case 8:
                 units = "eight";
            break;
            case 9:
                units = "nine";
            break;
            default:
                units = "";
        }
        return units;
    }
    public static String approx10_19(int unitDigits) {
        String tens ="";
        switch (unitDigits) {
            case 0:
                tens="ten";
                break;
            case 1:
                 tens = "eleven";
                break;
            case 2:
                tens = "twelve";
                break;
            case 3:
                 tens = "thirteen";
            break;
            case 4:
                 tens = "fourteen";
            break;
            case 5:
                 tens = "fifteen";
            break;
            case 6:
                 tens = "sixteen";
            break;
            case 7:
                 tens = "seventeen";
            break;
            case 8:
                 tens = "eighteen";
            break;
            case 9:
                 tens = "nineteen";
            break;
            default:
                 tens = "";
        }
        return tens;
    }
    public static  String approx20_99(int tensDigits){
        String tens="";
        switch(tensDigits){
            case 2:
                tens="twenty";
                break;
            case 3:
                tens = "thirty";
                break;
            case 4:
                tens = "forty";
                break;
            case 5:
                tens = "fifty";
                break;
            case 6:
                tens = "sixty";
                break;
            case 7:
                tens = "seventy";
                break;
            case 8:
                tens = "eighty";
                break;
            case 9:
                tens = "ninety";
                break;
            default:
                tens = "";
        }

        return tens;
    }
    public static  String approx100_999(int hundredsDigit){
        String hundred="";
        switch (hundredsDigit) {
            case 1:
                hundred= "one hundred";
                break;
            case 2:
                hundred= "two hundred";
                break;
            case 3:
                hundred = "three hundred";
                break;
            case 4:
                hundred = "four hundred";
                break;
            case 5:
                hundred= "five hundred";
                break;
            case 6:
                hundred= "six hundred";
                break;
            case 7:
                hundred = "seven hundred";
                break;
            case 8:
                hundred = "eight hundred";
                break;
            case 9:
                hundred = "nine hundred";
                break;
            default:
                hundred = "";
        }
        return hundred;
    }
}



