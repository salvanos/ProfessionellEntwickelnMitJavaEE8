package de.java2enterprise.onlineshop.model;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class Customer {

    private Long id;

    @JsonbProperty("user")
    private String email;

    private String password;

    @JsonbTransient
    private int numberOfPurchasedItems;

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

    public int getNumberOfPurchasedItems() {
        return numberOfPurchasedItems;
    }

    public void setNumberOfPurchasedItems(
            int numberOfPurchasedItems) {
        this.numberOfPurchasedItems = numberOfPurchasedItems;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", email=" + email
                + ", password=" + password
                + ", numberOfPurchasedItems="
                + numberOfPurchasedItems + "]";
    }
}
