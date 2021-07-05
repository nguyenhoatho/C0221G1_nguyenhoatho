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
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;
    private String contractStartDate;
    private String contractEndDate;
    private Double contractDeposit;
    private Integer flag;
    @ManyToOne
    @JoinColumn(name = "employeeId",referencedColumnName = "employeeId")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "serviceId",referencedColumnName = "serviceId")
    private Service service;
    @ManyToOne
    @JoinColumn(name = "customerId",referencedColumnName = "idCustomer")
    private Customer customer;
    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL)
    List<ContractDetail> contractDetailList;
}
