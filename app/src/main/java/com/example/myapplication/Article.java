package com.example.myapplication;

public class Article {
    private final String author;
    private final String text;
    private final String date;
    private final String sectionName;
    private final String url;

    public Article(String author, String text, String date, String sectionName, String url) {
        this.author = author;
        this.text = text;
        this.date = date;
        this.sectionName = sectionName;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public String getSectionName() {
        return sectionName;
    }
}
