package de.java2enterprise.onlineshop.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import de.java2enterprise.onlineshop.ejb.RegisterBeanLocal;

@Named
@RequestScoped
public class RegisterController implements Serializable {    
    private static final long serialVersionUID = 1L;
    
    private String email;
    
    private String password;
    
    @EJB
    private RegisterBeanLocal registerBeanLocal;

    public String persist() {
        String msg = 
            registerBeanLocal.persist(email, password);
        FacesContext.getCurrentInstance().
            addMessage(null, new FacesMessage(msg));
        return "register";
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
}
