package examplearray;

import java.util.Locale;
import java.util.Scanner;

public class ExampleString {
    public static void main(String[] args) {
        String str="Chào mừng bạn đến với khảo sát chất lượng dịch vụ CodeGym. Rất đơn giản, bạn chỉ mất vài phút để hoàn thành bản khảo sát này. Khảo sát chất lượng dịch vụ CodeGym là cơ hội để bạn nói lên quan điểm của mình về những điều bạn mong muốn trong thời gian bạn học tại CodeGym cũng như mọi thứ bạn nghĩ cần được cải tiến. Khảo sát chất lượng dịch vụ CodeGym giúp CodeGym nắm bắt được những suy nghĩ, nguyện vọng của học viên. Ý kiến đóng góp của bạn là những gợi ý cần thiết và sát thực tế để CodeGym có căn cứ cải thiện các điều kiện học tập của bạn ngày càng tốt hơn";
        str=str.toLowerCase();
        Scanner sc=new Scanner(System.in);
        char search=sc.nextLine().charAt(0);
        int count=0;
        System.out.println(str);
        for (int i = 0; i <str.length() ; i++) {
           if (str.charAt(i)==search)
           {
               count++;
           }

        }
        System.out.println(count);
    }

}
