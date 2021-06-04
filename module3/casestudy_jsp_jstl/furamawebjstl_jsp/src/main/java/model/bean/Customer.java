package model.bean;

public class Customer {
    private int customerID;
    private int customerTypeID;
    private String customerName;
    private String customerBirthday;
    private String customerGender;
    private String customerIDCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;

    public Customer() {
    }

    public Customer(int customerTypeID, String customerName, String customerBirthday, String customerGender, String customerIDCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerTypeID = customerTypeID;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIDCard = customerIDCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public Customer(int customerID, int customerTypeID, String customerName, String customerBirthday, String customerGender, String customerIDCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerID = customerID;
        this.customerTypeID = customerTypeID;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIDCard = customerIDCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCustomerTypeID() {
        return customerTypeID;
    }

    public void setCustomerTypeID(int customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIDCard() {
        return customerIDCard;
    }

    public void setCustomerIDCard(String customerIDCard) {
        this.customerIDCard = customerIDCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }


}
