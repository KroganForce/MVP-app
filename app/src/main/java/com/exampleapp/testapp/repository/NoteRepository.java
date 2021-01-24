package com.exampleapp.testapp.repository;

import androidx.lifecycle.LiveData;

import com.exampleapp.testapp.db.NotesDao;
import com.exampleapp.testapp.entity.Note;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class NoteRepository {

    private final NotesDao mDao;
    private Note mNote;

    @Inject
    public NoteRepository(NotesDao dao) {
        mDao = dao;
    }

    public LiveData<List<Note>> getAll() {
        return mDao.getData();
    }

    public void addNote(String text) {
        mNote = new Note();
        mNote.setText(text);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> mDao.insert(mNote));
        executor.shutdown();

        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateNote(int id, String text) {
        mNote = new Note();
        mNote.setId(id);
        mNote.setText(text);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> mDao.update(mNote));
        executor.shutdown();

        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getDataById(int id) {
        Callable<String> task = (() -> mDao.getDataById(id));
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
        executor.submit(() -> mDao.deleteNote(id));
        executor.shutdown();

        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}