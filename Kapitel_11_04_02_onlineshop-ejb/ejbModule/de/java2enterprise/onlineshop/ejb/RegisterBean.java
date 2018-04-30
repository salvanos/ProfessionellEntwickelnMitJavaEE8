package de.java2enterprise.onlineshop.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.java2enterprise.onlineshop.model.Customer;

@Stateless
public class RegisterBean {

    @PersistenceContext
    private EntityManager em;

    public Customer find(Long id) {
        return em.find(Customer.class, id);
    }
}
