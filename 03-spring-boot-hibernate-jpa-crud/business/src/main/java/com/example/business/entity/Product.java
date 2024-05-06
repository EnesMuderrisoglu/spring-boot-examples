package com.example.business.entity;


import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity

@Table(name="product")
public class Product {

    // table fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int product_id;



    @Column(name = "origin")
    private String origin;

    @Column(name= "price")
    public int price;



    //constructors


    public Product() {
    }

    public Product(String origin, int price) {
        this.origin = origin;
        this.price = price;
    }


    //get-set

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    //string


    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", origin='" + origin + '\'' +
                ", price=" + price +

                '}';
    }
}
