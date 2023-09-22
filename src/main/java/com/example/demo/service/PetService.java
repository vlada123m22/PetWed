package com.example.demo.service;

import com.example.demo.entity.Pet;

import java.util.List;

public interface PetService {
    Pet findById(Long petId);
    void savePet(Pet pet);
    void removePet(Integer petId);
    List<Pet> getPetsByBreed (Long breedId);
    List <Pet> allPets();
}
