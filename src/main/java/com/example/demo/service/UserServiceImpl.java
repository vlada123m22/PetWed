package com.example.demo.service;

import com.example.demo.dto.AddNewUserRequestDTO;
import com.example.demo.entity.Usser;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Usser saveUser(AddNewUserRequestDTO dto) {
        Usser newUser = new Usser();
        if(!userRepository.checkEmailExists(dto.getEmail())) {
            newUser.setSurname(dto.getFirstName());
            newUser.setFamilyName(dto.getLastName());
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
    public long getUsserId(Usser usser) {
        return usser.getId();
    }

    @Override
    public Usser getUsserById(long id) {
        return userRepository.getUsserById(id);
    }

}
