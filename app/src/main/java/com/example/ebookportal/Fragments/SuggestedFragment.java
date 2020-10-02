package com.example.ebookportal.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ebookportal.Adapters.BookItem;
import com.example.ebookportal.Adapters.CourseItem;
import com.example.ebookportal.Adapters.ListItem;
import com.example.ebookportal.Adapters.SuggestedAdapter;
import com.example.ebookportal.Model.BookModel;
import com.example.ebookportal.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SuggestedFragment extends Fragment {

    private List<ListItem> items;
    private RecyclerView recyclerView;

    public SuggestedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_suggested, container, false);
        items = new ArrayList<>();
        Map<String, List<BookModel>> events = toMap(load());
        for(String s : events.keySet()){
            CourseItem course = new CourseItem(s);
            items.add(course);
            for(BookModel bookModel : events.get(s)){
                BookItem item = new BookItem(bookModel.getCourse(), bookModel.getDownloadBookLink());
                items.add(item);
            }
        }
        recyclerView = view.findViewById(R.id.suggestedRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new SuggestedAdapter(getContext(), items));
        return view;
    }

    @NonNull
    private List<BookModel> load(){
        List<BookModel> bookModels = new ArrayList<>();
        for(int i=0; i<5; ++i){
            bookModels.add(new BookModel("DSA", "DSA book", "www.exampleBook.com"));
        }
        for(int i=0; i<5; ++i){
            bookModels.add(new BookModel("NA", "NA book", "www.exampleBook.com"));
        }
        for(int i=0; i<5; ++i){
            bookModels.add(new BookModel("EDC", "EDC book", "www.exampleBook.com"));
        }
        return bookModels;
    }

    @NonNull
    private Map<String, List<BookModel>> toMap(List<BookModel> lists) {
        Map<String, List<BookModel>> map = new TreeMap<>();
        for (BookModel bookModel : lists){
            List<BookModel> tempCourse = map.get(bookModel.getBook());
            if(tempCourse==null){
                tempCourse = new ArrayList<>();
                map.put(bookModel.getBook(), tempCourse);
            }
            tempCourse.add(bookModel);
        }
        return map;
    }
}