package com.ecommerce.service.serviceImpl;

import java.util.Date;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Dto.ProductDto;
import com.ecommerce.Dto.ProductPostDto;
import com.ecommerce.Exception.ResourceNotFoundException;
import com.ecommerce.model.Category;
import com.ecommerce.model.MyUser;
import com.ecommerce.model.Product;

import com.ecommerce.modelMapper.ProductModelMapper;
import com.ecommerce.repo.CategoryRepo;
import com.ecommerce.repo.ProductRepo;
import com.ecommerce.repo.UserRepo;
import com.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	CategoryRepo categoryRepo;
	@Autowired
	ProductRepo productRepo;

	@Override
	public ProductPostDto createProduct(ProductPostDto productDto, int categoryId, int userId) {

		MyUser user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with given Id:" + userId));
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category is not exist with given id:" + categoryId));

		Product product = new Product();

		product.setProductName(productDto.getProductName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setImageUrl(productDto.getImageUrl());
		product.setStock(productDto.getStock());
		product.setCategory(category);
		product.setUser(user);
		product.setImageName("default.png");
		product.setCreatedDate(new Date());

		Product savedProduct = productRepo.save(product);

		ProductPostDto productPostDto = new ProductPostDto();
		productPostDto.setProductId(savedProduct.getProductId());
		productPostDto.setProductName(savedProduct.getProductName());
		productPostDto.setDescription(savedProduct.getDescription());
		productPostDto.setPrice(savedProduct.getPrice());
		productPostDto.setImageUrl(savedProduct.getImageUrl());
		productPostDto.setStock(savedProduct.getStock());

		productPostDto.setImageName(savedProduct.getImageName());
		productPostDto.setCreatedDate(savedProduct.getCreatedDate());

		return productPostDto;
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto, int productId) {
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product is not Exist with id:" + productId));
		product.setProductName(productDto.getProductName());
		product.setDescription(productDto.getDescription());
		product.setImageName(productDto.getImageName());
		product.setPrice(productDto.getPrice());
		product.setStock(productDto.getStock());
		product.setImageUrl(productDto.getImageUrl());
		productRepo.save(product);

		return ProductModelMapper.entityToDto(product);
	}

	@Override
	public List<ProductDto> getAllProduct() {
		List<Product> products = productRepo.findAll();

		List<ProductDto> productDto = products.stream().map((product) -> ProductModelMapper.entityToDto(product))
				.collect(Collectors.toList());
		return productDto;
	}

	@Override
	public ProductDto getProductById(int productId) {
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product is not Exist with id:" + productId));
		ProductDto productDto = ProductModelMapper.entityToDto(product);
		return productDto;
	}

	@Override
	public List<ProductDto> getAllProductByCategory(int categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category is not exist with Id:" + categoryId));

		List<Product> products = productRepo.findByCategory(category);
		List<ProductDto> productDto = products.stream().map((product) -> ProductModelMapper.entityToDto(product))
				.collect(Collectors.toList());

		return productDto;
	}

	@Override
	public void deleteProduct(int productId) {
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product is not exist with Id:" + productId));
		productRepo.delete(product);

	}

	@Override
	public List<ProductDto> searchProduct(String keyWord) {
		List<Product> product = productRepo.findByProductName("%" + keyWord + "%");
		List<ProductDto> product1 = product.stream().map((produdct) -> ProductModelMapper.entityToDto(produdct))
				.collect(Collectors.toList());
		return product1;
	}

}
