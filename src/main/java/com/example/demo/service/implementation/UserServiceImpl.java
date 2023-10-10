package com.example.demo.service.implementation;

import com.example.demo.dto.AddNewUserRequestDTO;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.entity.enums.RoleName;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public User saveUser(AddNewUserRequestDTO dto) {
        User newUser = new User();
        if(!userRepository.checkEmailExists(dto.getEmail())) {
            newUser.setFirstName(dto.getFirstName());
            newUser.setLastName(dto.getLastName());
            newUser.setPassword(dto.getPassword());
            newUser.setEmail(dto.getEmail());
            newUser.setRegion(dto.getRegion());
            newUser.setCity(dto.getCity());
            newUser.setRegistrationDateTime(LocalDateTime.now());
            newUser.setPassword(passwordEncoder.encode(dto.getPassword()));
            //TODO
            //1. Inject password encoder
            //2. Encode password from DTO with password encoder
            //3. Create UserRole Repository
            //4. Select from database userRoleRegistered
            //5. Set this role to user
            //6. Save user into database

            newUser = userRepository.save(newUser);
            UserRole registered = new UserRole();
            registered.setRoleName("REGISTERED");
            newUser.setUserRole(registered);
            return newUser;

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
