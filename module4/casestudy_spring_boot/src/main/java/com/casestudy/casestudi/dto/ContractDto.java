package com.casestudy.casestudi.dto;


import com.casestudy.casestudi.model.entity.Customer;
import com.casestudy.casestudi.model.entity.Employee;
import com.casestudy.casestudi.model.entity.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ContractDto implements Validator {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    public  int countDay(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
    public  int daysBetweens(String d1, String d2){
        Date date1 = null;
        Date date2 = null;
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(d1);
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(d2);
            cal1.setTime(date1);
            cal2.setTime(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return   countDay(cal1.getTime(),cal2.getTime());
    }
    public double totalMoney(){
        double total = daysBetweens(getContractStartDate(),getContractEndDate())* service.getServiceCost();
        return total;
    }
    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto=(ContractDto) target;
        int a =  daysBetweens(contractDto.getContractStartDate(),contractDto.getContractEndDate());
        if(a<=0){
            errors.rejectValue("contractStartDate","","Start date < End Date");
        }
    }
}
