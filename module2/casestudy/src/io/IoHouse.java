package io;

import models.House;

import java.io.*;
import java.util.ArrayList;

public class IoHouse {
    public static void saveFile(ArrayList<House> houseArrayList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (House house: houseArrayList) {
                String line = house.toString();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<House> readFile(String path) {
        ArrayList<House> houseArrayList = new ArrayList<House>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] temp = line.split(",");
//               String id, String nameService, double areaUsed, double rentPrice, int maxNumberOfPeople
//            , String typeRent, String roomType, String convenientDescription, int numberOfFloors
                if (temp.length ==9) {
                    House house = new House();
                    house = new House(temp[0],temp[1],Double.parseDouble(temp[2]),Double.parseDouble(temp[3]),Integer.parseInt(temp[4]),temp[5],temp[6],temp[7],Integer.parseInt(temp[8]));
                    houseArrayList.add(house);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return houseArrayList;
    }
}
