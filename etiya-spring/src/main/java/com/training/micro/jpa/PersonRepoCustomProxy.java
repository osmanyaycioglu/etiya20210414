package com.training.micro.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import com.training.micro.models.Person;

public class PersonRepoCustomProxy extends PersonRepoCustom {

    private PersonRepoCustom     prc;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void save2(final Person personParam) {
        EntityManager em = this.entityManagerFactory.createEntityManager();
        EntityTransaction transactionLoc = em.getTransaction();
        try {
            transactionLoc.begin();
            this.prc.save2(personParam);
            transactionLoc.commit();
        } catch (Exception eLoc) {
            transactionLoc.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void save(final Person personParam) {
    }
}
