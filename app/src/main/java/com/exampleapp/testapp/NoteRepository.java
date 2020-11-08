package com.exampleapp.testapp;

import androidx.lifecycle.LiveData;

import com.exampleapp.testapp.db.NotesDao;

import java.util.List;

public class NoteRepository {

    private final NotesDao dao = AppInit.getDb().dao();

    public LiveData<List<Note>> getAll() {
        return dao.getData();
    }
}
