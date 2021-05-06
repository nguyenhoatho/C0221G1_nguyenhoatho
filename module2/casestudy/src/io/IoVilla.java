package io;

import models.Villa;

import java.io.*;
import java.util.ArrayList;

public class IoVilla {
    public static void saveFile(ArrayList<Villa> villaArrayList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (Villa villa: villaArrayList) {
                String line = villa.toString();
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

    public static ArrayList<Villa> readFile(String path) {
        ArrayList<Villa> villaArrayList = new ArrayList<Villa>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] temp = line.split(",");
//               String id, String nameService, double areaUsed, double rentPrice, int maxNumberOfPeople
//            , String typeRent, String roomType, String convenientDescription, int numberOfFloors
                if (temp.length ==10) {
                    //tring id, String nameService, double areaUsed, double rentPrice, int maxNumberOfPeople
                    //            , String typeRent, String roomType, String convenientDescription, double areaPool, int numberOfFloors
                    Villa villa = new Villa();
                    villa = new Villa(temp[0],temp[1],Double.parseDouble(temp[2]),Double.parseDouble(temp[3]),Integer.parseInt(temp[4]),temp[5],temp[6],temp[7],Double.parseDouble(temp[8]),Integer.parseInt(temp[9]));
                    villaArrayList.add(villa);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return villaArrayList;
    }
}
