package regex;
import exception.NameException;

public class Regex {
    static boolean check=false;
    public static void checkBienSo(String bienso) throws NameException {
        String regex="^[0-9]{2}[A-Z][0-9] [0-9]{5}$";

        check=bienso.matches(regex);
        if (!check)throw new NameException("moi ban nhap lai");

    }

}
