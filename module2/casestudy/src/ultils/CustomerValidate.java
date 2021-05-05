package ultils;

import java.time.LocalDate;

public class CustomerValidate {
    private static String regex = "";


    public static boolean validateName(String serviceName) {
        regex = "^((\\p{Lu})(\\p{Ll}*))( (\\p{Lu})(\\p{Ll}*))*$";
        if (serviceName.matches(regex)) {
            return true;
        }
        System.out.println("Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ");
        return false;
    }

    public static boolean ValidationEmail(String email){
        regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (email.matches(regex)) {
            return true;
        } else {
            System.out.println("Email phải đúng định dạng abc@abc.abc");
            return false;
        }
    }

    public static String ValidateGender(String gender){
        if (gender.toLowerCase().equals("male")){
            return "Male";
        }else if (gender.toLowerCase().equals("female")){
            return "Female";
        }else if (gender.toLowerCase().equals("unknow")){
            return "Unknow";
        }else {
            System.out.println("Gender phai la: Male, Female, Unknow");
            return "false";
        }
    }

    public static boolean ValidateIdcard(String idCard){
        regex="^\\d{3}\\s\\d{3}\\s\\d{3}$";
        if (idCard.matches(regex)) {
            return true;
        } else {
            System.out.println("Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX");
            return false;
        }
    }


    public static boolean ValidationBirthday(String day) {
        regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
        while (true) {
            LocalDate date = LocalDate.now();

            if (day.matches(regex)) {
                String temp = "";
                for (int i = day.length() - 4; i < day.length(); i++) {
                    temp += day.charAt(i);
                }
                if (date.getYear() - Integer.valueOf(temp) >= 18 && (Integer.parseInt(temp) > 1900)) {
                    return true;
                } else {
                    System.out.println("Năm sinh phải >1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy");
                    return false;
                }

            } else {
                System.out.println("Birthday không đúng định dạng");
                return false;
            }
        }
    }
}
