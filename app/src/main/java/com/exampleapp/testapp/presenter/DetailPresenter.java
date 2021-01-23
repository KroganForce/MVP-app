package com.exampleapp.testapp.presenter;

import com.exampleapp.testapp.contract.DetailContract;
import com.exampleapp.testapp.entity.Note;
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
        Note note = new Note();
        note.setNote(mView.getNoteData());
        mNoteRepository.addNote(note);
    }

    public void update(int id) {
        Note note = new Note();
        note.setId(id);
        note.setNote(mView.getNoteData());
        mNoteRepository.updateNote(note);
    }

    public String getNoteData() {
        return mNoteRepository.getDataById(mView.getNoteId());
    }
}
