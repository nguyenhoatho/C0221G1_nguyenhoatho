package models;

import io.IoEmployee;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Cabinet {
    private static Stack<Employee> employeeStack=new Stack<>();
    static {
        Map<String ,Employee> employeeMap= (Map<String, Employee>) IoEmployee.readFile("casestudy/src/data/employee.csv");
        for(Map.Entry<String,Employee>employeeEntry:employeeMap.entrySet()){
            employeeStack.push(employeeEntry.getValue());
        }
    }
    public static Employee getFileOfEmployee(String id){
        Employee employee=null;
        while(!employeeStack.isEmpty()){
            employee=employeeStack.pop();
            if(employee.getIdEmployee().equals(id)){
                return employee;
            }

        }
        return employee;
    }
    public static void searchId(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("input id search ");
        String id=scanner.nextLine();
        Employee employee= getFileOfEmployee(id);
        if (employee!=null){
            System.out.println("file tim được"+employee.toString());
        }else{
            System.out.println("file not found");
        }
    }
    }

