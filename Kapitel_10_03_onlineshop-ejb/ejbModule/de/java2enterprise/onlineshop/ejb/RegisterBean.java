package de.java2enterprise.onlineshop.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.java2enterprise.onlineshop.model.Customer;

@Stateless
public class RegisterBean 
        implements 
        RegisterBeanRemote, 
        RegisterBeanLocal {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public String persist(String email, String password) {
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);
        em.persist(customer);
        return email + " persisted";
    }
}

