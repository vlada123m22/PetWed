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
    }

    @Override
    public List<Pet> getPetsByUser(Long userId) {
        return null;
    }

    @Override
    public List<Pet> allPets() {
        return petRepository.allPets();
    }
}
