package com.exampleapp.testapp.repository;

import androidx.lifecycle.LiveData;

import com.exampleapp.testapp.db.NotesDao;
import com.exampleapp.testapp.entity.Note;
import com.exampleapp.testapp.utils.AppInit;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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

    public void updateNote(Note note) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> dao.update(note));
        executor.shutdown();

        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getDataById(int id) {

        Callable<String> task = (() -> dao.getDataById(id));
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(task);
        executor.shutdown();

        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteNote(int id) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> dao.deleteNote(id));
        executor.shutdown();

        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
