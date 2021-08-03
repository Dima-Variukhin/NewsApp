package com.example.myapplication;

public class Article {
    private String author;
    private String text;
    private String date;
    private String sectionName;
    private String url;

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
