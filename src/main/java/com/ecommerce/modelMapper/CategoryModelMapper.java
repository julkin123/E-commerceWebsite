package com.ecommerce.modelMapper;

import com.ecommerce.Dto.CategoryDto;
import com.ecommerce.model.Category;

public class CategoryModelMapper {
	public static Category dtoToEntity(CategoryDto categoryDto) {

		return new Category(categoryDto.getCategoryId(), categoryDto.getCategoryName());
	}

	public static CategoryDto entityToDto(Category category) {

		return new CategoryDto(category.getCategoryId(), category.getCategoryName());
	}

}
