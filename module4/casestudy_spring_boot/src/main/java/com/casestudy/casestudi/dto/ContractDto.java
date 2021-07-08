package com.casestudy.casestudi.dto;



import com.casestudy.casestudi.model.entity.Customer;
import com.casestudy.casestudi.model.entity.Employee;
import com.casestudy.casestudi.model.entity.Service;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class ContractDto {
    private Integer contractId;
    @NotBlank(message = "Contract Start Date is Empty")
    @Pattern(regexp = "^[0-2][0-9][0-9][0-9][/-][0-3][0-9][/-][0-3][0-9]$",message = "Wrong date forrmat")
    private String contractStartDate;
    @Pattern(regexp = "^[0-2][0-9][0-9][0-9][/-][0-3][0-9][/-][0-3][0-9]$",message = "Wrong date forrmat")
    @NotBlank(message = "Contract End Date is Empty")
    private String contractEndDate;
    @NotNull(message = "Contract Deposit is Empty")
    @Min(value = 0,message = "Contract deposit >=0")
    private double contractDeposit;
    private Employee employee;
    private Customer customer;
    private Service service;

    public ContractDto() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
