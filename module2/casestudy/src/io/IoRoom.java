package io;

import models.Room;

import java.io.*;
import java.util.ArrayList;

public class IoRoom {
    //String id, String nameService, double areaUse, double rentPrice, int maxNumberOfPeople, String typeRent
    //            , String freeService
    public static void saveFile(ArrayList<Room> roomArrayList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (Room room: roomArrayList) {
                String line = room.toString();
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

    public static ArrayList<Room> readFile(String path) {
        ArrayList<Room> roomArrayList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] temp = line.split(",");
//
                if (temp.length ==7) {
                    Room room = new Room();
                    room= new Room(temp[0],temp[1],Double.parseDouble(temp[2]),Double.parseDouble(temp[3]),Integer.parseInt(temp[4]),temp[5],temp[6]);
                    roomArrayList.add(room);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return roomArrayList;
    }
}
