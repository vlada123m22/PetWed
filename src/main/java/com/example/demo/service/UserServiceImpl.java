package com.example.demo.service;

import com.example.demo.dto.AddNewUserRequestDTO;
import com.example.demo.entity.Usser;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Usser saveUser(AddNewUserRequestDTO dto) {
        Usser newUser = new Usser();
        newUser.setSurname(dto.getFirstName());
        newUser.setFamilyName(dto.getLastName());
        newUser.setPassword(dto.getPassword());
        newUser.setEmail(dto.getEmail());
        return userRepository.save(newUser);
    }

}
