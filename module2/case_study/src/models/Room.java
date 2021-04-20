package models;

public class Room extends Services {
    private int freeOfServices;

    public Room() {
    }

    public Room(int numberRoom) {
        this.freeOfServices = numberRoom;
    }

    public Room(String serviceName, float areaUsed, float rentalCosts, int maximumPeople, String typeServices, int freeOfServices) {
        super(serviceName, areaUsed, rentalCosts, maximumPeople, typeServices);
        this.freeOfServices = freeOfServices;
    }

    public int getNumberRoom() {
        return freeOfServices;
    }

    public void setNumberRoom(int numberRoom) {
        this.freeOfServices = numberRoom;
    }

    @Override
    public String showInfor() {
        return "name service"+"\t"+super.getServiceName()+"\n"
                +"area user"+"\t"+super.getAreaUsed()
                +"rental costs"+"\t"+super.getRentalCosts()
                +"maximum people"+"\t"+super.getMaximumPeople()
                +"type services"+"\t"+super.getTypeServices()
                +"number of room"+"\t"+ freeOfServices;

    }
}
