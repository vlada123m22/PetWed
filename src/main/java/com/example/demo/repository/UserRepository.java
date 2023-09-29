package com.example.demo.repository;

import com.example.demo.entity.Usser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Usser, Long> {
    Usser findByEmail(String email);
}