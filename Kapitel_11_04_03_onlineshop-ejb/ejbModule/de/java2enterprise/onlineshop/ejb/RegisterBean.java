package de.java2enterprise.onlineshop.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.java2enterprise.onlineshop.model.Customer;

@Stateless
public class RegisterBean {

    @PersistenceContext
    private EntityManager em;

    public Customer persist(String email, String password) {
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);
        em.persist(customer);
        return customer;
    }

    public Customer find(Long id) {
        return em.find(Customer.class, id);
    }
}
