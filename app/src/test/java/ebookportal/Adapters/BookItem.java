package com.example.ebookportal.Adapters;

import androidx.annotation.NonNull;

public class BookItem extends ListItem {
    private String bookString;
    private String bookDownloadLink;

    public BookItem(@NonNull String bookString, @NonNull String bookDownloadLink) {
        this.bookString = bookString;
        this.bookDownloadLink = bookDownloadLink;
    }

    @NonNull
    public String getBookString() {
        return bookString;
    }

    @NonNull
    public String getBookDownloadLink(){
        return bookDownloadLink;
    }

    // here getters and setters
    // for title and so on, built

    @Override
    public int getType() {
        return TYPE_BOOK;
    }
}
