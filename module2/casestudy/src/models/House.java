package models;

public class House extends Service {
    private String roomType;
    private String convenient;
    private int numberOfFloor;

    public House() {
    }

    public House(String id, String nameService, double areaUsed, double rentPrice, int maxNumberOfPeople
            , String typeRent, String roomType, String convenientDescription, int numberOfFloors) {
        super(id, nameService, areaUsed, rentPrice, maxNumberOfPeople, typeRent);
        this.roomType = roomType;
        this.convenient = convenientDescription;
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

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return  super.toString()+","+roomType +","+ convenient + "," + numberOfFloor ;
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
                "\t Number Of Floor: " + this.getNumberOfFloor()
                ;
    }
}
