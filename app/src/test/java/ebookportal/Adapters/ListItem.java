package com.example.ebookportal.Adapters;

public abstract class ListItem{
    public static final int TYPE_COURSE = 0;
    public static final int TYPE_BOOK = 1;

    abstract public int getType();
}
