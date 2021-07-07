package com.casestudy.casestudi.model.entity.contract;

import javax.persistence.*;

@Entity

@Table(name = "contract_detail")
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private int contractDetailId;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_service_id", referencedColumnName = "attach_service_id")
    private AttachService attachService;

    @Column(name = "quantity")
    private int quantity;

    public ContractDetail() {
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
