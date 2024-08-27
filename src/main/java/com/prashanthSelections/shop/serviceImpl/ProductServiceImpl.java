package com.prashanthSelections.shop.serviceImpl;

import com.prashanthSelections.shop.Mapper.ProductMapper;
import com.prashanthSelections.shop.dto.ProductDto;
import com.prashanthSelections.shop.exception.ProductNotFoundException;
import com.prashanthSelections.shop.model.Product;
import com.prashanthSelections.shop.repository.ProductRepository;
import com.prashanthSelections.shop.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.toEntity(productDto);
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        //product.setCreatedOn(new Date());
        product.setDeleted(false);
        productRepository.save(product);
        return ProductMapper.toDto(product);
    }

    @Override
    public ProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) throws ProductNotFoundException {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
        return ProductMapper.toDto(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product not found"));
        product.setDeleted(true);
        productRepository.save(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findByIsDeletedFalse();
        return products.stream().map(ProductMapper::toDto).collect(Collectors.toList());
    }
}
