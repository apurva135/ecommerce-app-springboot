package com.app.ecom_application.service.impl;

import com.app.ecom_application.dto.CategoryRequestDTO;
import com.app.ecom_application.dto.CategoryResponseDTO;
import com.app.ecom_application.model.Category;
import com.app.ecom_application.repositories.CategoryRepository;
import com.app.ecom_application.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private CategoryResponseDTO mapToResponseDTO(Category category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setId(category.getId());
        dto.setCategoryName(category.getCategoryName());
        dto.setDescription(category.getDescription());
        return dto;
    }

    private Category mapToEntity(CategoryRequestDTO dto) {
        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());
        category.setDescription(dto.getDescription());
        return category;
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {
         Category category = mapToEntity(categoryRequestDTO);
         Category saved = categoryRepository.save(category);
         return mapToResponseDTO(saved);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
          Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
          return mapToResponseDTO(category);
    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        category.setCategoryName(categoryRequestDTO.getCategoryName());
        category.setDescription(categoryRequestDTO.getCategoryName());
        Category updated = categoryRepository.save(category);
        return mapToResponseDTO(updated);

    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        categoryRepository.delete(category);
    }
}
