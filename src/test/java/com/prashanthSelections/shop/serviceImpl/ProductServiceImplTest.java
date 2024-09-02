package com.prashanthSelections.shop.serviceImpl;

import com.prashanthSelections.shop.dto.ProductDto;
import com.prashanthSelections.shop.model.Product;
import com.prashanthSelections.shop.repository.ProductRepository;
import com.prashanthSelections.shop.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;
    private ProductDto productDto;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(2);
        product.setName("joggers");
        product.setDescription("nice joggers");
        product.setPrice(1234);

        productDto = new ProductDto();
        productDto.setId(2);
        productDto.setName("joggers");
        productDto.setDescription("nice joggers");
        productDto.setPrice(1234);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createProduct() {
        Product product = new Product();
        product.setId(2);
        product.setName("joggers");
        product.setDescription("nice joggers");
        product.setPrice(1234);

        ProductDto productDto = new ProductDto();
        productDto.setId(2);
        productDto.setName("joggers");
        productDto.setDescription("nice joggers");
        productDto.setPrice(1234);

        when(productRepository.save(any(Product.class))).thenReturn(product);
        ProductDto createdProduct = productService.createProduct(productDto);

        assertNotNull(createdProduct);
        assertEquals(product.getId(), createdProduct.getId());
        assertEquals(product.getName(), createdProduct.getName());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void getProductById() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void getAllProducts() {
    }
}