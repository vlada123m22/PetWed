package com.example.demo.service;

import com.example.demo.dto.AddNewUserRequestDTO;
import com.example.demo.entity.User;


public interface UserService {
    public User saveUser(AddNewUserRequestDTO addNewUserRequestDTO);
    public long getUsserId(User user);
    public User getUsserById(long id);
    public User getUserByEmail(String email);
}
