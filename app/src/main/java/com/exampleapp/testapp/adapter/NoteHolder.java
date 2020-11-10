package com.exampleapp.testapp.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.exampleapp.testapp.R;
import com.exampleapp.testapp.entity.Note;

public class NoteHolder extends RecyclerView.ViewHolder {

    private final View mView;

    public NoteHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
    }

    void bind(NoteAdapter.NoteClickListener listener, Note item) {
        TextView textView = mView.findViewById(R.id.note_text_view);
        textView.setText(item.getNote());
        textView.setOnClickListener(view -> listener.click(item.getId()));

        ImageView imageView = mView.findViewById(R.id.delete_button);
        imageView.setOnClickListener(buttonView -> listener.deleteItem(item.getId()));
    }
}
