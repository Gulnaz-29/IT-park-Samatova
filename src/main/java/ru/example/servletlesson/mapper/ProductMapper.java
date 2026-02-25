package ru.example.servletlesson.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.example.servletlesson.dto.request.NewProductRequest;
import ru.example.servletlesson.dto.response.ListProductsResponse;
import ru.example.servletlesson.model.ProductEntity;

import java.util.List;

public interface ProductMapper extends RowMapper<ProductEntity> {
    ProductEntity toEntity(NewProductRequest request);

    ListProductsResponse toDto(List<ProductEntity> productEntityList);
}
