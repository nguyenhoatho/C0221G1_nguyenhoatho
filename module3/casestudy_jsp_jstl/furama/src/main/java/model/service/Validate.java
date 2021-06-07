package model.service;

public class Validate {
    public static boolean checkCustomerID(String customerID){
        String regex = "^KH-[0-9]{4}$";
        return customerID.matches(regex);
    }

    public static boolean checkServiceID(String customerID){
        String regex = "^DV-[0-9]{4}$";
        return customerID.matches(regex);
    }
    public static boolean checkPhoneNumber(String phoneNumber){
        String regex ="^(09[0-1][0-9]{7})|(\\(84\\)\\+9[01][0-9]{7})$";
        return phoneNumber.matches(regex);
    }
    public static boolean checkIDCard(String idCard){
        String regex="^([0-9]{9})|([0-9]{12})$";
        return idCard.matches(regex);
    }
    public static  boolean checkPositiveNumber(String number){
        String regex="[0-9]{0,}";
        return number.matches(regex);
    }
    public static boolean checkMoney(String money){
        String regex ="[0-9]{0,}[.,]{0,1}[0-9]{1,}";
        return money.matches(regex);
    }

}
