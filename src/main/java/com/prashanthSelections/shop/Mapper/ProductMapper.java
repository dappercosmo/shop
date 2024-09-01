package com.prashanthSelections.shop.Mapper;

import com.prashanthSelections.shop.dto.ProductDto;
import com.prashanthSelections.shop.model.Product;

public class ProductMapper {

    public static ProductDto toDto(Product product){
        if(product == null){
            throw new IllegalStateException("product cannot be null");
        }
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    public static Product toEntity(ProductDto productDto){
        if(productDto == null){
            throw new IllegalStateException("productdto cannot be null");
        }
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return product;
    }
}
