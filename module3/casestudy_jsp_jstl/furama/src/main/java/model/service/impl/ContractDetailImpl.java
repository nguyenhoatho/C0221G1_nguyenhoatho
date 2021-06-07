package model.service.impl;

import model.bean.ContractDetail;
import model.repository.contract_detail.ContractDetailRepository;
import model.service.IContractDetail;

public class ContractDetailImpl implements IContractDetail {
    ContractDetailRepository contractDetailRepository = new ContractDetailRepository();
    @Override
    public boolean createContractDetail(ContractDetail contractDetail) {
        return contractDetailRepository.createContractDetail(contractDetail);
    }
}
