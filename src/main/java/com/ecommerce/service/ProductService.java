package com.ecommerce.service;

import java.util.List;

import com.ecommerce.Dto.ProductDto;
import com.ecommerce.Dto.ProductPostDto;

public interface ProductService {

	ProductPostDto createProduct(ProductPostDto productDto, int categoryId, int userId);

	ProductDto updateProduct(ProductDto productDto, int productId);

	void deleteProduct(int productId);

	List<ProductDto> getAllProduct();

	ProductDto getProductById(int productId);

	List<ProductDto> getAllProductByCategory(int categoryId);

	List<ProductDto> searchProduct(String keyWord);

}
