package de.java2enterprise.onlineshop.model;

public class Customer {

    private Long id;

    private String email;

    private String password;
    
    private int amountOfPurchasedItems;

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

    public int getAmountOfPurchasedItems() {
        return amountOfPurchasedItems;
    }

    public void setAmountOfPurchasedItems(
            int amountOfPurchasedItems) {
        this.amountOfPurchasedItems = amountOfPurchasedItems;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", email=" + email
                + ", password=" + password + "]";
    }
}
