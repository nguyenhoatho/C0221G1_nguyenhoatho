package models;

public abstract class Services {
    private String serviceName;
    private float areaUsed;
    private float rentalCosts;
    private int maximumPeople;
    private String typeServices;

    public Services() {
    }

    public Services(String serviceName, float areaUsed, float rentalCosts, int maximumPeople, String typeServices) {
        this.serviceName = serviceName;
        this.areaUsed = areaUsed;
        this.rentalCosts = rentalCosts;
        this.maximumPeople = maximumPeople;
        this.typeServices = typeServices;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public float getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(float areaUsed) {
        this.areaUsed = areaUsed;
    }

    public float getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(float rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(int maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public String getTypeServices() {
        return typeServices;
    }

    public void setTypeServices(String typeServices) {
        this.typeServices = typeServices;
    }

    public abstract String showInfor();
}