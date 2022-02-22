package com.example.zodziu_zaidimas.Service;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.zodziu_zaidimas.Model.Dictionary;
import com.example.zodziu_zaidimas.Model.Words;

import java.util.List;

@Dao
public interface DictionaryService {

    @Insert(onConflict = REPLACE)
    void insert(Dictionary word);
    @Delete
    void delete(Dictionary word);
    @Update
    void update(Dictionary word);
    @Query("SELECT * FROM Dictionary")
    LiveData<List<Dictionary>> getAll();
    @Query("SELECT * FROM Dictionary WHERE id = :id")
    LiveData<Dictionary> getById(int id);
    @Query("SELECT * FROM Dictionary WHERE word = :word")
    LiveData<Dictionary>  getByWord(String word);
    //standard data so it can be edited.
    @Query("SELECT * FROM Dictionary WHERE word = :word")
    boolean getByWordSync(String word);
}
