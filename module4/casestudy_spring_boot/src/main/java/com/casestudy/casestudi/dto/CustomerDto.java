package com.casestudy.casestudi.dto;



import com.casestudy.casestudi.model.entity.CustomerType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class CustomerDto {
    @NotBlank(message = "Your ID is Empty")
    @Pattern(regexp = "^KH-[0-9]{4}$",message = "ID must be in the format KH-XXXX(X is number 0-9)")
    private String customerId;
    private CustomerType customerType;
    @NotBlank(message = "Your Name is Empty")
    private String customerName;
    @NotBlank(message = "Your Birthday is Empty")
    @Pattern(regexp = "^[0-2][0-9][0-9][0-9][/-][0-3][0-9][/-][0-3][0-9]$",message = "Wrong birthday forrmat")
    private String customerBirthday;
    private boolean customerGender;
    @NotBlank(message = "Yoour ID Card is Empty")
    @Pattern(regexp = "^([0-9]{9})|([0-9]{12})$")
    private String customerIdCard;
    @NotBlank(message = "Your Phone is Empty")
    @Pattern(regexp = "^(09[0-1][0-9]{7})|(\\(84\\)\\+9[01][0-9]{7})$",message = "Phone must be 090xxxxxxx | 091xxxxxxx | (84)+90xxxxxxx | (84)+91xxxxxxx")
    private String customerPhone;
    @NotBlank(message = "Your Email is Empty")
    @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",message = "Email wrong Format")
    private String customerEmail;
    @NotBlank(message = "Your Address is Empty")
    private String customerAddress;

    public CustomerDto() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
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

    public boolean isCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
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
