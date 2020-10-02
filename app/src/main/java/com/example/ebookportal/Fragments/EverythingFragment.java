package com.example.ebookportal.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ebookportal.Adapters.ListItem;
import com.example.ebookportal.R;

import java.util.ArrayList;
import java.util.List;

public class EverythingFragment extends Fragment {

    private List<ListItem> items = new ArrayList<>();

    public EverythingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_everything, container, false);
    }
}