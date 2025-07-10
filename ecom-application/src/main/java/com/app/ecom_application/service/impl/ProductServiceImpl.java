package com.app.ecom_application.service.impl;

import com.app.ecom_application.dto.ProductRequestDTO;
import com.app.ecom_application.dto.ProductResponseDTO;
import com.app.ecom_application.model.Category;
import com.app.ecom_application.model.Product;
import com.app.ecom_application.repositories.CategoryRepository;
import com.app.ecom_application.repositories.ProductRepository;
import com.app.ecom_application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    // Map ProductRequestDTO to Product
    private Product maptoEntity(ProductRequestDTO dto, Category category)
    {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setImageUrl(dto.getImageUrl());
        product.setCategory(category);
        return product;
    }

    // map product to responseDTO
    private ProductResponseDTO mapToResponseDTO(Product product)
    {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setImageUrl(product.getImageUrl());
        dto.setCategoryName(product.getCategory().getCategoryName());
        return dto;

    }


    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Category category = categoryRepository.findById(productRequestDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("category not found"));
        Product product = maptoEntity(productRequestDTO, category);
        Product saved = productRepository.save(product);
        return mapToResponseDTO(saved);
    }

    @Override
    public List<ProductResponseDTO> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());

    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Id Found"));
        return mapToResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        Category category = categoryRepository.findById(productRequestDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("not found"));
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setQuantity(productRequestDTO.getQuantity());
        product.setImageUrl(productRequestDTO.getImageUrl());
        product.setCategory(category);
        Product saved = productRepository.save(product);
        return  mapToResponseDTO(saved);
    }

    @Override
    public void deleteProduct(Long id) {
        if(!productRepository.existsById(id))
        {
            throw new RuntimeException("Not Found");
        }
        productRepository.deleteById(id);

    }
}
