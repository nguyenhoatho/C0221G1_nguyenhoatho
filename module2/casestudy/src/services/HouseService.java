package services;

import io.WriteAndReadFile;
import models.House;
import models.Service;

import java.util.*;

public class HouseService {
    public static void addHouse() {
        List<Service> serviceList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("input id ");
        String id = scanner.nextLine();

        System.out.println("input name ");
        String name = scanner.nextLine();

        System.out.println("input area");
        double area = Double.parseDouble(scanner.nextLine());

        System.out.println("input rent price");
        double rent = Double.parseDouble(scanner.nextLine());

        System.out.println("input max people");
        int maxPeople = Integer.parseInt(scanner.nextLine());

        System.out.println(" input type for rent");
        String typeForRent = scanner.nextLine();
        System.out.println("input room type");
        String roomType=scanner.nextLine();

        System.out.println("input convenient ");
        String convenient=input().nextLine();

        System.out.println("input number of floor");
        int numberOfFloor = input().nextInt();
        House house=new House(id,name,area,rent,maxPeople,typeForRent,roomType,convenient,numberOfFloor);
        serviceList.add(house);
        WriteAndReadFile.writeFile("hosuse.csv",serviceList,true);

    }
    public static Scanner input(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    public static void showAllHouse(){
        List<Service> servicesList = new ArrayList<>();
        servicesList = WriteAndReadFile.readFile("hosuse.csv");
        System.out.println('a');
        System.out.println(servicesList.get(0) instanceof House);

        for (Service services : servicesList) {
            if (services instanceof House) {
                System.out.println(services.showInfor());
            }
        }
    }
    public static void showNotDe(){
        TreeSet<String> servicesTreeSet = new TreeSet<>(new HashSet<>());
        List<Service> servicesList = new ArrayList<>();
        servicesList =WriteAndReadFile.readFile("villa.csv");
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
