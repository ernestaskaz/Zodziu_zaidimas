package com.example.zodziu_zaidimas.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.zodziu_zaidimas.Model.Dictionary;
import com.example.zodziu_zaidimas.Model.Words;
import com.example.zodziu_zaidimas.Service.DictionaryService;
import com.example.zodziu_zaidimas.Service.WordsService;



@Database(entities = {Dictionary.class, Words.class}, version = 1, exportSchema = false)
public abstract class WordsDatabase extends RoomDatabase {

    private static WordsDatabase wordsDatabase;
    private static String DBNAME = "Words";
    // one database on one thread. If not sync, could be created multiple DBs on different threads.
    public synchronized static WordsDatabase getInstance(Context context) {
        //condition
        if (wordsDatabase == null) {
            wordsDatabase = Room.databaseBuilder(context.getApplicationContext(), WordsDatabase.class,DBNAME).createFromAsset("Dictionary.sqlite").build();
        }
        return wordsDatabase;
    }
    public abstract WordsService wordsService();
    public abstract DictionaryService dictionaryService();

}
