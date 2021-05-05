package ultils;

public class ServiceValidate {
    private static String regex = "";

    public static boolean validateName(String serviceName){
        regex = "^((\\p{Lu})(\\p{Ll}*))( (\\p{Lu})(\\p{Ll}*))*$";
        if (serviceName.matches(regex)){
            return true;
        }
        System.out.println("Thông tin nhập vào không hợp lệ");
        return false;
    }

    public static boolean validateAreaOrAreaPool(Double area){
        if (area > 30) {
            return true;
        } else {
            System.out.println("Area phải lớn hơn 30");
            System.out.println("Mời bạn nhập lại: ");
            return false;
        }
    }

    public static boolean validateFloor(int floor){
        if (floor > 0) {
            return true;
        } else {
            System.out.println("Floor phải là số nguyên lớn hơn 0");
            System.out.println("Mời bạn nhập lại: ");
            return false;
        }
    }

    public static boolean validateMaxPeople(int number){
        if (number > 0 && number < 20) {
            return true;
        } else {
            System.out.println("Số Người phải là số nguyên lớn hơn 0 và nhỏ hơn 20");
            System.out.println("Mời bạn nhập lại: ");
            return false;
        }
    }

    public static boolean validatePrice(double price){
        if (price > 0) {
            return true;
        } else {
            System.out.println("Price phải là số lớn hơn 0");
            System.out.println("Mời bạn nhập lại: ");
            return false;
        }
    }

    public static boolean validateConvenient(String convenient){
        if (convenient.equals("massage") || convenient.equals("karaoke") || convenient.equals("food") || convenient.equals("drink")|| convenient.equals("car")) {
            return true;
        } else {
            System.out.println("Dịch vụ đi kèm phải là: massage, karaoke, food, drink, car");
            System.out.println("Mời bạn nhập lại: ");
            return false;
        }
    }
}
