package com.exampleapp.testapp.presenter;

import androidx.lifecycle.LifecycleOwner;

import com.exampleapp.testapp.repository.NoteRepository;
import com.exampleapp.testapp.contract.HomeContract;

public class HomePresenter implements BasePresenter<HomeContract> {

    private HomeContract mView;
    private final NoteRepository mNoteRepository;

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
        mNoteRepository.getAll().observe((LifecycleOwner) mView, list -> mView.getData(list));
    }
    public void deleteNote(int id){
        mNoteRepository.deleteNote(id);
    }
}
