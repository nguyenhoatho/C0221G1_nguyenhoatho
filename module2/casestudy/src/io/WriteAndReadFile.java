package io;

import models.House;
import models.Room;
import models.Service;
import models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadFile {
    private static final String PATH = "casestudy/src/data/";

    public static void writeFile(String nameFile, List<Service> servicesList, boolean statusWrite) {
        File file = new File(PATH + nameFile);
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, statusWrite));
            for (Service services : servicesList) {
                bufferedWriter.write(services.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println("error writing...");
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<Service> readFile(String nameFile) {
        List<Service> servicesList = new ArrayList<>();
        File file = new File(PATH+nameFile);
        BufferedReader bufferedReader = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            String[] temp;
            Service services = null;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                if (temp.length == 10) {
                    Service villa = new Villa(temp[0], temp[1],Double.parseDouble( temp[2]),Double.parseDouble( temp[3]), Integer.parseInt(temp[4]), temp[5], temp[6], temp[7],Double.parseDouble( temp[8]),Integer.parseInt(temp[9]));
                    servicesList.add(villa);
                }else if(temp.length == 9){
                    Service house = new House(temp[0], temp[1],Double.parseDouble( temp[2]),Double.parseDouble( temp[3]),Integer.parseInt(temp[4]), temp[5], temp[6], temp[7], Integer.parseInt(temp[8]));
                    servicesList.add(house);
                }else {
                    Service room = new Room(temp[0], temp[1],Double.parseDouble( temp[2]),Double.parseDouble(temp[3]),Integer.parseInt( temp[4]), temp[5], temp[6]);
                    servicesList.add(room);
                }
            }
        } catch (IOException e) {
            System.err.println("error reading...");
            e.printStackTrace();
        }finally {
            try{
                bufferedReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return servicesList;
    }
}
