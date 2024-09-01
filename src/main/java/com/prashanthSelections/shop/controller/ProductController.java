package com.prashanthSelections.shop.controller;

import com.prashanthSelections.shop.dto.ProductDto;
import com.prashanthSelections.shop.serviceImpl.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/api/v1/")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto createdProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(createdProduct,HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable long id, @RequestBody ProductDto productDto){
        ProductDto updatedProduct = productService.updateProduct(id, productDto);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable long id){
        ProductDto productDto = productService.getProductById(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
