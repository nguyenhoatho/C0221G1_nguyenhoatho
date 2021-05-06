package io;

import models.XeMay;

import java.io.*;
import java.util.ArrayList;

public class IoXeMay {
    public static void saveFile(ArrayList<XeMay> xeMayArrayList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (XeMay xeMay : xeMayArrayList) {
                String line = xeMay.toString();
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

    public static ArrayList<XeMay> readFile(String path) {
        ArrayList<XeMay> xeMayArrayList = new ArrayList<XeMay>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] temp = line.split(",");
//                String bienKiemSoat, String hangSanXuat, String namSanxuat, String chuSoHuu, String congSuat
                if (temp.length ==5) {
                    XeMay xeMay = new XeMay();
                    xeMay = new XeMay(temp[0],temp[1],temp[2],temp[3],temp[4]);
                    xeMayArrayList.add(xeMay);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return xeMayArrayList;
    }
}
