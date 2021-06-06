package model.bean;

public class Contract {
    private int contractID;
    private String contractStartDate;
    private String contractEndDate;
    private double contractDeposit;
    private Employee employee;
    private Customer customer;
    private Services services;

    public Contract() {
    }

    public Contract(int contractID, String contractStartDate, String contractEndDate, double contractDeposit, Employee employee, Customer customer, Services services) {
        this.contractID = contractID;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.employee = employee;
        this.customer = customer;
        this.services = services;
    }

    public Contract(String contractStartDate, String contractEndDate, double contractDeposit, Employee employee, Customer customer, Services services) {
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.employee = employee;
        this.customer = customer;
        this.services = services;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
}
