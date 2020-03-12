package com.example.aquaone.to;

public class ProductTo extends BaseTo {

    private Integer categoryId;
    private String name;
    private String description;
    private Integer price;
    private String image;
    private Integer count;
    private Integer subprice;

    public ProductTo() {
    }

    public ProductTo(Integer categoryId, String name, String description, Integer price, String image, Integer count, Integer subprice) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.count = count;
        this.subprice = subprice;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSubprice() {
        return subprice;
    }

    public void setSubprice(Integer subprice) {
        this.subprice = subprice;
    }
}
