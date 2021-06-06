package model.bean;

public class ServiceType {
    private int serviceTypeID;
    private String serviceTypeName;

    public ServiceType(int serviceTypeID, String serviceTypeName) {
        this.serviceTypeID = serviceTypeID;
        this.serviceTypeName = serviceTypeName;
    }

    public ServiceType() {
    }

    public ServiceType(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public int getServiceTypeID() {
        return serviceTypeID;
    }

    public void setServiceTypeID(int serviceTypeID) {
        this.serviceTypeID = serviceTypeID;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }
}
