package com.cdk.dao;

import com.cdk.model.Bank;
import com.cdk.model.Branch;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class BranchDaoHibernate {

    public Branch getBranchDetails(int branchId) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("mysql");
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Branch branch = entityManager.find(Branch.class, branchId);
        transaction.commit();
        return branch;
    }
}
