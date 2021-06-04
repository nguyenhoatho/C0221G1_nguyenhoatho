package model.bean;

public class Contract {
    private int contractID;
    private String contractStartDate;
    private String contractEndDate;
    private double contractDeposit;
    private int employeeID;
    private int customerID;
    private int serviceID;

    public Contract(int contractID, String contractStartDate, String contractEndDate, double contractDeposit, int employeeID, int customerID, int serviceID) {
        this.contractID = contractID;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.serviceID = serviceID;
    }

    public Contract() {
    }

    public Contract(String contractStartDate, String contractEndDate, double contractDeposit, int employeeID, int customerID, int serviceID) {
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.serviceID = serviceID;
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

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

}
