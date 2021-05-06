package controller;

import io.IoXeMay;
import models.XeMay;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerXeMay {
    static ArrayList<XeMay> xeMayArrayList=new ArrayList<>();
    //String bienKiemSoat, String hangSanXuat, String namSanxuat, String chuSoHuu, double trongtai
    public static void themXeMay(){
        XeMay xeMay=new XeMay();
        Scanner scanner=new Scanner(System.in);
        System.out.println("bien kiem soat");
        String bienKiemSoat=scanner.nextLine();
        xeMay.setBienKiemSoat(bienKiemSoat);
        System.out.println("hang san xuat");
        String hangSanXuat=scanner.nextLine();
        xeMay.setHangSanXuat(hangSanXuat);
        System.out.println("nam san xuat");
        String namSanXuat=scanner.nextLine();
        xeMay.setNamSanxuat(namSanXuat);
        System.out.println("chu so huu");
        String chuSoHuu=scanner.nextLine();
        xeMay.setChuSoHuu(chuSoHuu);
        System.out.println("nhap cong suat");
        String congSuat=scanner.nextLine();
        xeMay.setCongSuat(congSuat);
        xeMayArrayList.add(xeMay);
        IoXeMay.saveFile(xeMayArrayList,"quan_ly_bai_do_xe/src/data/xemay.csv");


    }
    public static void hienThiXeMay(){
        xeMayArrayList=IoXeMay.readFile("quan_ly_bai_do_xe/src/data/xetai.csv");
        for (XeMay xeMay:xeMayArrayList){
            System.out.println(xeMay.toString());
        }
    }
}
