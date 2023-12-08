package com.example.demo.service.implementation;

import com.example.demo.dto.AddNewUserRequestDTO;
import com.example.demo.dto.UserProfileDTO;
import com.example.demo.entity.Breed;
import com.example.demo.entity.Pet;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.entity.enums.RoleName;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

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
        if(userRepository.checkEmailExists(dto.getEmail())) {
            return null;
        }
        newUser.setFirstName(dto.getFirstName());
        newUser.setLastName(dto.getLastName());
        newUser.setPassword(dto.getPassword());
        newUser.setEmail(dto.getEmail());
        newUser.setRegion(dto.getRegion());
        newUser.setCity(dto.getCity());
        newUser.setRegistrationDateTime(LocalDateTime.now());
        newUser.setBirthDate(dto.getBirthDate());
        newUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        newUser=userRepository.save(newUser);
        UserRole registered = userRoleRepository.getUserRoleByName(RoleName.REGISTERED);
        registered.setRoleName(RoleName.REGISTERED);
        registered=userRoleRepository.save(registered);
        newUser.setUserRole(registered);
        newUser.setAccountNonLocked(true);
        return newUser;
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

    @Override
    public Boolean userHasPet(Pet pet, User user) {
        return pet.getUser() == user;

    }

    public UserProfileDTO getUserProfileDTOByUserId(Long userId) {

        return userRepository.UserProfileDTOByUserId(userId);
    }

    @Override
    public void updateUserProfile(UserProfileDTO dto) {
        if (Objects.nonNull(dto.getUserId())){
            User userProfile = userRepository.getById(dto.getUserId());
            userProfile.setFirstName(dto.getFirstName());
            userProfile.setLastName(dto.getLastName());
            userProfile.setAvatarPath(dto.getImgPath());
            userProfile.setRegion(dto.getRegion());
            userProfile.setCity(dto.getCity());
            userRepository.save(userProfile);
        }

    }


}
