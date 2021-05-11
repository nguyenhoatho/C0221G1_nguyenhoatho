package io;

import model.HocSinh;
import model.HocSinhKhoiA;
import model.HocSinhKhoiB;
import model.HocSinhKhoiC;

import java.io.*;
import java.util.ArrayList;

public class Io {

  public static void saveFile(ArrayList<HocSinh> hocSinhArrayList, String path,boolean a) {
    try {
        FileOutputStream fos = new FileOutputStream(path);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        for (HocSinh hocSinh:hocSinhArrayList) {
            String line = hocSinh.toString();
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

    public static ArrayList<HocSinh> readFile(String path) {
        ArrayList<HocSinh> hocSinhArrayList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] temp = line.split(",");
                if (temp.length ==6) {
                    HocSinh hocSinhKhoiA=new HocSinhKhoiA(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6]);
                   hocSinhArrayList.add(hocSinhKhoiA);
                   HocSinh hocSinhKhoiB=new HocSinhKhoiB(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6]);
                   hocSinhArrayList.add(hocSinhKhoiB);
                   HocSinh hocSinhKhoiC=new HocSinhKhoiC(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6]);
                   hocSinhArrayList.add(hocSinhKhoiC);

                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hocSinhArrayList;
    }
}
