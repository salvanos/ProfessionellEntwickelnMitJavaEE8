package de.java2enterprise.onlineshop.model;

import java.time.LocalDateTime;

import javax.json.bind.annotation.JsonbDateFormat;

public class Item {

    private Long id;

    private String description;

    private byte[] foto;

    private Double price;

    private String title;

    @JsonbDateFormat(
            value = "dd.MM.yyyy",
            locale = "Locale.GERMAN"
    )
    private LocalDateTime sold;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getFoto() {
        return this.foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getSold() {
        return this.sold;
    }

    public void setSold(LocalDateTime sold) {
        this.sold = sold;
    }
}
