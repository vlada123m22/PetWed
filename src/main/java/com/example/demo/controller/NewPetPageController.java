package com.example.demo.controller;

import com.example.demo.dto.AddNewPetRequestDTO;
import com.example.demo.entity.Pet;
import com.example.demo.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

//TODO must work only from the user's profile
@Controller
public class NewPetPageController {
    private final PetService petService;

    public NewPetPageController(PetService petService) {
        this.petService = petService;
    }

    @Secured("REGISTERED")
    @GetMapping("/new-pet")
    public String newPet(Model model){
        model.addAttribute("pageTitle", "New Pet");
        model.addAttribute("pageContent", "new-pet");
        return "authentication-layout";
    }

    @Secured("REGISTERED")
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
