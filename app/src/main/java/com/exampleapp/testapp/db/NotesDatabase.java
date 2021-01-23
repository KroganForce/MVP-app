package com.exampleapp.testapp.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.exampleapp.testapp.entity.Note;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {

    public abstract NotesDao dao();
}

