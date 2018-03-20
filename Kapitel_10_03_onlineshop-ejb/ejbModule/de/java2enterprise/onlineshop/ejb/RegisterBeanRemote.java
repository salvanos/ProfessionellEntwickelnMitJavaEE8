package de.java2enterprise.onlineshop.ejb;

import java.io.Serializable;

import javax.ejb.Remote;

@Remote
public interface RegisterBeanRemote extends Serializable {
    
    public abstract String persist(
            String email, 
            String password);

}
