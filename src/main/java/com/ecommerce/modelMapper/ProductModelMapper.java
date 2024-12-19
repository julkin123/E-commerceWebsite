package com.ecommerce.modelMapper;

import com.ecommerce.Dto.ProductDto;
import com.ecommerce.model.Product;

public class ProductModelMapper {

	public static Product dtoToEntity(ProductDto productDto) {

		return new Product(productDto.getProductId(), productDto.getProductName(), productDto.getDescription(),
				productDto.getImageName(), productDto.getCreatedDate(), productDto.getPrice(), productDto.getStock(),
				productDto.getCategory(), productDto.getUser()

				, productDto.getImageUrl()

		);

	}

	public static ProductDto entityToDto(Product product) {

		return new ProductDto(product.getProductId(), product.getProductName(), product.getDescription(),
				product.getImageName(), product.getCreatedDate(), product.getPrice(), product.getStock(),
				product.getCategory(), product.getUser(), product.getImageUrl()

		);

	}

}
