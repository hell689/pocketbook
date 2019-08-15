package com.example.pocketbook.service;

import com.example.pocketbook.util.newsparser.HttpPage;
import com.example.pocketbook.util.newsparser.NewsAddresses;
import com.example.pocketbook.util.newsparser.NewsTitlesFinder;
import com.example.pocketbook.util.newsparser.NewsUrlTimeTitle;
import com.example.pocketbook.util.newsparser.finderimpl.ChampionatAutoLastNewsFinder;
import com.example.pocketbook.util.newsparser.finderimpl.TutByLastNewsTitleFinder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Override
    public List<NewsUrlTimeTitle> getNewsFromSite(NewsAddresses address, int countNews) {
        NewsTitlesFinder titlesFinder = null;
        switch (address) {
            case TUT_BY:
                titlesFinder = new TutByLastNewsTitleFinder();
                break;
            case CHAMPIONAT_AUTO:
                titlesFinder = new ChampionatAutoLastNewsFinder();
                break;
        }
        HttpPage httpPage = new HttpPage(address.getAddress(), address.getCharset());
        return titlesFinder.getTitlesFromHTML(httpPage.getContent(), countNews);
    }
}
