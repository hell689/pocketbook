package com.example.pocketbook.controller;

import com.example.pocketbook.service.NewsService;
import com.example.pocketbook.util.newsparser.NewsAddresses;
import com.example.pocketbook.util.newsparser.NewsUrlTimeTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TutAutoPressController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/latestnews")
    public String latestNews(Model model) {

        List<NewsUrlTimeTitle> tutNews = newsService.getNewsFromSite(NewsAddresses.TUT_BY, 0);
        List<NewsUrlTimeTitle> autonews = newsService.getNewsFromSite(NewsAddresses.CHAMPIONAT_AUTO, 0);
        model.addAttribute("tutnews", tutNews);
        model.addAttribute("autonews", autonews);

        return "latestnews";
    }
}
