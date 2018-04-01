package de.java2enterprise.onlineshop.model;

public class Customer {
    private String email;

    private String password;
    
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return email + "-" + password;
    }
}
