package com.exampleapp.testapp;

public class DetailPresenter implements BasePresenter<ActionsContract> {

    private ActionsContract mView;
    private final NoteRepository mNoteRepository;

    public DetailPresenter(NoteRepository repository) {
        mNoteRepository = repository;
    }

    @Override
    public void attachView(ActionsContract contract) {
        mView = contract;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void viewIsReady() {
    }

    public void add() {
        mNoteRepository.addNote(mView.getNoteData());
    }

    public String noteData() {
        return mNoteRepository.getDataById(mView.getNoteId());
    }
}
