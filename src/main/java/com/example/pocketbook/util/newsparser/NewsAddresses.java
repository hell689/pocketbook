package com.example.pocketbook.util.newsparser;

public enum NewsAddresses {
    TUT_BY("https://news.tut.by/?sort=time", "UTF-8"),
    CHAMPIONAT_AUTO("https://www.championat.com/auto/", "UTF-8");

    private String address;
    private String charset;

    NewsAddresses(String address, String charset) {
        this.address = address;
        this.charset = charset;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }
}
