package com.example.ecommerce.dto;

import lombok.*;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {

    private int cartId;

    private int userId;

    private int productId;

    private int quantity;
}
