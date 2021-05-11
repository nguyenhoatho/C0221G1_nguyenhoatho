package controllers;

import io.Io;
import model.HocSinh;
import model.HocSinhKhoiA;
import model.HocSinhKhoiB;
import model.HocSinhKhoiC;

import java.util.ArrayList;
import java.util.Scanner;

public class HocSinhController {
    static Scanner scanner= new Scanner(System.in);
    static ArrayList<HocSinh>hocSinhArrayList=new ArrayList<>();
    public static void addNewHocSinhKhoiA(){

        System.out.println("nhap so bao danh");
        String soBaodanh=scanner.nextLine();
        System.out.println("nhap ho va ten");
        String hoVaTen=scanner.nextLine();
        System.out.println("nhap dia chi");
        String diachi=scanner.nextLine();
        System.out.println("khu vuc uu tien");
        String uuTien=scanner.nextLine();
        String toan="toan";
        String ly="ly";
        String hoa="hoa";
        HocSinh hocSinhKhoiA=new HocSinhKhoiA(soBaodanh,hoVaTen,diachi,uuTien,toan,ly,hoa);
        hocSinhArrayList.add(hocSinhKhoiA);
        Io.saveFile(hocSinhArrayList,"quan_ly_hoc_sinh/src/data/hocsinh.csv",true);


    }
    public static void addHocSinhKhoiB(){
        System.out.println("nhap so bao danh");
        String soBaodanh=scanner.nextLine();
        System.out.println("nhap ho va ten");
        String hoVaTen=scanner.nextLine();
        System.out.println("nhap dia chi");
        String diachi=scanner.nextLine();
        System.out.println("khu vuc uu tien");
        String uuTien=scanner.nextLine();
        String monToan="toan";
        String hoa="Hoa";
        String sinh="Sinh";
        HocSinh hocSinhKhoiB=new HocSinhKhoiB(soBaodanh,hoVaTen,diachi,uuTien,monToan,hoa,sinh);
        hocSinhArrayList.add(hocSinhKhoiB);
        Io.saveFile(hocSinhArrayList,"quan_ly_hoc_sinh/src/data/hocsinh.csv",true);

    }
    public static void addNewHocSinhKhoiC(){
        System.out.println("nhap so bao danh");
        String soBaodanh=scanner.nextLine();
        System.out.println("nhap ho va ten");
        String hoVaTen=scanner.nextLine();
        System.out.println("nhap dia chi");
        String diachi=scanner.nextLine();
        System.out.println("khu vuc uu tien");
        String uuTien=scanner.nextLine();
        String van="van";
        String su="Su";
        String dia="dia";
        HocSinh hocSinhKhoiC=new HocSinhKhoiC(soBaodanh,hoVaTen,diachi,uuTien,van,su,dia);
        hocSinhArrayList.add(hocSinhKhoiC);
        Io.saveFile(hocSinhArrayList,"quan_ly_hoc_sinh/src/data/hocsinh.csv",true);
    }

}
