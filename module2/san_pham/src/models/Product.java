package models;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String nameOfProduct;
    private String manufacturer;
    private double price;
    private String other;

    public Product() {
    }

    public Product(String id, String nameOfProduct, String manufacturer, double price, String other) {
        this.id = id;
        this.nameOfProduct = nameOfProduct;
        this.manufacturer = manufacturer;
        this.price = price;
        this.other = other;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", other='" + other ;
    }
}
