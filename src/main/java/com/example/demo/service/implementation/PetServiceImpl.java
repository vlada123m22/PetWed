package com.example.demo.service.implementation;

import com.example.demo.dto.AddNewPetRequestDTO;
import com.example.demo.entity.Breed;
import com.example.demo.entity.Pet;
import com.example.demo.repository.BreedRepository;
import com.example.demo.repository.PetRepository;
import com.example.demo.service.PetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
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
        List<Breed> breedsForSpecies=breedRepository.getBySpecies(addNewPetRequestDTO.getSpecies());
        Breed breed= breedRepository.getByName(addNewPetRequestDTO.getBreed());
        newPet.setBreed(breed);
        newPet.setRegion(addNewPetRequestDTO.getRegion());
        newPet.setCity(addNewPetRequestDTO.getCity());
        return petRepository.save(newPet);
    }

    @Override
    public List<Pet> getPetsByUserId(Long userId) {
        return petRepository.getPetsByUserId(userId);
    }

    @Override
    public List<Pet> allPets() {
        return petRepository.allPets();
    }

    @Override
    public Pet getPetById(long petId) {
        return petRepository.getById(petId);
    }

//    @Override
//    public int getAge(Pet pet) {
//        return petRepository.getAge(pet.getId());
//    }
}
