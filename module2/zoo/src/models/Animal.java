package models;

import java.util.Scanner;

public abstract class Animal {
    private String name;
    private int age;
    private String description;

    public abstract void display();

    public void  input(){
        Scanner sc=new Scanner(System.in);


    }

    public abstract void showSound();


    public int getAge() {
        return age;
    }

    public Animal(String name, int age,String description) {
        this.name = name;
        this.age = age;
        this.description = description;
    }

    public Animal() {
    }

}
