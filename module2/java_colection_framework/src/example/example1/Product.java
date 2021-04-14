package example.example1;

public class Product {
    private int id;
    private String name;
    private double price;


    public Product(int id, String name,double price) {
        this.id = id;
        this.name = name;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id+"\t"+this.name+"\t"+this.price;
    }



}
