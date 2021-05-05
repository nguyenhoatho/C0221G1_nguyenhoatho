import java.util.ArrayList;

public class IoTextTest {
    public static void main(String[] args) {
        int n=0;
        ArrayList<String> ds=Io.ReadFile("littered.txt");
//        for (String str:ds){
//            System.out.println(str);
//
//        }
        ArrayList<String>ds1=new ArrayList<>();
        for (String str1:ds){
            ds1.add(str1);

        }
        boolean kq=Io.SavaFile(ds1,"io_text/src/filemgoi.txt");
        if (kq){
            System.out.println("luu file thanh cong");
        }else {
            System.out.println("luu file tha bai");
        }
        ArrayList<String>ds2=Io.ReadFile("io_text/src/filemoi.txt");
        for (String str2:ds2){
            System.out.println(str2);
        }


    }
}
