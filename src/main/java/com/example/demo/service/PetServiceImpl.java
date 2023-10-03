package com.example.demo.service;

import com.example.demo.dto.AddNewPetRequestDTO;
import com.example.demo.entity.Breeds;
import com.example.demo.entity.Pet;
import com.example.demo.repository.BreedRepository;
import com.example.demo.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService{
    private final PetRepository petRepository;
    private final BreedRepository breedRepository;

    public PetServiceImpl(PetRepository petRepository, BreedRepository breedRepository) {
        this.petRepository = petRepository;
        this.breedRepository = breedRepository;
    }

    @Override
    public Pet savePet(AddNewPetRequestDTO addNewPetRequestDTO) {
        Pet newPet = new Pet();
        newPet.setNickname(addNewPetRequestDTO.getNickname());
        //TODO newPet.setUser(the user who is adding the pet);

        //TODO the list breedsForSpecies will be used later in the dropdown list to display all the species of the specified breed
        List<Breeds> breedsForSpecies=breedRepository.getBySpecies(addNewPetRequestDTO.getSpecies());
        Breeds breed= breedRepository.getByName(addNewPetRequestDTO.getBreed());
        newPet.setBreed(breed);
        newPet.setRegion(addNewPetRequestDTO.getRegion());
        newPet.setCity(addNewPetRequestDTO.getCity());
        return newPet;
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
