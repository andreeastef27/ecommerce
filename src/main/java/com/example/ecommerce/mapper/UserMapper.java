package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto convertEntityToDto(User user);
    User convertDtoToEntity(UserDto userDto);
    UserMapper mapper = Mappers.getMapper(UserMapper.class);
}
