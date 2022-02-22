package com.example.zodziu_zaidimas.Service;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.zodziu_zaidimas.Model.Words;

import java.util.List;
@Dao
public interface WordsService {

    @Insert(onConflict = REPLACE)
    void insert(Words word);
    @Delete
    void delete(Words word);
    @Update
    void update(Words word);
    @Query("SELECT * FROM Words")
    LiveData<List<Words>> getAll();
    @Query("SELECT * FROM Words WHERE id = :id")
    LiveData<Words> getById(int id);
    @Query("SELECT * FROM Words WHERE word = :word")
    LiveData<Words>  getByWord(String word);
    //standard data so it can be edited.
    @Query("SELECT * FROM Words WHERE word = :word")
    boolean getByWordSync(String word);
    @Query("SELECT * FROM Words WHERE isGuessed = 0")
    List<Words> getAllAsync();

}
