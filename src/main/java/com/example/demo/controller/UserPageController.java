package com.example.demo.controller;

import com.example.demo.entity.Pet;
import com.example.demo.entity.User;
import com.example.demo.service.PetService;
import com.example.demo.service.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//TODO this controller will work only if the user is logged in
@Controller
public class UserPageController {
    private final UserService userService;
    private final PetService petService;

    public UserPageController(UserService userService, PetService petService) {
        this.userService = userService;
        this.petService = petService;
    }


    @Secured("REGISTERED")
    @GetMapping("/profile")
    public String getProfilePage(Model model) {
        User user = userService.getUserById(1); //TODO user = userul care s-a logat
        List<Pet> pets = petService.getPetsByUser(user.getId());
        model.addAttribute("pets", pets);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("pageTitle", "Profile");
        model.addAttribute("pageContent", "user-profile-body");
        return "layout";
    }



//    will return the page with the potential partners for your pet
    @Secured("REGISTERED")
    @GetMapping({"/home"})
    public String getHomePage(Model model){
        List<Pet> allPets = petService.allPets();
        model.addAttribute("pets", allPets);
        model.addAttribute("pageContent", "home-body");
        model.addAttribute("pageTitle", "Petwed");
        return "home";
    }
}
