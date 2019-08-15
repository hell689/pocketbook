package com.example.pocketbook.util.newsparser;

import java.util.List;

public interface NewsTitlesFinder {

    List<NewsUrlTimeTitle> getTitlesFromHTML(String htmlString, int countNews);
}
