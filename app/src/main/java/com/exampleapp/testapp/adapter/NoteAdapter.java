package com.exampleapp.testapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.exampleapp.testapp.entity.Note;
import com.exampleapp.testapp.R;
import com.exampleapp.testapp.utils.DiffUtility;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteHolder> {

    private final NoteClickListener mNoteClickListener;
    private final List<Note> mList = new ArrayList<>();

    public NoteAdapter(NoteClickListener listener) {
        mNoteClickListener = listener;
    }

    public interface NoteClickListener {
        void clickOnNote(int id);

        void deleteItem(int id);
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        holder.bind(mNoteClickListener, mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void updateList(List<Note> newList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtility(mList, newList));
        mList.clear();
        mList.addAll(newList);
        diffResult.dispatchUpdatesTo(this);
    }
}
