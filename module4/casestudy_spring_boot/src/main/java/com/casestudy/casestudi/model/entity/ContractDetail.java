package com.casestudy.casestudi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractDetailId;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "contractId",referencedColumnName = "contractId")
    private Contact contact;
    @ManyToOne
    @JoinColumn(name = "attachServiceId",referencedColumnName = "attachServiceId")
    private AttachService attachService;
}
