package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewPageController {
    @GetMapping("/new-page")
    public String getNewPage(Model model){

        model.addAttribute("pageContent", "new-page-body");
        model.addAttribute("pageTitle", "Petwed");
        return "layout";
    }
}
