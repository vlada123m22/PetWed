package com.example.demo.service;

import com.example.demo.dto.AddNewPetRequestDTO;
import com.example.demo.entity.Pet;

import java.util.List;

public interface PetService {
    Pet savePet(AddNewPetRequestDTO addNewPetRequestDTO);
    List<Pet> getPetsByUserId(Long userId);
    List <Pet> allPets();
    Pet getPetById(long petId);
    void computeAge(Pet pet);
    List<Pet> getSuitablePets(Long petId, Long userId);


}

