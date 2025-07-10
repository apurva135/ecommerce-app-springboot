package com.app.ecom_application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
    private Long id;

    private String categoryName;

    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
