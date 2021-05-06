package controller;

import java.util.Scanner;

public class MainController {
    public static void menu(){
        System.out.println("chuowng trinh  quan ly phuong tien");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1.them moi phuong tine \n" +
                "2.hien thi phuong tien\n" +
                "3.xoa phuong tien\n"+
                    "4.thoat");
        int choose=new Scanner(System.in).nextInt();
        switch (choose){
            case 1:
                themPhuongTienMoi();
                break;
            case 2:
                hienThiPhuongTien();
                break;
            case 3:
                xoaPhuongTien();
                break;
            case 4:
                System.exit(0);

        }

    }

    private static void xoaPhuongTien() {
    }

    private static void hienThiPhuongTien() {
        System.out.println("1. Hiện thị xe tải.\n" +
                "2. Hiện thị ôtô. \n" +
                "3. Hiện  xe máy.");
        int chon=new Scanner(System.in).nextInt();
        switch (chon){
            case 1:
                ControllerXeTai.hienThiXetai();
                break;
            case 2:
                ControllerOto.hienThiXeOto();
                break;
            case 3:
                ControllerXeMay.hienThiXeMay();
                break;
        }
    }

    private static void themPhuongTienMoi() {
        System.out.println("\t1. Thêm xe tải,\n" +
                " \t2. Thêm ôtô, \n" +
                "\t3. Thêm  xe máy.");
        int chon=new Scanner(System.in).nextInt();
        switch (chon){
            case 1:
                ControllerXeTai.themXeTai();
                break;
            case 2:
                ControllerOto.addOto();
                break;
            case 3:
                ControllerXeMay.themXeMay();
                break;

        }

    }
}
