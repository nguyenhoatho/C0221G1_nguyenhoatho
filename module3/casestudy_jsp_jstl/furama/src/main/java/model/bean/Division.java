package model.bean;

public class Division {
    private int divisionID;
    private String divisionName;

    public Division() {
    }

    public Division(int divisionID, String divisionName) {
        this.divisionID = divisionID;
        this.divisionName = divisionName;
    }

    public Division(String divisionName) {
        this.divisionName = divisionName;
    }

    public int getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}
