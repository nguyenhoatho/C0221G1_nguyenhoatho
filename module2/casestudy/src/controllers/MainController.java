package controllers;


import models.Cabinet;

import java.util.Scanner;

public class MainController {

    public static void displayMainMenu() {
        System.out.println(
                "               1.Add New Services\n" +
                        "        2. Show Services\n" +
                        "        3. Add New Customer\n" +
                        "        4. Show Information of Customer\n" +
                        "        5. Add New Booking\n" +
                        "        6. Show Information of Employee\n" +
                                "7.show queue of customer"+
                        "        8. Exit");
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
            case 9:
                System.exit(0);
            case 7:
                showQueueCustomer();
                break;
            case 8:
                Cabinet.searchId();
                break;
        }
    }

    private static void showQueueCustomer() {
        CustomerController.showQueueCustomer();
    }

    private static void addNewServices() {
        System.out.println(
                "            1. Add New Villa\n" +
                        "    2. Add New House\n" +
                        "    3. Add New Room\n" +
                        "    4. Back to menu\n" +
                        "    5. Exit");
        int choose = Integer.parseInt(new Scanner(System.in).nextLine());
        switch (choose) {
            case 1:
                VillaController.addNewVilla();
                break;
            case 2:
                HouseController.addNewHouse();
                break;
            case 3:
                RoomController.addNewRoom();
                break;
            case 4:
                displayMainMenu();
            case 5:
                System.exit(0);
        }
    }


    public static void showInforOfEmployee() {
        EmployeeController.showEmployee();
    }

    private static void addNewBooking() {
        System.out.println("    1. Booking Villa\n" +
                "    2. Booking House\n" +
                "    3. Booking Room");
        int choose=new Scanner(System.in).nextInt();
        switch (choose){
            case 1:
                VillaController.showAllVillaDe();
                break;
            case 2:
                HouseController.showAllHouseDe();
                break;
            case 3:
                RoomController.showAllRoom();
                break;
        }
    }

    private static void showInforCustomer() {
        CustomerController.showAllCustomer();
    }

    private static void addNewCustomer() {
        CustomerController.addNewCustomer();

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
                VillaController.showAllVilla();
                break;
            case 2:
                HouseController.showAllHouse();
                break;
            case 3:
                RoomController.showAllRoom();
                break;
            case 4:
                VillaController.showAllVillaDe();
                break;
            case 5:
                HouseController.showAllHouseDe();
                break;
            case 6:
                RoomController.showAllRoomDe();

                break;
            case 7:
                displayMainMenu();
            case 8:
                System.exit(0);

        }
    }
}


