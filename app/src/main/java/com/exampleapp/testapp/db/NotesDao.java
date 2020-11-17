package com.exampleapp.testapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.exampleapp.testapp.entity.Note;

import java.util.List;

@Dao
public interface NotesDao {

    @Insert
    void insert(Note item);

    @Update
    void update(Note note);

    @Query("SELECT * FROM NOTE")
    LiveData<List<Note>> getData();

    @Query("SELECT note FROM NOTE WHERE id = :id")
    String getDataById(int id);

    @Query("DELETE FROM NOTE WHERE id = :id")
    void deleteNote(int id);
}
