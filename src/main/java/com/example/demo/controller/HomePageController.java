package com.example.demo.controller;

import com.example.demo.entity.Pet;
import com.example.demo.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomePageController {
    private final PetService petService;

    public HomePageController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/")
    public String getHomePage(Model model){
//        List<Pet> allPets = petService.allPets();
//        model.addAttribute("pets", allPets);
//        model.addAttribute("pageContent", "home-body");
//        model.addAttribute("pageTitle", "Petwed");

        return "home";
    }
}
