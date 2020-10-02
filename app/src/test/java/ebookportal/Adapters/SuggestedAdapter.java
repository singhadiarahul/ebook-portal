package com.example.ebookportal.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebookportal.R;

import java.util.List;

public class SuggestedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<ListItem> items;

    public SuggestedAdapter(Context context, List<ListItem> list){
        this.context = context;
        this.items = list;
        setHasStableIds(true);
    }

    private static class CourseViewHolder extends RecyclerView.ViewHolder{
        TextView courseTextView;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTextView = itemView.findViewById(R.id.courseTextView);
        }
    }

    private class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView bookTextView;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookTextView = itemView.findViewById(R.id.bookTextView);
            bookTextView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("downloading", String.valueOf(getAdapterPosition()));
            download(getAdapterPosition());
        }
    }

    public void download(int pos){
        // download here from firebase to internal storage
        Toast.makeText(context, "downloading.." + pos, Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case ListItem.TYPE_BOOK: {
                View itemView = inflater.inflate(R.layout.view_list_item_book, parent, false);
                return new BookViewHolder(itemView);
            }
            case ListItem.TYPE_COURSE: {
                View itemView = inflater.inflate(R.layout.view_list_item_course, parent, false);
                return new CourseViewHolder(itemView);
            }
            default:
                throw new IllegalStateException("unsupported item type");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case ListItem.TYPE_BOOK: {
                BookItem bookItem = (BookItem) items.get(position);
                BookViewHolder holder = (BookViewHolder) viewHolder;
                // your logic here
                holder.bookTextView.setText(bookItem.getBookString());
                break;
            }
            case ListItem.TYPE_COURSE: {
                CourseItem courseItem = (CourseItem) items.get(position);
                CourseViewHolder holder = (CourseViewHolder) viewHolder;
                 // your logic here
                holder.courseTextView.setText(courseItem.getCourse());
                break;
            }
            default:
                throw new IllegalStateException("unsupported item type");
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }

    @Override
    public long getItemId(int position){
        return position;
    }
}
