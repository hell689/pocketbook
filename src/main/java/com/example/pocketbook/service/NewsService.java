package com.example.pocketbook.service;

import com.example.pocketbook.util.newsparser.NewsAddresses;
import com.example.pocketbook.util.newsparser.NewsUrlTimeTitle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {

    List<NewsUrlTimeTitle> getNewsFromSite(NewsAddresses address, int countNews);
}
