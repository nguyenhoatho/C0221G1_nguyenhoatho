package controllers;

import io.IoVilla;
import models.Villa;
import ultils.ServiceValidate;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class VillaController {
    static ArrayList<Villa>villaArrayList=new ArrayList<>();
    public static void addNewVilla() {
        Villa villa=new Villa();
        Scanner scanner = new Scanner(System.in);
        System.out.println("input id ");
        String id = scanner.nextLine();
//        while (ServiceValidate.validateId(id)){
//            id = scanner.nextLine();
//        }
        villa.setId(id);
        System.out.println("input name ");
        String name = scanner.nextLine();
//        while (ServiceValidate.validateName(name)){
//            name = scanner.nextLine();
//        }
        villa.setName(name);
        System.out.println("input area");
        double area = Double.parseDouble(scanner.nextLine());
        while (ServiceValidate.validateAreaOrAreaPool(area)){
            area = Double.parseDouble(scanner.nextLine());
        }
        villa.setArea(area);
        System.out.println("input rent price");
        double rent = Double.parseDouble(scanner.nextLine());
        while (ServiceValidate.validatePrice(rent)){
            rent = Double.parseDouble(scanner.nextLine());
        }
        villa.setRentPrice(rent);
        System.out.println("input max people");
        int maxPeople = Integer.parseInt(scanner.nextLine());
        while (ServiceValidate.validateMaxPeople(maxPeople)){
            maxPeople = Integer.parseInt(scanner.nextLine());
        }
        villa.setMaxPeople(maxPeople);
        System.out.println(" input type for rent");
        String typeForRent = scanner.nextLine();
        while (ServiceValidate.validateName(typeForRent)){
            typeForRent=scanner.nextLine();
        }
        villa.setTypeForRent(typeForRent);
        System.out.println("input room type ");
        String roomType = scanner.nextLine();

        villa.setRoomType(roomType);
        System.out.println("input convenient");
        String convenient = scanner.nextLine();
        while (ServiceValidate.validateConvenient(convenient)){
            convenient=scanner.nextLine();
        }
        villa.setConvenient(convenient);
        System.out.println("input area pool");
        double areaPool = Double.parseDouble(scanner.nextLine());
        while (ServiceValidate.validateAreaOrAreaPool(areaPool)){
            areaPool = Double.parseDouble(scanner.nextLine());
        }
        villa.setAreaPool(areaPool);
        System.out.println("input number of floor");
        int numberOfFloor = Integer.parseInt(scanner.nextLine());
        while (ServiceValidate.validateFloor(numberOfFloor)){
            numberOfFloor = Integer.parseInt(scanner.nextLine());
        }
        villa.setNumberOfFloor(numberOfFloor);
        villaArrayList.add(villa);
        IoVilla.saveFile(villaArrayList,"casestudy/src/data/villa.csv");
    }
    public static void showAllVilla(){
        villaArrayList=IoVilla.readFile("casestudy/src/data/villa.csv");
        for (Villa villa:villaArrayList){
            System.out.println(villa.showInfor());
        }
    }
    public static void showAllVillaDe(){
        Set<String>villaSet=new TreeSet<>();
        villaArrayList=IoVilla.readFile("casestudy/src/data/villa.csv");
        for (Villa villa:villaArrayList){
            villaSet.add(villa.getName());

        }
        for (String villa:villaSet){
            System.out.println(villa);
        }
    }
}