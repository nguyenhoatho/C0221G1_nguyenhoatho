package controllers;

import io.IoCustomer;
import models.Customer;

import java.util.*;

public class CustomerController {
    static private ArrayList<Customer> customerArrayList = new ArrayList<>();

    public static void addNewCustomer() {
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("input id");
        String id = scanner.nextLine();
        customer.setId(id);
        System.out.println("input name");
        String name = scanner.nextLine();
        customer.setName(name);
        System.out.println("input birthday");
        String birthday = scanner.nextLine();
        customer.setBirthday(birthday);
        System.out.println("input gender");
        String gender = scanner.nextLine();
        customer.setGender(gender);
        System.out.println("input id card");
        String idCard = scanner.nextLine();
        customer.setIdCard(idCard);
        System.out.println("input phone");
        String phone = scanner.nextLine();
        customer.setPhone(phone);
        System.out.println("input email");
        String email = scanner.nextLine();
        customer.setEmail(email);
        System.out.println("customer type");
        String customerType = scanner.nextLine();
        customer.setCustomerType(customerType);
        System.out.println("input address");
        String address = scanner.nextLine();
        customer.setAddress(address);
        System.out.println("input use Service");
        String useService = scanner.nextLine();
        customer.setUseService(useService);
        customerArrayList.add(customer);
        IoCustomer.saveFile(customerArrayList, "casestudy/src/data/customer.csv");
    }

    public static void showAllCustomer() {
        customerArrayList = IoCustomer.readFile("casestudy/src/data/customer.csv");
        Collections.sort(customerArrayList);
        Customer customer = null;
        for (int i = 0; i < customerArrayList.size(); i++) {
            customer = customerArrayList.get(i);
            System.out.println((i + 1) + ".");
            customer.showInfor();
        }
    }

    public static void showQueueCustomer() {
        customerArrayList = IoCustomer.readFile("casestudy/src/data/customer.csv");
        Queue<Customer> customerQueue = new LinkedList<>();
        for (Customer customer : customerArrayList) {
            customerQueue.add(customer);
        }
        Customer customer = null;
        while (!customerQueue.isEmpty()) {
            customer = customerQueue.poll();
            System.out.println(customer.showInfor());

        }

    }
}
