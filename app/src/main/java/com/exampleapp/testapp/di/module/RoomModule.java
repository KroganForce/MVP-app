package com.exampleapp.testapp.di.module;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.exampleapp.testapp.db.NotesDao;
import com.exampleapp.testapp.db.NotesDatabase;
import com.exampleapp.testapp.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    @Singleton
    @Provides
    public NotesDatabase createDb(Context context) {

        return Room.databaseBuilder(context, NotesDatabase.class, String.valueOf(Constants.NOTES_DATABASE))
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        db.execSQL("INSERT INTO NOTE(id,note) VALUES (123,'NOTE 1'),(124,'NOTE 2')");
                    }
                }).build();
    }

    @Singleton
    @Provides
    public NotesDao providesDao(NotesDatabase database) {
        return database.dao();
    }
}
