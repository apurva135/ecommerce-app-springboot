package com.app.ecom_application.dto;

import lombok.Data;

@Data
public class ProductRequestDTO {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String imageUrl;
    private Long categoryId;

}
