package controller;

import java.util.Scanner;

public class MenuChinh {
    public static void menu(){
        System.out.println("1 xem danh sách\n"+
                "2.thêm mới\n"+
                "3.cập nhật\n"+"4.xóa\n"+"5.tìm kiếm\n"+"6 đọc file\n"+"7.ghi vào file\n"+"8. thoát");
        System.out.println("mời bạn chon các chức năng trên");
        
            int chon=new Scanner(System.in).nextInt();
        switch (chon){
            case 1:
                xemDanhSach();
                break;
            case 2:
                themMoi();
                break;
            case 3:
                capNhat();
                break;
            case 4:
                xoa();
                break;
            case 5:
                timkien();
                break;
            case 6:
                docFile();
                break;
            case 7:
                ghiVaoFile();
                break;
            case 8:
                System.exit(0);
            default:
                System.out.println("nhap sai vui longf nhap lai");
        }

    }

    private static void ghiVaoFile() {
        ThucHienChucNang.ghiVaoFile();
    }

    private static void docFile() {
        ThucHienChucNang.docFile();
    }

    private static void timkien() {
        ThucHienChucNang.timkiem();
    }

    private static void xoa() {
        ThucHienChucNang.xoa();
    }

    private static void capNhat() {
        ThucHienChucNang.capnhat();
    }

    private static void themMoi() {
        ThucHienChucNang.them();
    }

    private static void xemDanhSach() {
        ThucHienChucNang.hienThi();
    }
}
