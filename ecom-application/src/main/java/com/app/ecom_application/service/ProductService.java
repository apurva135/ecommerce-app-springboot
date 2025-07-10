package com.app.ecom_application.service;

import com.app.ecom_application.dto.ProductRequestDTO;
import com.app.ecom_application.dto.ProductResponseDTO;


import java.util.List;


public interface ProductService {

    ProductResponseDTO createProduct(ProductRequestDTO product);
    List<ProductResponseDTO> getAllProduct();
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);
    void deleteProduct(Long id);

}
