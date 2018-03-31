package de.java2enterprise.onlineshop.model;

public class Customer {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String email;

    private String password;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Customer [id=" + id + ", email=" + email
                + ", password=" + password + "]";
    }
}
