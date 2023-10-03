package com.example.demo.repository;

import com.example.demo.entity.Pet;
import com.example.demo.entity.Usser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Usser, Long> {
    @Query("SELECT EXISTS(SELECT u FROM Usser u WHERE u.email=:email)")
    boolean checkEmailExists(String email);
    @Query("SELECT u FROM Usser u WHERE u.id=:id")
    Usser getById(long id);
    @Query("SELECT u FROM Usser u WHERE u.email=:email")
    Usser getByEmail(String email);
}