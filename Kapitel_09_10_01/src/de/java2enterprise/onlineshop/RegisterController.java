package de.java2enterprise.onlineshop;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import de.java2enterprise.onlineshop.model.Customer;

@Named
@RequestScoped
public class RegisterController implements Serializable {
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    @Inject
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String persist() {
        try {
            ut.begin();
            em.persist(customer);
            ut.commit();
            FacesMessage m = new FacesMessage(
                    "Succesfully registered!",
                    "You are a new user!");
            FacesContext
                    .getCurrentInstance()
                    .addMessage("registerForm", m);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    e.getMessage(),
                    e.getCause().getMessage());
            FacesContext
                    .getCurrentInstance()
                    .addMessage(
                            "registerForm",
                            fm);
        }
        return "/register.jsf";
    }
}
