package com.exampleapp.testapp;

import androidx.lifecycle.LiveData;

import com.exampleapp.testapp.db.NotesDao;
import com.exampleapp.testapp.entity.Note;
import com.exampleapp.testapp.utils.AppInit;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NoteRepository {

    private final NotesDao dao = AppInit.getDb().dao();

    public LiveData<List<Note>> getAll() {
        return dao.getData();
    }

    public void addNote(Note item) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> dao.insert(item));
        executor.shutdown();

        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
