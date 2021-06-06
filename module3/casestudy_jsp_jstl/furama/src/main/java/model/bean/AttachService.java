package model.bean;

public class AttachService {
    private int attachServiceID;
    private String attachServiceName;
    private Double attachServiceCost;
    private int attachServiceUnit;
    private String attachServiceStatus;

    public AttachService() {
    }

    public AttachService(int attachServiceID, String attachServiceName, Double attachServiceCost, int attachServiceUnit, String attachServiceStatus) {
        this.attachServiceID = attachServiceID;
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
    }

    public AttachService(String attachServiceName, Double attachServiceCost, int attachServiceUnit, String attachServiceStatus) {
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
    }

    public int getAttachServiceID() {
        return attachServiceID;
    }

    public void setAttachServiceID(int attachServiceID) {
        this.attachServiceID = attachServiceID;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public Double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(Double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public int getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(int attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }
}
