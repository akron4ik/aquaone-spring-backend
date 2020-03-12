package com.example.aquaone.to;

public class CartTo {

    private UserTo userTo;


    private ProductTo[] products;

    private String comment;

    private Boolean isCreateAccount;

    public CartTo() {
    }

    public CartTo(UserTo userTo, ProductTo[] products, String comment, Boolean isCreateAccount) {
        this.userTo = userTo;
        this.products = products;
        this.comment = comment;
        this.isCreateAccount = isCreateAccount;
    }

    public UserTo getUserTo() {
        return userTo;
    }

    public void setUserTo(UserTo usetTo) {
        this.userTo = usetTo;
    }

    public ProductTo[] getProducts() {
        return products;
    }

    public void setProducts(ProductTo[] products) {
        this.products = products;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getCreateAccount() {
        return isCreateAccount;
    }

    public void setCreateAccount(Boolean createAccount) {
        isCreateAccount = createAccount;
    }
}
