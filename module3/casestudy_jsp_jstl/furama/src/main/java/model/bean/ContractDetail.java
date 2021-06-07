package model.bean;

public class ContractDetail {
    private int contractDetailID;
    private Contract contract;
    private String attachServiceID;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int contractDetailID, Contract contract, String attachServiceID, int quantity) {
        this.contractDetailID = contractDetailID;
        this.contract = contract;
        this.attachServiceID = attachServiceID;
        this.quantity = quantity;
    }

    public ContractDetail(Contract contract, String attachServiceID, int quantity) {
        this.contract = contract;
        this.attachServiceID = attachServiceID;
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

    public String getAttachServiceID() {
        return attachServiceID;
    }

    public void setAttachServiceID(String attachServiceID) {
        this.attachServiceID = attachServiceID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
