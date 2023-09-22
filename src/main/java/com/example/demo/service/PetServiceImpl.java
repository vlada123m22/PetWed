package com.example.demo.service;

import com.example.demo.entity.Pet;
import com.example.demo.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService{
    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    } //Could not autowire. Why?

    @Override
    public Pet findById(Long petId) {
        return null;
    }

    @Override
    public void savePet(Pet pet) {

    }

    @Override
    public void removePet(Integer petId) {

    }

    @Override
    public List<Pet> getPetsByBreed(Long breedId) {
        return null;
    }

    @Override
    public List<Pet> allPets() {
        return petRepository.allPets();
    }
}
