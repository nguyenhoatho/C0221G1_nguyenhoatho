package service.house;

import models.House;
import ultils.compare.HouseCompare;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HouseServiceIml implements HouseService{
    private static final String PATH_FILE_HOUSE = "src/data/House.csv";
    private static final String[] FILE_HEADER_OF_HOUSE = {"id", "nameService", "area", "rentalPrice"
            , "maxNumberOfPeople", "typeRent", "roomType", "convenient"
            , "numberOfFloors"};
    @Override
    public Set<String> getNameServiceFromFileCsv(String path) {
        return null;
    }

    @Override
    public void WriteFileCsv(House house) {
        try {
            List<House> houseWrite=readCsvFile();
            Writer writer=new PrintWriter(PATH_FILE_HOUSE);
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(FILE_HEADER_OF_HOUSE));

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

    @Override
    public List<House> readCsvFile() {
        return null;
    }

    @Override
    public TreeSet<House> readFileCsvNotDuplicate() {
        return null;
    }

    @Override
    public void addNewHouse() {
        Scanner sc=new Scanner(System.in);
        House house =new House();
        System.out.println("input name house");
        house.setServiceName(sc.nextLine());
        System.out.println("type service");
        house.setTypeServices(sc.nextLine());
        System.out.println("input convenient ");
        house.setConvenient(sc.nextLine());
        System.out.println("input area used");
        house.setAreaUsed(sc.nextFloat());
        System.out.println("input floor");
        house.setNumberOfFloor(sc.nextInt());
        System.out.println("input Standard Room");
        house.setStandardRoom(sc.nextLine());
        System.out.println("input Price");
        house.setRentalCosts(sc.nextFloat());
        System.out.println("maximum people");
        house.setMaximumPeople(sc.nextInt());
        WriteFileCsv(house);

    }

    @Override
    public void showAllHouse() {
        List<House> listHouse= readCsvFile();
        for (int i=0;i<listHouse.size();i++){
            System.out.println((i+1)+". \t");
            System.out.println(listHouse.get(i).showInfo());
            System.out.println();
        }

    }

    @Override
    public House getHouseById(int id) {
        List<House> houseList=readCsvFile();
        House house=houseList.get(id-1);
        return house;
    }

    @Override
    public void showAllHouseNotDuplicate() {
        TreeSet<House> houses=new TreeSet<>(new HouseCompare());
        int count=1;
        for (House house:houses){
            System.out.println((count)+". \t");
            System.out.println(house);
            System.out.println();
            count++;

        }

    }
}
