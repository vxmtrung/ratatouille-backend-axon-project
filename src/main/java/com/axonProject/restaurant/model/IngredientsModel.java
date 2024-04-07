package com.axonProject.restaurant.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "ingredients")
public class IngredientsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "price_per_unit")
    private Long pricePerUnit;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "name")
    private String name;

    @Column(name = "import_date")
    @Temporal(TemporalType.DATE)
    private Date importDate;

    @Column(name = "expired_date")
    @Temporal(TemporalType.DATE)
    private Date expiredDate;

    @Column(name = "image")
    private String image;

    public IngredientsModel() {
        //Do nothing in this :)
    }

    public IngredientsModel(Long pricePerUnit, String description, int quantity, String name, Date importDate, Date expiredDate, String image){
        this.pricePerUnit = pricePerUnit;
        this.description = description;
        this.quantity = quantity;
        this.name = name;
        this.importDate = importDate;
        this.expiredDate = expiredDate;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public Long getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Long pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
