package com.example.demo.repository;

import com.example.demo.dto.UserProfileDTO;
import com.example.demo.entity.Pet;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT EXISTS(SELECT u.id FROM User u WHERE u.email= :email)")
    Boolean checkEmailExists(String email);
    @Query("SELECT u FROM User u WHERE u.id= :id")
    User getById(long id);
    @Query("SELECT u FROM User u WHERE u.email= :email")
    User getByEmail(String email);
    @Query("SELECT p.user FROM Pet p WHERE p.id= :petId ")
    User getByPetId(long petId);

    @Query ("SELECT new com.example.demo.dto.UserProfileDTO(" +
            " u.id, u.email, u.firstName, u.lastName,u.avatarPath,u.region,u.city, u.registrationDateTime) " +
            " FROM User u " +
            " WHERE u.id = :userId")
    UserProfileDTO UserProfileDTOByUserId(Long userId);
}