package example.example1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManagerProductManager {
    static ArrayList<Product> listProducts =new ArrayList<Product>();

    public static void menu(){
        System.out.println("Please choose the function");
        System.out.println("1.add"+"\n"+"2.edit"+"\n"+"3.delete by id"+"\n"+"4.display"+"\n"+"5 search by name"+"\n"+"6.sort by price");
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
                System.exit(0);

        }
    }

    private static void sortOfPrice() {
        Collections.sort(listProducts);
        Collections.sort(listProducts, new PriceComparatorOfProduct());
//        listProducts.sort(Comparator.comparing(Product::getPrice));
    }

    private static void searchOfName() {
        System.out.println("please input name search");
        String name=new Scanner(System.in).nextLine();
        for (Product product: listProducts){
            if (product.getName().equals(name)){
                System.out.println(product);
            }
        }
    }

    private static void deleteOfId() {
        System.out.println("please input id delete");
        int idOfDelete=new Scanner(System.in).nextInt();
        listProducts.removeIf(product -> product.getId() == idOfDelete);


    }

    private static void displayProduct() {
        for (Product array: listProducts){
            System.out.println(array);
        }
    }

    private static void editOfId() {
        System.out.println("please input Id can Search");
        int idInput=new Scanner(System.in).nextInt();
        for(Product product: listProducts){
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
        int id=Integer.parseInt(new Scanner(System.in).next());
        System.out.println("please input Name");
        String name=new Scanner(System.in).next();
        System.out.println("please  input Price");
        double price=Double.parseDouble(new Scanner(System.in).next());
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        listProducts.add(product);

    }

    public static void main(String[] args) {
       do {
           menu();
       }while (true);

    }
}
