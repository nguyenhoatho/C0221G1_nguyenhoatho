package models;

public class Villa extends Services{
    private String standardRoom;
    private String convenient;
    private double arePool;
    private int numberOfFloor;

    public Villa() {
    }

    @Override
    public String showInfo() {
        return "name service"+"\t"+super.getServiceName()+"\n"
                +"area user"+"\t"+super.getAreaUsed()+"\n"
                +"rental costs"+"\t"+super.getRentalCosts()+"\n"
                +"maximum people"+"\t"+super.getMaximumPeople()+"\n"
                +"type services"+"\t"+super.getTypeServices()+"\n"
                +"standard room"+"\t"+standardRoom+"\n"
                +"convenient"+"\t"+convenient+"\n"
                +"area pool"+"\t"+arePool+"\n"
                +"number floor"+"\t"+numberOfFloor;
    }



    public Villa(String standardRoom, String convennient, double arePool, int numberOfFloor) {
        this.standardRoom = standardRoom;
        this.convenient = convennient;
        this.arePool = arePool;
        this.numberOfFloor = numberOfFloor;
    }

    public Villa(String serviceName, float areaUsed, float rentalCosts, int maximumPeople, String typeServices, String standardRoom, String convenient, double arePool, int numberOfFloor) {
        super(serviceName, areaUsed, rentalCosts, maximumPeople, typeServices);
        this.standardRoom = standardRoom;
        this.convenient = convenient;
        this.arePool = arePool;
        this.numberOfFloor = numberOfFloor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getConvennient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public double getArePool() {
        return arePool;
    }

    public void setArePool(double arePool) {
        this.arePool = arePool;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }
}