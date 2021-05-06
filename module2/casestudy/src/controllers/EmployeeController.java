package controllers;

import io.IoEmployee;
import models.Employee;

import java.util.*;

public class EmployeeController {
    static private ArrayList<Employee>employeeArrayList=new ArrayList<>();

    public static void addNewEmployee(){
        Employee employee=new Employee();
        Scanner scanner=new Scanner(System.in);
        System.out.println("input id");
        String id=scanner.nextLine();
        employee.setIdEmployee(id);
        System.out.println("input name");
        String name=scanner.nextLine();
        employee.setNameEmployee(name);
        System.out.println("input age");
        int age=Integer.parseInt(scanner.nextLine());
        employee.setAge(age);
        System.out.println("input address");
        String address=scanner.nextLine();
        employee.setAddress(address);
        employeeArrayList.add(employee);
        IoEmployee.saveFile(employeeArrayList,"casestudy/src/data/employee.csv");
    }
    public static void showEmployee(){
        ArrayList<Employee> employees=IoEmployee.readFile("casestudy/src/data/employee.csv");
        Map<String,Employee>employeeMap=new HashMap<>();
        for (Employee employee:employeeArrayList){
            employeeMap.put(employee.getIdEmployee(),employee);

        }
        for (Map.Entry<String,Employee>employeeEntry:employeeMap.entrySet()){
            System.out.println(employeeEntry.getKey()+" "+employeeEntry.getValue().showInfor());
        }
    }

}
