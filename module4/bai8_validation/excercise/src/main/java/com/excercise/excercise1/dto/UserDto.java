package com.excercise.excercise1.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import java.io.IOException;
import java.util.Date;

public class UserDto implements Validator {

    private Integer id;
    @NotBlank(message = "ten khong duoc de trong")
    @Size(min=5 , max= 45, message = "thấp nhất 5 kí tự, tối đa 45 kí tự,và không đc trống")
    private String firstName;
    @NotBlank(message = "ten khong duoc de trong")
    @Size(min=5 , max= 45, message = "thấp nhất 5 kí tự, tối đa 45 kí tự,và không đc trống")
    private String lastName;
    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp = "^0[0-9]{9}$",message = "Số điện thoại bắt đầu từ số 0 giới hạn 10 số,và không đc trống")
    private Integer phoneNumber;
    @NotBlank(message = "khong duoc de trong")
    private Date yearOfBirth;
    @Min(value = 18,message = "Số tuổi phải lớn hơn hoặc bằng 18, và không đc trống")
    private Integer age;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDto(Integer id, String firstName, String lastName, Integer phoneNumber, Date yearOfBirth, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.yearOfBirth = yearOfBirth;
        this.age = age;
        this.email=email;
    }

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Date yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

