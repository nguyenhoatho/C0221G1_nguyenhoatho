package model.bean;

public class CustomerUsingService {
    private String customerID;
    private String customerName;
    private int contractID;
    private String contractStartDate;
    private String contractEndDate;
    private String serviceName;
    private String attachServiceID;
    private String attachServiceName;
    private int quantity;

    public CustomerUsingService() {
    }

    public CustomerUsingService(String customerID, String customerName, int contractID, String contractStartDate, String contractEndDate, String serviceName, String attachServiceID, String attachServiceName, int quantity) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.contractID = contractID;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.serviceName = serviceName;
        this.attachServiceID = attachServiceID;
        this.attachServiceName = attachServiceName;
        this.quantity = quantity;
    }

    public CustomerUsingService(int contractID, String attachServiceID, String attachServiceName, int quantity) {
        this.contractID = contractID;
        this.attachServiceID = attachServiceID;
        this.attachServiceName = attachServiceName;
        this.quantity = quantity;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAttachServiceID() {
        return attachServiceID;
    }

    public void setAttachServiceID(String attachServiceID) {
        this.attachServiceID = attachServiceID;
    }
}
