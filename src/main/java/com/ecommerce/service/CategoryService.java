package com.ecommerce.service;

import java.util.List;

import com.ecommerce.Dto.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);

	CategoryDto updaetCategory(CategoryDto categoryDto, int categoryId);

	void deleteCategory(int categoryId);

	List<CategoryDto> getAllCategory();

	CategoryDto getCategoryById(int categoryId);

}
