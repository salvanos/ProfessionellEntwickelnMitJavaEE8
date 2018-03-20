package de.java2enterprise.onlineshop;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.java2enterprise.onlineshop.model.Customer;

@Named
@SessionScoped
public class SigninController implements Serializable {
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;

    private String email;

    private String password;

    @Inject
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String find() {
        try {
            TypedQuery<Customer> query = em.createQuery(
                    "SELECT c FROM Customer c "
                            + "WHERE c.email= :email "
                            + "AND c.password= :password",
                    Customer.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            List<Customer> customers = query.getResultList();
            if(customers.isEmpty()) {
                FacesMessage m = new FacesMessage(
                        "Signing in was not successful!",
                        "Sorry, try again!");
                FacesContext
                        .getCurrentInstance()
                        .addMessage("signinForm", m);
            } else {
                customer = customers.get(0);
                FacesMessage m = new FacesMessage(
                        "Succesfully signed in!",
                        "You signed in under id " +
                                customer.getId());
                FacesContext
                        .getCurrentInstance()
                        .addMessage("signinForm", m);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    e.getMessage(),
                    e.getCause().getMessage());
            FacesContext
                    .getCurrentInstance()
                    .addMessage(
                            "signinForm",
                            fm);
        }
        return "/signin.jsf";
    }
}
