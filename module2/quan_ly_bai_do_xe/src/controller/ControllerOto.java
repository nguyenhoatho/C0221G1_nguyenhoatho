package controller;

import io.IoOto;
import models.Oto;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerOto {
    static ArrayList<Oto>otoArrayList=new ArrayList<>();
    static Scanner scanner=new Scanner(System.in);
    public static void addOto(){
        //String bienKiemSoat, String hangSanXuat, String namSanxuat, String chuSoHuu, int soKieuNgoi, String kieuXe
        Oto oto=new Oto();
        System.out.println("nhap bien kiem soat");
        String bienKiemSoat= scanner.nextLine();
        //
        oto.setBienKiemSoat(bienKiemSoat);
        System.out.println("nhap hang san xuat ");
        String hangSanXuat=scanner.nextLine();
       //
        oto.setHangSanXuat(hangSanXuat);
        System.out.println("nhap nawm san xuat");
        String namSanXuat=scanner.nextLine();
        //
        oto.setNamSanxuat(namSanXuat);
        System.out.println("so cho ngoi");
        int soChoNgoi=Integer.parseInt(scanner.nextLine());
        //
        oto.setSoKieuNgoi(soChoNgoi);
        System.out.println("chu so huu");
        String chuSohuu=scanner.nextLine();
        oto.setChuSoHuu(chuSohuu);
        System.out.println("kieu xe");
        String kieuXe=scanner.nextLine();
        oto.setKieuXe(kieuXe);
        otoArrayList.add(oto);
        IoOto.saveFile(otoArrayList,"quan_ly_bai_do_xe/src/data/oto.csv");
    }
    public static void hienThiXeOto(){
        otoArrayList=IoOto.readFile("quan_ly_bai_do_xe/src/data/oto.csv");
        for (Oto oto:otoArrayList){
            System.out.println(oto.toString());
        }
    }
}
