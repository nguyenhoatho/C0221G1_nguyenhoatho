package io;

import models.DanhBa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFile {
    public static boolean saveFile(List<DanhBa> danhBaList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (DanhBa danhBa :danhBaList) {
                String line = danhBa.toString();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static List<DanhBa> readFile(String path) {
        List<DanhBa> danhBaList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] temp = line.split(",");
//               String id, String nameService, double areaUsed, double rentPrice, int maxNumberOfPeople
//            , String typeRent, String roomType, String convenientDescription, int numberOfFloors
                if (temp.length ==7) {
                    //tring id, String nameService, double areaUsed, double rentPrice, int maxNumberOfPeople
                    //            , String typeRent, String roomType, String convenientDescription, double areaPool, int numberOfFloors
                   DanhBa danhBa = new DanhBa(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6]);
                    danhBaList.add(danhBa);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return danhBaList;
    }
}
