package com.aconex.cost.contract.services;

import com.aconex.cost.contract.models.Contract;
import com.aconex.cost.contract.repositories.ContractRepository;

import java.util.List;

public class ContractService {

    private final ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    public Contract getContract(long id) {
        return contractRepository.getContract(id);
    }

    public List<Contract> findContractByCode(String code) {
        return contractRepository.findContractByCode(code);
    }

    public Contract saveOrUpdate(Contract contract) throws Exception {
        return contractRepository.saveOrUpdate(contract);
    }

    public boolean deleteContract(long id) throws Exception {
        return contractRepository.deleteContract(id);
    }
}
