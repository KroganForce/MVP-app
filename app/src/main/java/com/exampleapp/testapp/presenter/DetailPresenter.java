package com.exampleapp.testapp.presenter;

import com.exampleapp.testapp.contract.DetailContract;
import com.exampleapp.testapp.repository.NoteRepository;

import javax.inject.Inject;

public class DetailPresenter implements BasePresenter<DetailContract> {

    @Inject
    public DetailContract mView;

    private final NoteRepository mNoteRepository;

    @Inject
    public DetailPresenter(NoteRepository repository) {
        mNoteRepository = repository;
    }

    @Override
    public void attachView(DetailContract contract) {
        mView = contract;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    public void add() {
        mNoteRepository.addNote(mView.getNoteData());
    }

    public void update(int id) {
        mNoteRepository.updateNote(id, mView.getNoteData());
    }

    public String getNoteData() {
        return mNoteRepository.getDataById(mView.getNoteId());
    }
}
