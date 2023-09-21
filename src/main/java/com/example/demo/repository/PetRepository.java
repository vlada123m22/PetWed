package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import com.example.demo.entity.*;

import java.util.List;

public interface PetRepository {
    @Query("SELECT p  from  Pet p where p.breedId= :categoryId")
    List<Pet> getByBreedId(Long BreedId);
    @Query("SELECT p  from  Pet p where p.userId= :categoryId")
    Usser getByUserId(Long UserId);

}
