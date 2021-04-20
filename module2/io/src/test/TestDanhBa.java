package test;

import io.SerializeFileFactory;
import model.DanhBa;

import java.util.ArrayList;
import java.util.Scanner;

public class TestDanhBa {

    static ArrayList<DanhBa> dsDB=new ArrayList<DanhBa>();
    public static void menu()
    {
        System.out.println("1.Nhập");
        System.out.println("2.Xuất");
        System.out.println("3.Lưu");
        System.out.println("4.Đọc");
        System.out.println("5.Thoát");
        System.out.println("Muốn gì?:");
        int n=new Scanner(System.in).nextInt();
        switch(n)
        {
            case 1:
                nhap();
                break;
            case 2:
                xuat();
                break;
            case 3:
                luu();
                break;
            case 4:
                doc();
                break;
            case 5:
                System.err.println("Tạm biệt!");
                System.exit(0);
                break;
        }
    }
    private static void doc() {
        dsDB= SerializeFileFactory.readFile("danhba.txt");
        xuat();
    }
    private static void luu() {
        boolean kt=SerializeFileFactory.saveFile(dsDB, "danhba.txt");
        if(kt)
            System.out.println("Lưu OK");
    }
    private static void xuat() {
        System.out.println("Danh sách Danh bạ:");
        for(DanhBa db: dsDB)
            System.out.println(db);
    }
    private static void nhap() {
        System.out.println("Nhập tên:");
        String ten=new Scanner(System.in).nextLine();
        System.out.println("Nhập phone:");
        String phone=new Scanner(System.in).nextLine();
        DanhBa db=new DanhBa(ten, phone);
        dsDB.add(db);
    }
    public static void main(String[] args) {
        while(true)
            menu();
    }
}
