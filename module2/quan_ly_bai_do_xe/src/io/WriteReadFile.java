package io;

import models.BoCongAn;
import models.Oto;
import models.XeMay;
import models.Xetai;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteReadFile {
    public static final String PATH="quan_ly_bai_do_xe/src/data/bocongan.csv";
    public static void writeFile(List<BoCongAn> list, boolean status){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try{
            fileWriter = new FileWriter(PATH);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(BoCongAn boCongAn : list){
                bufferedWriter.write(boCongAn.toString());
                bufferedWriter.append("\n");
            }
        }catch (FileNotFoundException e){
            System.err.println("Not Found Path");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                bufferedWriter.close();
                fileWriter.close();
            }catch (Exception e){
                System.err.println("Exception !!!!");
            }
        }
    }
    public static List<BoCongAn> readFile(){
        FileReader fileReader =null;
        BufferedReader bufferedReader = null;
        String line = null;
        String[] str = null;
        List<BoCongAn> boCongAns = new ArrayList<>();
        try{
            fileReader = new FileReader(PATH);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                str = line.split(",");
                if(str.length == 6){
                    //String id, String nameServices, float areaOfUse, float pricesofRent, int numberPeoples, String typeOfRent, String standardRoom, String convenient, float areaPool, int numberOfFloors
                    BoCongAn oto = new Oto(str[0],str[1],str[2],str[3],Integer.parseInt(str[4]),str[5]);
                    boCongAns.add(oto);
                    //String id, String nameServices, float areaOfUse, float pricesofRent, int numberPeoples, String typeOfRent, String freeServices
                }else if(str.length == 5){
                    BoCongAn xemay = new XeMay(str[0],str[1],str[2],str[3],str[4]);
                    boCongAns.add(xemay);
                    BoCongAn xetai=new Xetai(str[0],str[1],str[2],str[3],Double.parseDouble(str[4]));
                    boCongAns.add(xetai);
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("File Not Fould");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return boCongAns;

    }
    }
