package com.example.demo.service;

import com.example.demo.entity.Pet;

import java.util.List;

public interface PetService {
    List<Pet> getPetsByUser(Long userId);
    List <Pet> allPets();
}
