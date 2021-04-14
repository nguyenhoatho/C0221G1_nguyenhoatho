package example.example1;

import java.util.ArrayList;
import java.util.Scanner;

public class Practice {
    static ArrayList<Product> products=new ArrayList<Product>();

    public static void menu(){
        System.out.println("Please choose the function");
        String choose=new Scanner(System.in).nextLine();


        switch (Integer.parseInt(choose)){
            case 1:
                addProduct();
                break;
            case 2:
                editOfId();
                break;
            case 3:
                deleteOfId();
                break;
            case 4:
                displayProduct();
                break;
            case 5:
                searchOfName();
                break;
            case 6:
                sortOfPrice();
                break;
            default:
                break;

        }
    }

    private static void sortOfPrice() {
    }

    private static void searchOfName() {
        System.out.println("please input name search");
        String name=new Scanner(System.in).nextLine();
        for (Product product:products){
            if (product.getName().equals(name)){
                System.out.println(product);
            }
        }
    }

    private static void deleteOfId() {
        System.out.println("please input id delete");
        int idOfDelete=new Scanner(System.in).nextInt();
        products.removeIf(product -> product.getId() == idOfDelete);


    }

    private static void displayProduct() {
        for (Product array:products){
            System.out.println(array);
        }
    }

    private static void editOfId() {
        System.out.println("please input Id can Search");
        int idInput=new Scanner(System.in).nextInt();
        for(Product product:products){
            boolean condition = product.getId() == idInput;
            if(condition){
                System.out.println("please input Id");
                int idEdit=new Scanner(System.in).nextInt();
                product.setId(idEdit);
                System.out.println("please input Name");
                String nameEdit=new Scanner(System.in).nextLine();
                product.setName(nameEdit);
                System.out.println("please  input Price");
                double priceEdit=new Scanner(System.in).nextDouble();
                product.setPrice(priceEdit);
            }
            }
            }
    private static void addProduct() {
        Product product =new Product();
        System.out.println("please input Id");
        int id=new Scanner(System.in).nextInt();
        System.out.println("please input Name");
        String name=new Scanner(System.in).next();
        System.out.println("please  input Price");
        double price=new Scanner(System.in).nextDouble();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        products.add(product);

    }

    public static void main(String[] args) {
        while (true) {
            menu();
        }

    }
}
