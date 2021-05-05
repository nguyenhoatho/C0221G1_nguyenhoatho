package services;

import io.WriteAndReadFile;
import models.Room;
import models.Service;

import java.util.*;

public class RoomService {
    public static void addRoom(){
        List<Service>serviceList=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("input id ");
        String id=scanner.nextLine();

        System.out.println("input name ");
        String name=scanner.nextLine();

        System.out.println("input area");
        double area=Double.parseDouble(scanner.nextLine());

        System.out.println("input rent price");
        double rent=Double.parseDouble(scanner.nextLine());

        System.out.println("input max people");
        int maxPeople=Integer.parseInt(scanner.nextLine());

        System.out.println(" input type for rent");
        String typeForRent=scanner.nextLine();
        System.out.println("input free server");
        String freeServer=scanner.nextLine();
        Room room=new Room(id,name,area,rent,maxPeople,typeForRent,freeServer);
        serviceList.add(room);
        WriteAndReadFile.writeFile("room",serviceList,true);

    }
    public static void showAllRoom(){
        List<Service>serviceList=new ArrayList<>();
        serviceList=WriteAndReadFile.readFile("room.csv");
        for (Service service:serviceList){
            if (service instanceof Room){
                System.out.println(service.showInfor());
            }
        }
    }
    public static void showAllNameVilla(){
        TreeSet<String> servicesTreeSet = new TreeSet<>(new HashSet<>());
        List<Service> servicesList = new ArrayList<>();
        servicesList = WriteAndReadFile.readFile("Villa.csv");
        String name = null;
        for(int i=0;i<servicesList.size();i++){
            name = servicesList.get(i).getName();
            if(servicesTreeSet.equals(name)){
                continue;
            }
            servicesTreeSet.add(name);
        }
        System.out.println(servicesTreeSet);

    }
}
