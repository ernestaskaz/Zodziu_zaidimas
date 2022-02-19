package com.example.zodziu_zaidimas.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "Words")
public class Words {

    @PrimaryKey
    @ColumnInfo(name = "Id")
    private int Id;
    @ColumnInfo(name = "word")
    @NonNull
    private String word;
    @ColumnInfo(name = "isGuessed")
    @NonNull
    private boolean isGuessed;
    @ColumnInfo(name = "isRight")
    @NonNull
    private boolean isRight;

    public Words(String word, boolean isGuessed, boolean isRight) {
        this.isGuessed = isGuessed;
        this.isRight = isRight;
        this.word = word;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isGuessed() {
        return isGuessed;
    }

    public void setGuessed(boolean guessed) {
        isGuessed = guessed;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }
}
