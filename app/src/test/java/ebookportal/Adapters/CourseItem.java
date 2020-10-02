package com.example.ebookportal.Adapters;

import androidx.annotation.NonNull;

public class CourseItem extends ListItem {
    private String courseString;

    public CourseItem(@NonNull String courseString) {
        this.courseString = courseString;
    }

    @NonNull
    public String getCourse() {
        return courseString;
    }

    // here getters and setters
    // for title and so on, built

    @Override
    public int getType() {
        return TYPE_COURSE;
    }
}
