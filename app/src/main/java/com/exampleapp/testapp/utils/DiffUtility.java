package com.exampleapp.testapp.utils;

import androidx.recyclerview.widget.DiffUtil;

import com.exampleapp.testapp.entity.Note;

import java.util.List;

public class DiffUtility extends DiffUtil.Callback {

    private final List<Note> mOldList;
    private final List<Note> mNewList;

    public DiffUtility(List<Note> mOldList, List<Note> newList) {
        this.mOldList = mOldList;
        this.mNewList = newList;
    }

    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldList.get(oldItemPosition).getId() == (mNewList.get(newItemPosition).getId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Note oldNote = mOldList.get(oldItemPosition);
        Note newNote = mNewList.get(newItemPosition);
        return oldNote.getText().equals(newNote.getText());
    }
}
