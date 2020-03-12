package com.example.aquaone.model;

import com.example.aquaone.HasId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product extends AbstractBaseEntity implements HasId {


    @Column(name = "categoryId", nullable = false)
    @NotNull
    private Integer categoryId;

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "description", nullable = false)
    @NotNull
    private String description;

    @Column(name = "price", nullable = false)
    @NotNull
    private Integer price;

    @Column(name = "image", nullable = false)
    @NotNull
    private String image;


    public Product(){
    }

    public Product(Product p){
        this(p.getId(), p.getCategoryId(),  p.getName(), p.getDescription(), p.getPrice(), p.getImage());
    }

    public Product(Integer id, Integer categoryId, String name, String description, Integer price, String image){
        super(id);
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", id=" + id +
                '}';
    }
}
