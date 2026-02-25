package ru.example.servletlesson.dto.response;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ProductsResponse {
    int id_product;
    String name;
    int price;
    int quantity;
}
