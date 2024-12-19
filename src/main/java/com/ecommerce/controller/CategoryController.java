package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Dto.CategoryDto;
import com.ecommerce.service.CategoryService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@PostMapping("/admin/category")
	ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
		return new ResponseEntity<CategoryDto>(categoryService.createCategory(categoryDto), HttpStatus.OK);
	}

	@GetMapping("/user/category")
	ResponseEntity<List<CategoryDto>> getAllCategory() {
		return new ResponseEntity<List<CategoryDto>>(categoryService.getAllCategory(), HttpStatus.OK);
	}

	@GetMapping("/user/category/{categoryId}")
	ResponseEntity<CategoryDto> getAllCategoryById(@PathVariable int categoryId) {
		return new ResponseEntity<CategoryDto>(categoryService.getCategoryById(categoryId), HttpStatus.OK);
	}

	@DeleteMapping("/admin/category/{categoryid}")
	ResponseEntity<String> deleteCategory(@PathVariable int categoryid) {
		categoryService.deleteCategory(categoryid);
		return new ResponseEntity<String>("Category Deleted", HttpStatus.OK);
	}

	@PutMapping("/admin/category/{categoryId}")
	public ResponseEntity<CategoryDto> putMethodName(@PathVariable int categoryId,
			@RequestBody CategoryDto categoryDto) {

		return new ResponseEntity<CategoryDto>(categoryService.updaetCategory(categoryDto, categoryId), HttpStatus.OK);
	}

}
