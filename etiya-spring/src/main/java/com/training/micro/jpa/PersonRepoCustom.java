package com.training.micro.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.micro.models.Person;

@Repository
public class PersonRepoCustom {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Transactional
    public void save2(final Person personParam) {
        EntityManager em = this.entityManagerFactory.createEntityManager();
        em.joinTransaction();
        em.persist(personParam);
    }

    public void save(final Person personParam) {
        EntityManager em = this.entityManagerFactory.createEntityManager();
        EntityTransaction transactionLoc = em.getTransaction();
        try {
            transactionLoc.begin();
            em.persist(personParam);
            personParam.setName("osman");
            personParam.setSurname("xyz");
            transactionLoc.commit();
        } catch (Exception eLoc) {
            transactionLoc.rollback();
        } finally {
            em.close();
        }
        em = this.entityManagerFactory.createEntityManager();
        try {
            transactionLoc.begin();
            Person mergeLoc = em.merge(personParam);
            mergeLoc.setName("osman");
            mergeLoc.setSurname("xyz");
            em.refresh(mergeLoc);
            em.remove(mergeLoc);
            transactionLoc.commit();
        } catch (Exception eLoc) {
            transactionLoc.rollback();
        } finally {
            em.close();
        }
    }

}
