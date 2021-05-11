package controller;

import exception.NameException;
import io.WriteReadFile;
import models.BoCongAn;
import models.Oto;
import models.XeMay;
import models.Xetai;
import regex.Regex;

import java.util.List;
import java.util.Scanner;

public class Service {
    static List<BoCongAn>boCongAns=WriteReadFile.readFile();
    static Scanner scanner =new Scanner(System.in);
    public static void themMoiOto(){


        String  bienKiemSoat=null;
       do {
           try {
               System.out.println("nhap bien kiem soat");
               bienKiemSoat=scanner.nextLine();
               Regex.checkBienSo(bienKiemSoat);
               break;

           }catch (NameException nameException){
               System.out.println(nameException.getMessage());
           }
       }while (true);
        System.out.println("nhap hang san xuat ");
        String hangSanXuat=scanner.nextLine();
        //
        System.out.println("nhap nawm san xuat");
        String namSanXuat=scanner.nextLine();
        //
        System.out.println("so cho ngoi");
        int soChoNgoi=Integer.parseInt(scanner.nextLine());
        //

        System.out.println("chu so huu");
        String chuSohuu=scanner.nextLine();
        System.out.println("kieu xe");
        String kieuXe=scanner.nextLine();
        BoCongAn oto=new Oto(bienKiemSoat,hangSanXuat,namSanXuat,chuSohuu,soChoNgoi,kieuXe);
        boCongAns.add(oto);
        WriteReadFile.writeFile(boCongAns,false);
    }
        public static void themMoiXeTai(){
            System.out.println("bien kiem soat");
            String bienKiemSoat=scanner.nextLine();

            System.out.println("hang san xuat");
            String hangSanXuat=scanner.nextLine();

            System.out.println("nam san xuat");
            String namSanXuat=scanner.nextLine();

            System.out.println("chu so huu");
            String chuSoHuu=scanner.nextLine();

            System.out.println("trong tai");
            double trongTai=Double.parseDouble(scanner.nextLine());
           BoCongAn xeTai=new Xetai(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu,trongTai);
           boCongAns.add(xeTai);
           WriteReadFile.writeFile(boCongAns,false);
        }
        public static void themMoiXeMay(){
            System.out.println("bien kiem soat");
            String bienKiemSoat=scanner.nextLine();

            System.out.println("hang san xuat");
            String hangSanXuat=scanner.nextLine();

            System.out.println("nam san xuat");
            String namSanXuat=scanner.nextLine();

            System.out.println("chu so huu");
            String chuSoHuu=scanner.nextLine();

            System.out.println("nhap cong suat");
            String congSuat=scanner.nextLine();

            BoCongAn xeMay=new XeMay(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu,congSuat);
            boCongAns.add(xeMay);
    }
    public static void hienThiXeOto(){
        for (BoCongAn xeOto:boCongAns){
            if (xeOto instanceof Oto){
                System.out.println(xeOto.toString());
            }
        }
    }
    public static void hienThiXeMay(){
        for (BoCongAn xeMay:boCongAns){
            if (xeMay instanceof XeMay){
                System.out.println(xeMay.toString());
            }
        }
    }
    public static void hienThiXeTai(){
        for (BoCongAn xeTai:boCongAns){
            if (xeTai instanceof Xetai){
                System.out.println(xeTai.toString());
            }
        }
    }
    public static void xoaPhuongTien(){
        String bienSoCanTim=scanner.nextLine();
        boCongAns.removeIf(xeCanXoa -> xeCanXoa.getBienKiemSoat().equals(bienSoCanTim));
        WriteReadFile.writeFile(boCongAns,false);
    }

}
