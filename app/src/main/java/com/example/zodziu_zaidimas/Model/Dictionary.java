package com.example.zodziu_zaidimas.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Dictionary")
public class Dictionary {

    @PrimaryKey
    @ColumnInfo(name = "Id")
    private int Id;
    @ColumnInfo(name = "word")
    @NonNull
    private String word;

    public Dictionary(String word) {
        this.word = word;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @NonNull
    public String getWord() {
        return word;
    }

    public void setWord(@NonNull String word) {
        this.word = word;
    }
}
