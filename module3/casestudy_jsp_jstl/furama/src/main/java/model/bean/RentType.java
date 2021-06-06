package model.bean;

public class RentType {
    private int rentTypeID;
    private String rentTypeName;
    private double rentTypeCost;

    public RentType() {
    }

    public RentType(int rentTypeID, String rentTypeName, double rentTypeCost) {
        this.rentTypeID = rentTypeID;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
    }

    public RentType(String rentTypeName, double rentTypeCost) {
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
    }

    public int getRentTypeID() {
        return rentTypeID;
    }

    public void setRentTypeID(int rentTypeID) {
        this.rentTypeID = rentTypeID;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }
}
