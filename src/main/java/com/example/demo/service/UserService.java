package com.example.demo.service;

import com.example.demo.dto.AddNewUserRequestDTO;
import com.example.demo.entity.Pet;
import com.example.demo.entity.User;


public interface UserService {
    User saveUser(AddNewUserRequestDTO addNewUserRequestDTO);
    long getUserId(User user);
    User getUserById(long id);
    User getUserByEmail(String email);
    User getUserByPetId(long petId);
    Boolean userHasPet(Pet pet, User user);
}
