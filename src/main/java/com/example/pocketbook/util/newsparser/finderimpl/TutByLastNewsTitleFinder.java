package com.example.pocketbook.util.newsparser.finderimpl;

import com.example.pocketbook.util.newsparser.NewsTitlesFinder;
import com.example.pocketbook.util.newsparser.NewsUrlTimeTitle;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TutByLastNewsTitleFinder implements NewsTitlesFinder {
    private final String TITLE_REGEXP  =
            "data-vr-contentbox-url=\\\"([a-z0-9:\\/.]+)\\\"><span class=\\\"entry-cnt\\\"><span class=\\\"entry-head _title\\\" data-vr-headline>" +
                    "([А-Яа-яA-Z0-9 \\-,a-z;:.&?!]+)<\\/span><span class=\\\"entry-meta\\\">[<>a-z0-9\\\"\\- =\\/]+<\\/span>" +
                    "<span class=\\\"entry-time\\\"><span data-ctime=\\\"[0-9]+\\\">([0-9:]+)<\\/span>";

    @Override
    public List<NewsUrlTimeTitle> getTitlesFromHTML(String htmlString, int countNews) {
        List<NewsUrlTimeTitle> newsTitles = new ArrayList<>();
        Pattern pattern = Pattern.compile(TITLE_REGEXP);
        Matcher matcher = pattern.matcher(htmlString);
        while (matcher.find()) {
            String newsUrl = matcher.group(1);
            String newsTitle = matcher.group(2)
                    .replace("&laquo;", "\"")
                    .replace("&raquo;", "\"")
                    .replace("&nbsp;", " ")
                    .replace("&mdash;", "-");
            String newsTime = matcher.group(3);
            newsTitles.add(new NewsUrlTimeTitle(newsUrl, newsTitle, newsTime));
            countNews--;
            if (countNews == 0) break;
        }
        return newsTitles;
    }
}