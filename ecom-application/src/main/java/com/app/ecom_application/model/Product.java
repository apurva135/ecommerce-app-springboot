package com.app.ecom_application.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Product {

    private Long Id;
    private String name ;
    private String description;
    private Double price;
    private Integer quantity;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
