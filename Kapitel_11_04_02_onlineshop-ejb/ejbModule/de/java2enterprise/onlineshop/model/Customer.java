package de.java2enterprise.onlineshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="ONLINESHOP", name="CUSTOMER")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(
            name="CUSTOMER_ID_GENERATOR", 
            sequenceName="SEQ_CUSTOMER",
            schema="ONLINESHOP",
            allocationSize=1,
            initialValue=1)
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE, 
            generator="CUSTOMER_ID_GENERATOR")
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
}
