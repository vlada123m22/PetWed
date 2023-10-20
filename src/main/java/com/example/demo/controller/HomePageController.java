package com.example.demo.controller;


import com.example.demo.dto.AppreciatingDTO;
import com.example.demo.dto.MessageDTO;
import com.example.demo.entity.Message;
import com.example.demo.entity.Pet;
import com.example.demo.entity.User;
import com.example.demo.service.LikeService;
import com.example.demo.service.MessageService;
import com.example.demo.service.PetService;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class HomePageController {
    private final UserService userService;
    private final PetService petService;
    private final LikeService likeService;
    private final MessageService messageService;

    public HomePageController(UserService userService, PetService petService, LikeService likeService, MessageService messageService) {
        this.userService = userService;
        this.petService = petService;
        this.likeService = likeService;
        this.messageService = messageService;
    }


    @Secured("REGISTERED")
    @GetMapping({"/home"})
    public String getHomePage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email= authentication.getName();
        User user = userService.getUserByEmail(email);
        model.addAttribute("pets", new ArrayList<>());
        List<Pet> personalPets=petService.getPetsByUserId(user.getId());
        model.addAttribute("personalPets", personalPets);
        model.addAttribute("pageContent", "home-body");
        model.addAttribute("pageTitle", "Home");
        return "layout";
    }
    @Secured("REGISTERED")
    @GetMapping({"/home/{petId}"})
    public String getRecommendations(Model model, @PathVariable Long petId){
        Pet pet = petService.getPetById(petId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email= authentication.getName();
        User user = userService.getUserByEmail(email);
        if (pet.getUser()!=user){
            return "Whitelabel-page";
        }
        List<Pet> personalPets=petService.getPetsByUserId(user.getId());
        List<Pet> suitablePets = petService.getSuitablePets(petId,user.getId());
        for (Pet p: suitablePets) {
            petService.computeAge(p);
        }
        model.addAttribute("personalPets", personalPets);
        model.addAttribute("pets", suitablePets);
        model.addAttribute("petFrom", petId);
        model.addAttribute("pageContent", "home-body");
        model.addAttribute("pageTitle", "Home");
        return "layout";
    }

    @Secured("REGISTERED")
    @PostMapping("/like/{petFromId}/{petToId}")
    public ResponseEntity<AppreciatingDTO> likePet(@PathVariable Long petFromId, @PathVariable Long petToId){
        likeService.likeDislikePet(true, petFromId, petToId);
        //TODO need to find a solution how to display modals from vanilla js
        //TODO after registry of this like need to check if it is a match
        //TODO if the method returns true return (new AppreciatingDTO("matching"))
        if (likeService.isMatch(petFromId,petToId)) return ResponseEntity.ok(new AppreciatingDTO("Match"));
        else return ResponseEntity.ok(new AppreciatingDTO("Not Match"));
    }

    @Secured("REGISTERED")
    @PostMapping("/dislike/{petFromId}/{petToId}")
    public ResponseEntity<String> dislikePet(@PathVariable Long petFromId, @PathVariable Long petToId){
        likeService.likeDislikePet(false, petFromId, petToId);
        return ResponseEntity.ok("success");
    }

    @Secured("REGISTERED")
    @PostMapping("/record-first-message/{petToId}")
    public ResponseEntity<String> recordFirsMessage(@RequestBody MessageDTO messageRequest, @PathVariable Long petToId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email= authentication.getName();
        User fromUser = userService.getUserByEmail(email);
        User toUser=userService.getUserByPetId(petToId);


        Message newMessage = null;
        if (Objects.nonNull(messageRequest)){
            newMessage  =     messageService.saveMessage(messageRequest,fromUser,toUser);

        }
        if(Objects.nonNull(newMessage)){

            return ResponseEntity.ok("success");

        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }
}