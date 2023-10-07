package com.example.demo.service;

import com.example.demo.dto.AddNewUserRequestDTO;
import com.example.demo.entity.User;


public interface UserService {
    public User saveUser(AddNewUserRequestDTO addNewUserRequestDTO);
    public long getUserId(User user);
    public User getUserById(long id);
    public User getUserByEmail(String email);
}
