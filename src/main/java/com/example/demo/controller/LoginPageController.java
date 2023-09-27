package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {
    @GetMapping("/")
    public String getLoginPage(Model model){
        model.addAttribute("pageContent", "login");
        model.addAttribute("pageTitle", "Petwed");
        return "layout";
    }
}
