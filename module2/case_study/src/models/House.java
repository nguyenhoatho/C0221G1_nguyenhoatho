package models;

public class House extends Services  {
    private String standardRoom;
    private String convenient;
    private int numberOfFloor;

    public House() {
    }

    public House(String standardRoom, String convenient, int numberOfFloor) {
        this.standardRoom = standardRoom;
        this.convenient = convenient;
        this.numberOfFloor = numberOfFloor;
    }

    public House(String serviceName, float areaUsed, float rentalCosts, int maximumPeople, String typeServices, String standardRoom, String convenient, int numberOfFloor) {
        super(serviceName, areaUsed, rentalCosts, maximumPeople, typeServices);
        this.standardRoom = standardRoom;
        this.convenient = convenient;
        this.numberOfFloor = numberOfFloor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getConvenient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String showInfor() {
       return  "name service"+"\t"+super.getServiceName()+"\n"
                +"area user"+"\t"+super.getAreaUsed()
                +"rental costs"+"\t"+super.getRentalCosts()
                +"maximum people"+"\t"+super.getMaximumPeople()
                +"type services"+"\t"+super.getTypeServices()
                +"standard room"+"\t"+standardRoom
                +"convenient"+"\t"+convenient
                +"number floor"+"\t"+numberOfFloor;


    }
}
