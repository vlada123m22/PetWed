package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT EXISTS(SELECT u FROM User u WHERE u.email= :email)")
    boolean checkEmailExists(String email);
    @Query("SELECT u FROM User u WHERE u.id= :id")
    User getById(long id);
    @Query("SELECT u FROM User u WHERE u.email= :email")
    User getByEmail(String email);
}