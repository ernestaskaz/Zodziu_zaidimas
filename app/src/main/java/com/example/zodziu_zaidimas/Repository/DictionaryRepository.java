package com.example.zodziu_zaidimas.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.zodziu_zaidimas.Database.WordsDatabase;
import com.example.zodziu_zaidimas.Model.Dictionary;
import com.example.zodziu_zaidimas.Service.DictionaryService;

import java.util.List;

public class DictionaryRepository {

private LiveData<List<Dictionary>> wordsDictionary;
private DictionaryService dictionaryService;

public DictionaryRepository(Application application) {
    WordsDatabase wordsDatabase = WordsDatabase.getInstance(application);
    dictionaryService = wordsDatabase.dictionaryService();
}

public LiveData<List<Dictionary>> getAllWords() {
    wordsDictionary = dictionaryService.getAll();
    return wordsDictionary;
}


}
