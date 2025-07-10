package com.app.ecom_application.controller;

import com.app.ecom_application.dto.ProductRequestDTO;
import com.app.ecom_application.dto.ProductResponseDTO;
import com.app.ecom_application.model.Category;
import com.app.ecom_application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("api/Product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/admin/add/")
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductRequestDTO productRequestDTO)
    {        ProductResponseDTO product = productService.createProduct(productRequestDTO);
             return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<ProductResponseDTO>> getAllProduct()
    {
        List<ProductResponseDTO> product =  productService.getAllProduct();
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id)
    {
        ProductResponseDTO product = productService.getProductById(id);
        return new ResponseEntity<>(product,HttpStatus.FOUND);
    }

    @PostMapping("/updateProduct/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO)
    {
        ProductResponseDTO productResponseDTO = productService.updateProduct(id,productRequestDTO);
        return new ResponseEntity<>(productResponseDTO,HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id)
    {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
