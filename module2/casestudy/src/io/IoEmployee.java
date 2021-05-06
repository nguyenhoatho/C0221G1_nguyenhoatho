package io;

import models.Employee;

import java.io.*;
import java.util.ArrayList;

public class IoEmployee {
    public static void saveFile(ArrayList<Employee> employeeArrayList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (Employee employee :employeeArrayList) {
                String line = employee.toString();
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

    public static ArrayList<Employee> readFile(String path) {
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] temp = line.split(",");
//               String id, String nameService, double areaUsed, double rentPrice, int maxNumberOfPeople
//            , String typeRent, String roomType, String convenientDescription, int numberOfFloors
                if (temp.length ==4) {
                    //tring id, String nameService, double areaUsed, double rentPrice, int maxNumberOfPeople
                    //            , String typeRent, String roomType, String convenientDescription, double areaPool, int numberOfFloors
                    Employee employee = new Employee();
                    employee = new Employee(temp[0],temp[1],Integer.parseInt(temp[2]),temp[3]);
                    employeeArrayList.add(employee);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employeeArrayList;
    }
}
