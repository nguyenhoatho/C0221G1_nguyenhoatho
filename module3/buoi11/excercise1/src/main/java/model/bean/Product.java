package model.bean;

public class Product {
    private int id;
    private String name;
    private String dateOfManufacture;
    private String expiryDate;
    private  String origin;

    public Product(int id, String name, String dateOfManufacture, String expiryDate, String origin) {
        this.id = id;
        this.name = name;
        this.dateOfManufacture = dateOfManufacture;
        this.expiryDate = expiryDate;
        this.origin = origin;
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

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
