package models;

public abstract class Service {
    private String id;
    private String name;
    private double area;
    private double rentPrice;
    private int maxPeople;
    private String typeForRent;

    public Service() {
    }

    public Service(String id, String name, double area, double rentPrice, int maxPeople, String typeForRent) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.rentPrice = rentPrice;
        this.maxPeople = maxPeople;
        this.typeForRent = typeForRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getTypeForRent() {
        return typeForRent;
    }

    public void setTypeForRent(String typeForRent) {
        this.typeForRent = typeForRent;
    }

    @Override
    public String toString() {
        return  id +","+ name +"," + area +","+ rentPrice +"," + maxPeople+"," + typeForRent ;
    }

    public abstract String showInfor();
}
