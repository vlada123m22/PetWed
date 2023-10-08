package com.example.demo.service.implementation;

import com.example.demo.dto.AddNewUserRequestDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(AddNewUserRequestDTO dto) {
        User newUser = new User();
        if(!userRepository.checkEmailExists(dto.getEmail())) {
            newUser.setFirstName(dto.getFirstName());
            newUser.setLastName(dto.getLastName());
            newUser.setPassword(dto.getPassword());
            newUser.setEmail(dto.getEmail());
            newUser.setRegion(dto.getRegion());
            newUser.setCity(dto.getCity());
            newUser.setRegistrationDate(new Date(System.currentTimeMillis()));
            return userRepository.save(newUser);
        }
        else return null;
    }

    @Override
    public long getUserId(User user) {
        return user.getId();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public User getUserByPetId(long petId) {
        return userRepository.getByPetId(petId);
    }



}
