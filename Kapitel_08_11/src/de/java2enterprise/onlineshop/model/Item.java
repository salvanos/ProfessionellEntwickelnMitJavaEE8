package de.java2enterprise.onlineshop.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the ITEM database table.
 * 
 */
@Entity
@Table(
        schema = "ONLINESHOP",
        name = "ITEM"
)
@NamedQuery(
        name = "Item.findAll",
        query = "SELECT i FROM Item i"
)
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(
            name = "ITEM_ID_GENERATOR",
            sequenceName = "SEQ_ITEM",
            schema = "ONLINESHOP",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITEM_ID_GENERATOR"
    )
    private Long id;

    private String description;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] foto;

    private Double price;

    private LocalDateTime sold;

    private String title;

    // bi-directional many-to-one association to Customer
    @ManyToOne
    private Customer seller;

    // bi-directional many-to-one association to Customer
    @ManyToOne
    private Customer buyer;

    public Item() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(
            Long id
    ) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(
            String description
    ) {
        this.description = description;
    }

    public byte[] getFoto() {
        return this.foto;
    }

    public void setFoto(
            byte[] foto
    ) {
        this.foto = foto;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(
            Double price
    ) {
        this.price = price;
    }

    public LocalDateTime getSold() {
        return this.sold;
    }

    public void setSold(
            LocalDateTime sold
    ) {
        this.sold = sold;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(
            String title
    ) {
        this.title = title;
    }

    public Customer getSeller() {
        return this.seller;
    }

    public void setSeller(
            Customer seller
    ) {
        this.seller = seller;
    }

    public Customer getBuyer() {
        return this.buyer;
    }

    public void setBuyer(
            Customer buyer
    ) {
        this.buyer = buyer;
    }

}