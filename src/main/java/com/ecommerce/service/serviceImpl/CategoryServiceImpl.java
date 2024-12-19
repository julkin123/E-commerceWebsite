package com.ecommerce.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.ecommerce.Dto.CategoryDto;
import com.ecommerce.Exception.ResourceNotFoundException;
import com.ecommerce.model.Category;
import com.ecommerce.modelMapper.CategoryModelMapper;
import com.ecommerce.repo.CategoryRepo;
import com.ecommerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = CategoryModelMapper.dtoToEntity(categoryDto);
		categoryRepo.save(category);
		return CategoryModelMapper.entityToDto(category);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> category = categoryRepo.findAll();
		List<CategoryDto> categoryDto = category.stream().map((catogarys) -> CategoryModelMapper.entityToDto(catogarys))
				.collect(Collectors.toList());
		return categoryDto;
	}

	@Override
	public CategoryDto getCategoryById(int categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category not Exist with id:" + categoryId));
		return CategoryModelMapper.entityToDto(category);
	}

	@Override
	public void deleteCategory(int categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceAccessException("Category not Exist with id:" + categoryId));
		categoryRepo.deleteById(category.getCategoryId());
	}

	@Override
	public CategoryDto updaetCategory(CategoryDto categoryDto, int categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceAccessException("category is not exist with id:" + categoryId));
		category.setCategoryName(categoryDto.getCategoryName());

		categoryRepo.save(category);

		return CategoryModelMapper.entityToDto(category);
	}

}
