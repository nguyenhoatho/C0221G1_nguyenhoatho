package io;

import models.Product;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeFileFactory {
    public static boolean saveFile(ArrayList<Product> productArrayList , String path){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(path);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productArrayList);
            objectOutputStream.close();
            fileOutputStream.close();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();

        }
        return  false;

    }
    public static ArrayList<Product>readFile(String path){
        ArrayList<Product>productArrayList=new ArrayList<Product>();
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            Object data=objectInputStream.readObject();
            productArrayList = (ArrayList<Product>) data;
            objectInputStream.close();
            fileInputStream.close();

        }catch (Exception exception){
            exception.printStackTrace();
        }
        return productArrayList;
    }

}
