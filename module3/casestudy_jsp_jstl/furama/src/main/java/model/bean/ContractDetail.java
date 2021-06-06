package model.bean;

public class ContractDetail {
    private int contractDetailID;
    private Contract contract;
    private AttachService attachService;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int contractDetailID, Contract contract, AttachService attachService, int quantity) {
        this.contractDetailID = contractDetailID;
        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public ContractDetail(Contract contract, AttachService attachService, int quantity) {
        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public int getContractDetailID() {
        return contractDetailID;
    }

    public void setContractDetailID(int contractDetailID) {
        this.contractDetailID = contractDetailID;
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
