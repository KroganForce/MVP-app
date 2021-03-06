package com.exampleapp.testapp.presenter;

import androidx.lifecycle.LifecycleOwner;

import com.exampleapp.testapp.contract.HomeContract;
import com.exampleapp.testapp.repository.NoteRepository;

import javax.inject.Inject;

public class HomePresenter implements BasePresenter<HomeContract> {

    @Inject
    public HomeContract mView;

    private final NoteRepository mNoteRepository;

    @Inject
    public HomePresenter(NoteRepository repository) {
        mNoteRepository = repository;
    }

    @Override
    public void attachView(HomeContract contract) {
        mView = contract;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    public void viewIsReady() {
        loadNotes();
    }

    public void loadNotes() {
        mNoteRepository.getAll().observe((LifecycleOwner) mView, list -> mView.setData(list));
    }

    public void deleteNote(int id) {
        mNoteRepository.deleteNote(id);
    }
}
