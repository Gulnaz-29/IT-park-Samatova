package ru.example.servletlesson.model;

import lombok.*;

//import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ProductEntity {
    int id_product;
    String name_product;
    int price;
    int quantity;
}
