package com.example.pocketbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(Model model){
        String message = "Guest";
        model.addAttribute("message", message);
        return "greeting";
    }

}
