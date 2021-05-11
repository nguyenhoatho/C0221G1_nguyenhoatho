package regex;

import exception.EmailException;
import exception.GenderException;
import exception.NameException;

import java.util.regex.Pattern;

public class Regex {
    static boolean check = false;
    public static void checkNameCustomers(String string) throws NameException {
        String regex = "([A-Z]"+"([a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]+)[ ])+" +
                "[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ]" +
                "([a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*)";
        check = string.matches(regex);
        if(!check) throw new NameException("Mời Người dùng nhập lại");
    }
    public static void checkEmail(String string) throws EmailException {
        String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$";
        check = string.matches(regex);
        if(!check) throw new EmailException("Mời Người Dùng Nhập Lại");
    }
    public static void regexGender(String str) throws GenderException {
        String regex= "^(Male|Female|Unknow)$";
        check = str.matches(regex);
        if(!check) throw new GenderException("Mời Người Dùng nhập lại");
    }
    public static boolean regexPhone(String str){
        String regex = "^0[1-9]{1}[0-9]{8}$";
        return Pattern.matches(regex,str);
    }

    }

