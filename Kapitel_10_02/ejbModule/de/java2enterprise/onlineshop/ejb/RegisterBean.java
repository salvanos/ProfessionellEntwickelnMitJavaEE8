package de.java2enterprise.onlineshop.ejb;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class RegisterBean
 */
@Stateless
public class RegisterBean implements RegisterBeanRemote {

    @Override
    public String persist(
        String email, 
        String password) {
        
        return email + ":" +password;
    }
}
