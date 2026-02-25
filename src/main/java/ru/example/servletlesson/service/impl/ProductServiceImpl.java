package ru.example.servletlesson.service.impl;

import lombok.RequiredArgsConstructor;
import ru.example.servletlesson.dto.request.NewProductRequest;
import ru.example.servletlesson.dto.response.ListProductsResponse;
import ru.example.servletlesson.mapper.ProductMapper;
import ru.example.servletlesson.model.ProductEntity;
import ru.example.servletlesson.repository.ProductRepository;
import ru.example.servletlesson.service.ProductService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

//@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private final ProductMapper productMapper;


    @Override
    public ListProductsResponse getAllProducts() {
        List<ProductEntity> products = productRepository.getAllProducts();
     //   log.info("Get all products");

        if (products.isEmpty()) {
            return new ListProductsResponse(Collections.emptyList());
        }
        return productMapper.toDto(products);
    }

    @Override
    public void saveNewProduct(NewProductRequest request/*, List<CategoryRequest> requestList*/) {
        Optional<ProductEntity> optionalProduct = productRepository.saveNewProduct(productMapper.toEntity(request)/*, requestList*/);

    }
}
