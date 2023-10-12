package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import com.example.demo.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {
//    @Query("SELECT p  from  Pet p where p.breed.id= :pet.breed.id")
//    List<Pet> getSameBreedPets(Pet pet);

    @Query("SELECT p  from  Pet p where p.breed= :breed and p.user.id!= :userId")
    List<Pet> getSuitablePets(Breed breed, Long userId); //returns all pets of the indicated breed excluding the pets of the user with the indicated userId

    @Query("SELECT p  from  Pet p where p.user.id= :userId ")
    List<Pet> getPetsByUserId(Long userId);

    @Query("SELECT p from Pet p")
    List<Pet> allPets();

    @Query("SELECT p FROM Pet p WHERE p.id= :petId")
    Pet getById(long petId);

    @Query("SELECT DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),p.birthDate)), '%Y') FROM Pet p WHERE p.id= :petId")
    int getAge(Long petId);


}
