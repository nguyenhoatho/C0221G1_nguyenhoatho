package com.casestudy.casestudi.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private Integer contractDetailId;

    @ManyToOne
    @JoinColumn(name = "attach_service_id",nullable = false)
    private Attach_Service attach_service;

    @ManyToOne
    @JoinColumn(name = "contract_id",nullable = false)
    private Contract contract;

    @Column(name = "quantity")
    private int quantity;

    public ContractDetail() {
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Attach_Service getAttach_service() {
        return attach_service;
    }

    public void setAttach_service(Attach_Service attach_service) {
        this.attach_service = attach_service;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
