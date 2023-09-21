package com.example.demo.controller;

import com.example.demo.entity.Usser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginPageController {
    @Autowired Usser user;

}
