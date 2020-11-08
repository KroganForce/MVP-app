package com.exampleapp.testapp;

import android.app.Application;

import com.exampleapp.testapp.db.NotesDatabase;

public class AppInit extends Application {
    private static NotesDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = NotesDatabase.getInstance(this);
    }

    static public NotesDatabase getDb() {
        return db;
    }
}
