package com.example.demo.controller;


import com.example.demo.entity.Pet;
import com.example.demo.entity.User;
import com.example.demo.service.PetService;
import com.example.demo.service.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomePageController {
    private final UserService userService;
    private final PetService petService;

    public HomePageController(UserService userService, PetService petService) {
        this.userService = userService;
        this.petService = petService;
    }


    // @Secured("REGISTERED")
    @GetMapping({"/home"})
    public String getRecomendations(Model model){


        List<Pet> pets = petService.allPets();
        Map<Pet,Integer> petAge=new HashMap<>();
        for (Pet p: pets) {
            petAge.put(p,petService.getAge(p));
        }
        model.addAttribute("petAge", petAge);
        model.addAttribute("pageContent", "home-body");
        model.addAttribute("pageTitle", "Home");
        return "layout";
    }
    @Secured("REGISTERED")
    @GetMapping({"/home/{petId}"})
    public String getHomePage(Model model, @PathVariable Long petId){
        Pet pet = petService.getPetById(petId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email= authentication.getName();
        User user = userService.getUserByEmail(email);
        if (pet.getUser()!=user){
            return "Whitelabel-page";
        }

        List<Pet> suitablePets = petService.getSuitablePets(petId,user.getId());
        Map<Pet,Integer> petAge=new HashMap<>();
        for (Pet p: suitablePets) {
            petAge.put(p,petService.getAge(p));
        }
        model.addAttribute("petAge", petAge);
        model.addAttribute("pageContent", "home-body");
        model.addAttribute("pageTitle", "Home");
        return "layout";
    }



    @PutMapping("/like-dislike/{like}/{petFromId}/{petToId}")
    public void likeDislikePet(@PathVariable boolean like, @PathVariable Long petFromId, @PathVariable Long petToId){
        petService.likeDislikePet(like, petFromId, petToId);
    }
}
