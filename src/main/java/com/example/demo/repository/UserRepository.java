package com.example.demo.repository;

import com.example.demo.entity.Usser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<Usser, Long> {
    @Query("SELECT u FROM Usser u WHERE u.email=:email ")
    Usser getUserByEmail(String email);

    @Query("SELECT u.password FROM Usser u WHERE u.email=:email")
    Usser getPasswordByEmail(String email);

    @Query("SELECT EXISTS(SELECT u FROM Usser u WHERE u.email=:email)")
    boolean checkEmailExists(String email);
}