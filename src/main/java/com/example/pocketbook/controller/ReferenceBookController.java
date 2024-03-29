package com.example.pocketbook.controller;

import com.example.pocketbook.domain.Reference.ReferenceBook;
import com.example.pocketbook.domain.Reference.ReferenceRecord;
import com.example.pocketbook.repos.ReferenceBookRepo;
import com.example.pocketbook.repos.ReferenceRecordRepo;
import com.example.pocketbook.util.comparators.RefRecordComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.NoSuchElementException;
@Controller
public class ReferenceBookController {
    @Autowired
    private ReferenceBookRepo bookRepo;
    @Autowired
    private ReferenceRecordRepo recordRepo;

    @GetMapping("/refbook")
    public String referenceBookList(Model model){
        List<ReferenceBook> refBooks = (List<ReferenceBook>) bookRepo.findAll();
        refBooks.sort(((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())));
        model.addAttribute("refbooks", refBooks);
        return "refbook";
    }

    @GetMapping("/refbook/{referenceBook}")
    public String referenceBookFromId(
            @PathVariable ReferenceBook referenceBook,
            Model model
    ){
        model.addAttribute("refbook", referenceBook);
        List<ReferenceRecord> refRecords = referenceBook.getReferenceRecords();
        refRecords.sort(new RefRecordComparator());
        model.addAttribute("refrecords", refRecords);
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
}
