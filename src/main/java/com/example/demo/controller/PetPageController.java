package com.example.demo.controller;

import com.example.demo.dto.AddNewPetRequestDTO;
import com.example.demo.dto.UserProfileDTO;
import com.example.demo.entity.Pet;
import com.example.demo.entity.User;
import com.example.demo.service.PetService;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TODO must work only from the user's profile
@Controller
public class PetPageController {
    private final PetService petService;
    private final UserService userService;

    public PetPageController(PetService petService, UserService userService) {
        this.petService = petService;
        this.userService = userService;
    }

    @Secured("REGISTERED")
    @GetMapping("/new-pet")
    public String newPet(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User authorisedUser = userService.getUserByEmail(email);
        List<Pet> personalPets = petService.getPetsByUserId(authorisedUser.getId());
        model.addAttribute("personalPets", personalPets);
        model.addAttribute("pageTitle", "New Pet");
        model.addAttribute("pageContent", "new-pet");
        return "authentication-layout";
    }


    @Secured("REGISTERED")
    @GetMapping("/personal-pet/{petId}")
    public String getPersonalPetProfilePage(Model model, @PathVariable Long petId) {
        Pet pet = petService.getPetById(petId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userService.getUserByEmail(email);
        if (pet.getUser() != user) {
            return "Whitelabel-page";
        }

        List<Pet> personalPets = petService.getPetsByUserId(user.getId());

        petService.computeAge(pet);
        model.addAttribute("personalPets", personalPets);
        model.addAttribute("pet", pet);
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "Pet profile");
        model.addAttribute("pageContent", "personal-pet-profile-body");
        return "layout";
    }


    @GetMapping("/pet/{petId}")
    public String getPetProfilePage(Model model, @PathVariable Long petId) {
        Pet pet = petService.getPetById(petId);
        petService.computeAge(pet);
        User user = userService.getUserByPetId(petId);
        List<Pet> personalPets;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User authorisedUser = userService.getUserByEmail(email);
        if (Objects.nonNull(authorisedUser)) {
            personalPets = petService.getPetsByUserId(authorisedUser.getId());
        } else {
            personalPets = new ArrayList<>();
        }
        model.addAttribute("personalPets", personalPets);
        model.addAttribute("pet", pet);
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "Pet profile");
        model.addAttribute("pageContent", "pet-profile-body");
        return "layout";
    }

    @Secured("REGISTERED")
    @GetMapping("personal-pet/edit/{petId}")
    public String getEditPetPage(Model model, @PathVariable Long petId) {
        Pet pet = petService.getPetById(petId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userService.getUserByEmail(email);
        if (pet.getUser() != user) {
            return "Whitelabel-page";
        }
        List<Pet> personalPets = petService.getPetsByUserId(user.getId());
        model.addAttribute("personalPets", personalPets);
        model.addAttribute("pet", pet);
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "Edit pet profile");
        model.addAttribute("pageContent", "edit-pet-profile");
        return "layout";
    }


    @PostMapping("/add-new-pet")
    public ResponseEntity<String> addNewPet(@RequestBody AddNewPetRequestDTO newPetRequest) {
        Pet newPet = null;
        if (Objects.nonNull(newPetRequest)) {
            newPet = petService.savePet(newPetRequest);
        }
        if (Objects.nonNull(newPet)) {

            return ResponseEntity.ok("success");

        } else {
            return ResponseEntity.ok("fail");
        }

    }

    @Secured("REGISTERED")
    @PostMapping("/update-pet-profile")
    public ResponseEntity<String> addNewUser(@RequestBody UserProfileDTO userProfileDTO) {
        userService.updateUserProfile(userProfileDTO);
        return ResponseEntity.ok("Success");
    }

}
