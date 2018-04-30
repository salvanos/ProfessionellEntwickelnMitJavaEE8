package de.java2enterprise.onlineshop.ejb;

import java.io.Serializable;

import javax.ejb.Local;

@Local
public interface RegisterBeanLocal extends Serializable {
    String persist(
        String email, 
        String password);
}
