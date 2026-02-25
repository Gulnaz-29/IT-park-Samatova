package ru.example.servletlesson.dto.request;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewProductRequest {

    private int id_product;
    private String name;
    private int price;
    private int quantity;

}
