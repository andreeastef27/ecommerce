package com.example.ecommerce.dto;

import lombok.*;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private int productId;

    private String name;

    private String description;

    private float basePrice;
}
