package io;

import models.Customer;

import java.io.*;
import java.util.ArrayList;

public class IoCustomer {
    public static void saveFile(ArrayList<Customer> customerArrayList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (Customer customer:customerArrayList) {
                String line = customer.toString();
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

    public static ArrayList<Customer> readFile(String path) {
        ArrayList<Customer> customerArrayList = new ArrayList<>();
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
                   Customer customer = new Customer();
                    customer = new Customer(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7],temp[8],temp[9]);
                    customerArrayList.add(customer);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customerArrayList;
    }
}
