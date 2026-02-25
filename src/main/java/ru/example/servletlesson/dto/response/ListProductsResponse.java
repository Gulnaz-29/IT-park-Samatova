package ru.example.servletlesson.dto.response;

import lombok.*;
import java.util.List;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ListProductsResponse {
    List<ProductsResponse> products;
}
