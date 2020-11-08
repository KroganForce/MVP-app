package com.exampleapp.testapp;

import androidx.lifecycle.LifecycleOwner;

public class NotePresenter {

    private UiContract mView;
    private final NoteRepository mNoteRepository;

    public NotePresenter(NoteRepository repository) {
        mNoteRepository = repository;
    }

    public void attachView(UiContract uiContract) {
        mView = uiContract;
    }

    public void detachView() {
        mView = null;
    }

    public void viewIsReady() {
        loadNotes();
    }

    public void loadNotes() {
        mNoteRepository.getAll().observe((LifecycleOwner) mView, list -> mView.showData(list));
    }
}
