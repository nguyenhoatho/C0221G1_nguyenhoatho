package model.service.contract_detail.impl;

import model.bean.ContractDetail;
import model.repository.contract_detail.ContractDetailRepo;
import model.service.contract_detail.IContractDetail;

public class ContractDetailImpl implements IContractDetail {
    ContractDetailRepo contractDetailRepository = new ContractDetailRepo();
    @Override
    public boolean createContractDetail(ContractDetail contractDetail) {
        return contractDetailRepository.createContractDetail(contractDetail);
    }
}
