package model.bean;

public class CustomerType {
    private int customerTypeID;
    private String customerTypeName;

    public CustomerType() {
    }

    public CustomerType(int customerTypeID, String customerTypeName) {
        this.customerTypeID = customerTypeID;
        this.customerTypeName = customerTypeName;
    }

    public CustomerType(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public int getCustomerTypeID() {
        return customerTypeID;
    }

    public void setCustomerTypeID(int customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
