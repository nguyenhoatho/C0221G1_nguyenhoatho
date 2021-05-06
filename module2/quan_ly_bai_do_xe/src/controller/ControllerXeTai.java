package controller;

import io.IoXetai;
import models.Xetai;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerXeTai {
    static ArrayList<Xetai>xetaiArrayList=new ArrayList<>();
    //String bienKiemSoat, String hangSanXuat, String namSanxuat, String chuSoHuu, double trongtai
    public static void themXeTai(){
        Xetai xetai=new Xetai();
        Scanner scanner=new Scanner(System.in);
        System.out.println("bien kiem soat");
        String bienKiemSoat=scanner.nextLine();
        xetai.setBienKiemSoat(bienKiemSoat);
        System.out.println("hang san xuat");
        String hangSanXuat=scanner.nextLine();
        xetai.setHangSanXuat(hangSanXuat);
        System.out.println("nam san xuat");
        String namSanXuat=scanner.nextLine();
        xetai.setNamSanxuat(namSanXuat);
        System.out.println("chu so huu");
        String chuSoHuu=scanner.nextLine();
        xetai.setChuSoHuu(chuSoHuu);
        System.out.println("trong tai");
        double trongTai=Double.parseDouble(scanner.nextLine());
        xetai.setTrongtai(trongTai);
        xetaiArrayList.add(xetai);
        IoXetai.saveFile(xetaiArrayList,"quan_ly_bai_do_xe/src/data/xetai.csv");


    }
    public static void hienThiXetai(){
        xetaiArrayList=IoXetai.readFile("quan_ly_bai_do_xe/src/data/xetai.csv");
        for (Xetai xetai:xetaiArrayList){
            System.out.println(xetai.toString());
        }
    }
}
