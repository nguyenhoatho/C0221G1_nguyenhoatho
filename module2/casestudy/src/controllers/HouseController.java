package controllers;

import io.IoHouse;
import models.House;
import ultils.ServiceValidate;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HouseController {
    static ArrayList<House> houseArrayList=new ArrayList<>();
    public static void addNewHouse(){
        House house=new House();
        Scanner scanner = new Scanner(System.in);
        System.out.println("input id ");
        String id = scanner.nextLine();
//        while (ServiceValidate.validateId(id)){
//            id = scanner.nextLine();
//        }
        house.setId(id);
        System.out.println("input name ");
        String name = scanner.nextLine();
//        while (ServiceValidate.validateName(name)){
//            name = scanner.nextLine();
//        }
        house.setName(name);
        System.out.println("input area");
        double area = Double.parseDouble(scanner.nextLine());
//        while (ServiceValidate.validateAreaOrAreaPool(area)){
//            area = Double.parseDouble(scanner.nextLine());
//        }
        house.setArea(area);
        System.out.println("input rent price");
        double rent = Double.parseDouble(scanner.nextLine());
//        while (ServiceValidate.validatePrice(rent)){
//            rent = Double.parseDouble(scanner.nextLine());
//        }
        house.setRentPrice(rent);
        System.out.println("input max people");
        int maxPeople = Integer.parseInt(scanner.nextLine());
//        while (ServiceValidate.validateMaxPeople(maxPeople)){
//            maxPeople = Integer.parseInt(scanner.nextLine());
//        }
        house.setMaxPeople(maxPeople);
        System.out.println(" input type for rent");
        String typeForRent = scanner.nextLine();
        house.setTypeForRent(typeForRent);
        System.out.println("input room type");
        String roomType=scanner.nextLine();
        house.setRoomType(roomType);

        System.out.println("input convenient ");
        String convenient;
        do {
            convenient=scanner.nextLine();
        }
        while (ServiceValidate.validateConvenient(convenient));


        house.setConvenient(convenient);
        System.out.println("input number of floor");
        int numberOfFloor;
        do {
             numberOfFloor = Integer.parseInt(scanner.nextLine());
        }while (ServiceValidate.validateFloor(numberOfFloor));
        house.setNumberOfFloor(numberOfFloor);
        houseArrayList.add(house);
        IoHouse.saveFile(houseArrayList,"casestudy/src/data/house.csv");

    }
    public static void showAllHouse(){
        houseArrayList=IoHouse.readFile("casestudy/src/data/house.csv");
        for (House house:houseArrayList){
            System.out.println(house.showInfor());
        }
    }
    public static void showAllHouseDe(){
        Set<String>houseSet=new TreeSet<>();
        houseArrayList=IoHouse.readFile("casestudy/src/data/house.csv");

        for (House house:houseArrayList){
            houseSet.add(house.getName());

        }
        for (String house:houseSet){
            System.out.println(house);
        }
    }
}
