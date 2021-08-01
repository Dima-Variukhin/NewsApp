package com.example.myapplication;

public class Article {
    private String type;
    private String text;
    private long date;
    private String sectionName;
    private String url;

    public Article(String type, String text, long date, String sectionName, String url) {
        this.type = type;
        this.text = text;
        this.date = date;
        this.sectionName = sectionName;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public long getDate() {
        return date;
    }

    public String getSectionName() {
        return sectionName;
    }
}
