package com.example.pocketbook.util.newsparser;

public class NewsUrlTimeTitle {
    private String url;
    private String title;
    private String time;

    public NewsUrlTimeTitle() {
    }

    public NewsUrlTimeTitle(String url, String title, String time) {
        this.url = url;
        this.title = title;
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
