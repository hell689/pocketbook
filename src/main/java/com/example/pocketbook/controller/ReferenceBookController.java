package com.example.pocketbook.controller;

import com.example.pocketbook.domain.ReferenceBook;
import com.example.pocketbook.repos.ReferenceBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReferenceBookController {
    @Autowired
    private ReferenceBookRepo bookRepo;

    @GetMapping("/refbook")
    public String referenceBookList(Model model){
        model.addAttribute("refbooks", bookRepo.findAll());
        return "refbook";
    }

    @PostMapping("/refbook/add")
    public String referenceBookAdd(@RequestParam String name){
        ReferenceBook referenceBook = new ReferenceBook(name);

        bookRepo.save(referenceBook);

        return "redirect:/refbook";
    }

}
