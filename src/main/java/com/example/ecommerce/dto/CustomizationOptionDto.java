package com.example.ecommerce.dto;

import lombok.*;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomizationOptionDto {

    private int optionId;

    private String name;

    private float additionalPrice;
}
