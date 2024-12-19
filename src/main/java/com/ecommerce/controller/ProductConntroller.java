package com.ecommerce.controller;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.Dto.ProductDto;
import com.ecommerce.Dto.ProductPostDto;
import com.ecommerce.service.ProductService;

import com.ecommerce.service.FileService;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductConntroller {
	@Autowired
	ProductService productService;
	@Autowired
	private FileService fileService;
	@Value("${project.image}")
	private String path;

	@PostMapping("/user/{userId}/category/{categoryId}/product")
	public ResponseEntity<ProductPostDto> createProduct(@RequestBody ProductPostDto productDto,
			@PathVariable int categoryId, @PathVariable int userId) {

		return new ResponseEntity<ProductPostDto>(productService.createProduct(productDto, categoryId, userId),
				HttpStatus.CREATED);
	}

	@DeleteMapping("/admin/product/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productId) {

		productService.deleteProduct(productId);

		return new ResponseEntity<String>("product deleted", HttpStatus.OK);
	}

	@GetMapping("/product")
	public ResponseEntity<List<ProductDto>> getAllProduct() {
		return new ResponseEntity<List<ProductDto>>(productService.getAllProduct(), HttpStatus.OK);
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable int productId) {

		return new ResponseEntity<ProductDto>(productService.getProductById(productId), HttpStatus.OK);
	}

	@PutMapping("/admin/product/{productId}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable int productId, @RequestBody ProductDto productDto) {
		// TODO: process PUT request

		return new ResponseEntity<ProductDto>(productService.updateProduct(productDto, productId), HttpStatus.OK);
	}

	@GetMapping("/user/category/{categoryId}/products")
	public ResponseEntity<List<ProductDto>> getProductsByCategoty(@PathVariable int categoryId) {
		return new ResponseEntity<List<ProductDto>>(productService.getAllProductByCategory(categoryId), HttpStatus.OK);
	}

	@PostMapping("/product/image/upload/{productId}")
	public ResponseEntity<ProductDto> uploadImage(@RequestParam MultipartFile image, @PathVariable int productId)
			throws IOException {

		String fileName = this.fileService.uploadImage(path, image);
		ProductDto postDto = this.productService.getProductById(productId);
		postDto.setImageName(fileName);
		ProductDto updatepost = this.productService.updateProduct(postDto, productId);
		return new ResponseEntity<ProductDto>(updatepost, HttpStatus.OK);

	}

	@GetMapping(value = "/product/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable String imageName, HttpServletResponse response) throws IOException {
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());

	}

	@GetMapping("/user/product/search/{keyword}")
	public ResponseEntity<List<ProductDto>> search(@PathVariable String keyword) {
		List<ProductDto> productDto = productService.searchProduct(keyword);

		return new ResponseEntity<List<ProductDto>>(productDto, HttpStatus.OK);

	}

}
