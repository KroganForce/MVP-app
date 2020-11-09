package com.exampleapp.testapp;

import androidx.lifecycle.LifecycleOwner;

public class HomePresenter implements BasePresenter<ShowNotesContract> {

    private ShowNotesContract mView;
    private final NoteRepository mNoteRepository;

    public HomePresenter(NoteRepository repository) {
        mNoteRepository = repository;
    }

    @Override
    public void attachView(ShowNotesContract contract) {
        mView = contract;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void viewIsReady() {
        loadNotes();
    }

    public void loadNotes() {
        mNoteRepository.getAll().observe((LifecycleOwner) mView, list -> mView.showData(list));
    }
}
