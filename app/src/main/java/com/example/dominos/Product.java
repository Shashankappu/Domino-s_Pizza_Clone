package com.example.dominos;

public class Product {
    private String productTitle;
    private String productPrice;
    private String productDescription;
    private String productImage;
    public Product(String productTitle,String productPrice,String productDescription,String productImage){
        setProductTitle(productTitle);
        setProductPrice("Rs."+productPrice);
        setProductDescription(productDescription);
        setProductImage(productImage);
    }
    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
