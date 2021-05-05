package services;

import io.WriteAndReadFile;
import models.Service;
import models.Villa;

import java.util.*;

public class VillaService {
    public static void addVilla(){
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
        System.out.println("input room type ");
        String roomType=scanner.nextLine();

        System.out.println("input convenient");
        String convenient=scanner.nextLine();

        System.out.println("input area pool");
        double areaPool=Double.parseDouble(scanner.nextLine());

        System.out.println("input number of floor");
        int numberOfFloor=Integer.parseInt(scanner.nextLine());
        Villa villa=new Villa(id,name,area,rent,maxPeople,typeForRent,roomType,convenient,areaPool,numberOfFloor);
        serviceList.add(villa);
        WriteAndReadFile.writeFile("villa.csv",serviceList,true);


    }
    public static void showAllVilla(){
        List<Service>serviceList=new ArrayList<>();
        serviceList= WriteAndReadFile.readFile("room.csv");
        for (Service service:serviceList){
            if (service instanceof Villa){
                System.out.println(service.showInfor());
            }
        }

    }
    public static void showNameVilla(){
        TreeSet<String> servicesTreeSet = new TreeSet<>(new HashSet<>());
        List<Service> servicesList = new ArrayList<>();
        servicesList = WriteAndReadFile.readFile("room.csv");
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

