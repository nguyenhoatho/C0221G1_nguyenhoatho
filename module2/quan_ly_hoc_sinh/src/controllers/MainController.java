package controllers;

import java.util.Scanner;

public class MainController {
    public static void menu() {
        System.out.println("1 them hoc sinh khoi a\n"+
                                "2 them hoc sinh khoi b\n"+
                            "3 them hoc sinh khoi c");
        System.out.println("chon hoc khoi");
        int choose=new Scanner(System.in).nextInt();
        switch (choose){
            case 1:
                HocSinhController.addNewHocSinhKhoiA();
                break;
            case 2:
                HocSinhController.addHocSinhKhoiB();
            case 3:
                HocSinhController.addNewHocSinhKhoiC();

        }
    }
}
