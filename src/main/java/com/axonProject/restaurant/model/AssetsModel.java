package com.axonProject.restaurant.model;

import jakarta.persistence.*;

@Entity
@Table(name = "assets")
public class AssetsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "material")
    private String material;

    @Column(name = "price_per_unit")
    private Long pricePerUnit;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    public AssetsModel() {
        //Do nothing
    }

    public AssetsModel(int quantity, String material, Long pricePerUnit, String description, String name, String image) {
        this.quantity = quantity;
        this.material = material;
        this.pricePerUnit = pricePerUnit;
        this.description = description;
        this.name = name;
        this.image = image;
    }
    public long getId() {
        return id;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String getMaterial(){
        return material;
    }

    public void setMaterial(String material){
        this.material = material;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
