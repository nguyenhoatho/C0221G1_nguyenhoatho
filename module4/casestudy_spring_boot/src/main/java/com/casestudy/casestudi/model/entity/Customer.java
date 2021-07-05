package com.casestudy.casestudi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCustomer;
    private String  nameCustomer;
    private String dateOfBirth;
    private Integer gender;
    private String customerIDCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    private Integer flag;
    @ManyToOne
    @JoinColumn(name = "customerTypeId", referencedColumnName = "customerTypeId")
    private CustomerType customerType;
    @OneToMany(mappedBy = "customer",cascade =  CascadeType.ALL)
    List<Contact> contactList;

}
