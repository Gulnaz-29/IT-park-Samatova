package ru.example.servletlesson.repository;

import ru.example.servletlesson.dto.request.CategoryRequest;
import ru.example.servletlesson.model.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductEntity> getAllProducts();
    Optional<ProductEntity> findProductById(int id_product);
//    Optional<ProductEntity> saveNewProduct(ProductEntity product, List<CategoryRequest> category);
    Optional<ProductEntity> saveNewProduct(ProductEntity product);
}
