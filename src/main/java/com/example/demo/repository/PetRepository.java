package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import com.example.demo.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {
    @Query("SELECT p  from  Pet p where p.breed.id= :breedId")
    List<Pet> getPetsByBreedId(Long breedId);
    @Query("SELECT p  from  Pet p where p.user.id= :userId")
    Pet getPetsByUserId(Long userId);

    @Query("SELECT p from Pet p")
    List<Pet> allPets();

}
