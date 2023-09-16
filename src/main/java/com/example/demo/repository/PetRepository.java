package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import com.example.demo.entity.*;

import java.util.List;

public interface AnimalRepository {
    @Query("SELECT p  from  Pet p where p.category.id= :categoryId")
    List<Pet> getByCategoryId(Long categoryId);
}
