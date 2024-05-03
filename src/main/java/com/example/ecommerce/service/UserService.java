package com.example.ecommerce.service;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.mapper.UserMapper;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepo;
import lombok.AllArgsConstructor;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepo userRepo;

    public List<UserDto> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(UserMapper.mapper::convertEntityToDto)
                .toList();
    }

    public List<UserDto> getUserById(int id) {
        return userRepo.findById(id)
                .stream()
                .map(UserMapper.mapper::convertEntityToDto)
                .toList();
    }

    public void createUser(UserDto userDto) {
        User user = UserMapper.mapper.convertDtoToEntity(userDto);
        userRepo.save(user);
    }

    public void modifyUser(int id, UserDto newUserDto) {
//        User existingUser = userRepo.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Does not exist!"));

        User newUser = UserMapper.mapper.convertDtoToEntity(newUserDto);
        //existingUser.setName(newUser.getName());
        //userRepo.save(existingUser);
    }

    public String deleteUserById(int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            userRepo.deleteById(id);
            return "Deleted";
        } else {
            return "Not Found";
        }
    }

    public void deleteAllUsers() {
        userRepo.deleteAll();
    }
}
