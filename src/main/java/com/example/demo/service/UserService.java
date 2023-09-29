package com.example.demo.service;

import com.example.demo.dto.AddNewUserRequestDTO;
import com.example.demo.entity.Pet;
import com.example.demo.entity.Usser;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public Usser saveUser(AddNewUserRequestDTO addNewUserRequestDTO);
}
