package com.example.demo.service;

import com.example.demo.dto.AddNewPetRequestDTO;
import com.example.demo.dto.AddNewUserRequestDTO;
import com.example.demo.entity.Pet;
import com.example.demo.entity.Usser;

import java.util.List;

public interface PetService {
    public Pet savePet(AddNewPetRequestDTO addNewPetRequestDTO);
    List<Pet> getPetsByUser(Long userId);
    List <Pet> allPets();
}
