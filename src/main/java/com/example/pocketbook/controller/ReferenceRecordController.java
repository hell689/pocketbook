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
public class ReferenceRecordController {
    @Autowired
    private ReferenceBookRepo bookRepo;
    @Autowired
    private ReferenceRecordRepo recordRepo;

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

    @GetMapping("/refbook/refrecord/{referenceRecord}")
    public String referenceRecordEdit(
            @PathVariable ReferenceRecord referenceRecord,
            Model model
    ){
        model.addAttribute("refrecord", referenceRecord);
        return "refrecordedit";
    }

    @PostMapping("refbook/refrecord/save")
    public String referenceRecordSave(
            @RequestParam Long idrefrecord,
            @RequestParam String name,
            Model model
    ){
        ReferenceRecord referenceRecord = recordRepo.findById(idrefrecord).
                orElseThrow(() -> new NoSuchElementException());
        if (!name.isEmpty() && !name.equals(referenceRecord.getName())) {
            referenceRecord.setName(name);
            recordRepo.save(referenceRecord);
        }
        ReferenceBook referenceBook = referenceRecord.getReferenceBook();
        model.addAttribute("refbook", referenceBook);
        model.addAttribute("refrecords", referenceBook.getReferenceRecords());
        return "refbookedit";
    }
}
