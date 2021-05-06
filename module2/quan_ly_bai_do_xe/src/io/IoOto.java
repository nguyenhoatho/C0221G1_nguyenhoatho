package io;

import models.Oto;

import java.io.*;
import java.util.ArrayList;

public class IoOto {
    public static void saveFile(ArrayList<Oto> otoArrayList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (Oto oto: otoArrayList) {
                String line = oto.toString();
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

    public static ArrayList<Oto> readFile(String path) {
        ArrayList<Oto> otoArrayList = new ArrayList<Oto>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] temp = line.split(",");
//                String bienKiemSoat, String hangSanXuat, String namSanxuat, String chuSoHuu, int soKieuNgoi, String kieuXe
                if (temp.length ==6) {
                    Oto oto = new Oto();
                    oto = new Oto(temp[0],temp[1],temp[2],temp[3],Integer.parseInt(temp[4]),temp[5]);
                    otoArrayList.add(oto);
                }
                    line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return otoArrayList;
    }
}
