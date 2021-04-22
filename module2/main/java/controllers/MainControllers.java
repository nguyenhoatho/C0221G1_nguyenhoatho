package controllers;

import java.util.Scanner;

public class MainControllers {
    private static void displayMainMenu(){
        System.out.println("1.  Add New Services\n" +
                "        2. Show Services\n" +
                "        3. Add New Customer\n" +
                "        4. Show Information of Customer\n" +
                "        5. Add New Booking\n" +
                "        6. Show Information of Employee\n" +
                "        7. Exit       ");

        System.out.println("please input choose");
        int choose=new Scanner(System.in).nextInt();
        switch (choose){
            case 1:
                addNewServices();
                break;
            case 2:
                showService();
                break;
            case 3:
                addNewCustom();
                break;
            case 5:
                addNewBooking();
                break;
            case 4:
                ShowInformationOfCustomer();
                break;
            case 6:
                ShowInformationOfEmployee();
                break;
            case 7:
                System.exit(0);



        }
    }

    private static void ShowInformationOfEmployee() {
    }

    private static void ShowInformationOfCustomer() {
    }

    private static void addNewBooking() {
    }

    private static void addNewCustom() {
    }

    private static void showService() {
    }

    private static void addNewServices() {
        System.out.println("1. Add New Villa\n" +
                "    2. Add New House\n" +
                "    3. Add New Room\n" +
                "    4. Back to menu\n" +
                "    5. Exit");
        System.out.println("Please select the function on the menu");
        int choose=new Scanner(System.in).nextInt();
        switch (choose){
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                System.out.println("back top menu");
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
        }

    }

    private static void addNewRoom() {
    }

    private static void addNewHouse() {
    }

    private static void addNewVilla() {
    }

}

