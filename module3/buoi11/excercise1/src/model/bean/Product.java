package model.bean;

public class Product {
    private int id;
    private String name;
    private float price;
    private String description;
    private String manufacturers;

    public Product() {
    }

    public Product(int id, String name, float price, String productDescription, String manufacturers) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = productDescription;
        this.manufacturers = manufacturers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(String manufacturers) {
        this.manufacturers = manufacturers;
    }


}
