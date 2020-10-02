package com.example.ebookportal.Model;

public class BookModel {
    String course;
    String book;
    String downloadBookLink;

    public BookModel(String course, String book, String downloadBookLink) {
        this.book = course;
        this.course = book;
        this.downloadBookLink = downloadBookLink;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getDownloadBookLink() {
        return downloadBookLink;
    }

    public void setDownloadBookLink(String downloadBookLink) {
        this.downloadBookLink = downloadBookLink;
    }
}
