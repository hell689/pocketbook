package com.example.pocketbook.controller;

import com.example.pocketbook.domain.ReferenceBook;
import com.example.pocketbook.repos.ReferenceBookRepo;
import com.example.pocketbook.repos.ReferenceRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReferenceBookController {
    @Autowired
    private ReferenceBookRepo bookRepo;
    @Autowired
    private ReferenceRecordRepo recordRepo;

    @GetMapping("/refbook")
    public String referenceBookList(Model model){
        model.addAttribute("refbooks", bookRepo.findAll());
        return "refbook";
    }

    @GetMapping("/refbook/{referenceBook}")
    public String referenceBookFromId(
            @PathVariable ReferenceBook referenceBook,
            Model model
    ){
        model.addAttribute("refbook", referenceBook);
        model.addAttribute("refrecords", recordRepo.findByReferenceBook(referenceBook));
        return "refbookedit";
    }

    @PostMapping("refbook/add")
    public String referenceBookAdd(@RequestParam String name){
        if (bookRepo.findByName(name) == null){
            ReferenceBook referenceBook = new ReferenceBook(name);
            bookRepo.save(referenceBook);
        }

        return "redirect:/refbook";
    }

    @PostMapping("refbook/del")
    public String referenceBookDel(@RequestParam Long id){
        bookRepo.deleteById(id);
        return "redirect:/refbook";
    }

}
