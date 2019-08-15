package com.example.pocketbook.util.newsparser.finderimpl;

import com.example.pocketbook.util.newsparser.NewsTitlesFinder;
import com.example.pocketbook.util.newsparser.NewsUrlTimeTitle;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChampionatAutoLastNewsFinder implements NewsTitlesFinder {

    private final String TITLE_REGEXP  =
            "<li class=\"news-item\">[a-z<>\\n =\"\\-_]+([0-9:]+)[a-z<>\\/=\\n ]+\"news-item__content\">[a-z\\n <>=]+\"" +
                    "(https:[a-z0-9:\\/.-]+)\"[a-z =\"_\\-\\n ]+data-event-label=\"([A-Za-zА-Яа-яё0-9 :\\-—,!?.«»]+)";

    @Override
    public List<NewsUrlTimeTitle> getTitlesFromHTML(String htmlString, int countNews) {
        List<NewsUrlTimeTitle> newsTitles = new ArrayList<>();
        Pattern pattern = Pattern.compile(TITLE_REGEXP);
        Matcher matcher = pattern.matcher(htmlString);
        while (matcher.find()) {
            String newsUrl = matcher.group(2);
            String newsTitle = matcher.group(3);
            String newsTime = matcher.group(1);
            newsTitles.add(new NewsUrlTimeTitle(newsUrl, newsTitle, newsTime));
            countNews--;
            if (countNews == 0) break;
        }
        return newsTitles;
    }
}
