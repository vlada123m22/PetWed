package com.example.demo.controller;

import com.example.demo.dto.AddNewPetRequestDTO;
import com.example.demo.entity.Pet;
import com.example.demo.entity.User;
import com.example.demo.service.PetService;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    //@Secured("REGISTERED")
    @GetMapping("/new-pet")
    public String newPet(Model model){
        model.addAttribute("pageTitle", "New Pet");
        model.addAttribute("pageContent", "new-pet");
        return "authentication-layout";
    }

    @GetMapping("/pet/{petId}")
    public String getPetProfilePage(Model model,@PathVariable Long petId) {
        Pet pet = petService.getPetById(petId);
        User user = userService.getUserByPetId(petId);
        model.addAttribute("pet", pet);
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "Pet profile");
        model.addAttribute("pageContent", "pet-profile-body");
        return "layout";
    }



    @PostMapping("/add-new-pet")
    public ResponseEntity<String> addNewUser(@RequestBody AddNewPetRequestDTO newPetRequest) {
        Pet newPet=null;
        if (Objects.nonNull(newPetRequest)) {
            newPet  =     petService.savePet(newPetRequest);
        }
        if(Objects.nonNull(newPet)){

            return ResponseEntity.ok("success");

        } else {
            return ResponseEntity.ok("fail");
        }

    }
}
