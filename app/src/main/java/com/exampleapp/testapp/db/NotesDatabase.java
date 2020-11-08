package com.exampleapp.testapp.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.exampleapp.testapp.Constants;
import com.exampleapp.testapp.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class NotesDatabase extends RoomDatabase {

    private static volatile NotesDatabase mInstance;

    public static synchronized NotesDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = createDb(context);
        }
        return mInstance;
    }

    private static NotesDatabase createDb(Context context) {
        return Room.databaseBuilder(context, NotesDatabase.class, String.valueOf(Constants.NOTES_DATABASE))
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        db.execSQL("INSERT INTO NOTE(id,note) VALUES (123,'HELLO! THIS IS NOTE!')");
                    }
                }).build();
    }

    public abstract NotesDao dao();
}

