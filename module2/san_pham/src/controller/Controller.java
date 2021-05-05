package controller;

import io.SerializeFileFactory;
import models.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    static ArrayList<Product>productArrayList=new ArrayList<Product>();
    public static void menu(){
        System.out.println("1.add"+"\n"+
                "2.luu file"+"\n"+"3.read file"+"\n"+"4.search"+"\n"+"6.exit");
        int choose=new Scanner(System.in).nextInt();
        switch (choose){
            case 1:
                addProduct();
                break;
            case 2:
                saveFile();
                break;
            case 3:
                readFile();
                display();
                break;
            case 4:
                search();
                break;
            case 5:
                display();
                break;
            case 6:
                exit();
                break;

        }
    }

    private static void search() {
        String idSearch=new Scanner(System.in).nextLine();
        for (Product product :productArrayList )
        {
            if (product.getId().equals(idSearch))
            {
                System.out.println(product);
            }
        }

    }

    private static void display() {
        for (Product list:productArrayList){
            System.out.println(list);
        }
    }

    private static void readFile() {
        productArrayList=SerializeFileFactory.readFile("san_pham/src/data/listproduct.csv");

    }

    private static void exit() {
        System.exit(0);
    }

    private static void saveFile() {
        boolean check= SerializeFileFactory.saveFile(productArrayList,"san_pham/src/data/listproduct.csv");
        if (check){
            System.out.println("luu file thanh cong");
        }
        else {
            System.out.println("luu file that bai");
        }

    }

    private static void addProduct() {
        Product product = new Product();
        System.out.println("input id product");
        product.setId(new Scanner(System.in).next());
        System.out.println("input name product ");
        product.setNameOfProduct(new Scanner(System.in).next());
        System.out.println("input manufacturer");
        product.setManufacturer(new Scanner(System.in).next());
        System.out.println("input price");
        product.setPrice(new Scanner(System.in).nextDouble());
        System.out.println("input other");
        product.setOther(new Scanner(System.in).next());
        productArrayList.add(product);


    }


}
