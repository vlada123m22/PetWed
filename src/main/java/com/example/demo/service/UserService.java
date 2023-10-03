package com.example.demo.service;

import com.example.demo.dto.AddNewUserRequestDTO;
import com.example.demo.entity.Pet;
import com.example.demo.entity.Usser;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public Usser saveUser(AddNewUserRequestDTO addNewUserRequestDTO);
    public long getUsserId(Usser usser);
    public Usser getUsserById(long id);
}
