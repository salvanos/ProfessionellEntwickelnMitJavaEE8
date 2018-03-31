package de.java2enterprise.onlineshop;

import javax.jws.WebService;

@WebService
public class Register {
    
    public String persist(
        String email, 
        String password) {
        
        //TODO: Persist Customer
        return "Registrierung von " +
                email + "/" + password;
    }
}
