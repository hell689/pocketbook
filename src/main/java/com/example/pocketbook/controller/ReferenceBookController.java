package com.example.pocketbook.controller;

import com.example.pocketbook.domain.ReferenceBook;
import com.example.pocketbook.domain.ReferenceRecord;
import com.example.pocketbook.repos.ReferenceBookRepo;
import com.example.pocketbook.repos.ReferenceRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.NoSuchElementException;

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
        model.addAttribute("refrecords", referenceBook.getReferenceRecords());
        return "refbookedit";
    }

    @PostMapping("refbook/add")
    public String referenceBookAdd(@RequestParam String name, Model model){
        if (!name.isEmpty()){
            if (bookRepo.findByName(name) == null){
                ReferenceBook referenceBook = new ReferenceBook(name);
                bookRepo.save(referenceBook);
            } else {
                model.addAttribute("errorMessage", "Справочник с таким именем уже существует");
            }
        } else {
            model.addAttribute("errorMessage", "Имя справочника не может быть пустым");
        }
        model.addAttribute("refbooks", bookRepo.findAll());
        return "refbook";
    }

    @PostMapping("refbook/del")
    public String referenceBookDel(@RequestParam Long id, Model model){
        ReferenceBook referenceBook = bookRepo.findById(id).orElseThrow(
                () -> new NoSuchElementException(id + " not Found!")
        );
        if (referenceBook.getReferenceRecords().isEmpty()){
            bookRepo.delete(referenceBook);
        } else {
            model.addAttribute("errorMessage", "Нельзя удалить непустой справочник");
        }
        model.addAttribute("refbooks", bookRepo.findAll());

        return "refbook";
    }

    @PostMapping("/refbook/addrecord")
    public String referenceBookAddRecord(
            @RequestParam Long idrefbook,
            @RequestParam String name,
            Model model
    ){
        if (!name.isEmpty() && idrefbook != null){
            ReferenceBook referenceBook = bookRepo.findById(idrefbook).orElseThrow(
                    () -> new NoSuchElementException(idrefbook + " not Found!")
            );
            ReferenceRecord referenceRecord = new ReferenceRecord(name, referenceBook);
            recordRepo.save(referenceRecord);
        }
        return "redirect:/refbook/" + idrefbook;
    }

    @PostMapping("/refbook/delrecord")
    public String referenceBookDelRecord(
            @RequestParam Long id,
            @RequestParam Long idrefbook
    ){
        recordRepo.deleteById(id);
        return "redirect:/refbook/" + idrefbook;
    }

}
