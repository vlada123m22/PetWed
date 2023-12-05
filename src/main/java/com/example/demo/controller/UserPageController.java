package com.example.demo.controller;

import com.example.demo.dto.UserProfileDTO;
import com.example.demo.entity.Breed;
import com.example.demo.entity.Pet;
import com.example.demo.entity.User;
import com.example.demo.service.PetService;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


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
    public String getPersonalProfilePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email= authentication.getName();
        User user = userService.getUserByEmail(email);
        List<Pet> pets = petService.getPetsByUserId(user.getId());
        model.addAttribute("pets", pets);
        model.addAttribute("personalPets", pets);
        model.addAttribute("user", user);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("pageTitle", "Profile");
        model.addAttribute("pageContent", "personal-profile-body");
        return "layout";
    }

    @Secured("REGISTERED")
    @GetMapping("/profile/edit")
    public String getEditProfilePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email= authentication.getName();
        User authorisedUser = userService.getUserByEmail(email);
        List<Pet> personalPets=petService.getPetsByUserId(authorisedUser.getId());
        model.addAttribute("personalPets", personalPets);
        model.addAttribute("user", authorisedUser);
        model.addAttribute("firstName", authorisedUser.getFirstName());
        model.addAttribute("lastName", authorisedUser.getLastName());
        model.addAttribute("pageTitle", "Edit Profile");
        model.addAttribute("pageContent", "edit-user-profile");
        return "layout";
    }


    @GetMapping("/profile/{userId}")
    public String getProfilePage(Model model, @PathVariable Long userId) {
        User user = userService.getUserById(userId);
        List<Pet> pets = petService.getPetsByUserId(user.getId());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email= authentication.getName();
        User authorisedUser = userService.getUserByEmail(email);
        List<Pet> personalPets=petService.getPetsByUserId(authorisedUser.getId());
        model.addAttribute("personalPets", personalPets);
        model.addAttribute("pets", pets);
        model.addAttribute("user", user);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("pageTitle", "Profile");
        model.addAttribute("pageContent", "user-profile-body");
        return "layout";
    }

    @Secured("REGISTERED")
    @PostMapping("/update-user-profile")
    public ResponseEntity<String> updateUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
        userService.updateUserProfile(userProfileDTO);
        return ResponseEntity.ok("Success");
    }

}
