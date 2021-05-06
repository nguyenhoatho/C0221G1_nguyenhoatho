package models;

public class Room extends Service {
    private String freeService;

    public Room() {
    }

    public Room(String id, String nameService, double areaUse, double rentPrice, int maxNumberOfPeople, String typeRent
            , String freeService) {
        super(id, nameService, areaUse, rentPrice, maxNumberOfPeople, typeRent);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return super.toString()+","+freeService;
    }

    @Override
    public String showInfor() {
         return " Id Service: " + super.getId() +
                "\t Name Service: " + super.getName() +
                "\t Area: " + super.getArea() +
                "\t Rent Price: " + super.getRentPrice() +
                "\t Type For Rent: " + super.getTypeForRent() +
                "\t Max People: " + super.getMaxPeople() +
                "\t Free Service: " + this.getFreeService()
                ;
    }
}
