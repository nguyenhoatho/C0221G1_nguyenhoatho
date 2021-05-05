package models;

public class Villa extends Service {

    private String roomType;
    private String convenient;
    private double areaPool;
    private int numberOfFloor;

    public Villa() {
    }

    public Villa(String id, String nameService, double areaUsed, double rentPrice, int maxNumberOfPeople
            , String typeRent, String roomType, String convenientDescription, double areaPool, int numberOfFloors) {
        super(id, nameService, areaUsed, rentPrice, maxNumberOfPeople, typeRent);
        this.roomType = roomType;
        this.convenient = convenientDescription;
        this.areaPool = areaPool;
        this.numberOfFloor = numberOfFloors;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getConvenient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return  super.toString()+ roomType + ","+ convenient +","+  areaPool+"," + numberOfFloor ;
    }

    @Override
    public String showInfor() {
        return " Id Service: " + super.getId() +
                "\t Name Service: " + super.getName() +
                "\t Area: " + super.getArea() +
                "\t Rent Price: " + super.getRentPrice() +
                "\t Type For Rent: " + super.getTypeForRent() +
                "\t Max People: " + super.getMaxPeople() +
                "\t RoomType: " + this.getRoomType() +
                "\t Convenient: " + this.getConvenient() +
                "\t Area Pool: " + this.getAreaPool() +
                "\t Number Of Floor: " + this.getNumberOfFloor()
                ;
    }
}
