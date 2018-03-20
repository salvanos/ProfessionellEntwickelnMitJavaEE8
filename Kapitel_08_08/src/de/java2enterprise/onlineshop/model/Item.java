package de.java2enterprise.onlineshop.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="ONLINESHOP", name="ITEM")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String title;
    private String description;
    private Double price;
    private byte[] foto;
    private Customer seller;
    private Customer buyer;

    private LocalDateTime sold;

    public Item() {
    }

    public Item(
            String title,
            String description,
            Double price,
            Customer seller) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.seller = seller;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Customer getSeller() {
        return seller;
    }

    public void setSeller(Customer seller) {
        this.seller = seller;
    }

    public Customer getBuyer() {
        return this.buyer;
    }

    public void setBuyer(Customer buyer) {
        this.buyer = buyer;
    }

    public LocalDateTime getSold() {
        return sold;
    }

    public void setSold(LocalDateTime sold) {
        this.sold = sold;
    }

    public String toString() {
        return "[" +
                getId() + "," +
                getTitle() + "," +
                getDescription() + "," +
                getPrice() + "," +
                getSeller() + "," +
                getBuyer() + "," +
                getSold() +
                "]";
    }

}
