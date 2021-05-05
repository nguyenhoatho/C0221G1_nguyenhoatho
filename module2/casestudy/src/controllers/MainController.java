package controllers;

import services.HouseService;
import services.RoomService;
import services.VillaService;

import java.util.Scanner;

public class MainController {
    public static String VILLA = "villa";
    public static String HOUSE = "house";
    public static String ROOM = "room";

    public static void displayMainMenu() {
        System.out.println(
                "        1.Add New Services\n" +
                        "        2. Show Services\n" +
                        "        3. Add New Customer\n" +
                        "        4. Show Information of Customer\n" +
                        "        5. Add New Booking\n" +
                        "        6. Show Information of Employee\n" +
                        "        7. Exit");
        System.out.println("invite you to choose the function you want");
        int choose = new Scanner(System.in).nextInt();
        switch (choose) {
            case 1:
                addNewServices();
                break;
            case 2:
                showServices();
                break;
            case 3:
                addNewCustomer();
                break;
            case 4:
                showInforCustomer();
                break;
            case 5:
                addNewBooking();
                break;
            case 6:
                showInforOfEmployee();
                break;
            case 7:
                System.exit(0);
        }
    }

    private static void addNewServices() {
        System.out.println(
                "1. Add New Villa\n" +
                        "    2. Add New House\n" +
                        "    3. Add New Room\n" +
                        "    4. Back to menu\n" +
                        "    5. Exit");
        int choose = Integer.parseInt(new Scanner(System.in).nextLine());
        switch (choose) {
            case 1:
                VillaService.addVilla();
                break;
            case 2:
                HouseService.addHouse();
                break;
            case 3:
                RoomService.addRoom();
                break;
            case 4:
                displayMainMenu();
            case 5:
                System.exit(0);
        }
    }


    private static void showInforOfEmployee() {
    }

    private static void addNewBooking() {
    }

    private static void showInforCustomer() {
    }

    private static void addNewCustomer() {
    }

    private static void showServices() {
        System.out.println("    1. Show all Villa\n" +
                "    2. Show all House\n" +
                "    3. Show all Room\n" +
                "    4. Show All Name Villa Not Duplicate\n" +
                "    5. Show All Name House Not Duplicate\n" +
                "    6. Show All Name Name Not Duplicate\n" +
                "    7. Back to menu\n" +
                "    8. Exit");
        int choose = new Scanner(System.in).nextInt();
        switch (choose) {
            case 1:
                VillaService.showAllVilla();
                break;
            case 2:
                HouseService.showAllHouse();
                break;
            case 3:
                RoomService.showAllRoom();
                break;
            case 4:
                VillaService.showNameVilla();
                break;
            case 5:
                HouseService.showNotDe();
                break;
            case 6:
                RoomService.showAllNameVilla();

                break;
            case 7:
                displayMainMenu();
            case 8:
                System.exit(0);

        }
    }
}


