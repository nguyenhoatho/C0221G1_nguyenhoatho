package models;

public class Vehicle {
    private String Manufacturer;
    private int licensePlate;
    private int yearOfManufacture;
    private String idOfOwner;
    private float length;
    private float width;

    public Vehicle(String manufacturer, int licensePlate, int yearOfManufacture, String idOfOwner, float length, float width) {
        this.Manufacturer = manufacturer;
        this.licensePlate = licensePlate;
        this.yearOfManufacture = yearOfManufacture;
        this.idOfOwner = idOfOwner;
        this.length = length;
        this.width = width;
    }

    public Vehicle() {
    }

    @Override
    public String toString() {
        return "Manufacturer='" + Manufacturer + '\'' +
                ", licensePlate=" + licensePlate +
                ", yearOfManufacture=" + yearOfManufacture +
                ", idOfOwner='" + idOfOwner + '\'' +
                ", length=" + length +
                ", width=" + width ;
    }
}
