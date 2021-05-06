package io;

import models.Xetai;

import java.io.*;
import java.util.ArrayList;

public class IoXetai {
    public static void saveFile(ArrayList<Xetai>xetaiArrayList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (Xetai xetai : xetaiArrayList) {
                String line = xetai.toString();
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

    public static ArrayList<Xetai> readFile(String path) {
        ArrayList<Xetai> xetaiArrayList = new ArrayList<Xetai>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] temp = line.split(",");
//                String bienKiemSoat, String hangSanXuat, String namSanxuat, String chuSoHuu, String congSuat
                if (temp.length ==5) {
                    Xetai xetai = new Xetai();
                    xetai = new Xetai(temp[0],temp[1],temp[2],temp[3],Double.parseDouble(temp[4]));
                    xetaiArrayList.add(xetai);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return xetaiArrayList;
    }
}
