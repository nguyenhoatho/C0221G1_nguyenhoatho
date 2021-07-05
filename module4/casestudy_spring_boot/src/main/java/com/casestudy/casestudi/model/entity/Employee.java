package com.casestudy.casestudi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeName;
    private String employeeBirthday;
    private String employeeIdCard;
    private Double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private Integer flag;
    @ManyToOne
    @JoinColumn(name = "divisionId",referencedColumnName =  "divisionId")
    private Division division;
    @ManyToOne
    @JoinColumn(name ="positionId",referencedColumnName = "positionId")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "educationDegreeId",referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "userName",referencedColumnName = "userName")
    private User user;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    List<Contact> contactList;



}
