package ru.example.servletlesson.service;

import ru.example.servletlesson.dto.request.NewProductRequest;
import ru.example.servletlesson.dto.response.ListProductsResponse;

public interface ProductService {
    ListProductsResponse getAllProducts();

    void saveNewProduct(NewProductRequest request/*, List<CategoryRequest> requestList*/);
}
