package com.aconex.cost.contract.repositories;

import com.aconex.cost.contract.models.Contract;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ContractRepository {

    private final SessionFactory sessionFactory;

    public ContractRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Contract> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Contract.class).addOrder(Order.asc("code")).list();
    }

    public Contract getContract(long id) {
        return (Contract) sessionFactory.getCurrentSession().get(Contract.class, id);
    }

    public List<Contract> findContractByCode(String code) {
        return sessionFactory.getCurrentSession().createCriteria(Contract.class).add(Restrictions.eq("code", code)).list();
    }

    public Contract saveOrUpdate(Contract contract) {
        long contractId;
        if(contract.getId() != null) {
            sessionFactory.getCurrentSession().update(contract);
            contractId = contract.getId();
        } else {
            contractId = (long) sessionFactory.getCurrentSession().save(contract);
        }
        return  getContract(contractId);
    }

    public void deleteContract(long id) {
        sessionFactory.getCurrentSession().delete(getContract(id));
    }
}
