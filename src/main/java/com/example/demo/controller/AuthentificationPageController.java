package com.example.demo.controller;

import com.example.demo.dto.AddNewUserRequestDTO;
import com.example.demo.entity.Usser;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Controller
public class AuthentificationPageController {

    private final UserService userService;

    public AuthentificationPageController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("pageTitle", "Login");
        model.addAttribute("pageContent", "login");
        return "layout";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model){
        model.addAttribute("pageTitle", "Register");
        model.addAttribute("pageContent", "registration");
        return "layout";
    }

    @PostMapping("/add-new-user")
    public ResponseEntity<String> addNewUser(@RequestBody AddNewUserRequestDTO registryRequest) {
        Usser newUser = null;
        if (Objects.nonNull(registryRequest) && (registryRequest.getPassword().equals(registryRequest.getPasswordForCheck()))) {
            newUser  =     userService.saveUser(registryRequest);
        }
        if(Objects.isNull(newUser) && Objects.nonNull(newUser.getId())){
            return ResponseEntity.ok("success");

        } else {
            return ResponseEntity.ok("fail");
        }

    }
}