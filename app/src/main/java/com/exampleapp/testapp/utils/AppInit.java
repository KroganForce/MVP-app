package com.exampleapp.testapp.utils;

import android.app.Application;

import com.exampleapp.testapp.db.NotesDatabase;
import com.exampleapp.testapp.di.DaggerNoteComponent;
import com.exampleapp.testapp.di.NoteComponent;

public class AppInit extends Application {
    private static NotesDatabase db;
    private static NoteComponent mNoteComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        db = NotesDatabase.getInstance(this);
        mNoteComponent = DaggerNoteComponent.create();
    }

    static public NotesDatabase getDb() {
        return db;
    }

    public static NoteComponent getNoteComponent() {
        return mNoteComponent;
    }
}
