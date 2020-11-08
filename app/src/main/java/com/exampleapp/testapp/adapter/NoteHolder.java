package com.exampleapp.testapp.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.exampleapp.testapp.Note;
import com.exampleapp.testapp.R;

public class NoteHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    private View mView;

    public NoteHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    void bind(NoteAdapter.ItemClickListener listener, Note item) {

        TextView textView = mView.findViewById(R.id.note_text_view);
        textView.setText(item.getNote());

        textView.setOnClickListener(view -> {
            listener.showDetailFragment(item.getId());
            Toast.makeText(mContext, "Click", Toast.LENGTH_SHORT).show();
        });
    }
}
