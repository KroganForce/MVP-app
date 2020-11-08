package com.exampleapp.testapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.exampleapp.testapp.Note;
import com.exampleapp.testapp.R;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteHolder> {

    private final ItemClickListener mItemClickListener;
    private final List<Note> mList = new ArrayList<>();

    public NoteAdapter(ItemClickListener listener) {
        mItemClickListener = listener;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        holder.bind(mItemClickListener, mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void upDateList(List<Note> newList) {

     /*   DiffUtil.DiffResult diffResult =
                DiffUtil.calculateDiff(new DiffUtilCallback(this.mAllDataList, newList));*/
        mList.clear();
        mList.addAll(newList);
        notifyDataSetChanged();
        //   diffResult.dispatchUpdatesTo(this);
    }

    public interface ItemClickListener {
        void showDetailFragment(int id);
    }
}
