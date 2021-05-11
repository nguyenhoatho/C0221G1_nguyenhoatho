package controller;

import exception.EmailException;
import exception.NameException;
import io.DocGhiFile;
import models.DanhBa;
import regex.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThucHienChucNang {
    static List<DanhBa>danhBaList=new ArrayList<>();
    static Scanner scanner=new Scanner(System.in);
    public static void them(){
        String soDienThoai=null;
        do {
            try{
                System.out.println("nhap so dien thoai ");
                soDienThoai= scanner.nextLine();
                Regex.regexPhone(soDienThoai);
                break;
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }while (true);

        System.out.println("nhap nhom danh ba");
        String nhomCuaDanhBa=scanner.nextLine();
        String hoTen=null;
        do {
            try{
                System.out.println("Nhập tên ");
                hoTen= scanner.nextLine();
                Regex.checkNameCustomers(hoTen);
                break;
            }catch (NameException e){
                System.err.println(e.getMessage());
            }
        }while (true);




                System.out.println("nhap gioi tinh");
                String gioitinh= scanner.nextLine();

        System.out.println("nhap dia chi");
        String diaChi=scanner.nextLine();
        System.out.println("nhap ngay sinh");
        String ngaySinh=scanner.nextLine();
        String email=null;
        do {
            try{
                System.out.println("nhap email");
                 email=scanner.nextLine();
                Regex.checkEmail(email);
                break;
            }catch (EmailException e){
                System.err.println(e.getMessage());
            }
        }while (true);

        DanhBa danhBa=new DanhBa(soDienThoai,nhomCuaDanhBa,hoTen,gioitinh,diaChi,ngaySinh,email);
        danhBaList.add(danhBa);

    }
    public static void ghiVaoFile(){
        boolean check= DocGhiFile.saveFile(danhBaList,"thicuoimodule/src/data/contacts.csv");
        if (check){
            System.out.println("luu file thanh cong");
        }else {
            System.out.println("that bai");
        }
    }
    public static void docFile(){
        List<DanhBa>danhBaArrayList;
        danhBaArrayList=  DocGhiFile.readFile("thicuoimodule/src/data/contacts.csv");
        danhBaList.addAll(danhBaArrayList);

    }
    public static void capnhat(){
        System.out.println("nhap so dien thoai can cap nhat");
        String soCapNhat=scanner.nextLine();
        for (DanhBa danhBa:danhBaList){
           boolean check=danhBa.getSoDienThoai().equals(soCapNhat);
            if (check){
                System.out.println("nhap nhom danh ba");
                String nhomCuaDanhBa=scanner.nextLine();
                System.out.println("nhap ho ten");
                String hoTen=scanner.nextLine();
                System.out.println("nhap gioi tinh");
                String gioitinh=scanner.nextLine();
                System.out.println("nhap dia chi");
                String diaChi=scanner.nextLine();
                System.out.println("nhap ngay sinh");
                String ngaySinh=scanner.nextLine();
                System.out.println("nhap email");
                String email=scanner.nextLine();
                danhBa.setNhomCuaDanhBa(nhomCuaDanhBa);
                danhBa.setHoTen(hoTen);
                danhBa.setGioiTinh(gioitinh);
                danhBa.setDiaChi(diaChi);
                danhBa.setEmail(email);
                danhBa.setNgaySinh(ngaySinh);
            }
        }


    }
    public static void xoa(){
        System.out.println("nhap so dien thoai muon xoa");
        String soDienThoaiMuonXoa=scanner.nextLine();
        danhBaList.removeIf(danhBa -> danhBa.getSoDienThoai().equals(soDienThoaiMuonXoa));
    }
    public static void timkiem(){
        System.out.println("nhap so dien thoai muon tim kiem");
        String sodienThoaiCanTim=scanner.nextLine();

        for (DanhBa danhBa:danhBaList){
            boolean check=danhBa.getSoDienThoai().equals(sodienThoaiCanTim);
            if (check){
                System.out.println(danhBa.hienThi());
            }

        }



    }
    public static void hienThi(){
        for (DanhBa danhBa2:danhBaList){
            System.out.println(danhBa2.hienThi());
        }
    }



}
