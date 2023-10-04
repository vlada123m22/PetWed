package com.example.demo.controller;

import com.example.demo.dto.AddNewUserRequestDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatusCode;
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


    @GetMapping(value = "/login.html")
    public String getLoginPage(Model model) {
        model.addAttribute("pageTitle", "Login");
        model.addAttribute("pageContent", "login");
        return "authentication-layout";
    }

    @GetMapping(value = "/registration.html")
    public String getRegistrationPage(Model model) {
        model.addAttribute("pageTitle", "Registration Page");
        model.addAttribute("pageContent", "registration");

        return "authentication-layout";
    }


    //TODO open user's profile after registration
    @PostMapping("/add-new-user")
    public ResponseEntity<String> addNewUser(@RequestBody AddNewUserRequestDTO registryRequest) {
        User newUser = null;
        if (Objects.nonNull(registryRequest) && (registryRequest.getPassword().equals(registryRequest.getPasswordForCheck()))) {
            newUser  =     userService.saveUser(registryRequest);
        }
        if(Objects.nonNull(newUser)){

            return ResponseEntity.ok("success");

        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }

    }
}