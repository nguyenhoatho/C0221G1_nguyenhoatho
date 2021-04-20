package io;

import model.Product;

import java.io.*;
import java.util.ArrayList;

public class SerializeFileFactory {
    public static boolean saveFile(ArrayList<Product>listProducts,String path) {
        try {
            FileOutputStream fos=new FileOutputStream(path);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.close();
            fos.close();
            return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public static ArrayList<Product> readFile(String path)
    {
        ArrayList<Product>listProduct=new ArrayList<>();

        try {
            FileInputStream fis=new FileInputStream(path);
            ObjectInputStream ois=new ObjectInputStream(fis);

            ois.close();
            fis.close();


        }catch (Exception ex){
            ex.printStackTrace();
        }
        return listProduct;
    }
}
