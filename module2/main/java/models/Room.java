package models;

public class Room extends Services {
    private int freeOfServices;

    public Room() {
    }

    @Override
    public String showInfo() {
        return null;
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

}
