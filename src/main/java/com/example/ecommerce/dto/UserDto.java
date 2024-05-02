package com.example.ecommerce.dto;

import lombok.*;

import java.util.Date;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int userId;

    private String name;

    private String surname;

    private Date birthDate;

    private String email;

    private String address;

    private String phoneNumber;

    private String username;

    private String password;
}
