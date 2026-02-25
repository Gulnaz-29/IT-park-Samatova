package ru.example.servletlesson.mapper.impl;

import ru.example.servletlesson.dto.request.NewProductRequest;
import ru.example.servletlesson.dto.response.ListProductsResponse;
import ru.example.servletlesson.dto.response.ProductsResponse;
import ru.example.servletlesson.mapper.ProductMapper;
import ru.example.servletlesson.model.ProductEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductEntity toEntity(NewProductRequest request){
        return ProductEntity.builder()
                .name_product(request.getName())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();
    }

    @Override
    public ListProductsResponse toDto(List<ProductEntity> productEntityList){
        List<ProductsResponse> productsResponses=productEntityList.stream()
                .map(product -> ProductsResponse.builder()
                        .id_product(product.getId_product())
                        .name(product.getName_product())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .build())
                .collect(Collectors.toList());

        return ListProductsResponse.builder()
                .products(productsResponses)
                .build();

    }

    @Override
    public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException{
        return ProductEntity.builder()
                .id_product(rs.getInt("id_product"))
                .name_product(rs.getString("name_product"))
                .price(rs.getInt("price"))
                .quantity(rs.getInt("quantity"))
                .build();
    }
}
