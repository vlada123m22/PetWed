package com.example.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MessagesController {
    @Secured("REGISTERED")
    @GetMapping("/chats")
    public String getChats(Model model){
        model.addAttribute("pageTitle", "Chats");
        model.addAttribute("pageContent", "chats");
        return "layout";
    }

    @Secured("REGISTERED")
    @GetMapping("/messages/{id}")
    public String getMessages(Model model, @PathVariable String id){

        return "index";
    }


}
