package com.exampleapp.testapp.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "note")
    private String text;

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String note) {
        this.text = note;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}