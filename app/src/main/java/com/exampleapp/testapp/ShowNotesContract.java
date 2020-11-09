package com.exampleapp.testapp;

import com.exampleapp.testapp.entity.Note;

import java.util.List;

public interface ShowNotesContract {

    void showData(List<Note> list);
}
