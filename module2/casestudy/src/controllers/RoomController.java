package controllers;

import io.IoRoom;
import models.Room;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RoomController {
    static ArrayList<Room>roomArrayList=new ArrayList<>();
    public static void addNewRoom(){
        Room room=new Room();
        Scanner scanner=new Scanner(System.in);
        System.out.println("input id ");
        String id=scanner.nextLine();
//        while (ServiceValidate.validateId(id)){
//            id = scanner.nextLine();
//        }
        room.setId(id);
        System.out.println("input name ");
        String name=scanner.nextLine();
//        while (ServiceValidate.validateName(name)){
//            name = scanner.nextLine();
//        }
        room.setName(name);
        System.out.println("input area");
        double area=Double.parseDouble(scanner.nextLine());
//        while (ServiceValidate.validateAreaOrAreaPool(area)){
//            area = Double.parseDouble(scanner.nextLine());
//        }
        room.setArea(area);
        System.out.println("input rent price");
        double rent=Double.parseDouble(scanner.nextLine());
//        while (ServiceValidate.validatePrice(rent)){
//            rent = Double.parseDouble(scanner.nextLine());
//        }
        room.setRentPrice(rent);
        System.out.println("input max people");
        int maxPeople=Integer.parseInt(scanner.nextLine());
//        while (ServiceValidate.validateMaxPeople(maxPeople)){
//            maxPeople = Integer.parseInt(scanner.nextLine());
//        }
        room.setMaxPeople(maxPeople);
        System.out.println(" input type for rent");
        String typeForRent=scanner.nextLine();
//        while (ServiceValidate.validateName(typeForRent)){
//            typeForRent=scanner.nextLine();
//        }
        room.setTypeForRent(typeForRent);
        System.out.println("input free server");
        String freeServer=scanner.nextLine();
//        while (ServiceValidate.validateConvenient(freeServer)){
//            freeServer=scanner.nextLine();
//        }
        room.setFreeService(freeServer);
        roomArrayList.add(room);
        IoRoom.saveFile(roomArrayList,"casestudy/src/data/room.csv");
    }
    public static void showAllRoom(){
        roomArrayList=IoRoom.readFile("casestudy/src/data/room.csv");
        for (Room room:roomArrayList){
            System.out.println(room.showInfor());
        }
    }
    public static void showAllRoomDe(){
        Set<String> roomSet=new TreeSet<>();
        roomArrayList= IoRoom.readFile("casestudy/src/data/room.csv");
        for (Room room:roomArrayList){
            roomSet.add(room.getName());
        }
        for (String room:roomSet){
            System.out.println(room);
        }

    }
}
