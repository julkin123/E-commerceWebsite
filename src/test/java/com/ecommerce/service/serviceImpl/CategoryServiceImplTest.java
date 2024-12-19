package com.ecommerce.service.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ecommerce.Dto.CategoryDto;
import com.ecommerce.model.Category;
import com.ecommerce.modelMapper.CategoryModelMapper;
import com.ecommerce.repo.CategoryRepo;
 

class CategoryServiceImplTest {
	
	@Mock
	CategoryRepo  categoryRepo;
	@InjectMocks
	CategoryServiceImpl categoryService;
	AutoCloseable autoCloseable;
	Category category;

	@BeforeEach
	void setUp() throws Exception {
		
		autoCloseable=MockitoAnnotations.openMocks(this);
		
		category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("Laptops");
		categoryRepo.save(category);
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void testCreateCategory() {
		
		when(categoryRepo.save(category)).thenReturn(category);
		CategoryDto categoryDto=CategoryModelMapper.entityToDto(category);
		CategoryDto result=categoryService.createCategory(categoryDto);
		assertThat(result).isEqualTo(categoryDto);

	}

	@Test
	void testGetAllCategory() {
		when(categoryRepo.findAll()).thenReturn(
				new ArrayList<Category>( Collections.singleton(category)));
		assertThat(categoryService.getAllCategory().get(0).getCategoryName()).isEqualTo(category.getCategoryName());
	}

	@Test
	void testGetCategoryById() {
		when(categoryRepo.findById(1)).thenReturn(Optional.of(category));
		assertEquals(categoryService.getCategoryById(1).getCategoryName(), category.getCategoryName());
	}

	@Test
	void testDeleteCategory() {
		when(categoryRepo.findById(1)).thenReturn(Optional.of(category));
		categoryRepo.delete(category);
		verify(categoryRepo,times(1)).delete(category);
		
		
	}

	@Test
	void testUpdaetCategory() {
		when(categoryRepo.findById(1)).thenReturn(Optional.of(category));
		when(categoryRepo.save(category)).thenReturn(category);
		CategoryDto categoryDto=CategoryModelMapper.entityToDto(category);
		CategoryDto result=categoryService.updaetCategory(categoryDto,1);
		assertThat(result).isEqualTo(categoryDto);
		 verify(categoryRepo, times(1)).findById(1);
	}

}
